package ejer2_Factory;



public class FactoryProducer {
    private AbstractDBConnectionFactory factory;

    public AbstractDBConnectionFactory getConnection(String choice) {

        if (choice == null) {
            return null;
        }
        if (choice.compareTo("MySQL") == 0) {
            factory = new MySqlConnectionFactory();
            return factory;
        }
        if (choice.compareTo("MS SQL Server") == 0) {
            factory = new SqlServerConnectionFactory();
            return factory;
        }
        if (choice.compareTo("Oracle") == 0) {
            factory = new OracleConnectionFactory();
            return factory;
        }

        return null;
    }
}