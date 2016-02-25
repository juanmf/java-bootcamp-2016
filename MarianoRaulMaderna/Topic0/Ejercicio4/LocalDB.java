package Topic0.Ejercicio4;

public class LocalDB implements DBBuilder{
	
	private Database database;
	
	public LocalDB(){
		database = new Database();
	}
	
	@Override
	public void buildIp() {
		database.setIp("66.249.78.133");
		
	}

	@Override
	public void buildPort() {
		database.setPort("25255");		
	}

	@Override
	public Database getDatabase() {
		return database;
	}
	
}
