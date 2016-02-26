package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl extends Connect implements PersonDAO {
	@Override
	public void resgistrar(Person per) throws SQLException, ClassNotFoundException {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("INSERT INTO Persona(nombre) VLUES(?)");
			st.setString(1, per.getNombre());
			st.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} finally {
			this.cerrar();
		}

	}

	@Override
	public void modificar(Person per) throws SQLException, ClassNotFoundException {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("UPDATE Persona set nombre ? where id = ? ");
			st.setString(1, per.getNombre());
			st.setInt(2, per.getId());
			st.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} finally {
			this.cerrar();
		}

	}

	@Override
	public void eliminar(Person per) throws SQLException, ClassNotFoundException {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("DELETE from persona where id = ?");
			st.setInt(1, per.getId());
			st.executeUpdate();

		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} finally {
			this.cerrar();
		}

	}

	@Override
	public List<Person> listar() throws SQLException, ClassNotFoundException {
		List<Person> lista = null;
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("select * from persona");

			lista = new ArrayList<>();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Person per = new Person();
				per.setId(rs.getInt("id"));
				per.setNombre("nombre");
				lista.add(per);
			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} finally {
			this.cerrar();
		}

		return lista;
	}

}
