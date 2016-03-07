package exercise4corregido;

public class SqlConnection {

	//State
	private String url;
	private String driver;
	private String query;
	
	//Getters & Setters
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	@Override
	public String toString() {
		return "SqlConnection [url=" + url + ", driver=" + driver + ", query=" + query + "]";
	}
	
	
	
}
