/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author dierodr
 */
public class Comentario implements Serializable {

	private String usuario;
	private String incidencia;
	private String comentario;

	public Comentario() {
	}

	public Comentario(String usuario, String incidencia, String comentario) {
		this.usuario = usuario;
		this.incidencia = incidencia;
		this.comentario = comentario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
