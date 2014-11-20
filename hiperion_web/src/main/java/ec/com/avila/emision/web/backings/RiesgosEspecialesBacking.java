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

import ec.com.avila.emision.web.beans.RamoRiesgosEspecialesBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoRiesgosEsp;
import ec.com.avila.hiperion.servicio.RamoRiesgosEspecialesService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Riesgos Especiales. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RiesgosEspecialesBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{ramoRiesgosEspecialesBean}")
	private RamoRiesgosEspecialesBean ramoRiesgosEspecialesBean;

	@EJB
	private RamoService ramoService;

	@EJB
	private RamoRiesgosEspecialesService ramoRiesgosEspecialesService;

	Logger log = Logger.getLogger(RiesgosEspecialesBacking.class);

	/**
	 * 
	 * <b> Permite guardar la informacion del ramo y objeto asegurado en sus respectivas tablas </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 11/11/2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {

		RamoRiesgosEsp ramoRiesgosEsp = new RamoRiesgosEsp();

		ramoRiesgosEsp.setTasaRiesgosEsp(ramoRiesgosEspecialesBean.getTasa());
		ramoRiesgosEsp.setCondImpRiesgos(ramoRiesgosEspecialesBean.getCondicionesImp());

		try {
			ramoRiesgosEspecialesService.guardarRamoRiesgosEspeciales(ramoRiesgosEsp);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.sOjeto"));
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el Ramo riesgos especiales", e);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));
			throw new HiperionException(e);
		}

	}

	/**
	 * @return the ramoRiesgosEspecialesBean
	 */
	public RamoRiesgosEspecialesBean getRamoRiesgosEspecialesBean() {
		return ramoRiesgosEspecialesBean;
	}

	/**
	 * @param ramoRiesgosEspecialesBean
	 *            the ramoRiesgosEspecialesBean to set
	 */
	public void setRamoRiesgosEspecialesBean(RamoRiesgosEspecialesBean ramoRiesgosEspecialesBean) {
		this.ramoRiesgosEspecialesBean = ramoRiesgosEspecialesBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}
}