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

import ec.com.avila.emision.web.beans.RamoRiesgoContratistaBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoContratista;
import ec.com.avila.hiperion.servicio.RamoRiesgoContratistaService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b> Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Todo Riesgo Contratista.
 * </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,20/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RiesgosContratistaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoRiesgoContratistaService ramoRiesgoContratistaService;
	
	@ManagedProperty(value = "#{ramoRiesgoContratistaBean}")
	private RamoRiesgoContratistaBean ramoRiesgoContratistaBean;

	Logger log = Logger.getLogger(RiesgosContratistaBacking.class);

	

	/**
	 * 
	 * <b>
	 * Prmite guardar informacion en el Ramo Riesgo contrataista
	 * </b>
	 * <p>[Author: Franklin Pozo, Date: 05/09/2014]</p>
	 *
	 */
	public void guardarRamo()throws HiperionException {
		RamoRiesgoContratista ramoRiesgoContratista=new RamoRiesgoContratista();
		
		ramoRiesgoContratista.setPeriodConstruccionContratista(ramoRiesgoContratistaBean.getPeriodoConstruccion());
		ramoRiesgoContratista.setPeriodMantContratista(ramoRiesgoContratistaBean.getPeriodoMantenimiento());
		ramoRiesgoContratista.setMinimoAmparoA(ramoRiesgoContratistaBean.getPorcentajeConstruccionA());
		ramoRiesgoContratista.setMinimoAmparoA(ramoRiesgoContratistaBean.getMinimoA());
		ramoRiesgoContratista.setMinimoAmparoB(ramoRiesgoContratistaBean.getMinimoB());
		ramoRiesgoContratista.setAmparoCContratista(ramoRiesgoContratistaBean.getPorcentajeConstruccionC());
		ramoRiesgoContratista.setMinimoAmparoC(ramoRiesgoContratistaBean.getMinimoC());
		ramoRiesgoContratista.setAmparoDContratista(ramoRiesgoContratistaBean.getPorcentajeConstruccionD());
		ramoRiesgoContratista.setMinimoAmparoD(ramoRiesgoContratistaBean.getMinimoD());
		ramoRiesgoContratista.setAmparoGContratista(ramoRiesgoContratistaBean.getPorcentajeG());
		ramoRiesgoContratista.setMinimoAmparoG(ramoRiesgoContratistaBean.getMinimoG());
		ramoRiesgoContratista.setTasaPeridConst(ramoRiesgoContratistaBean.getTasa());
		
		try{
			ramoRiesgoContratistaService.guardarRamoRiesgoContratista(ramoRiesgoContratista);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.todoRiesgoContratista"));
			
		}catch(HiperionException e){
			log.error("Error al momento de guardar el Ramo Todo Riesgo Contratista",e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.todoRiesgoContratista"));
			throw new HiperionException(e);
		}
	}

	
	/**
	 * @return the ramoRiesgoContratistaBean
	 */
	public RamoRiesgoContratistaBean getRamoRiesgoContratistaBean() {
		return ramoRiesgoContratistaBean;
	}


	/**
	 * @param ramoRiesgoContratistaBean the ramoRiesgoContratistaBean to set
	 */
	public void setRamoRiesgoContratistaBean(RamoRiesgoContratistaBean ramoRiesgoContratistaBean) {
		this.ramoRiesgoContratistaBean = ramoRiesgoContratistaBean;
	}


	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}
}
