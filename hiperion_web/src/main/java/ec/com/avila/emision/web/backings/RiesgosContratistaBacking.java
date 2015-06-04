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

import ec.com.avila.emision.web.beans.RamoRiesgoContratistaBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoContratista;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.RamoRiesgoContratistaService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
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

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoRiesgoContratistaService ramoRiesgoContratistaService;

	@ManagedProperty(value = "#{ramoRiesgoContratistaBean}")
	private RamoRiesgoContratistaBean ramoRiesgoContratistaBean;

	Logger log = Logger.getLogger(RiesgosContratistaBacking.class);
	RamoRiesgoContratista ramoRiesgoContratista = new RamoRiesgoContratista();

	/**
	 * 
	 * <b> Prmite guardar informacion en el Ramo Riesgo contrataista </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 05/09/2014]
	 * </p>
	 * 
	 */
	public void guardarRamo() throws HiperionException {

		Usuario usuario = usuarioBean.getSessionUser();
		RamoRiesgoContratista ramoRiesgoContratista = new RamoRiesgoContratista();

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

		ramoRiesgoContratista.setIdUsuarioCreacion(usuario.getIdUsuario());
		ramoRiesgoContratista.setFechaCreacion(new Date());
		ramoRiesgoContratista.setEstado(EstadoEnum.A);
		try {
			ramoRiesgoContratistaService.guardarRamoRiesgoContratista(ramoRiesgoContratista);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.sOjeto"));

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el Ramo Todo Riesgo Contratista", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.todoRiesgoContratista"));
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
	 * @return the ramoRiesgoContratistaBean
	 */
	public RamoRiesgoContratistaBean getRamoRiesgoContratistaBean() {
		return ramoRiesgoContratistaBean;
	}

	/**
	 * @param ramoRiesgoContratistaBean
	 *            the ramoRiesgoContratistaBean to set
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

	/**
	 * 
	 * <b> Permite generar y descargar el documento en PDF. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/05/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descargarTodoRiesgosContratistaPDF() throws HiperionException {
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR,
					GenerarPdfUtil.generarArchivoPDFRiesgosContratista(ramoRiesgoContratista));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		} catch (Exception e) {
			log.error("Error al momento generar el documento Riesgos Contratista" + " en PDF", e);
			throw new HiperionException(e);
		}

	}
}
