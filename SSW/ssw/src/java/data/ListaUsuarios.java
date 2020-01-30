package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ListaUsuarios {

    private ArrayList<data.Usuario> lista = null;

	public ListaUsuarios() {
		lista = new ArrayList<>();
	}
	
    public void listarTodos() {
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT * FROM usuarios");

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

                lista.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Usuario> getLista() {
        return lista;
    }

	public void setLista(ArrayList<Usuario> lista) {
		this.lista = lista;
	}
	
	public void addUsuario(Usuario usu){
		lista.add(usu);
	}
}
