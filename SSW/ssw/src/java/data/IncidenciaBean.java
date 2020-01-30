/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import util.FormatearString;

/**
 *
 * @author dierodr
 */
public class IncidenciaBean implements Serializable {

	private String id;
	private String titulo;
	private String direccion;
	private String descripcion;
	private String estado;
	private String prioridad;
	private String tipoIncidencia;
	private String usuario;
	private String autonomo;
	private String informe;

	public IncidenciaBean() {
	}

	public IncidenciaBean(String id, String titulo, String direccion, String descripcion, String estado, String prioridad, String tipoIncidencia, String usuario, String autonomo) {
		this.id = id;
		this.titulo = titulo;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.estado = estado;
		this.prioridad = prioridad;
		this.tipoIncidencia = tipoIncidencia;
		this.usuario = usuario;
		this.autonomo = autonomo;
	}
	
		public IncidenciaBean(String id, String titulo, String direccion, String descripcion, String estado, String prioridad, String tipoIncidencia, String usuario, String autonomo, String informe) {
		this.id = id;
		this.titulo = titulo;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.estado = estado;
		this.prioridad = prioridad;
		this.tipoIncidencia = tipoIncidencia;
		this.usuario = usuario;
		this.autonomo = autonomo;
		this.informe = informe;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return FormatearString.toView(estado);
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPrioridad() {
		return FormatearString.toView(prioridad);
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getTipoIncidencia() {
		return FormatearString.toView(tipoIncidencia);
	}

	public void setTipoIncidencia(String tipoIncidencia) {
		this.tipoIncidencia = tipoIncidencia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getAutonomo() {
		return autonomo;
	}

	public void setAutonomo(String autonomo) {
		this.autonomo = autonomo;
	}

	public String getInforme() {
		return informe;
	}

	public void setInforme(String informe) {
		this.informe = informe;
	}
	
}
