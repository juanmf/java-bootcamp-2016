package DAOPunto3;


import java.sql.SQLException;



public class Main {

	public static void main(String[] args) {
		
		Persona per = new Persona();
		per.setId(1);
		per.setNombre("choco");
		
		try{
			
			DAOPersona dao = new DAOPersonaImpl();
			dao.resgistrar(per);
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	}

}
