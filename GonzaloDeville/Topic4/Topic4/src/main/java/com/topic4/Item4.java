package com.topic4;

import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

public class Item4 {

	public static void main(String[] args) {
		
		try {
			Driver conn = Driver.getInstance();
			String operator=">";
			String query = "select Course.course_id, Course.name,avg(Student_course.final_note) as Promedio from Course left join Student_course on Student_course.course_id = Course.course_id where Course.course_id = ? and Student_course.final_note "+operator+ " 6 Group By Course.name Order By Course.course_id";
			PreparedStatement prepStmt = (PreparedStatement) conn.getConnect().prepareStatement(query);
			prepStmt.setInt(1, 1);
			prepStmt.execute();
			ResultSet rst = prepStmt.executeQuery();
			
			while (rst.next()) {
				System.out.println("The percentage of students that passed"+" "+rst.getString("Course.name")+" are "+rst.getString("Promedio")+"%");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			Driver.delInstance();
		}

	}

}
