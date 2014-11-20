/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.RamoCascoAereoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoCascoAereo;
import ec.com.avila.hiperion.servicio.RamoCascoAereoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b> Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Casco Aereo. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,18/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class CascoAereoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoCascoAereoService ramoCascoAereoService;

	@ManagedProperty(value = "#{ramoCascoAereoBean}")
	private RamoCascoAereoBean ramoCascoAereoBean;

	Logger log = Logger.getLogger(CascoAereoBacking.class);

	/**
	 * 
	 * <b> Permite guardar un objeto Ramo Casco Aereo en la base de datos. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 14/08/2014]
	 * </p>
	 * 
	 */
	public void guardarRamo() throws HiperionException {
		RamoCascoAereo cascoAereo = new RamoCascoAereo();

		cascoAereo.setMatricula(ramoCascoAereoBean.getMatricula());
		cascoAereo.setAnioConstruccionAereo(ramoCascoAereoBean.getAnioConstruccion());
		cascoAereo.setPesoMaximoAereo(ramoCascoAereoBean.getPesoMaximo());
		cascoAereo.setValorCascoAereo(ramoCascoAereoBean.getValorCasco());
		cascoAereo.setMarcaAereo(ramoCascoAereoBean.getMarca());
		cascoAereo.setTipoModeloAereo(ramoCascoAereoBean.getTipoModelo());
		cascoAereo.setHorasVoladas(ramoCascoAereoBean.getHorasVoladas());
		cascoAereo.setMaximaCargaAereo(ramoCascoAereoBean.getMaximaCarga());
		cascoAereo.setMarcaMotorAereo(ramoCascoAereoBean.getMarcaMotor());
		cascoAereo.setTipoMotorAereo(ramoCascoAereoBean.getTipoMotor());
		cascoAereo.setTotalAseguradoAereo(ramoCascoAereoBean.getTotalAsegurado());
		cascoAereo.setTasaCascoAereo(ramoCascoAereoBean.getTasa());
		cascoAereo.setDeducSiniestroAereo(ramoCascoAereoBean.getPorcentajeSiniestro());
		cascoAereo.setDeducMinimoSiniestroAereo(ramoCascoAereoBean.getMinimoSiniestro());
		

		try {

			ramoCascoAereoService.guardarRamoCascoAereo(cascoAereo);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.sOjeto"));

		} catch (HiperionException e) {

			log.error("Error al guardar el Ramo Casco Aereo", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.cascoAereo"));
		}

	}

	/**
	 * @return the ramoCascoAereoBean
	 */
	public RamoCascoAereoBean getRamoCascoAereoBean() {
		return ramoCascoAereoBean;
	}

	/**
	 * @param ramoCascoAereoBean
	 *            the ramoCascoAereoBean to set
	 */
	public void setRamoCascoAereoBean(RamoCascoAereoBean ramoCascoAereoBean) {
		this.ramoCascoAereoBean = ramoCascoAereoBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}
}
