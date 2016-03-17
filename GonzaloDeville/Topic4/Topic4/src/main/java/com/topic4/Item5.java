package com.topic4;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.mysql.jdbc.PreparedStatement;

public class Item5 {

	public static void main(String[] args) {
		try {
			ArrayList<String> id1 = new ArrayList<String>();
			ArrayList<String> id2 = new ArrayList<String>();
			ArrayList<String> id3 = new ArrayList<String>();

			HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

			Driver conn = Driver.getInstance();
			String query = "Select Teacher.first_name as firstName, Teacher.teacher_id, Teacher.last_name as lastName, Course.name as courseName,"
					+ " Schedule_time.beginning_hours as startHours, Schedule_time.ending_hours endHours,"
					+ " Schedule_time.date as dateSchudele " + "from Schedule_time " + "left join Course "
					+ " on Course.schedule_time_id = Schedule_time.schedule_time_id " + "left join Teacher_course "
					+ " on Teacher_course.course_id = Course.course_id " + "left join Teacher "
					+ " on Teacher.teacher_id = Teacher_course.teacher_id " + "where Teacher_course.teacher_id = ?";

			PreparedStatement prepStmt = (PreparedStatement) conn.getConnect().prepareStatement(query);
			prepStmt.setInt(1, 2);
			prepStmt.execute();
			ResultSet rst = prepStmt.executeQuery();

			while (rst.next()) {
				if (rst.getString("Teacher.teacher_id").equalsIgnoreCase("1")) {
					id1.add(rst.getString("dateSchudele") + rst.getString("startHours")+ " - "+rst.getString("endHours")+" : "+rst.getString("courseName"));
					map.put(rst.getString("firstName") + ", " + rst.getString("lastName"), id1);
				}
				
				if (rst.getString("Teacher.teacher_id").equalsIgnoreCase("2")) {
					id2.add(rst.getString("dateSchudele") + rst.getString("startHours")+ " - "+rst.getString("endHours")+" : "+rst.getString("courseName"));
					map.put(rst.getString("firstName") + ", " + rst.getString("lastName"), id2);
				}
				
				if (rst.getString("Teacher.teacher_id").equalsIgnoreCase("3")) {
					id3.add(rst.getString("dateSchudele") + rst.getString("startHours")+ " - "+rst.getString("endHours")+" : "+rst.getString("courseName"));
					map.put(rst.getString("firstName") + ", " + rst.getString("lastName"), id3);
				}
			}

			// Imprimimos el Map con un Iterador
			Iterator<String> it = map.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				System.out.println("Teacher: "+key +"\nSchedule: "+ map.get(key));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Driver.delInstance();
		}
	
	}

}
