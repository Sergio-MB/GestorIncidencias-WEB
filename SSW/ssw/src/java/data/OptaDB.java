package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OptaDB {

	public static void apuntar(String autonomo, String incidencia) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		try {
			String query = "INSERT INTO opta VALUES(?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, autonomo);
			statement.setInt(2, Integer.parseInt(incidencia));

			statement.execute();

			pool.freeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void asignar(String autonomo, String incidencia) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		try {
			String query = "UPDATE incidencias SET autonomo = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, autonomo);
			statement.setInt(2, Integer.parseInt(incidencia));
			statement.execute();

			query = "DELETE FROM opta WHERE incidencia = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, Integer.parseInt(incidencia));

			pool.freeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ListaUsuarios listar(String id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		try {
			String query = "SELECT usuario FROM opta WHERE incidencia = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			ResultSet resultado = statement.executeQuery();

			ListaUsuarios lista = new ListaUsuarios();

			while (resultado.next()) {
				Usuario usuario = UsuarioDB.buscarUsuario(resultado.getString(1));
				lista.addUsuario(usuario);
			}
			pool.freeConnection(connection);
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
