package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Part;

public class IncidenciaDB {

	public static ArrayList<IncidenciaBean> muestraPorEstado(String estado) {
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();
			ArrayList<IncidenciaBean> listaIncidencias = new ArrayList<IncidenciaBean>();
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM incidencias where ESTADO ='" + estado + "'");

			while (resultado.next()) {
				IncidenciaBean incidencia = new IncidenciaBean(
						resultado.getString("id"),
						resultado.getString("titulo"),
						resultado.getString("direccion"),
						resultado.getString("descripcion"),
						resultado.getString("estado"),
						resultado.getString("prioridad"),
						resultado.getString("tipoincidencia"),
						resultado.getString("usuario"),
						resultado.getString("autonomo"),
						resultado.getString("informe")
				);
				listaIncidencias.add(incidencia);
			}
			pool.freeConnection(connection);
			return listaIncidencias;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<IncidenciaBean> muestraTodasPorUsuario(String creador) {
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();
			ArrayList<IncidenciaBean> listaIncidencias = new ArrayList<IncidenciaBean>();
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM incidencias where Usuario ='" + creador + "'");

			while (resultado.next()) {
				IncidenciaBean incidencia = new IncidenciaBean(
						resultado.getString("id"),
						resultado.getString("titulo"),
						resultado.getString("direccion"),
						resultado.getString("descripcion"),
						resultado.getString("estado"),
						resultado.getString("prioridad"),
						resultado.getString("tipoincidencia"),
						resultado.getString("usuario"),
						resultado.getString("autonomo"),
						resultado.getString("informe")
				);
				listaIncidencias.add(incidencia);
			}
			pool.freeConnection(connection);
			return listaIncidencias;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<IncidenciaBean> muestraTodasPorAutonomo(String autonomo) {
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();
			ArrayList<IncidenciaBean> listaIncidencias = new ArrayList<IncidenciaBean>();
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM incidencias where autonomo ='" + autonomo + "'");

			while (resultado.next()) {
				IncidenciaBean incidencia = new IncidenciaBean(
						resultado.getString("id"),
						resultado.getString("titulo"),
						resultado.getString("direccion"),
						resultado.getString("descripcion"),
						resultado.getString("estado"),
						resultado.getString("prioridad"),
						resultado.getString("tipoincidencia"),
						resultado.getString("usuario"),
						resultado.getString("autonomo"),
						resultado.getString("informe")
				);
				listaIncidencias.add(incidencia);
			}
			pool.freeConnection(connection);
			return listaIncidencias;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ArrayList<IncidenciaBean> muestraTodas() {
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();
			ArrayList<IncidenciaBean> listaIncidencias = new ArrayList<IncidenciaBean>();
			Statement statement = connection.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM incidencias ");

			while (resultado.next()) {
				IncidenciaBean incidencia = new IncidenciaBean(
						resultado.getString("id"),
						resultado.getString("titulo"),
						resultado.getString("direccion"),
						resultado.getString("descripcion"),
						resultado.getString("estado"),
						resultado.getString("prioridad"),
						resultado.getString("tipoincidencia"),
						resultado.getString("usuario"),
						resultado.getString("autonomo"),
						resultado.getString("informe")
				);
				listaIncidencias.add(incidencia);
			}
			pool.freeConnection(connection);
			return listaIncidencias;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static IncidenciaBean buscarIncidencia(String id) {
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();

			PreparedStatement statement = connection.prepareStatement("SELECT * FROM incidencias WHERE ID = ?");
			statement.setInt(1, Integer.parseInt(id));

			ResultSet resultado = statement.executeQuery();

			if (resultado.next()) {
				IncidenciaBean incidencia = new IncidenciaBean(
						resultado.getString("id"),
						resultado.getString("titulo"),
						resultado.getString("direccion"),
						resultado.getString("descripcion"),
						resultado.getString("estado"),
						resultado.getString("prioridad"),
						resultado.getString("tipoincidencia"),
						resultado.getString("usuario"),
						resultado.getString("autonomo"),
						resultado.getString("informe")
				);

				pool.freeConnection(connection);
				return incidencia;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int crearIncidencia(String titulo, String direccion, Part partImage, String descripcion, String tipoIncidencia, Usuario creador) {
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();
			String query = "INSERT INTO USUARIO.INCIDENCIAS (TITULO, DIRECCION, IMAGEN, DESCRIPCION, ESTADO, PRIORIDAD, TIPOINCIDENCIA, USUARIO, AUTONOMO) \n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, NULL)";

			PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, titulo);
			ps.setString(2, direccion);
			ps.setBlob(3, partImage.getInputStream());
			ps.setString(4, descripcion);
			ps.setString(5, "SIN_ASIGNAR");
			ps.setString(6, "LEVE");
			ps.setString(7, tipoIncidencia.toUpperCase());
			ps.setString(8, creador.getUsername());
			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);

			return id;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static void agregarInforme(String informe, String id) {
		try {
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();
			String query = "UPDATE incidencias SET informe = ?, estado = 'SOLUCIONADA' WHERE id = ?";

			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, informe);
			ps.setString(2, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
