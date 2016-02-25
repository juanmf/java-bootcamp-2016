package Topic0.Ejercicio3;

public class Demo {
	public static void main(String[] args) {
		ProxyDBAccesor proxy = new ProxyDBAccesor();
		
		FastDBConnection flashConnection = new FastDBConnection();
		flashConnection.sayHello();
		
		proxy.sayHello();
	}
}
