/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dierodr
 */
public class ComentarioDB {

    public static ArrayList<Comentario> getComentarios(String incidenciaId) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT * FROM comentarios WHERE incidencia = " + incidenciaId);
            ArrayList<Comentario> comentarios = new ArrayList<Comentario>();

            while (resultado.next()) {
                Comentario comentario = new Comentario(
                        resultado.getString("usuario"),
                        resultado.getString("incidencia"),
                        resultado.getString("comentario")
                );
                comentarios.add(comentario);
            }

            pool.freeConnection(connection);
            return comentarios;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static int crearComentario(Usuario usuario, int id, String comentario, int voto) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String query = "INSERT INTO USUARIO.COMENTARIOS (USUARIO,INCIDENCIA,COMENTARIO) VALUES(?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, usuario.getUsername());
            ps.setInt(2, id);

            ps.setString(3, comentario);

            int res = ps.executeUpdate();
            ps.close();

            pool.freeConnection(connection);

            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

}
