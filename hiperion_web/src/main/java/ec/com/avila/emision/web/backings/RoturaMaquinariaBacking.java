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

import ec.com.avila.emision.web.beans.RamoRoturaMaquinariaBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ClausulaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.ObjetoAseguradoRoturaMaqDTO;
import ec.com.avila.hiperion.emision.entities.ClausulasAddRotura;
import ec.com.avila.hiperion.emision.entities.CobertAddRotura;
import ec.com.avila.hiperion.emision.entities.CobertRotura;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.ObjAsegRotura;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoRoturaMaquinaria;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.RamoRoturaMaquinariaService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Rotura Maquinaria. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RoturaMaquinariaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;
	@ManagedProperty(value = "#{ramoRoturaMaquinariaBean}")
	private RamoRoturaMaquinariaBean ramoRoturaMaquinariaBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	Logger log = Logger.getLogger(RoturaMaquinariaBacking.class);

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoRoturaMaquinariaService ramoRoturaMaquinariaService;

	RamoRoturaMaquinaria ramoRoturaMaquinaria = new RamoRoturaMaquinaria();
	private List<ClausulasAddRotura> clausulasAdicionales;
	private List<ClausulaAdicionalDTO> clausulasAdicionalesDTO = new ArrayList<>();
	private List<CobertRotura> coberturas;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();
	private List<CobertAddRotura> coberturasAdd;
	private List<CoberturaAdicionalDTO> coberturasAddDTO = new ArrayList<>();
	private List<DetalleAnexo> anexos;

	@PostConstruct
	public void inicializar() {
		try {

			Ramo ramo = ramoService.consultarRamoPorCodigo("RM");

			anexos = ramo.getDetalleAnexos();

			obtenerClausulasAdicionales();
			obtenerCoberturas();
			obtenerCoberturasAdicionales();

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las coberturas del ramo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 17/06/2015]
	 * </p>
	 * 
	 * @param anexos
	 */
	public void obtenerCoberturas() {

		coberturas = new ArrayList<CobertRotura>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertRotura cobertura = new CobertRotura();
					cobertura.setCoberturaRotura(anexo.getNombreDetalleAnexo());

					coberturas.add(cobertura);
				}

			}

			for (CobertRotura cobertura : coberturas) {
				CoberturaDTO coberturaDTO = new CoberturaDTO();
				coberturaDTO.setCobertura(cobertura.getCoberturaRotura());
				coberturaDTO.setSeleccion(false);

				coberturasDTO.add(coberturaDTO);
			}
		}

	}

	/**
	 * 
	 * <b> Permite obetener las coberturas adicionales del ramo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 26/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerCoberturasAdicionales() {

		coberturasAdd = new ArrayList<CobertAddRotura>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertAddRotura cobertura = new CobertAddRotura();
					cobertura.setCoberturaAddRotura(anexo.getNombreDetalleAnexo());

					coberturasAdd.add(cobertura);
				}

			}

			for (CobertAddRotura cobertura : coberturasAdd) {
				CoberturaAdicionalDTO coberturaAddDTO = new CoberturaAdicionalDTO();
				coberturaAddDTO.setCobertura(cobertura.getCoberturaAddRotura());
				coberturaAddDTO.setSeleccion(false);

				coberturasAddDTO.add(coberturaAddDTO);
			}
		}

	}

	/**
	 * 
	 * <b> Permite obtener las clausulas adicionales del ramo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 17/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerClausulasAdicionales() {
		clausulasAdicionales = new ArrayList<ClausulasAddRotura>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1) {
					ClausulasAddRotura clausula = new ClausulasAddRotura();
					clausula.setClausulaAddRotura(anexo.getNombreDetalleAnexo());

					clausulasAdicionales.add(clausula);
				}

			}
			for (ClausulasAddRotura clausula : clausulasAdicionales) {
				ClausulaAdicionalDTO clausulaDTO = new ClausulaAdicionalDTO();
				clausulaDTO.setClausula(clausula.getClausulaAddRotura());
				clausulaDTO.setSeleccion(false);

				clausulasAdicionalesDTO.add(clausulaDTO);
			}

		}

	}

	/**
	 * 
	 * <b> Permite setear objetos objetos en el Ramo Rotura de Maquinaria </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 09/09/2014]
	 * </p>
	 * 
	 */
	public void setearInfRamo() throws HiperionException {

		Usuario usuario = usuarioBean.getSessionUser();

		ramoRoturaMaquinaria.setTasaRotMaq(ramoRoturaMaquinariaBean.getTasa());
		ramoRoturaMaquinaria.setDeducSiniestroRotMaq(ramoRoturaMaquinariaBean.getPorcentajeValorSiniestro());
		ramoRoturaMaquinaria.setDeducMinimoSiniestroRot(ramoRoturaMaquinariaBean.getMinimo());
		ramoRoturaMaquinaria.setDeducMinimoSiniestroRot(ramoRoturaMaquinariaBean.getMinimoPorcentajeValorAsegurado());

		ramoRoturaMaquinaria.setIdUsuarioCreacion(usuario.getIdUsuario());
		ramoRoturaMaquinaria.setFechaCreacion(new Date());
		ramoRoturaMaquinaria.setEstado(EstadoEnum.A);
		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.setearInformacion"));
	}

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

		try {
			if (!ramoRoturaMaquinariaBean.getOrderlist().isEmpty()) {

				List<ObjAsegRotura> listObjetos = new ArrayList<>();
				for (ObjetoAseguradoRoturaMaqDTO objeto : ramoRoturaMaquinariaBean.getOrderlist()) {
					ObjAsegRotura objAsegRotura = new ObjAsegRotura();

					objAsegRotura.setItemObjRotura(objeto.getNumeroItem());
					objAsegRotura.setUbicacionObjRotura(objeto.getUbicacionRiesgo());
					objAsegRotura.setDescripcionObjRotura(objeto.getDescripcionObjeto());
					objAsegRotura.setTotalObjRotura(objeto.getTotal());

					Usuario usuario = usuarioBean.getSessionUser();
					objAsegRotura.setIdUsuarioCreacion(usuario.getIdUsuario());
					objAsegRotura.setFechaCreacion(new Date());
					objAsegRotura.setEstado(EstadoEnum.A);
					listObjetos.add(objAsegRotura);
				}
				ramoRoturaMaquinaria.setObjAsegRoturas(listObjetos);
			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save.Obj"));
			}
			ramoRoturaMaquinariaService.guardarRamoRoturaMaquinaria(ramoRoturaMaquinaria);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
			ramoRoturaMaquinaria = new RamoRoturaMaquinaria();
			ramoRoturaMaquinariaBean.getOrderlist().clear();
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo rotura maquinaria", e);
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
	 * @return the ramoRoturaMaquinariaBean
	 */
	public RamoRoturaMaquinariaBean getRamoRoturaMaquinariaBean() {
		return ramoRoturaMaquinariaBean;
	}

	/**
	 * @param ramoRoturaMaquinariaBean
	 *            the ramoRoturaMaquinariaBean to set
	 */
	public void setRamoRoturaMaquinariaBean(RamoRoturaMaquinariaBean ramoRoturaMaquinariaBean) {
		this.ramoRoturaMaquinariaBean = ramoRoturaMaquinariaBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * 
	 * <b> Permite descargar el documento en PDF </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 27/05/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descargarRoturaMaquinariaPDF() throws HiperionException {

		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR,
					GenerarPdfUtil.generarArchivoPDFRoturaMaquinaria(ramoRoturaMaquinaria));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		} catch (Exception e) {
			log.error("Error al momento generar el documento Rotura de Maquinaria en PDF", e);
			throw new HiperionException(e);
		}

	}

	/**
	 * @return the clausulasAdicionales
	 */
	public List<ClausulasAddRotura> getClausulasAdicionales() {
		return clausulasAdicionales;
	}

	/**
	 * @param clausulasAdicionales
	 *            the clausulasAdicionales to set
	 */
	public void setClausulasAdicionales(List<ClausulasAddRotura> clausulasAdicionales) {
		this.clausulasAdicionales = clausulasAdicionales;
	}

	/**
	 * @return the clausulasAdicionalesDTO
	 */
	public List<ClausulaAdicionalDTO> getClausulasAdicionalesDTO() {
		return clausulasAdicionalesDTO;
	}

	/**
	 * @param clausulasAdicionalesDTO
	 *            the clausulasAdicionalesDTO to set
	 */
	public void setClausulasAdicionalesDTO(List<ClausulaAdicionalDTO> clausulasAdicionalesDTO) {
		this.clausulasAdicionalesDTO = clausulasAdicionalesDTO;
	}

	/**
	 * @return the coberturas
	 */
	public List<CobertRotura> getCoberturas() {
		return coberturas;
	}

	/**
	 * @param coberturas
	 *            the coberturas to set
	 */
	public void setCoberturas(List<CobertRotura> coberturas) {
		this.coberturas = coberturas;
	}

	/**
	 * @return the coberturasDTO
	 */
	public List<CoberturaDTO> getCoberturasDTO() {
		return coberturasDTO;
	}

	/**
	 * @param coberturasDTO
	 *            the coberturasDTO to set
	 */
	public void setCoberturasDTO(List<CoberturaDTO> coberturasDTO) {
		this.coberturasDTO = coberturasDTO;
	}

	/**
	 * @return the coberturasAdd
	 */
	public List<CobertAddRotura> getCoberturasAdd() {
		return coberturasAdd;
	}

	/**
	 * @param coberturasAdd
	 *            the coberturasAdd to set
	 */
	public void setCoberturasAdd(List<CobertAddRotura> coberturasAdd) {
		this.coberturasAdd = coberturasAdd;
	}

	/**
	 * @return the coberturasAddDTO
	 */
	public List<CoberturaAdicionalDTO> getCoberturasAddDTO() {
		return coberturasAddDTO;
	}

	/**
	 * @param coberturasAddDTO
	 *            the coberturasAddDTO to set
	 */
	public void setCoberturasAddDTO(List<CoberturaAdicionalDTO> coberturasAddDTO) {
		this.coberturasAddDTO = coberturasAddDTO;
	}

}