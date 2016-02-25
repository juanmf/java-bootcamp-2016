package Topic0.Ejercicio4;

public class DBDirector {
	private DBBuilder dbBuilder = null;
	
	public DBDirector(DBBuilder dbBuilder){
		this.dbBuilder = dbBuilder;
	}
	
	public void constructorDB(){
		dbBuilder.buildIp();
		dbBuilder.buildPort();
	}
	
	public Database getDatabase(){
		return dbBuilder.getDatabase();
	}
}
