package ejer4_Builder;

/** Class  builder example for database connection.
 * @author Cristian Gomez
 * @since 1.0
 * @version 1.0
 *
 */
public class ConnectionType {

    private final String connectionPath;
    private final int timeout;
    private final int prop1;

    private ConnectionType(ConnectionBuilder connBuilder) {
        this.connectionPath = connBuilder.connectionPath;
        this.timeout = connBuilder.timeout;
        this.prop1 = connBuilder.prop1;
        System.out.println("Connection Path: " + connectionPath + ", Timeout: " + timeout + ", Prop1: " + prop1);
        System.out.print("Connection established");
    }

    public int getTimeout() {
        return timeout;
    }

    public int getProp1() {
        return prop1;
    }

    public static class ConnectionBuilder {

        private static String connType;
        private int timeout;
        private int prop1;
        private String connectionPath;

        public ConnectionBuilder(String connType) {
            this.connType = connType;
        }

        public ConnectionBuilder connectionPath(String connectionPath) {
            this.connectionPath = connectionPath;
            return this;
        }

        public ConnectionBuilder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public ConnectionBuilder prop1(int prop1) {
            this.prop1 = prop1;
            return this;
        }

        public ConnectionType build() {
            ConnectionType connection = new ConnectionType(this);
            return connection;
        }

    }

}