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

import ec.com.avila.emision.web.beans.RamoCascoAereoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoCascoAereo;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.RamoCascoAereoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
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
	
	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	Logger log = Logger.getLogger(CascoAereoBacking.class);
	
	RamoCascoAereo cascoAereo = new RamoCascoAereo();

	/**
	 * 
	 * <b> Permite guardar un objeto Ramo Casco Aereo en la base de datos. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 14/08/2014]
	 * </p>
	 * 
	 */
	public void guardarRamo() throws HiperionException {
		Usuario usuario=usuarioBean.getSessionUser();
	

		cascoAereo.setItemAereo(Integer.parseInt(ramoCascoAereoBean.getItem()));
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
		
		cascoAereo.setIdUsuarioCreacion(usuario.getIdUsuario());
		cascoAereo.setFechaCreacion(new Date());
		cascoAereo.setEstado(EstadoEnum.A);
		

		try {

			ramoCascoAereoService.guardarRamoCascoAereo(cascoAereo);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.sOjeto"));

		} catch (HiperionException e) {

			log.error("Error al guardar el Ramo Casco Aereo", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));
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
	
	/**
	 * 
	 * <b>
	 * Permite generar y descargar el documento en PDF
	 * </b>
	 * <p>[Author: Franklin Pozo B., Date: 22/04/2015]</p>
	 *
	 * @throws HiperionException
	 */
	public void descargarCascoAereoPDF()throws HiperionException{
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarAchivoPDFCascoAereo(cascoAereo));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		} catch (Exception e) {
			log.error("Error al momento generar el documento Casco Aereo en PDF", e);
			throw new HiperionException(e);
		}
	}
}
