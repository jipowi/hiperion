/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */

package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.DetalleAnexoBean;
import ec.com.avila.emision.web.beans.RamoCesanteRoturaMaqBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ObjetoAseguradoCesanteRoturaMaqDTO;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.ObjAsegLcRotMaq;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoLcRotMaq;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.RamoCesanteRoturaMaqService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.model.AnexosDataModel;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b> Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Lucro Cesante Rotura
 * Maquinaria. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,18/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class LucroCesanteRoturaMaquinariaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoCesanteRoturaMaqService ramoCesanteRoturaMaqService;

	@ManagedProperty(value = "#{ramoCesanteRoturaMaqBean}")
	private RamoCesanteRoturaMaqBean ramoCesanteRoturaMaqBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	Logger log = Logger.getLogger(LucroCesanteIncendioBacking.class);

	private AnexosDataModel anexosDataModel;
	private List<DetalleAnexo> anexos;

	private List<DetalleAnexoBean> clausulasAdicionales;
	private List<DetalleAnexoBean> coberturas;
	private List<DetalleAnexoBean> coberturasAdicionales;
	private DetalleAnexoBean[] selectClausulasAdicionales;
	private DetalleAnexoBean[] selectCoberturas;
	private DetalleAnexoBean[] selectCoberturasAdicionales;

	RamoLcRotMaq ramoCesanteRoturaMaq = new RamoLcRotMaq();

	@PostConstruct
	public void inicializar() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("LCRM");
			anexos = ramo.getDetalleAnexos();
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Clausulas Adicionales del Ramo Lucro Cesante Rotura Maquinaria. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerClausulasAdicionales() {
		clausulasAdicionales = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1)
					clausulasAdicionales.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(clausulasAdicionales);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas del Ramo Lucro Cesante Rotura Maquinaria.</b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCoberturas() {
		coberturas = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2)
					coberturas.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(coberturas);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas Adicionales Ramo Lucro Cesante Rotura Maquinaria. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCoberturasAdicionales() {
		coberturasAdicionales = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 6)
					coberturasAdicionales.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(coberturasAdicionales);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite ingresar datos del Ramo Lucro Cesante Rotura de Maquinaria </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 02/09/2014]
	 * </p>
	 * 
	 */
	public void setearInfRamo() throws HiperionException {

		Usuario usuario = usuarioBean.getSessionUser();

		ramoCesanteRoturaMaq.setUtilidadBrutaLcRotura(ramoCesanteRoturaMaqBean.getUtilidadBruta());
		ramoCesanteRoturaMaq.setTasaLcRotura(ramoCesanteRoturaMaqBean.getTasa());
		ramoCesanteRoturaMaq.setPeriodIndemnizacionLc(Integer.parseInt(ramoCesanteRoturaMaqBean.getPeriodoIndemnizacion()));
		ramoCesanteRoturaMaq.setDeducMinimoAsegLcRotura(ramoCesanteRoturaMaqBean.getMinPorcentajeValorAsegurado());
		ramoCesanteRoturaMaq.setDeducMinimoLcRotura(ramoCesanteRoturaMaqBean.getMinimo());
		ramoCesanteRoturaMaq.setDeducNumDias(ramoCesanteRoturaMaqBean.getNumeroDiasDeducible());

		ramoCesanteRoturaMaq.setIdUsuarioCreacion(usuario.getIdUsuario());
		ramoCesanteRoturaMaq.setFechaCreacion(new Date());
		ramoCesanteRoturaMaq.setEstado(EstadoEnum.A);
		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.setearInformacion"));

	}

	/**
	 * 
	 * <b> Permite guardar la informacion del ramo y objeto asegurado en sus respectivas tablas </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 10/11/2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {

		try {
			if (!ramoCesanteRoturaMaqBean.getObjetolist().isEmpty()) {
				List<ObjAsegLcRotMaq> listObjetos = new ArrayList<>();
				for (ObjetoAseguradoCesanteRoturaMaqDTO objeto : ramoCesanteRoturaMaqBean.getObjetolist()) {
					ObjAsegLcRotMaq objAsegCesante = new ObjAsegLcRotMaq();

					objAsegCesante.setItemObjLcRotura(objeto.getNumeroItem());
					objAsegCesante.setUbicacionObjLcRotura(objeto.getUbicacionRiesgo());
					objAsegCesante.setValorAsegObjLcRotura(objeto.getValorAsegurado());
					objAsegCesante.setDesObjLcRotura(objeto.getDescripcionObjeto());

					Usuario usuario = usuarioBean.getSessionUser();
					objAsegCesante.setIdUsuarioCreacion(usuario.getIdUsuario());
					objAsegCesante.setFechaCreacion(new Date());
					objAsegCesante.setEstado(EstadoEnum.A);
					listObjetos.add(objAsegCesante);
				}
				ramoCesanteRoturaMaq.setObjAsegLcRotMaqs(listObjetos);
			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save.Obj"));
			}
			ramoCesanteRoturaMaqService.guardarRamoCesanteRoturaMaq(ramoCesanteRoturaMaq);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
			ramoCesanteRoturaMaq = new RamoLcRotMaq();
			ramoCesanteRoturaMaqBean.getObjetolist().clear();
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo de lucro cesante rotura maquinaria", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));
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
	 * @return the ramoCesanteRoturaMaqBean
	 */
	public RamoCesanteRoturaMaqBean getRamoCesanteRoturaMaqBean() {
		return ramoCesanteRoturaMaqBean;
	}

	/**
	 * @param ramoCesanteRoturaMaqBean
	 *            the ramoCesanteRoturaMaqBean to set
	 */
	public void setRamoCesanteRoturaMaqBean(RamoCesanteRoturaMaqBean ramoCesanteRoturaMaqBean) {
		this.ramoCesanteRoturaMaqBean = ramoCesanteRoturaMaqBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * @return the selectClausulasAdicionales
	 */
	public DetalleAnexoBean[] getSelectClausulasAdicionales() {
		return selectClausulasAdicionales;
	}

	/**
	 * @param selectClausulasAdicionales
	 *            the selectClausulasAdicionales to set
	 */
	public void setSelectClausulasAdicionales(DetalleAnexoBean[] selectClausulasAdicionales) {
		this.selectClausulasAdicionales = selectClausulasAdicionales;
	}

	/**
	 * @return the selectCoberturas
	 */
	public DetalleAnexoBean[] getSelectCoberturas() {
		return selectCoberturas;
	}

	/**
	 * @param selectCoberturas
	 *            the selectCoberturas to set
	 */
	public void setSelectCoberturas(DetalleAnexoBean[] selectCoberturas) {
		this.selectCoberturas = selectCoberturas;
	}

	/**
	 * @return the selectCoberturasAdicionales
	 */
	public DetalleAnexoBean[] getSelectCoberturasAdicionales() {
		return selectCoberturasAdicionales;
	}

	/**
	 * @param selectCoberturasAdicionales
	 *            the selectCoberturasAdicionales to set
	 */
	public void setSelectCoberturasAdicionales(DetalleAnexoBean[] selectCoberturasAdicionales) {
		this.selectCoberturasAdicionales = selectCoberturasAdicionales;
	}

	public void descargarLucroCesanteRoturaMaquinariaPDF() throws HiperionException {

		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR,
					GenerarPdfUtil.generarArchivoPDFLucroCesanteRoturaMaquinaria(ramoCesanteRoturaMaq));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		} catch (Exception e) {
			log.error("Error al momento generar el documento Lucro Cesante Rotura Maquinaria en PDF", e);
			throw new HiperionException(e);

		}
	}
}