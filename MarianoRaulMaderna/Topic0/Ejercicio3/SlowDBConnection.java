package Topic0.Ejercicio3;

public class SlowDBConnection extends DBAccesor {
	
	public SlowDBConnection(){
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
