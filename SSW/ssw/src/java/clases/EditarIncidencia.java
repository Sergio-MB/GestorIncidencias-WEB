package clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import data.ConnectionPool;
import data.OptaDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author pastor
 */
public class EditarIncidencia extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String id = request.getPathInfo().substring(1);

		String titulo = request.getParameter("titulo");
		String direccion = request.getParameter("direccion");
		String descripcion = request.getParameter("descripcion");
		String estado = util.FormatearString.toDatabase(request.getParameter("estado"));
		String prioridad = request.getParameter("prioridad");
		String tipoincidencia = request.getParameter("tipo");

		String usuarioAsignado = request.getParameter("autonomo");
		if (usuarioAsignado != null && !"Sin asignar".equals(usuarioAsignado)) {
			OptaDB.asignar(usuarioAsignado, id);
			estado = "EN_PROGRESO";
		}

		try {
			Part part = request.getPart("foto");

			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();
			String query = "UPDATE incidencias SET titulo= ?, direccion = ?, descripcion = ?, estado = ?, prioridad = ?,"
					+ "tipoincidencia = ?  , IMAGEN = ? "
					+ "WHERE id = " + id;
			String query2 = "UPDATE incidencias SET titulo= ?, direccion = ?, descripcion = ?, estado = ?, prioridad = ?,"
					+ "tipoincidencia = ?  "
					+ "WHERE id = " + id;
			if (part.getSize() != 0) {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, titulo);
				ps.setString(2, direccion);
				ps.setString(3, descripcion);
				ps.setString(4, estado.toUpperCase());
				ps.setString(5, prioridad.toUpperCase());
				ps.setString(6, tipoincidencia.toUpperCase());
				ps.setBlob(7, part.getInputStream());
				ps.execute();
			} else {
				PreparedStatement ps = connection.prepareStatement(query2);
				ps.setString(1, titulo);
				ps.setString(2, direccion);
				ps.setString(3, descripcion);
				ps.setString(4, estado.toUpperCase());
				ps.setString(5, prioridad.toUpperCase());
				ps.setString(6, tipoincidencia.toUpperCase());
				ps.execute();
			}

			pool.freeConnection(connection);

			response.sendRedirect("../incidencia/" + id);
		} catch (Exception e) {

			out.println("ERROR  " + id + titulo + direccion + descripcion + "         .........");

			out.println(e.toString());
			e.printStackTrace();
		}
	}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
