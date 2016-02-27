package ejer2_Factory;


    public class Lan implements LocalSqlConnection{

        @Override
        public void connect() {
            System.out.println("LAN connection to a local sql server established.");
        }

    }
