/**
 * 
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

import ec.com.avila.emision.web.beans.RamoIncendioLineasAliadaBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ClausulaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.CondicionEspecialDTO;
import ec.com.avila.hiperion.dto.ObjetoAseguradoIlaDTO;
import ec.com.avila.hiperion.emision.entities.ClausulasAddIncendio;
import ec.com.avila.hiperion.emision.entities.CobertAddIncendio;
import ec.com.avila.hiperion.emision.entities.CobertIncendio;
import ec.com.avila.hiperion.emision.entities.CondEspIncendio;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.ObjAsegIncendio;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.RamoIncendioLineasAliadaService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Incendio y/o Lineas
 * Aliadas. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class IncendioLineasAliadasBacking implements Serializable {

	/**
	 * @return the ramoIncendioLineasAliadaBean
	 */
	public RamoIncendioLineasAliadaBean getRamoIncendioLineasAliadaBean() {
		return ramoIncendioLineasAliadaBean;
	}

	/**
	 * @param ramoIncendioLineasAliadaBean
	 *            the ramoIncendioLineasAliadaBean to set
	 */
	public void setRamoIncendioLineasAliadaBean(RamoIncendioLineasAliadaBean ramoIncendioLineasAliadaBean) {
		this.ramoIncendioLineasAliadaBean = ramoIncendioLineasAliadaBean;
	}

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{ramoIncendioLineasAliadaBean}")
	private RamoIncendioLineasAliadaBean ramoIncendioLineasAliadaBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoIncendioLineasAliadaService ramoIncendioLineasAliadaService;

	Logger log = Logger.getLogger(IncendioLineasAliadasBacking.class);

	private List<CobertIncendio> coberturas;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();
	private List<CobertAddIncendio> coberturasAdd;
	private List<CoberturaAdicionalDTO> coberturasAddDTO = new ArrayList<>();
	private List<ClausulasAddIncendio> clausulasAdicionales;
	private List<ClausulaAdicionalDTO> clausulasAdicionalesDTO = new ArrayList<>();
	private List<CondEspIncendio> condicionesEspeciales;
	private List<CondicionEspecialDTO> condicionesEspecialesDTO = new ArrayList<>();
	private List<DetalleAnexo> anexos;

	RamoIncendioLineasAliada ramoIncendioLineasAliada = new RamoIncendioLineasAliada();

	@PostConstruct
	public void inicializar() {
		try {

			Ramo ramo = ramoService.consultarRamoPorCodigo("RE");

			anexos = ramo.getDetalleAnexos();

			obtenerCoberturas();
			obtenerCoberturasAdicionales();
			obtenerClausulasAdicionales();
			obtenerCondicionesEspeciales();

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

		coberturas = new ArrayList<CobertIncendio>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertIncendio cobertura = new CobertIncendio();
					cobertura.setCoberturaIncendio(anexo.getNombreDetalleAnexo());

					coberturas.add(cobertura);
				}

			}

			for (CobertIncendio cobertura : coberturas) {
				CoberturaDTO coberturaDTO = new CoberturaDTO();
				coberturaDTO.setCobertura(cobertura.getCoberturaIncendio());
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

		coberturasAdd = new ArrayList<CobertAddIncendio>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 6) {
					CobertAddIncendio cobertura = new CobertAddIncendio();
					cobertura.setCoberturaAddIncendio(anexo.getNombreDetalleAnexo());

					coberturasAdd.add(cobertura);
				}

			}

			for (CobertAddIncendio cobertura : coberturasAdd) {
				CoberturaAdicionalDTO coberturaAddDTO = new CoberturaAdicionalDTO();
				coberturaAddDTO.setCobertura(cobertura.getCoberturaAddIncendio());
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
		clausulasAdicionales = new ArrayList<ClausulasAddIncendio>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1) {
					ClausulasAddIncendio clausula = new ClausulasAddIncendio();
					clausula.setClausulaAddIncendio(anexo.getNombreDetalleAnexo());

					clausulasAdicionales.add(clausula);
				}

			}
			for (ClausulasAddIncendio clausula : clausulasAdicionales) {
				ClausulaAdicionalDTO clausulaDTO = new ClausulaAdicionalDTO();
				clausulaDTO.setClausula(clausula.getClausulaAddIncendio());
				clausulaDTO.setSeleccion(false);

				
				clausulasAdicionalesDTO.add(clausulaDTO);
			}

		}

	}

	/**
	 * 
	 * <b> Permite obtener las condiciones especiales del ramo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 17/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerCondicionesEspeciales() {
		condicionesEspeciales = new ArrayList<CondEspIncendio>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3) {
					CondEspIncendio condicion = new CondEspIncendio();
					condicion.setCondicionEspIncendio(anexo.getNombreDetalleAnexo());

					condicionesEspeciales.add(condicion);
				}

			}
			for (CondEspIncendio condicion : condicionesEspeciales) {
				CondicionEspecialDTO condicionDTO = new CondicionEspecialDTO();
				condicionDTO.setCondicionEspecial(condicion.getCondicionEspIncendio());
				condicionDTO.setSeleccion(false);

				condicionesEspecialesDTO.add(condicionDTO);
			}

		}

	}
	/**
	 * 
	 * <b> Permite Ingresar Datos del ramo Incendio y Lineas Aliadas </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 04/09/2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {
		try {

			if (!ramoIncendioLineasAliadaBean.getObjetolist().isEmpty()) {
				List<ObjAsegIncendio> objetosList = new ArrayList<>();
				for (ObjetoAseguradoIlaDTO objeto : ramoIncendioLineasAliadaBean.getObjetolist()) {
					ObjAsegIncendio objAsegIncendio = new ObjAsegIncendio();
					objAsegIncendio.setItemIncendio(objeto.getNumeroItem().toString());
					objAsegIncendio.setUbicacionIncendio(objeto.getUbicacionRiesgo());
					objAsegIncendio.setDetalleIncendio(objeto.getDetalle());
					objAsegIncendio.setValorObjAsegIncendio(objeto.getValor());

					Usuario usuario = usuarioBean.getSessionUser();
					objAsegIncendio.setIdUsuarioCreacion(usuario.getIdUsuario());
					objAsegIncendio.setFechaCreacion(new Date());
					objAsegIncendio.setEstado(EstadoEnum.A);
					objetosList.add(objAsegIncendio);
				}
				ramoIncendioLineasAliada.setObjAsegIncendios(objetosList);

			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.incendio.Obj"));
			}

			ramoIncendioLineasAliadaService.guardarRamoIncendioLineasAliada(ramoIncendioLineasAliada);

			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.incendioLineasAliadas"));

			ramoIncendioLineasAliada = new RamoIncendioLineasAliada();
			ramoIncendioLineasAliadaBean.getObjetolist().clear();

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el Ramo Incendio y Lineas Aliadas", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.incendioLineasAliadas"));
			throw new HiperionException(e);
		}
	}

	/**
	 * 
	 * <b> Permite guardar en memoria los datos del ramo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Oct 25, 2014]
	 * </p>
	 * 
	 */
	public void setearInfRamo() {

		Usuario usuario = usuarioBean.getSessionUser();

		ramoIncendioLineasAliada.setValorItemsIncendio(ramoIncendioLineasAliadaBean.getValorItems());
		ramoIncendioLineasAliada.setConsideracionesImpIncendio(ramoIncendioLineasAliadaBean.getConsideracionesImp());
		ramoIncendioLineasAliada.setDeducTerremoto(ramoIncendioLineasAliadaBean.getMinimoTerremoto());
		ramoIncendioLineasAliada.setDeducLluvia(ramoIncendioLineasAliadaBean.getMinimoLluvia());
		ramoIncendioLineasAliada.setDeducOtros(ramoIncendioLineasAliadaBean.getMinimoOtrosEventos());
		ramoIncendioLineasAliada.setDeducVidrios(ramoIncendioLineasAliadaBean.getPorcentajeVidrios());
		ramoIncendioLineasAliada.setTasaComprensivaIncendio(ramoIncendioLineasAliadaBean.getTasaComprensiva());
		ramoIncendioLineasAliada.setTasaRemocion(ramoIncendioLineasAliadaBean.getTasaRemocionEscombros());
		ramoIncendioLineasAliada.setTasaDocumentos(ramoIncendioLineasAliadaBean.getTasaDocumentosModelos());
		ramoIncendioLineasAliada.setTasaHonorarios(ramoIncendioLineasAliadaBean.getTasaHonorarios());
		ramoIncendioLineasAliada.setTasaClaElectrica(ramoIncendioLineasAliadaBean.getTasaClausulaElectrica());
		ramoIncendioLineasAliada.setTasaAutoexplosion(ramoIncendioLineasAliadaBean.getTasaAutoexplosion());
		ramoIncendioLineasAliada.setTasaVidrios(ramoIncendioLineasAliadaBean.getTasaVidrios());
		ramoIncendioLineasAliada.setDeducMinimoTerremoto(ramoIncendioLineasAliadaBean.getMinimoTerremoto());
		ramoIncendioLineasAliada.setDeducMinimoLluvia(ramoIncendioLineasAliadaBean.getMinimoLluvia());
		ramoIncendioLineasAliada.setDeducMinimoOtros(ramoIncendioLineasAliadaBean.getMinimoOtrosEventos());
		ramoIncendioLineasAliada.setDeducMinimoVidrios(ramoIncendioLineasAliadaBean.getMinimoOtrosEventos());

		ramoIncendioLineasAliada.setIdUsuarioCreacion(usuario.getIdUsuario());
		ramoIncendioLineasAliada.setFechaCreacion(new Date());
		ramoIncendioLineasAliada.setEstado(EstadoEnum.A);
		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.setearDatos"));

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

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
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
	 * @return the condicionesEspecialesDTO
	 */
	public List<CondicionEspecialDTO> getCondicionesEspecialesDTO() {
		return condicionesEspecialesDTO;
	}

	/**
	 * @param condicionesEspecialesDTO
	 *            the condicionesEspecialesDTO to set
	 */
	public void setCondicionesEspecialesDTO(List<CondicionEspecialDTO> condicionesEspecialesDTO) {
		this.condicionesEspecialesDTO = condicionesEspecialesDTO;
	}

	/**
	 * 
	 * <b> Permite generar y descargar el documento en PDF </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 11/05/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descargarIncendioLineasAliadasPDF() throws HiperionException {

		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR,
					GenerarPdfUtil.generarArchivoPDFIncendioLineaAliada(ramoIncendioLineasAliada));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		} catch (Exception e) {
			log.error("Error al momento generar el documento Incendio Lineas Aliadas en PDF", e);
			throw new HiperionException(e);
		}
	}
}