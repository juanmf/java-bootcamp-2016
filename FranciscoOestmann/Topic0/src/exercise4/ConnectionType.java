package exercise4corregido;

public class ConnectionType implements ConnectionBuilder {
	
	private SqlConnection conn;
	
	

	public ConnectionType() {
		conn = new SqlConnection();
	}

	@Override
	public void buildConnection() {
		
		conn.setDriver("con.mysql.jdbc.Driver");
		conn.setUrl("jdbc:mysql://localhost:3306/database");
		conn.setQuery("SELECT * from table where table.id=1");
		
	}

	@Override
	public SqlConnection getConnection() {
		return conn;
	}

}
