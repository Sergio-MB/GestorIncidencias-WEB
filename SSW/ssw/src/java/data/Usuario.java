package data;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class Usuario implements Serializable {

    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String dni;
    private String cp;
    private String email;
    private String tipo;
    private String telefono;
    private String especialidad;
    private String descripcion;

    public Usuario() {
    }

    public Usuario(String username, String password, String nombre, String apellidos, String dni, String cp, String email, String tipo, String telefono, String especialidad, String descripcion) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.cp = cp;
        this.email = email;
        this.tipo = tipo;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.descripcion = descripcion;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getCp() {
        return cp;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isAutonomo() {
        return tipo.equals("AUTONOMO");
    }

    public boolean isNormal() {
        return tipo.equals("NORMAL");
    }

    public boolean isAdmin() {
        return tipo.equals("ADMIN");
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
    
}
