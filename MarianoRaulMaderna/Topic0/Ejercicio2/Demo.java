package Topic0.Ejercicio2;

import Topic0.Ejercicio2.SQLConnections.SQLConnection;

public class Demo {
	public static void main(String[] args) {
		SQLFactory sqlF= FactoryProducer.getFactory("SQLConnection");
		
		SQLConnection sqlS1= sqlF.getSQLConnection("SQL Server 1");
		SQLConnection sqlS2= sqlF.getSQLConnection("SQL Server 2");
		SQLConnection sqlS3= sqlF.getSQLConnection("SQL Server 3");
		
		System.out.println(sqlS1.connection());
		System.out.println(sqlS2.connection());
		System.out.println(sqlS3.connection());
		
	}
}
