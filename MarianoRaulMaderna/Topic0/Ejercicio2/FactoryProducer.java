package Topic0.Ejercicio2;

public class FactoryProducer {
	public static SQLFactory getFactory(String af){
		if(af.equals("SQLConnection")){
			return new SQLConnectionFactory();
		}
		else{
			return null;
		}
	}
}
