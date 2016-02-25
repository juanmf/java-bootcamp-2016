package Topic0.Ejercicio3;

import java.util.Date;

public abstract class DBAccesor {
	
	public void sayHello() {
		System.out.println(this.getClass().getSimpleName() + " connected at " + new Date());
	}

}
