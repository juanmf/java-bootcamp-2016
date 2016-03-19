package exercise4;

public class ConnectionType {

	private String connectionType;
	private String connectionUrl;
	private String driver;
	
	public ConnectionType(ConnectionBuilder builder) {
		
		this.connectionType = builder.connectionType;
		this.connectionUrl = builder.connectionUrl;
		this.driver = builder.driver;
	}
	
	

	
	


@Override
	public String toString() {
		return "ConnectionType [connectionType=" + connectionType + ", connectionUrl=" + connectionUrl + ", driver=" + driver + "]";
	}







public static class ConnectionBuilder{
	
	private String connectionType;
	private String connectionUrl;
	private String driver;
	
	
	public ConnectionBuilder() {
		
	}


	public ConnectionBuilder setConnectionType(String connectionType) {
		this.connectionType = connectionType;
		
		return this;
	}
	
	
	public ConnectionBuilder setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
		
		return this;
	}
	
	
	public ConnectionBuilder setDriver(String driver) {
		this.driver = driver;
		
		return this;
	}


	public ConnectionType buildConnecttion(){
		ConnectionType conn = new ConnectionType(this);
		return conn;
	}
	
}



}