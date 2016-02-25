package Topic0.Ejercicio1;

public class DBCDemo {
	public static void main(String[] args) {
		DBCSingleton dbcSingleton= DBCSingleton.getInstance();
		
		dbcSingleton.saySomething();
	}
}
