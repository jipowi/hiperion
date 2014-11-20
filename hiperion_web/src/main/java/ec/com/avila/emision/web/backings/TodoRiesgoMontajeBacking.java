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

import ec.com.avila.emision.web.beans.RamoTodoRiesgoMontajeBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje;
import ec.com.avila.hiperion.servicio.RamoRiesgoMontajeService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Todo Riesgo Montaje. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class TodoRiesgoMontajeBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;
	
	@ManagedProperty(value = "#{ramoTodoRiesgoMontajeBean}")
	private RamoTodoRiesgoMontajeBean ramoTodoRiesgoMontajeBean;

	Logger log = Logger.getLogger(TodoRiesgoMontajeBacking.class);

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoRiesgoMontajeService ramoRiesgoMontajeService;

	/**
	 * 
	 * <b>
	 * Permite guardar informacion del Ramo Riesgo Contratista
	 * </b>
	 * <p>[Author: Franklin Pozo, Date: 12/10/2014]</p>
	 *
	 */
	public void guardarRamo()throws HiperionException {
	
	RamoRiesgoMontaje ramoRiesgoMontaje=new RamoRiesgoMontaje();
		
		ramoRiesgoMontaje.setTasaMontaje(ramoTodoRiesgoMontajeBean.getTasa());
		ramoRiesgoMontaje.setPeriodoConstrucMontaje(ramoTodoRiesgoMontajeBean.getPeriodoConstruccion());
		ramoRiesgoMontaje.setPeriodoMantMontaje(ramoTodoRiesgoMontajeBean.getPeriodoMantenimiento());
		ramoRiesgoMontaje.setMinimoAmparoAMontaje(ramoTodoRiesgoMontajeBean.getPorcentajeConstruccionA());
		ramoRiesgoMontaje.setAmparoBMontaje(ramoTodoRiesgoMontajeBean.getPorcentajeConstruccionB());
		ramoRiesgoMontaje.setMinimoAmparoBMontaje(ramoTodoRiesgoMontajeBean.getMinimoB());
		ramoRiesgoMontaje.setAmparoCMontaje(ramoTodoRiesgoMontajeBean.getPorcentajeConstruccionC());
		ramoRiesgoMontaje.setMinimoAmparoCMontaje(ramoTodoRiesgoMontajeBean.getMinimoC());
		ramoRiesgoMontaje.setAmparoDMontaje(ramoTodoRiesgoMontajeBean.getPorcentajeConstruccionD());
		ramoRiesgoMontaje.setMinimoAmparoDMontaje(ramoTodoRiesgoMontajeBean.getMinimoD());
		ramoRiesgoMontaje.setAmparoGMontaje(ramoTodoRiesgoMontajeBean.getPorcentajeConstruccionG());
		ramoRiesgoMontaje.setMinimoAmparoGMontaje(ramoTodoRiesgoMontajeBean.getMinimoG());
		
		
		try{
			ramoRiesgoMontajeService.guardarRamoRiesgoMontaje(ramoRiesgoMontaje);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.todoRiesgoMontaje"));
		}catch(HiperionException e){
			log.error("Error al momento de guardar el Ramo Todo Riesgo Montaje",e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.todoRiesgoMontaje"));
			throw new HiperionException(e);
		}
		
	}

	/**
	 * @return the ramoBean
	 */
	public RamoBean getRamoBean() {
		return ramoBean;
	}

	/**
	 * @param ramoBean the ramoBean to set
	 */
	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * @return the ramoTodoRiesgoMontajeBean
	 */
	public RamoTodoRiesgoMontajeBean getRamoTodoRiesgoMontajeBean() {
		return ramoTodoRiesgoMontajeBean;
	}

	/**
	 * @param ramoTodoRiesgoMontajeBean the ramoTodoRiesgoMontajeBean to set
	 */
	public void setRamoTodoRiesgoMontajeBean(RamoTodoRiesgoMontajeBean ramoTodoRiesgoMontajeBean) {
		this.ramoTodoRiesgoMontajeBean = ramoTodoRiesgoMontajeBean;
	}

	
}