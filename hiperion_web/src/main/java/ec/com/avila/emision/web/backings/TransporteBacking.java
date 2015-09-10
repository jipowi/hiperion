/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import ec.com.avila.emision.web.beans.PolizaBean;
import ec.com.avila.emision.web.beans.RamoTransporteBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ClausulaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.CondicionEspecialDTO;
import ec.com.avila.hiperion.dto.ObjetoAseguradoTransporteDTO;
import ec.com.avila.hiperion.dto.TablaAmortizacionDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.ClausulasAddTran;
import ec.com.avila.hiperion.emision.entities.CobertTran;
import ec.com.avila.hiperion.emision.entities.CondEspTran;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.ObjAsegTransporte;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoTransporte;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.servicio.RamoTransporteService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Transporte. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class TransporteBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{ramoTransporteBean}")
	private RamoTransporteBean ramoTransporteBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	private List<DetalleAnexo> anexos;

	private List<SelectItem> tipoTransporteItems;
	private List<ClausulasAddTran> clausulasAdicionales;
	private List<ClausulaAdicionalDTO> clausulasAdicionalesDTO = new ArrayList<>();
	private List<CobertTran> coberturas;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();
	private List<CondEspTran> condicionesEspeciales;
	private List<CondicionEspecialDTO> condicionesEspecialesDTO = new ArrayList<>();
	private Usuario usuario;

	RamoTransporte ramoTransporte = new RamoTransporte();

	@EJB
	private RamoService ramoService;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private RamoTransporteService ramoTransporteService;

	@ManagedProperty(value = "#{polizaBean}")
	private PolizaBean polizaBean;

	Logger log = Logger.getLogger(TransporteBacking.class);

	@PostConstruct
	public void inicializar() {
		try {

			Ramo ramo = ramoService.consultarRamoPorCodigo("TR");

			anexos = ramo.getDetalleAnexos();

			obtenerClausulasAdicionales();
			obtenerCoberturas();
			obtenerCondicionesEspeciales();

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite setear los datos de la poliza </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 08/09/2015]
	 * </p>
	 * 
	 * @return
	 */
	public Poliza setearDatosPoliza() {

		Poliza poliza = new Poliza();

		poliza.setNumeroPoliza(polizaBean.getNumeroPoliza());
		poliza.setNumeroAnexo(polizaBean.getNumeroAnexo());
		poliza.setEjecutivo(polizaBean.getEjecutivo().getNombreUsuario());
		poliza.setVigenciaDesde(polizaBean.getVigenciaDesde());
		poliza.setVigenciaHasta(polizaBean.getVigenciaHasta());
		poliza.setDiasCobertura(polizaBean.getDiasCobertura());
		poliza.setSumaAsegurada(polizaBean.getSumaAsegurada());
		poliza.setPrimaNeta(BigDecimal.valueOf(polizaBean.getPrimaNeta()));
		poliza.setSuperBanSeguros(polizaBean.getSuperBanSeguros());
		poliza.setSeguroCampesino(BigDecimal.valueOf(polizaBean.getSeguroCampesino()));
		poliza.setDerechoEmision(BigDecimal.valueOf(polizaBean.getDerechoEmision()));
		poliza.setRamo(1);
		poliza.setEstadoPoliza("COTIZADO");

		PagoPoliza pagoPoliza = new PagoPoliza();
		pagoPoliza.setNumeroFactura(polizaBean.getNumeroFactura());
		pagoPoliza.setSubtotal(polizaBean.getSubtotal());
		pagoPoliza.setAdicionalSegCampesino(polizaBean.getAdicionalSegCampesino());
		pagoPoliza.setIva(polizaBean.getIva());
		pagoPoliza.setCuotaInicial(polizaBean.getCuotaInicial());
		pagoPoliza.setValorTotalPagoPoliza(polizaBean.getTotal());
		pagoPoliza.setEstado(EstadoEnum.A);
		pagoPoliza.setFechaCreacion(new Date());
		pagoPoliza.setIdUsuarioCreacion(usuario.getIdUsuario());

		List<Financiamiento> financiamientos = new ArrayList<>();
		for (TablaAmortizacionDTO financiamiento : polizaBean.getFinanciamientos()) {
			Financiamiento financiamientoTemp = new Financiamiento();
			financiamientoTemp.setNumeroCuota(financiamiento.getNumeroLetra());
			financiamientoTemp.setValorLetra(BigDecimal.valueOf(financiamiento.getValor()));
			financiamientoTemp.setFechaVencimiento(financiamiento.getFechaVencimiento());

			financiamientos.add(financiamientoTemp);
		}

		pagoPoliza.setFinanciamientos(financiamientos);

		poliza.setPagoPoliza(pagoPoliza);

		return poliza;
	}

	/**
	 * 
	 * <b> Permite obtener las coberturas del ramo de Transporte. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 17/06/2015]
	 * </p>
	 * 
	 * @param anexos
	 */
	public void obtenerCoberturas() {

		coberturas = new ArrayList<CobertTran>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertTran cobertura = new CobertTran();
					cobertura.setCoberturaTransporte(anexo.getNombreDetalleAnexo());

					coberturas.add(cobertura);
				}

			}

			for (CobertTran cobertura : coberturas) {
				CoberturaDTO coberturaDTO = new CoberturaDTO();
				coberturaDTO.setCobertura(cobertura.getCoberturaTransporte());
				coberturaDTO.setSeleccion(false);

				coberturasDTO.add(coberturaDTO);
			}
		}

	}

	/**
	 * 
	 * <b> Permite obtener las clausulas adicionales del ramo Transporte. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 17/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerClausulasAdicionales() {
		clausulasAdicionales = new ArrayList<ClausulasAddTran>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1) {
					ClausulasAddTran clausula = new ClausulasAddTran();
					clausula.setClausulaTrans(anexo.getNombreDetalleAnexo());

					clausulasAdicionales.add(clausula);
				}

			}
			for (ClausulasAddTran clausula : clausulasAdicionales) {
				ClausulaAdicionalDTO clausulaDTO = new ClausulaAdicionalDTO();
				clausulaDTO.setClausula(clausula.getClausulaTrans());
				clausulaDTO.setSeleccion(false);

				clausulasAdicionalesDTO.add(clausulaDTO);
			}

		}

	}

	/**
	 * 
	 * <b> Permite obtener las condiciones especiales del ramo Transporte. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 17/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerCondicionesEspeciales() {
		condicionesEspeciales = new ArrayList<CondEspTran>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3) {
					CondEspTran condicion = new CondEspTran();
					condicion.setCondicionEspTrans(anexo.getNombreDetalleAnexo());

					condicionesEspeciales.add(condicion);
				}

			}
			for (CondEspTran condicion : condicionesEspeciales) {
				CondicionEspecialDTO condicionDTO = new CondicionEspecialDTO();
				condicionDTO.setCondicionEspecial(condicion.getCondicionEspTrans());
				condicionDTO.setSeleccion(false);

				condicionesEspecialesDTO.add(condicionDTO);
			}

		}

	}

	/**
	 * 
	 * <b> Permite guardar la informacion del ramo y el objeto asegurado en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Nov 8, 2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 * 
	 */
	public void guardarRamo() throws HiperionException {
		try {
			Poliza poliza = setearDatosPoliza();

			ramoTransporte.setTasaTransporte(ramoTransporteBean.getTasa());
			ramoTransporte.setCondImportantesTransporte(ramoTransporteBean.getCondImportantes());
			ramoTransporte.setSiniestroTrans(ramoTransporteBean.getPorcentajeSiniestro());
			ramoTransporte.setMinimoSiniestroTrans(ramoTransporteBean.getMinimoSiniestro());
			ramoTransporte.setEmbarqueTrans(ramoTransporteBean.getPorcentajeEmbarque());
			ramoTransporte.setMinimoEmbarqueTrans(ramoTransporteBean.getMinimoEmbarque());

			ramoTransporte.setIdUsuarioCreacion(usuario.getIdUsuario());
			ramoTransporte.setFechaCreacion(new Date());
			ramoTransporte.setEstado(EstadoEnum.A);

			if (!ramoTransporteBean.getObjetoaseguradolist().isEmpty()) {

				List<ObjAsegTransporte> listObjetos = new ArrayList<>();
				for (ObjetoAseguradoTransporteDTO objeto : ramoTransporteBean.getObjetoaseguradolist()) {
					ObjAsegTransporte objAsegTransporte = new ObjAsegTransporte();

					objAsegTransporte.setItemTransporte(objeto.getItem());
					objAsegTransporte.setLimiteMovilizacionAnual(new BigDecimal(objeto.getLimiteMovilizacionAnual()));
					objAsegTransporte.setLimiteEmbarqueTransporte(new BigDecimal(objeto.getLimiteEmbarque()));
					objAsegTransporte.setMedioTransporte(objeto.getMedioTransporte());
					objAsegTransporte.setTrayectoDesde(objeto.getTrayectoDesde());
					objAsegTransporte.setTrayectoHasta(objeto.getTrayectoHasta());
					objAsegTransporte.setTipoEmbalaje(objeto.getTipoEmbalaje());
					objAsegTransporte.setValuacion(objeto.getValuacion().toString());

					Usuario usuario = usuarioBean.getSessionUser();
					objAsegTransporte.setIdUsuarioCreacion(usuario.getIdUsuario());
					objAsegTransporte.setFechaCreacion(new Date());
					objAsegTransporte.setEstado(EstadoEnum.A);
					listObjetos.add(objAsegTransporte);
				}
				ramoTransporte.setObjAsegTransportes(listObjetos);
				ramoTransporteService.guardarRamoTransporte(ramoTransporte, poliza);

				MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
				ramoTransporte = new RamoTransporte();
				ramoTransporteBean.getObjetoaseguradolist().clear();

			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save.Obj"));
			}
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo de transporte", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));

			throw new HiperionException(e);
		}
	}

	/**
	 * 
	 * <b> permite setear las condiciones especiales seleccionadas en el Bean. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 09/09/2015]
	 * </p>
	 * 
	 */
	public void setearCondiciones() {
		int contCondicion = 0;
		List<CondEspTran> condiciones = new ArrayList<>();
		for (CondicionEspecialDTO condicionDTO : condicionesEspecialesDTO) {
			if (condicionDTO.getSeleccion()) {
				contCondicion++;
				CondEspTran condicion = new CondEspTran();
				condicion.setCondicionEspTrans(condicionDTO.getCondicionEspecial());

				condiciones.add(condicion);
			}
		}
		if (contCondicion == 0) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.condicionesEsp"));
		} else {
			ramoTransporte.setCondEspTrans(condiciones);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.condicionesEsp"));
		}
	}

	/**
	 * 
	 * <b> permite setear las clausualas adicionales seleccionadas. </b>
	 * <p>
	 * [Author: Franklin Pozo B , Date: 09/09/2015]
	 * </p>
	 * 
	 */
	public void setearClausulasAdd() {

		int contClausulas = 0;
		List<ClausulasAddTran> clausulas = new ArrayList<>();
		for (ClausulaAdicionalDTO clausualaDTO : clausulasAdicionalesDTO) {
			if (clausualaDTO.getSeleccion()) {
				contClausulas++;
				ClausulasAddTran clausula = new ClausulasAddTran();
				clausula.setClausulaTrans(clausualaDTO.getClausula());
				clausula.setEstado(EstadoEnum.A);
				clausula.setFechaCreacion(new Date());
				clausula.setIdUsuarioCreacion(usuario.getIdUsuario());

				clausulas.add(clausula);
			}
		}
		if (contClausulas == 0) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.clausulasAdd"));
		} else {
			ramoTransporte.setClausulasAddTrans(clausulas);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.clausulasAdd"));
		}

	}

	/**
	 * 
	 * <b> permite setear las condiciones especiales seleccionadas en el Bean </b>
	 * <p>
	 * [Author: Franklin Pozo B., Date: 09/09/2015]
	 * </p>
	 * 
	 */
	public void setearCoberturas() {

		int contCobeturas = 0;
		List<CobertTran> coberturas = new ArrayList<>();
		for (CoberturaDTO coberturaDTO : coberturasDTO) {
			if (coberturaDTO.getSeleccion()) {
				contCobeturas++;
				CobertTran cobertura = new CobertTran();
				cobertura.setCoberturaTransporte(coberturaDTO.getCobertura());

				coberturas.add(cobertura);
			}
		}

		if (contCobeturas == 0) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.coberturas"));
		} else {
			ramoTransporte.setCobertTrans(coberturas);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.condicionesEsp"));
		}
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 09/09/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditCobertura(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((CoberturaDTO) event.getObject()).getCobertura());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 09/09/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditClausulasAdd(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ClausulaAdicionalDTO) event.getObject()).getClausula());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 09/09/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditCondicionesEsp(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((CondicionEspecialDTO) event.getObject()).getCondicionEspecial());
		FacesContext.getCurrentInstance().addMessage(null, msg);
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
	 * @return the ramoTransporteBean
	 */
	public RamoTransporteBean getRamoTransporteBean() {
		return ramoTransporteBean;
	}

	/**
	 * @param ramoTransporteBean
	 *            the ramoTransporteBean to set
	 */
	public void setRamoTransporteBean(RamoTransporteBean ramoTransporteBean) {
		this.ramoTransporteBean = ramoTransporteBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * @return the tipoTransporteItems
	 * @throws HiperionException
	 */
	public List<SelectItem> getTipoTransporteItems() throws HiperionException {

		this.tipoTransporteItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoMedioTransporte"));
		List<DetalleCatalogo> tipos = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : tipos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tipoTransporteItems.add(selectItem);
		}

		return tipoTransporteItems;
	}

	/**
	 * @param tipoTransporteItems
	 *            the tipoTransporteItems to set
	 */
	public void setTipoTransporteItems(List<SelectItem> tipoTransporteItems) {
		this.tipoTransporteItems = tipoTransporteItems;
	}

	public void descargarTransportePDF() throws HiperionException {

		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarArchivoPDFTransporte(ramoTransporte));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		} catch (Exception e) {
			log.error("Error al momento generar el documento Ramo Transporte en PDF", e);
			throw new HiperionException(e);
		}
	}

	/**
	 * @return the clausulasAdicionales
	 */
	public List<ClausulasAddTran> getClausulasAdicionales() {
		return clausulasAdicionales;
	}

	/**
	 * @param clausulasAdicionales
	 *            the clausulasAdicionales to set
	 */
	public void setClausulasAdicionales(List<ClausulasAddTran> clausulasAdicionales) {
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
	public List<CobertTran> getCoberturas() {
		return coberturas;
	}

	/**
	 * @param coberturas
	 *            the coberturas to set
	 */
	public void setCoberturas(List<CobertTran> coberturas) {
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
	 * @return the condicionesEspeciales
	 */
	public List<CondEspTran> getCondicionesEspeciales() {
		return condicionesEspeciales;
	}

	/**
	 * @param condicionesEspeciales
	 *            the condicionesEspeciales to set
	 */
	public void setCondicionesEspeciales(List<CondEspTran> condicionesEspeciales) {
		this.condicionesEspeciales = condicionesEspeciales;
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
	 * @return the polizaBean
	 */
	public PolizaBean getPolizaBean() {
		return polizaBean;
	}

	/**
	 * @param polizaBean
	 *            the polizaBean to set
	 */
	public void setPolizaBean(PolizaBean polizaBean) {
		this.polizaBean = polizaBean;
	}

}