package Topic0.Ejercicio1;

public class DBCSingleton {
	private static DBCSingleton dbcSingleton = null;
	
	private DBCSingleton(){
	}
	
	public static DBCSingleton getInstance(){
		if(dbcSingleton == null){
			dbcSingleton = new DBCSingleton();
		}
		return dbcSingleton;
	}
	
	public void saySomething(){
		System.out.println("I'm a database");
	}
}
