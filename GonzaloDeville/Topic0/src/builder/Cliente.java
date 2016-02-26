package builder;

import java.sql.SQLException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner reader = new Scanner(System.in);
		ConnectionAbstracBuilder constructor;
		System.out.print("MySql (1) o PostgreSql (2):");
		String seleccion = reader.next();
		if (seleccion.equals("1")) {
			constructor = new ConnectionMysqlBuilder("com.mysql.jdbc.Driver","jdbc:mysql://127.0.0.1/MyDataBase","123","root");
		} else {
			constructor = new ConnectionPostgreSqlBuilder("org.postgresql.Driver","jdbc:mysql://127.0.0.1/MyDataBase","123","root");
		}
		
		DirectorBuilder builder = new DirectorBuilder(constructor);
		builder.connectBuilder();
		
		reader.close();
	}
}
