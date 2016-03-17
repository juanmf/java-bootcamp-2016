package Topic0.Ejercicio4;

public class ServerDB implements DBBuilder{
	private Database database;
	
	public ServerDB(){
		database = new Database();
	}
	
	@Override
	public void buildIp() {
		database.setIp("198.49.78.145");
		
	}

	@Override
	public void buildPort() {
		database.setPort("25555");		
	}

	@Override
	public Database getDatabase() {
		return database;
	}
}
