package exercise3;

public class AccesorDAOTest {
	public static void main(String[] args) {
		
		//Create an Object of the type of the interface
		SelectorDAOImpl dao1 = new SqlDAO(1);
		//The Object can only call methods defined in the Interface, and can't call methods defined in the Class of origin
		dao1.connect();
		dao1.close();
		
		SelectorDAOImpl dao2 = new OracleDAO(2);
		dao2.connect();
		dao2.close();
	}
}
