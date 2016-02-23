package ejer2_Factory;



	/**
	 * @param args
	 */
	public abstract class AbstractDBConnectionFactory {
		abstract SqlConnection getConnection(String conType);
	}
