package com.topic4.choco;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.mysql.jdbc.PreparedStatement;

public class ListCourse {
	public static void main(String[] args) {
		try {
			
			ArrayList<String> courses = new ArrayList<String>();

			HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

			Driver conn = Driver.getInstance();
			String operator = ">";
			String query = "Select Teacher.first_name as firstName, Teacher.teacher_id, Teacher.last_name as lastName,"
					+ " Course.name as courseName,Schedule_time.beginning_hours as "
					+ "startHours, Schedule_time.ending_hours endHours,Schedule_time.date as dateSchudele"
					+ " from Schedule_time " + "left join Course "
					+ "on Course.schedule_time_id = Schedule_time.schedule_time_id " + "left join Teacher_course "
					+ "on Teacher_course.course_id = Course.course_id " + "left join Teacher "
					+ "on Teacher.teacher_id = Teacher_course.teacher_id " + "where Teacher_course.teacher_id = ?;";
			PreparedStatement prepStmt = (PreparedStatement) conn.getConnect().prepareStatement(query);
			prepStmt.setInt(1, 1);
			prepStmt.execute();
			ResultSet rst = prepStmt.executeQuery();
			String courseName=null;
		
			String teacher;
			while (rst.next()) {
				teacher="Teacher \n"+rst.getString("lastName")+" "+rst.getString("firstName");
				if("1".equalsIgnoreCase(rst.getString("teacher_id"))){
					courses.add(rst.getString("dateSchudele") + " " + rst.getString("startHours") +" "+rst.getString("endHours")+" " 
				+ rst.getString("courseName"));
				}
				if("2".equalsIgnoreCase(rst.getString("teacher_id"))){
					courses.add(rst.getString("dateSchudele") + " " + rst.getString("startHours") +" "+rst.getString("endHours")+" "
							+ rst.getString("courseName"));
				}
				if("3".equalsIgnoreCase(rst.getString("teacher_id"))){
					courses.add(rst.getString("dateSchudele") + " " + rst.getString("startHours") +" "+rst.getString("endHours")+" "
							+ rst.getString("courseName"));
				}
				map.put(teacher, courses);
			}
			//recorro el mapa
			Iterator<String> it=map.keySet().iterator();
			String key;
			Iterator<String>itSchudele;
			while(it.hasNext()){
				key=it.next();
				System.out.println(key +"\n Schudele \n ");
				itSchudele=map.get(key).iterator();
				while(itSchudele.hasNext()){
					System.out.println(itSchudele.next());
				}
			}
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Driver.delInstance();
		}

	}
}
