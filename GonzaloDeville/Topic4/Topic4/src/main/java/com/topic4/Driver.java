package com.topic4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {

	private static Connection con = null;
	private static Driver instance = null;

	private Driver() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1/high_school";
			String pwd = "root";
			String usr = "root";
			Class.forName(driver);

			con = DriverManager.getConnection(url, usr, pwd);

		} catch (SQLException ex) {

			System.err.println(ex.getMessage());

		} catch (ClassNotFoundException ex) {

			System.err.println(ex.getMessage());

		}
	}

	public static synchronized Driver getInstance() {
		if (instance == null) {
			instance = new Driver();
			System.out.println("Conexion Realizada!!");
		}
		return instance;
	}

	public Connection getConnect() {
		return con;
	}

	private static void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar la conexión.");
		}
	}

	public static void delInstance() {
		closeConnection();
		instance = null;
	}
}
