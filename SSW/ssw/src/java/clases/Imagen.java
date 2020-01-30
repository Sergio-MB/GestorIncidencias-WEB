package clases;

import data.ConnectionPool;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Imagen extends HttpServlet {

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
		OutputStream respuesta = response.getOutputStream();
		String tipo = request.getParameter("tipo");
		String id = request.getParameter("id");
		try{
			ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();
			PreparedStatement statement = null;
			if (tipo.equals("u")){
				statement = connection.prepareStatement("SELECT imagen FROM usuarios WHERE username LIKE ?");
			}else if(tipo.equals("i")){
				statement = connection.prepareStatement("SELECT imagen FROM incidencias WHERE id = ?");
			}
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()){
				Blob blob = result.getBlob("imagen");
				if (!result.wasNull() && blob.length() > 1){
					InputStream imagen = blob.getBinaryStream();
					response.setContentType("image/jpg");
					byte[] buffer = new byte[1000];
					int len = imagen.read(buffer);
					while (len != -1){
						respuesta.write(buffer, 0, len);
						len = imagen.read(buffer);
					}
					imagen.close();
					respuesta.close();
					response.flushBuffer();
				}else{ // No hay imagen
					InputStream imagen = null;
					if (tipo.equals("u")){
						response.setContentType("image/svg+xml");
						imagen = new FileInputStream(getServletContext().getRealPath("/img/usuario.svg"));
					}else if(tipo.equals("i")){
						response.setContentType("image/png");
						imagen = new FileInputStream(getServletContext().getRealPath("/img/incidencia.png"));
					}
					byte[] buffer = new byte[1000];
					int len = imagen.read(buffer);
					while (len != -1){
						respuesta.write(buffer, 0, len);
						len = imagen.read(buffer);
					}
					imagen.close();
					respuesta.close();
					response.flushBuffer();
				}
			}
			pool.freeConnection(connection);
		
		}catch(Exception e){
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
