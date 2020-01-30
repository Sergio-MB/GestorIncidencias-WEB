package data;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListaIncidencias implements Serializable {

	private ArrayList<data.IncidenciaBean> lista = new ArrayList<data.IncidenciaBean>();

	public ListaIncidencias() {
	}

	public List<data.IncidenciaBean> getLista() {
		return lista;
	}
	
	public void listarTodo() {
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();

			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM incidencias");

			while (resultado.next()) {
				IncidenciaBean incidencia = new IncidenciaBean(
						resultado.getString("id"),
						resultado.getString("titulo"),
						resultado.getString("direccion"),
						resultado.getString("descripcion"),
						resultado.getString("estado"),
						resultado.getString("prioridad"),
						resultado.getString("tipoIncidencia"),
						resultado.getString("usuario"),
						resultado.getString("autonomo")
				);
				lista.add(incidencia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buscar(String titulo, String estado, String tipo) {
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();

			String query = "SELECT * FROM incidencias where "
					+ "UPPER(titulo) LIKE UPPER(?) AND "
					+ "UPPER(estado) LIKE UPPER(?) AND "
					+ "UPPER(tipoincidencia) LIKE UPPER(?)";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, "%"+titulo+"%");
			statement.setString(2, "%"+estado+"%");
			statement.setString(3, "%"+tipo+"%");

			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {
				IncidenciaBean incidencia = new IncidenciaBean(
						resultado.getString("id"),
						resultado.getString("titulo"),
						resultado.getString("direccion"),
						resultado.getString("descripcion"),
						resultado.getString("estado"),
						resultado.getString("prioridad"),
						resultado.getString("tipoIncidencia"),
						resultado.getString("usuario"),
						resultado.getString("autonomo")
				);
				lista.add(incidencia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarPorAutor(String autor) {
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();

			String query = "SELECT * FROM incidencias where "
					+ "UPPER(usuario) LIKE UPPER(?)";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, "%"+autor+"%");

			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {
				IncidenciaBean incidencia = new IncidenciaBean(
						resultado.getString("id"),
						resultado.getString("titulo"),
						resultado.getString("direccion"),
						resultado.getString("descripcion"),
						resultado.getString("estado"),
						resultado.getString("prioridad"),
						resultado.getString("tipoIncidencia"),
						resultado.getString("usuario"),
						resultado.getString("autonomo")
				);
				lista.add(incidencia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarPorAsignado(String autonomo) {
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();

			String query = "SELECT * FROM incidencias where "
					+ "UPPER(autonomo) LIKE UPPER(?)";
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, "%"+autonomo+"%");

			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {
				IncidenciaBean incidencia = new IncidenciaBean(
						resultado.getString("id"),
						resultado.getString("titulo"),
						resultado.getString("direccion"),
						resultado.getString("descripcion"),
						resultado.getString("estado"),
						resultado.getString("prioridad"),
						resultado.getString("tipoIncidencia"),
						resultado.getString("usuario"),
						resultado.getString("autonomo")
				);
				lista.add(incidencia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
