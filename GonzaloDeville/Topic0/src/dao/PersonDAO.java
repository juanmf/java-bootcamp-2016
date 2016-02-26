package dao;

import java.sql.SQLException;
import java.util.List;


public interface PersonDAO {
	public void resgistrar(Person per) throws SQLException, ClassNotFoundException;

	public void modificar(Person per) throws SQLException, ClassNotFoundException;

	public void eliminar(Person per) throws SQLException, ClassNotFoundException;

	public List<Person> listar() throws SQLException, ClassNotFoundException;
}
