/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.RamoTodoRiesgoMontajeBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.RamoRiesgoMontajeService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
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

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	Logger log = Logger.getLogger(TodoRiesgoMontajeBacking.class);

	RamoRiesgoMontaje ramoRiesgoMontaje = new RamoRiesgoMontaje();

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoRiesgoMontajeService ramoRiesgoMontajeService;

	/**
	 * 
	 * <b> Permite guardar informacion del Ramo Riesgo Contratista </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 12/10/2014]
	 * </p>
	 * 
	 */
	public void guardarRamo() throws HiperionException {

		Usuario usuario = usuarioBean.getSessionUser();

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

		ramoRiesgoMontaje.setIdUsuarioCreacion(usuario.getIdUsuario());
		ramoRiesgoMontaje.setFechaCreacion(new Date());
		ramoRiesgoMontaje.setEstado(EstadoEnum.A);

		try {
			ramoRiesgoMontajeService.guardarRamoRiesgoMontaje(ramoRiesgoMontaje);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.sOjeto"));
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el Ramo Todo Riesgo Montaje", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.todoRiesgoMontaje"));
			throw new HiperionException(e);
		}

	}

	/**
	 * @return the usuarioBean
	 */
	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	/**
	 * @param usuarioBean
	 *            the usuarioBean to set
	 */
	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	/**
	 * @return the ramoBean
	 */
	public RamoBean getRamoBean() {
		return ramoBean;
	}

	/**
	 * @param ramoBean
	 *            the ramoBean to set
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
	 * @param ramoTodoRiesgoMontajeBean
	 *            the ramoTodoRiesgoMontajeBean to set
	 */
	public void setRamoTodoRiesgoMontajeBean(RamoTodoRiesgoMontajeBean ramoTodoRiesgoMontajeBean) {
		this.ramoTodoRiesgoMontajeBean = ramoTodoRiesgoMontajeBean;
	}
	
	/**
	 * 
	 * <b>
	 * Permite generar y descargar el documento PDF
	 * </b>
	 * <p>[Author: Franklin Pozo B, Date: 29/05/2015]</p>
	 *
	 * @throws HiperionException
	 */
	public void descargarTodoRiesgoMontajePDF()throws HiperionException{
		
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarArchivoPDFTodoRiesgoMontaje(ramoRiesgoMontaje));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		}catch(Exception e){
			log.error("Error al momento generar el documento Todo Riesgo Montaje en PDF", e);
			throw new HiperionException(e);
		}
	}

}