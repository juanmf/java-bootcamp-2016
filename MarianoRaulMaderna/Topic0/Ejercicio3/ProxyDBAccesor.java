package Topic0.Ejercicio3;

import java.util.Date;

public class ProxyDBAccesor {
	SlowDBConnection slowdbc;
	
	public ProxyDBAccesor(){
		System.out.println("Creating proxy at " + new Date());
	}
	
	public void sayHello(){
		if(slowdbc==null){
			slowdbc = new SlowDBConnection();
		}
		slowdbc.sayHello();
	}
}
