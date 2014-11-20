/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <b> Clase base con atributos comunes de todas las entidades para el control de auditoria del sistema hiperion </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Nov 18, 2014
 * @since JDK1.6
 */
@MappedSuperclass
public class Auditoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Column(name = "id_usuario_actualizacion")
	private Integer idUsuarioActualizacion;

	@Column(name = "id_usuario_creacion")
	private Integer idUsuarioCreacion;

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the fechaActualizacion
	 */
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	/**
	 * @param fechaActualizacion
	 *            the fechaActualizacion to set
	 */
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion
	 *            the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the idUsuarioActualizacion
	 */
	public Integer getIdUsuarioActualizacion() {
		return idUsuarioActualizacion;
	}

	/**
	 * @param idUsuarioActualizacion
	 *            the idUsuarioActualizacion to set
	 */
	public void setIdUsuarioActualizacion(Integer idUsuarioActualizacion) {
		this.idUsuarioActualizacion = idUsuarioActualizacion;
	}

	/**
	 * @return the idUsuarioCreacion
	 */
	public Integer getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}

	/**
	 * @param idUsuarioCreacion
	 *            the idUsuarioCreacion to set
	 */
	public void setIdUsuarioCreacion(Integer idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}

}
