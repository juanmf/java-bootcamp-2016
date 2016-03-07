package com.frann.oestmann;

import java.sql.*;

public class MySqlDAO {

	
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	private String teacher = "";
	private String day = " ";
	
	String temp = " ";
	
		
		public void connect(){
			try{
				
			   Class.forName("com.mysql.jdbc.Driver");
			   
			} catch (Exception e){
				
			   e.printStackTrace();
			   
			} 
			
			try {
				
				conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/highschool?autoReconnect=true&useSSL=false","root", "fno160884");
				
				System.out.println("Connected");
				
				String query = "select Teacher.LastName, "
						+ "Teacher.FirstName, DaysInWeek.Day, "
						+ "ClassPerWeek.Hour, Course.CourseName "
						+ "FROM ClassPerWeek  "
						+ "INNER JOIN Course ON Course.idCourse = ClassPerWeek.CoursesInWeek "
						+ "INNER JOIN Teacher ON Course.AssignedTeacher = Teacher.idTeacher "
						+ "INNER JOIN DaysInWeek ON DaysInWeek.idDay = ClassPerWeek.Day "
						+ "ORDER BY Teacher.LastName, ClassPerWeek.Day";
				
				st = conn.prepareStatement(query);
				System.out.println();
				
				System.out.println("Praparing Statement");
				System.out.println();
				
				rs = st.executeQuery();
				
				System.out.println("Executing Query");
				System.out.println();
				
				
				while(rs.next()){
					if(rs.isFirst()){
						teacher = rs.getString("Teacher.LastName")  + ", "+ rs.getString("Teacher.FirstName");
						day = rs.getString("DaysInWeek.Day") + " " + rs.getString("ClassPerWeek.Hour") + " " + rs.getString("Course.CourseName");
						System.out.println("Teacher: " + teacher);
						System.out.println("Schedule:");
						System.out.println("      " + day);
						System.out.println();
						
					}
					else{
						teacher = rs.getString("Teacher.LastName")  + ", "+ rs.getString("Teacher.FirstName");
						day = rs.getString("DaysInWeek.Day") + " " + rs.getString("ClassPerWeek.Hour") + " " + rs.getString("Course.CourseName");
						System.out.println("Teacher: " + teacher);
						System.out.println("Schedule:");
						System.out.println("      " + day);
						System.out.println();
						rs.next();
		
					}
				}
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
}
		

