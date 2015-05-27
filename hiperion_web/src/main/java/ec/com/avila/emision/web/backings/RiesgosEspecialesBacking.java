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

import ec.com.avila.emision.web.beans.RamoRiesgosEspecialesBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoRiesgosEsp;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.RamoRiesgosEspecialesService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
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
	
	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private RamoService ramoService;

	@EJB
	private RamoRiesgosEspecialesService ramoRiesgosEspecialesService;

	Logger log = Logger.getLogger(RiesgosEspecialesBacking.class);
	
	RamoRiesgosEsp ramoRiesgosEsp = new RamoRiesgosEsp();

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

		

		Usuario usuario =usuarioBean.getSessionUser();
		
		ramoRiesgosEsp.setTasaRiesgosEsp(ramoRiesgosEspecialesBean.getTasa());
		ramoRiesgosEsp.setCondImpRiesgos(ramoRiesgosEspecialesBean.getCondicionesImp());
		
		ramoRiesgosEsp.setIdUsuarioCreacion(usuario.getIdUsuario());
		ramoRiesgosEsp.setFechaCreacion(new Date());
		ramoRiesgosEsp.setEstado(EstadoEnum.A);

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
	 * @return the usuarioBean
	 */
	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}


	/**
	 * @param usuarioBean the usuarioBean to set
	 */
	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
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
	
	/**
	 * 
	 * <b>
	 * Permite generar y descargar el documento en PDF.
	 * </b>
	 * <p>[Author: Franklin Pozo B, Date: 25/05/2015]</p>
	 *
	 * @throws HiperionException
	 */
	public void descargarRiesgosEspecialesPDF()throws HiperionException{
		
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarArchivoPDFRiesgosEspeciales(ramoRiesgosEsp));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		}catch(Exception e){
			log.error("Error al momento generar el documento Riesgos Especiales en PDF", e);
			throw new HiperionException(e);
		}
	}
}