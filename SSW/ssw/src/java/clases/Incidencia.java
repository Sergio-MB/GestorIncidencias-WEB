package clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import data.ConnectionPool;
import data.IncidenciaBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dierodr
 */
@WebServlet(urlPatterns = {"/incidencia/*"})
public class Incidencia extends HttpServlet {

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

		data.ListaUsuarios optan = data.OptaDB.listar(id);

		IncidenciaBean incidencia = data.IncidenciaDB.buscarIncidencia(id);
		if (incidencia != null) {
			// Formatear las constantes para que solo tengan la primera mayuscula
			String str = incidencia.getTipoIncidencia();
			incidencia.setTipoIncidencia(str);

			str = incidencia.getPrioridad();
			incidencia.setPrioridad(str);

			str = incidencia.getEstado();
			str = str.replace("_", " ");
			incidencia.setEstado(str);

			request.setAttribute("incidencia", incidencia);
			request.setAttribute("optan", optan.getLista());
			request.setAttribute("destino", "/incidencia.jsp");
			out.println(request.getRequestURI());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/VerComentarios");
			dispatcher.forward(request, response);
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
