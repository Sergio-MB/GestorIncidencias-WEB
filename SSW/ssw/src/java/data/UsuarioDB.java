package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.Part;

public class UsuarioDB {
    
    public static ArrayList<Usuario> muestraTodos(){
        try {
            ArrayList<Usuario> listausuarios= new ArrayList<Usuario>();
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT * FROM usuarios ");

            while (resultado.next()) {
                Usuario usuario = new Usuario(
                        resultado.getString("username"),
                        resultado.getString("password"),
                        resultado.getString("nombre"),
                        resultado.getString("apellidos"),
                        resultado.getString("dni"),
                        resultado.getString("cp"),
                        resultado.getString("email"),
                        resultado.getString("tipo"),
                        resultado.getString("telefono"),
                        resultado.getString("especialidad"),
                        resultado.getString("descripcion")
                        
                );
                listausuarios.add(usuario);
                

              
            
            }
            pool.freeConnection(connection);
             return listausuarios;
             
        } catch (Exception e) {
            return null;
        }
         
    }
    public static Usuario crearUsuario(String username, String pwdHash, String nombre, String apellidos, String dni, String cp, String email, String tipo, String telefono, String especialidad, String descripcion, Part part) {
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            String query = "INSERT INTO usuarios VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, pwdHash);
            ps.setString(3, nombre);
            ps.setString(4, apellidos);
            ps.setString(5, dni);
            ps.setString(6, cp);
            ps.setString(7, email);
            ps.setString(8, tipo);
            ps.setString(9, telefono);
            ps.setString(10, especialidad != null ? especialidad.toUpperCase() : null);
            ps.setString(11, descripcion);
            if (part.getSize() > 1) {
                ps.setBlob(12, part.getInputStream());
            } else {
                ps.setNull(12, java.sql.Types.BLOB);
            }
            ps.execute();

            pool.freeConnection(connection);

            Usuario usu = UsuarioDB.buscarUsuario("username");
            return usu;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Usuario buscarUsuario(String username) {
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT * FROM usuarios WHERE username LIKE '" + username + "'");

            if (resultado.next()) {
                Usuario usuario = new Usuario(
                        resultado.getString("username"),
                        resultado.getString("password"),
                        resultado.getString("nombre"),
                        resultado.getString("apellidos"),
                        resultado.getString("dni"),
                        resultado.getString("cp"),
                        resultado.getString("email"),
                        resultado.getString("tipo"),
                        resultado.getString("telefono"),
                        resultado.getString("especialidad"),
                        resultado.getString("descripcion")
                );

                pool.freeConnection(connection);

                return usuario;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static Usuario login(String username, String pwdHash) {
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT * FROM usuarios WHERE username LIKE '" + username + "' AND password LIKE '" + pwdHash + "'");
            if (resultado.next()) {
                Usuario usuario = new Usuario(
                        resultado.getString("username"),
                        resultado.getString("password"),
                        resultado.getString("nombre"),
                        resultado.getString("apellidos"),
                        resultado.getString("dni"),
                        resultado.getString("cp"),
                        resultado.getString("email"),
                        resultado.getString("tipo"),
                        resultado.getString("telefono"),
                        resultado.getString("especialidad"),
                        resultado.getString("descripcion")
                );

                pool.freeConnection(connection);
                return usuario;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
