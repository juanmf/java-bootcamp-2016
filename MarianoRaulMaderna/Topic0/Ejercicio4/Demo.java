package Topic0.Ejercicio4;

public class Demo {
	public static void main(String[] args) {
		DBBuilder dbBuilder = new LocalDB();
		DBDirector dbDirector = new DBDirector(dbBuilder);
		dbDirector.constructorDB();
		Database database = dbDirector.getDatabase();
		System.out.println("Database is " + database);
		
		dbBuilder = new ServerDB();
		dbDirector = new DBDirector(dbBuilder);
		dbDirector.constructorDB();
		database = dbDirector.getDatabase();
		System.out.println("Database is " + database);
	}
}
