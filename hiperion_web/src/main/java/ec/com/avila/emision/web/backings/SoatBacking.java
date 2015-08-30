/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
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
import ec.com.avila.emision.web.beans.RamoSoatBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.TablaAmortizacionDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.CobertSoat;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoSoat;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.servicio.RamoSoatService;
import ec.com.avila.hiperion.web.beans.MarcasDto;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo SOAT. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class SoatBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	private List<SelectItem> tipoVehiculoItems;
	private List<SelectItem> tipoSoatItems;
	private List<SelectItem> modeloItems;
	private List<CobertSoat> coberturas;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();
	private List<DetalleAnexo> anexos;
	private Boolean activarMarcaAuto;
	private Boolean activarMarcaPesado;
	private Boolean activarMarcaMoto;

	@EJB
	private RamoService ramoService;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	@EJB
	private RamoSoatService ramoSoatService;

	@ManagedProperty(value = "#{ramoSoatBean}")
	private RamoSoatBean ramoSoatBean;
	@ManagedProperty(value = "#{polizaBean}")
	private PolizaBean polizaBean;

	Logger log = Logger.getLogger(SoatBacking.class);
	RamoSoat ramoSoat = new RamoSoat();
	private Usuario usuario;

	@PostConstruct
	public void inicializar() {
		try {

			usuario = usuarioBean.getSessionUser();

			Ramo ramo = ramoService.consultarRamoPorCodigo("ST");

			anexos = ramo.getDetalleAnexos();

			obtenerCoberturas();

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

		coberturas = new ArrayList<CobertSoat>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertSoat cobertura = new CobertSoat();
					cobertura.setCoberturaSoat(anexo.getNombreDetalleAnexo());

					coberturas.add(cobertura);
				}

			}

			for (CobertSoat cobertura : coberturas) {
				CoberturaDTO coberturaDTO = new CoberturaDTO();
				coberturaDTO.setCobertura(cobertura.getCoberturaSoat());
				coberturaDTO.setSeleccion(false);

				coberturasDTO.add(coberturaDTO);
			}
		}

	}

	/**
	 * 
	 * <b> Permite setear los datos de la poliza. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 09/07/2015]
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
	 * <b> Permite guaraadar la informacion de la poliza en la base de datos. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 30/08/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {

		try {

			Poliza poliza = setearDatosPoliza();

			ramoSoat.setAsegurado(ramoSoatBean.getAsegurado());
			ramoSoat.setColorSoat(ramoSoatBean.getColor());
			ramoSoat.setPlacaSoat(ramoSoatBean.getPlaca());
			ramoSoat.setChasisSoat(ramoSoatBean.getChasis());
			ramoSoat.setAnioSoat(ramoSoatBean.getAnio());
			ramoSoat.setCilindrajeSoat(ramoSoatBean.getCilindraje());

			ramoSoat.setIdUsuarioCreacion(usuario.getIdUsuario());
			ramoSoat.setFechaCreacion(new Date());
			ramoSoat.setEstado(EstadoEnum.A);

			ramoSoatService.guardarRamoSoat(ramoSoat, poliza);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el Ramo Soat", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));

			throw new HiperionException(e);

		}

	}

	/**
	 * 
	 * <b> permite setear las coberturas seleccionadas en el Bean. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/07/2015]
	 * </p>
	 * 
	 */
	public void setearCoberturas() {
		int contCoberturas = 0;
		List<CobertSoat> coberturas = new ArrayList<>();
		for (CoberturaDTO coberturaDTO : coberturasDTO) {
			if (coberturaDTO.getSeleccion()) {
				contCoberturas++;
				CobertSoat cobertura = new CobertSoat();
				cobertura.setCoberturaSoat(coberturaDTO.getCobertura());

				coberturas.add(cobertura);
			}
		}

		if (contCoberturas == 0) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.coberturas"));
		} else {
			ramoSoat.setCobertSoats(coberturas);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.coberturas"));
		}
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
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
	 * <b> Permite presentar en la pantalla el la lista de marcas dependiento de la clase de vehiculo seleccionada </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 22, 2014]
	 * </p>
	 * 
	 */
	public void selectClaseVehiculo() {
		if (ramoSoatBean.getTipoVehiculo().equals("2") || ramoSoatBean.getTipoVehiculo().equals("1") || ramoSoatBean.getTipoVehiculo().equals("4")) {
			activarMarcaAuto = true;
			activarMarcaPesado = false;
			activarMarcaMoto = false;
		}
		if (ramoSoatBean.getTipoVehiculo().equals("3")) {
			activarMarcaPesado = true;
			activarMarcaAuto = false;
			activarMarcaMoto = false;
		}
		if (ramoSoatBean.getTipoVehiculo().equals("5")) {
			activarMarcaMoto = true;
			activarMarcaAuto = false;
			activarMarcaPesado = false;
		}
	}

	/**
	 * 
	 * <b> Permite obtenerlos tipos de vehiculos que se encuentran en la tabla de catalogos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 15, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getTipoVehiculoItems() throws HiperionException {

		this.tipoVehiculoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoTipoVehiculoSoat"));
		List<DetalleCatalogo> tipos = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : tipos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tipoVehiculoItems.add(selectItem);
		}

		return tipoVehiculoItems;
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
	 * @param tipoVehiculoItems
	 *            the tipoVehiculoItems to set
	 */
	public void setTipoVehiculoItems(List<SelectItem> tipoVehiculoItems) {
		this.tipoVehiculoItems = tipoVehiculoItems;
	}

	/**
	 * @return the modeloItems
	 */
	public List<SelectItem> getModeloItems() {
		return modeloItems;
	}

	/**
	 * @param modeloItems
	 *            the modeloItems to set
	 */
	public void setModeloItems(List<SelectItem> modeloItems) {
		this.modeloItems = modeloItems;
	}

	/**
	 * @param tipoSoatItems
	 *            the tipoSoatItems to set
	 */
	public void setTipoSoatItems(List<SelectItem> tipoSoatItems) {
		this.tipoSoatItems = tipoSoatItems;
	}

	/**
	 * @return the ramoSoatBean
	 */
	public RamoSoatBean getRamoSoatBean() {
		return ramoSoatBean;
	}

	/**
	 * @param ramoSoatBean
	 *            the ramoSoatBean to set
	 */
	public void setRamoSoatBean(RamoSoatBean ramoSoatBean) {
		this.ramoSoatBean = ramoSoatBean;
	}

	/**
	 * @return the activarMarcaAuto
	 */
	public Boolean getActivarMarcaAuto() {
		return activarMarcaAuto;
	}

	/**
	 * @param activarMarcaAuto
	 *            the activarMarcaAuto to set
	 */
	public void setActivarMarcaAuto(Boolean activarMarcaAuto) {
		this.activarMarcaAuto = activarMarcaAuto;
	}

	/**
	 * @return the activarMarcaPesado
	 */
	public Boolean getActivarMarcaPesado() {
		return activarMarcaPesado;
	}

	/**
	 * @param activarMarcaPesado
	 *            the activarMarcaPesado to set
	 */
	public void setActivarMarcaPesado(Boolean activarMarcaPesado) {
		this.activarMarcaPesado = activarMarcaPesado;
	}

	/**
	 * @return the activarMarcaMoto
	 */
	public Boolean getActivarMarcaMoto() {
		return activarMarcaMoto;
	}

	/**
	 * @param activarMarcaMoto
	 *            the activarMarcaMoto to set
	 */
	public void setActivarMarcaMoto(Boolean activarMarcaMoto) {
		this.activarMarcaMoto = activarMarcaMoto;
	}

	/**
	 * 
	 * <b> Permite obtener los tipos de soat que se encuentran en la tabla de catalogos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 15, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getTipoSoatItems() throws HiperionException {

		this.tipoSoatItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoTipoSoat"));
		List<DetalleCatalogo> tipos = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : tipos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tipoSoatItems.add(selectItem);
		}

		return tipoSoatItems;
	}

	/**
	 * 
	 * <b> Permite obtener los modelos de autos dependiente de la marca seleccionada </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 15, 2014]
	 * </p>
	 * 
	 * @param selectedMarca
	 * @throws HiperionException
	 */
	public void obtenerModelo(MarcasDto selectedMarca) throws HiperionException {

		this.modeloItems = new ArrayList<SelectItem>();

		List<DetalleCatalogo> catalogos = new ArrayList<DetalleCatalogo>();

		if (!ramoSoatBean.getTipoVehiculo().equals("3") && !ramoSoatBean.getTipoVehiculo().equals("5"))
			catalogos = detalleCatalogoService.consultarDetalleCatalogoByCodDetalle(selectedMarca.getMarca(), HiperionMensajes.getInstancia()
					.getLong("ec.gob.avila.hiperion.recursos.catalogoModeloVehiculoLiviano"));

		if (ramoSoatBean.getTipoVehiculo().equals("3"))
			catalogos = detalleCatalogoService.consultarDetalleCatalogoByCodDetalle(selectedMarca.getMarca(), HiperionMensajes.getInstancia()
					.getLong("ec.gob.avila.hiperion.recursos.catalogoModeloVehiculoPesado"));

		if (ramoSoatBean.getTipoVehiculo().equals("5"))
			catalogos = detalleCatalogoService.consultarDetalleCatalogoByCodDetalle(selectedMarca.getMarca(), HiperionMensajes.getInstancia()
					.getLong("ec.gob.avila.hiperion.recursos.catalogoModeloVehiculoMoto"));

		for (DetalleCatalogo detalle : catalogos) {
			SelectItem selectItem = new SelectItem(detalle.getIdDetalleCatalogo(), detalle.getDescDetCatalogo());
			modeloItems.add(selectItem);
		}

	}

	/**
	 * 
	 * <b> Permite generar y descargar el documento en PDF. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 28/05/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descargarSoatPDF() throws HiperionException {
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarArchivoPDFSoat(ramoSoat));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		} catch (Exception e) {
			log.error("Error al momento generar el documento Soat en PDF", e);
			throw new HiperionException(e);
		}
	}

	/**
	 * @return the coberturas
	 */
	public List<CobertSoat> getCoberturas() {
		return coberturas;
	}

	/**
	 * @param coberturas
	 *            the coberturas to set
	 */
	public void setCoberturas(List<CobertSoat> coberturas) {
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