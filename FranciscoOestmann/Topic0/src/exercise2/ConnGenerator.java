package exercise2;

public class ConnGenerator {
	
	public static AbstractConnectionFactory getConnect(String check){
		
		if(check.equalsIgnoreCase("local")){
			return new LocalConnection();
		}
		
		else{
			if(check.equalsIgnoreCase("remote")){
				return new RemoteConnection();
			}
		}
		
		return null;
	}
}
