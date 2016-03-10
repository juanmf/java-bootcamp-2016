package com.topic4.choco;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.jdbc.PreparedStatement;

public class PercentageOfStudents {
	public static void main(String[] args) {
		try {
			ArrayList<String> lengua = new ArrayList<String>();
			ArrayList<String> matematica = new ArrayList<String>();
			ArrayList<String> geografia = new ArrayList<String>();

			HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

			Driver con = Driver.getInstance();
			String query = "UPDATE `high_school`.`Student_course` SET `final_note`= ((parcial_note_1+parcial_note_2+parcial_note_3)/3) "
					+ "WHERE `student_course_id`=?";
			PreparedStatement prepareStmt = (PreparedStatement) con.getConnect().prepareStatement(query);
			for (int i = 1; i <= 20; i++) {
				prepareStmt.setInt(1, i);
				prepareStmt.executeUpdate();
			}
			Driver conn = Driver.getInstance();
            String operator=">";
            query = "select Course.course_id, Course.name,avg(Student_course.final_note) as Promedio from Course left join Student_course on Student_course.course_id = Course.course_id where Course.course_id = ? and Student_course.final_note "+operator+ " 6 Group By Course.name Order By Course.course_id";
            PreparedStatement prepStmt = (PreparedStatement) conn.getConnect().prepareStatement(query);
            prepStmt.setInt(1, 1);
            prepStmt.execute();
            ResultSet rst = prepStmt.executeQuery();
            while(rst.next()){
            	System.out.println(rst.getString("Promedio"));
            }
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Driver.delInstance();
		}
	}
}
