package com.topic4.choco;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		try {
			ArrayList<String> lengua = new ArrayList<String>();
			ArrayList<String> matematica = new ArrayList<String>();
			ArrayList<String> geografia = new ArrayList<String>();

			HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

			Driver con = Driver.getInstance();
			Statement stmt = con.getConnect().createStatement();
			ResultSet rst = stmt.executeQuery("SELECT * FROM Course crs LEFT JOIN Student_course std_c ON crs.course_id = std_c.course_id "
					+ "LEFT JOIN Student std ON std_c.student_id = std.student_id "
					+ "LEFT JOIN Teacher_course tc  ON crs.course_id = tc.course_id "
					+ "LEFT JOIN Teacher tch ON tc.teacher_id = tch.teacher_id ORDER BY std.last_name");

			while (rst.next()) {
								
				if (rst.getString("name").equalsIgnoreCase("Lengua")) {
					lengua.add(rst.getString("std.first_name") + " " + rst.getString("std.last_name"));
					map.put("Course: "+rst.getString("name")+"\n"+"Teacher: " + rst.getString("tch.first_name") + ", " +
							rst.getString("tch.last_name") + "\n" + "Students: \n"  , lengua);
				}

				if (rst.getString("name").equalsIgnoreCase("musica")) {
					matematica.add(rst.getString("std.first_name") + " " + rst.getString("std.last_name"));
					map.put("Course: "+rst.getString("name")+"\n"+"Teacher: " + rst.getString("tch.first_name") + ", " +
							rst.getString("tch.last_name") + "\n" + "Students: \n"  , matematica);
				}

				if (rst.getString("name").equalsIgnoreCase("historia")) {
					geografia.add(rst.getString("std.first_name") + " " + rst.getString("std.last_name"));
					map.put("Course: "+rst.getString("name")+"\n"+"Teacher: " + rst.getString("tch.first_name") + ", " +
							rst.getString("tch.last_name") + "\n" + "Students: \n"  , geografia);
				}

			}
		
			Iterator<String> it = map.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				System.out.println(key + map.get(key)+ "\n");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Driver.delInstance();
		}
	}

}
