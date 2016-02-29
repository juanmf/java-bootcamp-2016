package ejer2_Factory_2_0;

public class FactoryProducer {
    public static SQLFactory getFactory(String af){
        if(af.equals("SQLConnection")){
            return new DBConnectionFactory();
        }
        else{
            return null;
        }
    }
}