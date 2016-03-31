/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/** 
 * <b>
 * Incluir aqui la descripcion de la clase.
 * </b>
 *  
 * @author Jona
 * @version 1.0,02/05/2015
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class IngresarLiquidacionBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cliente;
	private String ramo;
	private String poliza;
	private String asegurado;
	private String empresa;
	private Date fechaIncurrencia;
	private Date fechaNotificacion;
	private String paciente;
	private String tipoAtencion;
	private BigDecimal valorPresentado;
	private BigDecimal valorNoCubierto;
	private BigDecimal deducible;
	private BigDecimal porcentajeCoasegurado;
	private BigDecimal valorCoasegurado;
	private BigDecimal valorPagar;
	/**
	 * @return the paciente
	 */
	public String getPaciente() {
		return paciente;
	}
	/**
	 * @return the valorCoasegurado
	 */
	public BigDecimal getValorCoasegurado() {
		return valorCoasegurado;
	}
	/**
	 * @param valorCoasegurado the valorCoasegurado to set
	 */
	public void setValorCoasegurado(BigDecimal valorCoasegurado) {
		this.valorCoasegurado = valorCoasegurado;
	}
	/**
	 * @return the valorPagar
	 */
	public BigDecimal getValorPagar() {
		return valorPagar;
	}
	/**
	 * @param valorPagar the valorPagar to set
	 */
	public void setValorPagar(BigDecimal valorPagar) {
		this.valorPagar = valorPagar;
	}
	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	/**
	 * @return the tipoAtencion
	 */
	public String getTipoAtencion() {
		return tipoAtencion;
	}
	/**
	 * @param tipoAtencion the tipoAtencion to set
	 */
	public void setTipoAtencion(String tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
	}
	/**
	 * @return the valorPresentado
	 */
	public BigDecimal getValorPresentado() {
		return valorPresentado;
	}
	/**
	 * @param valorPresentado the valorPresentado to set
	 */
	public void setValorPresentado(BigDecimal valorPresentado) {
		this.valorPresentado = valorPresentado;
	}
	/**
	 * @return the valorNoCubierto
	 */
	public BigDecimal getValorNoCubierto() {
		return valorNoCubierto;
	}
	/**
	 * @param valorNoCubierto the valorNoCubierto to set
	 */
	public void setValorNoCubierto(BigDecimal valorNoCubierto) {
		this.valorNoCubierto = valorNoCubierto;
	}
	/**
	 * @return the deducible
	 */
	public BigDecimal getDeducible() {
		return deducible;
	}
	/**
	 * @param deducible the deducible to set
	 */
	public void setDeducible(BigDecimal deducible) {
		this.deducible = deducible;
	}
	/**
	 * @return the porcentajeCoasegurado
	 */
	public BigDecimal getPorcentajeCoasegurado() {
		return porcentajeCoasegurado;
	}
	/**
	 * @param porcentajeCoasegurado the porcentajeCoasegurado to set
	 */
	public void setPorcentajeCoasegurado(BigDecimal porcentajeCoasegurado) {
		this.porcentajeCoasegurado = porcentajeCoasegurado;
	}
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
	public String getPoliza() {
		return poliza;
	}
	/**
	 * @param poliza the poliza to set
	 */
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}
	/**
	 * @return the asegurado
	 */
	public String getAsegurado() {
		return asegurado;
	}
	/**
	 * @param asegurado the asegurado to set
	 */
	public void setAsegurado(String asegurado) {
		this.asegurado = asegurado;
	}
	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}
	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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
}
