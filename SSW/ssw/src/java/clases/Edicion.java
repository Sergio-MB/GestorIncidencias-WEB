package clases;

import data.ConnectionPool;
import data.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Part;

public class Edicion extends HttpServlet {

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
		String username = request.getPathInfo().substring(1);

		
		String password = request.getParameter("pwd");
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String dni = request.getParameter("dni");
		String cp = request.getParameter("cp");
		String email = request.getParameter("email");
		String telefono = request.getParameter("tlfn");
		String descripcion = request.getParameter("descripcion");
		String especialidad = request.getParameter("tipo");
		String pwdHash = util.PasswordDigest.digest(password);

		try {	
			Part part = request.getPart("fotoUser");
			
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();
			String query = "UPDATE USUARIOS SET PASSWORD= ?, NOMBRE = ?, APELLIDOS = ?, DNI = ?, CP = ?," +
"                                EMAIL = ?  , TELEFONO = ?, ESPECIALIDAD = ?, DESCRIPCION = ?, IMAGEN = ? "
                                + "WHERE username LIKE '"+username+"'";
                        String query2 = "UPDATE USUARIOS SET PASSWORD= ?, NOMBRE = ?, APELLIDOS = ?, DNI = ?, CP = ?," +
"                                EMAIL = ?  , TELEFONO = ?, ESPECIALIDAD = ?, DESCRIPCION = ?"
                                + "WHERE username LIKE '"+username+"'";
                        if(part.getSize()!=0){                    
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, pwdHash);
			ps.setString(2, nombre);
			ps.setString(3, apellidos);
			ps.setString(4, dni);
			ps.setString(5, cp);
			ps.setString(6, email);
			ps.setString(7, telefono);
			ps.setString(8, especialidad != null ? especialidad.toUpperCase() : null);
			ps.setString(9, descripcion);                    
			ps.setBlob(10, part.getInputStream());
			ps.execute();
                          }else{                  
                        PreparedStatement ps = connection.prepareStatement(query2);
			ps.setString(1, pwdHash);
			ps.setString(2, nombre);
			ps.setString(3, apellidos);
			ps.setString(4, dni);
			ps.setString(5, cp);
			ps.setString(6, email);
			ps.setString(7, telefono);
			ps.setString(8, especialidad != null ? especialidad.toUpperCase() : null);
			ps.setString(9, descripcion);                    
			ps.execute();
                        }
			
			pool.freeConnection(connection);

			response.sendRedirect("../perfil/"+username);
		}catch(Exception e){
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
