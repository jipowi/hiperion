/*
 * Copyright 2014 JIPOVI
 Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,06/04/2015
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class IngresarAsistenciaMedicaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cliente;
	private String aseguradora;
	private String ramo;
	private double poliza;
	private String paciente;
	private String parentesco;
	private Date fechaNotificacion;
	private Date fechaIncurrencia;
	private String observaciones;
	
	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the aseguradora
	 */
	public String getAseguradora() {
		return aseguradora;
	}
	/**
	 * @param aseguradora the aseguradora to set
	 */
	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}
	/**
	 * @return the ramo
	 */
	public String getRamo() {
		return ramo;
	}
	/**
	 * @param ramo the ramo to set
	 */
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}
	/**
	 * @return the poliza
	 */
	public double getPoliza() {
		return poliza;
	}
	/**
	 * @param poliza the poliza to set
	 */
	public void setPoliza(double poliza) {
		this.poliza = poliza;
	}
	/**
	 * @return the paciente
	 */
	public String getPaciente() {
		return paciente;
	}
	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	/**
	 * @return the parentesco
	 */
	public String getParentesco() {
		return parentesco;
	}
	/**
	 * @param parentesco the parentesco to set
	 */
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	/**
	 * @return the fechaNotificacion
	 */
	public Date getFechaNotificacion() {
		return fechaNotificacion;
	}
	/**
	 * @param fechaNotificacion the fechaNotificacion to set
	 */
	public void setFechaNotificacion(Date fechaNotificacion) {
		this.fechaNotificacion = fechaNotificacion;
	}
	/**
	 * @return the fechaIncurrencia
	 */
	public Date getFechaIncurrencia() {
		return fechaIncurrencia;
	}
	/**
	 * @param fechaIncurrencia the fechaIncurrencia to set
	 */
	public void setFechaIncurrencia(Date fechaIncurrencia) {
		this.fechaIncurrencia = fechaIncurrencia;
	}
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}