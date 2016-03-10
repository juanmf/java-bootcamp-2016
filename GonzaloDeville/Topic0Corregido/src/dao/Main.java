package dao;

import java.sql.SQLException;

/**
 * @author cota
 *
 */
public class Main {

	public static void main(String[] args) {
		Person per = new Person();
		per.setId(1);
		per.setNombre("Cota");
		
		try{
			
			PersonDAO dao = new PersonDAOImpl();
			dao.resgistrar(per);
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	}

}
