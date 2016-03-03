package builder;

/**
 * @author cota
 *
 */
public class ConnectionType {

	private final String driver;
	private final int timeOut;
	private final String url;

	private ConnectionType(ConnectionBuilder conectionBuilder) {
		this.driver = conectionBuilder.driver;
		this.timeOut = conectionBuilder.timeout;
		this.url = conectionBuilder.url;
		System.out.println("Connection Path: " + driver + ", Url: " + url + ", Timeout: " + timeOut);
		System.out.print("Connection established");
	}

	/**
	 * @return int with timout of connection
	 */
	public int getTimeout() {
		return timeOut;
	}

	/**
	 * @author cota
	 *
	 */
	public static class ConnectionBuilder {

		private static String connectionType;
		private int timeout;
		private String driver;
		private String url;

		/**
		 * @param conectionType
		 */
		public ConnectionBuilder(String conectionType) {
			this.connectionType = conectionType;
		}

		/**
		 * @param driver
		 * @return String with the driver of connection
		 */
		public ConnectionBuilder driver(String driver) {
			this.driver = driver;
			return this;
		}

		/**
		 * @param url
		 * @return String with the url of the connection
		 */
		public ConnectionBuilder url(String url) {
			this.url = url;
			return this;
		}

		/**
		 * @param timeout
		 * @return int with the time out of the connection
		 */
		public ConnectionBuilder timeout(int timeout) {
			this.timeout = timeout;
			return this;
		}

		/**
		 * @return a connection established if this would be possible
		 */
		public ConnectionType build() {
			ConnectionType connection = new ConnectionType(this);
			return connection;
		}

	}

}