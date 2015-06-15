 /*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/** 
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *  
 * @author Fernando
 * @version 1.0,04/05/2015
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class IngresarDatosSiniestroBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numerico;
	private String tipoCliente;
	private String nombreCliente;
	private String descripcionAsegurado;
	private String aseguradora;
	private int numeroReporte;
	private int numeroReclamo;
	private String ramo;
	private Date Fecha;
	private String estado;
	/**
	 * @return the numerico
	 */
	public int getNumerico() {
		return numerico;
	}
	/**
	 * @param numerico the numerico to set
	 */
	public void setNumerico(int numerico) {
		this.numerico = numerico;
	}
	/**
	 * @return the tipoCliente
	 */
	public String getTipoCliente() {
		return tipoCliente;
	}
	/**
	 * @param tipoCliente the tipoCliente to set
	 */
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}
	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	/**
	 * @return the descripcionAsegurado
	 */
	public String getDescripcionAsegurado() {
		return descripcionAsegurado;
	}
	/**
	 * @param descripcionAsegurado the descripcionAsegurado to set
	 */
	public void setDescripcionAsegurado(String descripcionAsegurado) {
		this.descripcionAsegurado = descripcionAsegurado;
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
	 * @return the numeroReporte
	 */
	public int getNumeroReporte() {
		return numeroReporte;
	}
	/**
	 * @param numeroReporte the numeroReporte to set
	 */
	public void setNumeroReporte(int numeroReporte) {
		this.numeroReporte = numeroReporte;
	}
	/**
	 * @return the numeroReclamo
	 */
	public int getNumeroReclamo() {
		return numeroReclamo;
	}
	/**
	 * @param numeroReclamo the numeroReclamo to set
	 */
	public void setNumeroReclamo(int numeroReclamo) {
		this.numeroReclamo = numeroReclamo;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return Fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	

}