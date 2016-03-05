package com.frann.oestmann;

import java.sql.*;

public class MySqlDAO {

	
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
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
						System.out.println("Teacher: " +rs.getString("Teacher.LastName") + ", " + rs.getString("Teacher.FirstName") );
						System.out.println("Schedule: ");
						temp = rs.getString("Teacher.LastName");
					}
									
									
					if(temp.equals(rs.getString("Teacher.LastName"))){
						System.out.println("	" + rs.getString("DaysInWeek.Day") + " " + rs.getString("ClassPerWeek.Hour") + ": " +  rs.getString("Course.CourseName"));
					}
					else{
						
						System.out.println("Teacher: " + rs.getString("Teacher.LastName") + ", " + rs.getString("Teacher.FirstName") );
						System.out.println("Schedule: ");
						System.out.println("	" + rs.getString("DaysInWeek.Day") + " " + rs.getString("ClassPerWeek.Hour") + ": " +  rs.getString("Course.CourseName"));
						temp = rs.getString("Teacher.LastName");
					}
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
}
		

