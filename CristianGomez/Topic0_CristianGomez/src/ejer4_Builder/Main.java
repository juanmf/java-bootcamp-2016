package ejer4_Builder;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ConnectionType connType1 = new ConnectionType.ConnectionBuilder("Test").timeout(15).prop1(30)
                .connectionPath("jdbc:mysql://192.168.2.10:3306/test").build();

    }

}
