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

import ec.com.avila.emision.web.beans.RamoDineroValoresBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ClausulaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.ObjetoAseguradoDineroValoresDTO;
import ec.com.avila.hiperion.emision.entities.ClausulasAddDinero;
import ec.com.avila.hiperion.emision.entities.CobertDineroVal;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.ObjAsegDineroVal;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoDineroValore;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.RamoDineroValoreService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Dinero y Valores. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class DineroValoresBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoDineroValoreService ramoDineroValoreService;

	@ManagedProperty(value = "#{ramoDineroValoresBean}")
	private RamoDineroValoresBean ramoDineroValoresBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	Logger log = Logger.getLogger(DineroValoresBacking.class);

	private List<DetalleAnexo> anexos;

	private List<CobertDineroVal> coberturas;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();
	private List<ClausulasAddDinero> clausulasAdicionales;
	private List<ClausulaAdicionalDTO> clausulasAdicionalesDTO = new ArrayList<>();

	RamoDineroValore ramoDineroValores = new RamoDineroValore();

	@PostConstruct
	public void inicializar() {
		try {

			Ramo ramo = ramoService.consultarRamoPorCodigo("DV");

			anexos = ramo.getDetalleAnexos();

			obtenerCoberturas();
			obtenerClausulasAdicionales();

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

		coberturas = new ArrayList<CobertDineroVal>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertDineroVal cobertura = new CobertDineroVal();
					cobertura.setCoberturaDinero(anexo.getNombreDetalleAnexo());

					coberturas.add(cobertura);
				}

			}

			for (CobertDineroVal cobertura : coberturas) {
				CoberturaDTO coberturaDTO = new CoberturaDTO();
				coberturaDTO.setCobertura(cobertura.getCoberturaDinero());
				coberturaDTO.setSeleccion(false);

				coberturasDTO.add(coberturaDTO);
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
		clausulasAdicionales = new ArrayList<ClausulasAddDinero>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1) {
					ClausulasAddDinero clausula = new ClausulasAddDinero();
					clausula.setClausulaAddDinero(anexo.getNombreDetalleAnexo());

					clausulasAdicionales.add(clausula);
				}

			}
			for (ClausulasAddDinero clausula : clausulasAdicionales) {
				ClausulaAdicionalDTO clausulaDTO = new ClausulaAdicionalDTO();
				clausulaDTO.setClausula(clausula.getClausulaAddDinero());
				clausulaDTO.setSeleccion(false);

				clausulasAdicionalesDTO.add(clausulaDTO);
			}

		}

	}

	/**
	 * 
	 * <b> Permite setear la informacion del ramo Dinero y valores</b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 26/08/2014]
	 * </p>
	 * 
	 */
	public void setearInfRamo() throws HiperionException {
		Usuario usuario = usuarioBean.getSessionUser();

		ramoDineroValores.setTasaDinero(ramoDineroValoresBean.getTasa());
		ramoDineroValores.setPorcentajeEmbarqueDinero(ramoDineroValoresBean.getPorcentajeEmbarque());
		ramoDineroValores.setDeducPorSiniestroDinero(ramoDineroValoresBean.getPorcentajeSiniestro());
		ramoDineroValores.setDeducMinimoDinero(ramoDineroValoresBean.getValorMinimo());

		ramoDineroValores.setIdUsuarioCreacion(usuario.getIdUsuario());
		ramoDineroValores.setFechaCreacion(new Date());
		ramoDineroValores.setEstado(EstadoEnum.A);

		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.setearInformacion"));
	}

	public void guardarRamo() throws HiperionException {
		try {
			if (!ramoDineroValoresBean.getObjetoaseguradolist().isEmpty()) {
				List<ObjAsegDineroVal> listObjetos = new ArrayList<>();
				for (ObjetoAseguradoDineroValoresDTO objeto : ramoDineroValoresBean.getObjetoaseguradolist()) {
					ObjAsegDineroVal objAsegDineroVal = new ObjAsegDineroVal();
					// TODO revisar campos
					objAsegDineroVal.setItemObjDinero(objeto.getItem());
					objAsegDineroVal.setDineroValores(objeto.getDineroValores());
					objAsegDineroVal.setDesde(objeto.getTrayectoDesde());
					objAsegDineroVal.setLimiteEstimado(objeto.getLimiteEstimadoAnual());
					objAsegDineroVal.setLimiteEmbarqueObjDinero(objeto.getLimiteEmbarque());
					objAsegDineroVal.setDesde(objAsegDineroVal.getDesde());
					objAsegDineroVal.setHasta(objeto.getTrayectoHasta());
					objAsegDineroVal.setMedioTransporteDinero(objeto.getMedioTransporte());

					Usuario usuario = usuarioBean.getSessionUser();
					objAsegDineroVal.setIdUsuarioCreacion(usuario.getIdUsuario());
					objAsegDineroVal.setFechaCreacion(new Date());
					objAsegDineroVal.setEstado(EstadoEnum.A);
					listObjetos.add(objAsegDineroVal);
				}

				ramoDineroValores.setObjAsegDineroVals(listObjetos);

			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save.Obj"));
			}
			ramoDineroValoreService.guardarRamoDineroValore(ramoDineroValores);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
			ramoDineroValores = new RamoDineroValore();
			ramoDineroValoresBean.getObjetoaseguradolist().clear();
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo de dinero y valores", e);
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
	 * @return the ramoDineroValoresBean
	 */
	public RamoDineroValoresBean getRamoDineroValoresBean() {
		return ramoDineroValoresBean;
	}

	/**
	 * @param ramoDineroValoresBean
	 *            the ramoDineroValoresBean to set
	 */
	public void setRamoDineroValoresBean(RamoDineroValoresBean ramoDineroValoresBean) {
		this.ramoDineroValoresBean = ramoDineroValoresBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * 
	 * <b> Permite generar y descargar informacion del Ramo Dinero y Valores </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 27/04/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descargarDineroValoresPDF() throws HiperionException {

		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarAchivoPDFDineroValores(ramoDineroValores));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();

		} catch (Exception e) {
			log.error("Error al momento generar el a hoja de vida en PDF", e);
			throw new HiperionException(e);
		}
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

}
