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
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,06/04/2015
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class IngresarSiniestroBean implements Serializable {

	/**
	 * Declaracion de variables  
	 */
	private static final long serialVersionUID = 1L;
	private String asegurado;
	private String ajustador;
	private String ramo;
	private String telefono;
	private String recAvila;
	private String repAvila;
	private String reporte;
	private String aseguradora; 
	private String poliza;
	private String perReporta;
	// fechas para relizar los calculos
	private Date fecSiniestro;
	private Date fecCliente ;
	private Date fecAseguradora; 
	private Date fecUltimoDoc;
	private Date fecInde;  
	private int diasSiniInde; 
	private int	diasSiniClie; 
	private int diasClieAseg; 
	private int diasSiniAseg; 
	private int diasSiniUltidocu; 
	private int diasUltidocuInde; 
	private String causa; 
	private String bienAsegurado;
	private double valorAsegurado;
	private double valorSiniestro;
	private double deducible;
	private double rasa;
	private double depreciacion; 
	private double totalIndemnizacion; 
	private double deducibleRasa; 
	private int numDias; 
	private double porcValorSiniestro;
	private double minValor;
	private Date vigenciaPoliza;
	private double tasa;
	private double porcValorAsegurado; 
	private String repAseguradora;
	
	/**
	 * @return the deducible
	 */
	public double getDeducible() {
		return deducible;
	}
	
	
	/**
	 * @return the repAseguradora
	 */
	public String getRepAseguradora() {
		return repAseguradora;
	}


	/**
	 * @param repAseguradora the repAseguradora to set
	 */
	public void setRepAseguradora(String repAseguradora) {
		this.repAseguradora = repAseguradora;
	}


	/**
	 * @param deducible the deducible to set
	 */
	public void setDeducible(double deducible) {
		this.deducible = deducible;
	}
	/**
	 * @return the rasa
	 */
	public double getRasa() {
		return rasa;
	}
	/**
	 * @param rasa the rasa to set
	 */
	public void setRasa(double rasa) {
		this.rasa = rasa;
	}
	/**
	 * @return the depreciacion
	 */
	public double getDepreciacion() {
		return depreciacion;
	}
	/**
	 * @param depreciacion the depreciacion to set
	 */
	public void setDepreciacion(double depreciacion) {
		this.depreciacion = depreciacion;
	}
	/**
	 * @return the totalIndemnizacion
	 */
	public double getTotalIndemnizacion() {
		return totalIndemnizacion;
	}
	/**
	 * @param totalIndemnizacion the totalIndemnizacion to set
	 */
	public void setTotalIndemnizacion(double totalIndemnizacion) {
		this.totalIndemnizacion = totalIndemnizacion;
	}
	/**
	 * @return the deducibleRasa
	 */
	public double getDeducibleRasa() {
		return deducibleRasa;
	}
	/**
	 * @param deducibleRasa the deducibleRasa to set
	 */
	public void setDeducibleRasa(double deducibleRasa) {
		this.deducibleRasa = deducibleRasa;
	}
	/**
	 * @return the numDias
	 */
	public int getNumDias() {
		return numDias;
	}
	/**
	 * @param numDias the numDias to set
	 */
	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}
	/**
	 * @return the porcValorSiniestro
	 */
	public double getPorcValorSiniestro() {
		return porcValorSiniestro;
	}
	/**
	 * @param porcValorSiniestro the porcValorSiniestro to set
	 */
	public void setPorcValorSiniestro(double porcValorSiniestro) {
		this.porcValorSiniestro = porcValorSiniestro;
	}
	/**
	 * @return the minValor
	 */
	public double getMinValor() {
		return minValor;
	}
	/**
	 * @param minValor the minValor to set
	 */
	public void setMinValor(double minValor) {
		this.minValor = minValor;
	}
	/**
	 * @return the vigenciaPoliza
	 */
	public Date getVigenciaPoliza() {
		return vigenciaPoliza;
	}
	/**
	 * @param vigenciaPoliza the vigenciaPoliza to set
	 */
	public void setVigenciaPoliza(Date vigenciaPoliza) {
		this.vigenciaPoliza = vigenciaPoliza;
	}
	/**
	 * @return the tasa
	 */
	public double getTasa() {
		return tasa;
	}
	/**
	 * @param tasa the tasa to set
	 */
	public void setTasa(double tasa) {
		this.tasa = tasa;
	}
	/**
	 * @return the porcValorAsegurado
	 */
	public double getPorcValorAsegurado() {
		return porcValorAsegurado;
	}
	/**
	 * @param porcValorAsegurado the porcValorAsegurado to set
	 */
	public void setPorcValorAsegurado(double porcValorAsegurado) {
		this.porcValorAsegurado = porcValorAsegurado;
	}
	/**
	 * @return the causa
	 */
	public String getCausa() {
		return causa;
	}
	/**
	 * @param causa the causa to set
	 */
	public void setCausa(String causa) {
		this.causa = causa;
	}
	/**
	 * @return the bienAsegurado
	 */
	public String getBienAsegurado() {
		return bienAsegurado;
	}
	/**
	 * @param bienAsegurado the bienAsegurado to set
	 */
	public void setBienAsegurado(String bienAsegurado) {
		this.bienAsegurado = bienAsegurado;
	}
	/**
	 * @return the valorAsegurado
	 */
	public double getValorAsegurado() {
		return valorAsegurado;
	}
	/**
	 * @param valorAsegurado the valorAsegurado to set
	 */
	public void setValorAsegurado(double valorAsegurado) {
		this.valorAsegurado = valorAsegurado;
	}
	/**
	 * @return the valorSiniestro
	 */
	public double getValorSiniestro() {
		return valorSiniestro;
	}
	/**
	 * @param valorSiniestro the valorSiniestro to set
	 */
	public void setValorSiniestro(double valorSiniestro) {
		this.valorSiniestro = valorSiniestro;
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
	 * @return the ajustador
	 */
	public String getAjustador() {
		return ajustador;
	}
	/**
	 * @param ajustador the ajustador to set
	 */
	public void setAjustador(String ajustador) {
		this.ajustador = ajustador;
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
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the recAvila
	 */
	public String getRecAvila() {
		return recAvila;
	}
	/**
	 * @param recAvila the recAvila to set
	 */
	public void setRecAvila(String recAvila) {
		this.recAvila = recAvila;
	}
	/**
	 * @return the repAvila
	 */
	public String getRepAvila() {
		return repAvila;
	}
	/**
	 * @param repAvila the repAvila to set
	 */
	public void setRepAvila(String repAvila) {
		this.repAvila = repAvila;
	}
	/**
	 * @return the reporte
	 */
	public String getReporte() {
		return reporte;
	}
	/**
	 * @param reporte the reporte to set
	 */
	public void setReporte(String reporte) {
		this.reporte = reporte;
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
	 * @return the perReporta
	 */
	public String getPerReporta() {
		return perReporta;
	}
	/**
	 * @param perReporta the perReporta to set
	 */
	public void setPerReporta(String perReporta) {
		this.perReporta = perReporta;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the fecSiniestro
	 */
	public Date getFecSiniestro() {
		return fecSiniestro;
	}
	/**
	 * @param fecSiniestro the fecSiniestro to set
	 */
	public void setFecSiniestro(Date fecSiniestro) {
		this.fecSiniestro = fecSiniestro;
	}
	/**
	 * @return the fecCliente
	 */
	public Date getFecCliente() {
		return fecCliente;
	}
	/**
	 * @param fecCliente the fecCliente to set
	 */
	public void setFecCliente(Date fecCliente) {
		this.fecCliente = fecCliente;
	}
	/**
	 * @return the fecAseguradora
	 */
	public Date getFecAseguradora() {
		return fecAseguradora;
	}
	/**
	 * @param fecAseguradora the fecAseguradora to set
	 */
	public void setFecAseguradora(Date fecAseguradora) {
		this.fecAseguradora = fecAseguradora;
	}
	/**
	 * @return the fecUltimoDoc
	 */
	public Date getFecUltimoDoc() {
		return fecUltimoDoc;
	}
	/**
	 * @param fecUltimoDoc the fecUltimoDoc to set
	 */
	public void setFecUltimoDoc(Date fecUltimoDoc) {
		this.fecUltimoDoc = fecUltimoDoc;
	}
	/**
	 * @return the fecInde
	 */
	public Date getFecInde() {
		return fecInde;
	}
	/**
	 * @param fecInde the fecInde to set
	 */
	public void setFecInde(Date fecInde) {
		this.fecInde = fecInde;
	}
	/**
	 * @return the diasSiniInde
	 */
	public int getDiasSiniInde() {
		return diasSiniInde;
	}
	/**
	 * @param diasSiniInde the diasSiniInde to set
	 */
	public void setDiasSiniInde(int diasSiniInde) {
		this.diasSiniInde = diasSiniInde;
	}
	/**
	 * @return the diasSiniClie
	 */
	public int getDiasSiniClie() {
		return diasSiniClie;
	}
	/**
	 * @param diasSiniClie the diasSiniClie to set
	 */
	public void setDiasSiniClie(int diasSiniClie) {
		this.diasSiniClie = diasSiniClie;
	}
	/**
	 * @return the diasClieAseg
	 */
	public int getDiasClieAseg() {
		return diasClieAseg;
	}
	/**
	 * @param diasClieAseg the diasClieAseg to set
	 */
	public void setDiasClieAseg(int diasClieAseg) {
		this.diasClieAseg = diasClieAseg;
	}
	/**
	 * @return the diasSiniAseg
	 */
	public int getDiasSiniAseg() {
		return diasSiniAseg;
	}
	/**
	 * @param diasSiniAseg the diasSiniAseg to set
	 */
	public void setDiasSiniAseg(int diasSiniAseg) {
		this.diasSiniAseg = diasSiniAseg;
	}
	/**
	 * @return the diasSiniUltidocu
	 */
	public int getDiasSiniUltidocu() {
		return diasSiniUltidocu;
	}
	/**
	 * @param diasSiniUltidocu the diasSiniUltidocu to set
	 */
	public void setDiasSiniUltidocu(int diasSiniUltidocu) {
		this.diasSiniUltidocu = diasSiniUltidocu;
	}
	/**
	 * @return the diasUltidocuInde
	 */
	public int getDiasUltidocuInde() {
		return diasUltidocuInde;
	}
	/**
	 * @param diasUltidocuInde the diasUltidocuInde to set
	 */
	public void setDiasUltidocuInde(int diasUltidocuInde) {
		this.diasUltidocuInde = diasUltidocuInde;
	} 



}
