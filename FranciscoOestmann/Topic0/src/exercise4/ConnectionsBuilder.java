package exercise4;

public interface ConnectionsBuilder {

	public void buildUrl();
	public void buildUser();
	public void buildPassword();
	public void buildConnectionAddress();
	public DbConnections getConnectionAddress();
}
