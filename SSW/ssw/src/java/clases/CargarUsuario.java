package clases;


import data.ConnectionPool;
import data.Usuario;
import data.UsuarioDB;
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

public class CargarUsuario extends HttpServlet {

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

        Usuario usuario = UsuarioDB.buscarUsuario(username);

        request.setAttribute("usuario", usuario);
        out.println(request.getRequestURI());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EditarUsuario.jsp");
        dispatcher.forward(request, response);
        response.sendRedirect("carga/" + username);

        //try {	
        //Part part = request.getPart("fotoUser");
        /*ConnectionPool pool = ConnectionPool.getInstance();
			Connection connection = pool.getConnection();
                        
              
                        String query = "Select * from usuarios where username=?";
                        PreparedStatement ps = connection.prepareStatement(query);
                        ResultSet rs = null;
			ps.setString(1, username);
                        rs = ps.executeQuery();
                        Usuario usuario = null;
                        String password = request.getParameter("pwd");
                        String nombre = request.getParameter("nombre");
                        String apellidos = request.getParameter("apellidos");
                        String dni = request.getParameter("dni");
                        String cp = request.getParameter("cp");
                        String email = request.getParameter("email");
                        String telefono = request.getParameter("tlfn");
                        String pwdHash = util.PasswordDigest.digest("aa");*/
 /*if(rs.next()){
                            usuario = new Usuario();
                            usuario.setNombre(nombre);
                            usuario.setApellidos(apellidos);
                            usuario.setCp(cp);
                            usuario.setDni(dni);
                            usuario.setEmail(email);
                            usuario.setTelefono(telefono);

                        }*/
 /*rs.close();
                        ps.close();            
			pool.freeConnection(connection);
                        
                        
                        
                        request.setAttribute("usuario", usuario);
			out.println(request.getRequestURI());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/EditarUsuario.jsp");
			dispatcher.forward(request, response);
                        response.sendRedirect("editarperfil/"+username);*/
        //String query = "UPDATE USUARIOS SET (?,?,?,?,?,?,?,?,?,?,?) WHERE USERNAME="+username+"";
        /*                                   
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
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
			ps.execute();*/
 /*}catch(Exception e){
			out.println(e.toString());
			e.printStackTrace();
		}*/
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
