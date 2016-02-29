package DAOPunto3;


import java.sql.SQLException;
import java.util.List;


public interface DAOPersona {
	public void resgistrar(Persona per) throws SQLException,ClassNotFoundException;
	public void modificar(Persona per) throws SQLException,ClassNotFoundException;
	public void eliminar(Persona per) throws SQLException,ClassNotFoundException;
	public List<Persona>listar() throws SQLException,ClassNotFoundException;

}
