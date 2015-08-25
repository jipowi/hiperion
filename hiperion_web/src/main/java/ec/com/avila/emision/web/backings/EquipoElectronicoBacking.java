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
import ec.com.avila.emision.web.beans.RamoEquipoElectronicoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ClausulaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.GarantiaPolizaDTO;
import ec.com.avila.hiperion.dto.ObjetoAseguradoEquipoElectronicoDTO;
import ec.com.avila.hiperion.dto.TablaAmortizacionDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.ClausulasAddEquipo;
import ec.com.avila.hiperion.emision.entities.CobertAddEquipo;
import ec.com.avila.hiperion.emision.entities.CobertEquipo;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.GarantiaPoliza;
import ec.com.avila.hiperion.emision.entities.ObjAsegEquipo;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoEquipoElectronico;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.RamoEquipoElectronicoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Equipo Electronico. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class EquipoElectronicoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private RamoEquipoElectronicoService ramoEquipoElectronicoService;

	@ManagedProperty(value = "#{polizaBean}")
	private PolizaBean polizaBean;

	@ManagedProperty(value = "#{ramoEquipoElectronicoBean}")
	private RamoEquipoElectronicoBean ramoEquipoElectronicoBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	Logger log = Logger.getLogger(EquipoElectronicoBacking.class);

	RamoEquipoElectronico equipoElectronico = new RamoEquipoElectronico();

	private List<CobertEquipo> coberturas;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();
	private List<CobertAddEquipo> coberturasAdd;
	private List<CoberturaAdicionalDTO> coberturasAddDTO = new ArrayList<>();
	private List<ClausulasAddEquipo> clausulasAdicionales;
	private List<ClausulaAdicionalDTO> clausulasAdicionalesDTO = new ArrayList<>();
	private List<GarantiaPoliza> garantias;
	private List<GarantiaPolizaDTO> garantiasDTO = new ArrayList<>();
	private List<DetalleAnexo> anexos;
	private Usuario usuario;

	private List<SelectItem> detalleItems;

	@PostConstruct
	public void inicializar() {
		try {

			usuario = usuarioBean.getSessionUser();
			
			Ramo ramo = ramoService.consultarRamoPorCodigo("EE");

			anexos = ramo.getDetalleAnexos();

			obtenerCoberturas();
			obtenerCoberturasAdicionales();
			obtenerGarantiasPoliza();

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener los valor del detalle de los equipos electronicos de un catalogo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 11, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getDetalleItems() throws HiperionException {
		this.detalleItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoDetalleEquipoElectronico"));
		List<DetalleCatalogo> sectores = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : sectores) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			detalleItems.add(selectItem);
		}

		return detalleItems;
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

		coberturas = new ArrayList<CobertEquipo>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertEquipo cobertura = new CobertEquipo();
					cobertura.setCoberturaEqElec(anexo.getNombreDetalleAnexo());

					coberturas.add(cobertura);
				}

			}

			for (CobertEquipo cobertura : coberturas) {
				CoberturaDTO coberturaDTO = new CoberturaDTO();
				coberturaDTO.setCobertura(cobertura.getCoberturaEqElec());
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

		coberturasAdd = new ArrayList<CobertAddEquipo>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 6) {
					CobertAddEquipo cobertura = new CobertAddEquipo();
					cobertura.setCoberturaAddEqElec(anexo.getNombreDetalleAnexo());

					coberturasAdd.add(cobertura);
				}

			}

			for (CobertAddEquipo cobertura : coberturasAdd) {
				CoberturaAdicionalDTO coberturaAddDTO = new CoberturaAdicionalDTO();
				coberturaAddDTO.setCobertura(cobertura.getCoberturaAddEqElec());
				coberturaAddDTO.setSeleccion(false);

				coberturasAddDTO.add(coberturaAddDTO);
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
	public void obtenerGarantiasPoliza() {

		garantias = new ArrayList<GarantiaPoliza>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 6) {
					GarantiaPoliza cobertura = new GarantiaPoliza();
					cobertura.setGarantiaEqElec(anexo.getNombreDetalleAnexo());

					garantias.add(cobertura);
				}

			}

			for (GarantiaPoliza garantia : garantias) {
				GarantiaPolizaDTO garantiaDTO = new GarantiaPolizaDTO();
				garantiaDTO.setGarantia(garantia.getGarantiaEqElec());
				garantiaDTO.setSeleccion(false);

				garantiasDTO.add(garantiaDTO);
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
		clausulasAdicionales = new ArrayList<ClausulasAddEquipo>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1) {
					ClausulasAddEquipo clausula = new ClausulasAddEquipo();
					clausula.setClausulaEqElec(anexo.getNombreDetalleAnexo());

					clausulasAdicionales.add(clausula);
				}

			}
			for (ClausulasAddEquipo clausula : clausulasAdicionales) {
				ClausulaAdicionalDTO clausulaDTO = new ClausulaAdicionalDTO();
				clausulaDTO.setClausula(clausula.getClausulaEqElec());
				clausulaDTO.setSeleccion(false);

				clausulasAdicionalesDTO.add(clausulaDTO);
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
	 * <b> Permite guardar la informacion del ramo y objeto asegurado en sus respectivas tablas </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Nov 7, 2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {

		try {
			
			Poliza poliza = setearDatosPoliza();
			
			equipoElectronico.setTasaEquiposFijos(ramoEquipoElectronicoBean.getTasaFijos());
			equipoElectronico.setTasaExtDatos(ramoEquipoElectronicoBean.getTasaDatos());
			equipoElectronico.setTasaOperacion(ramoEquipoElectronicoBean.getTasaOperacion());
			equipoElectronico.setTasaEquiposPortatiles(ramoEquipoElectronicoBean.getTasaPortatiles());
			equipoElectronico.setTasaCelulares(ramoEquipoElectronicoBean.getTasaCelulares());
			equipoElectronico.setTasaHurtoEqElec(ramoEquipoElectronicoBean.getTasaHurto());
			equipoElectronico.setTasaHurtoEqElec(ramoEquipoElectronicoBean.getTasaOtros());

			equipoElectronico.setIdUsuarioCreacion(usuario.getIdUsuario());
			equipoElectronico.setFechaCreacion(new Date());
			equipoElectronico.setEstado(EstadoEnum.A);
			
			if (!ramoEquipoElectronicoBean.getOrderlist().isEmpty()) {

				List<ObjAsegEquipo> listObjetos = new ArrayList<>();
				for (ObjetoAseguradoEquipoElectronicoDTO objeto : ramoEquipoElectronicoBean.getOrderlist()) {
					ObjAsegEquipo asegEquipo = new ObjAsegEquipo();

					asegEquipo.setItemObjEqElec(objeto.getNumeroItem());
					asegEquipo.setUbicacionObjEqElec(objeto.getUbicacionRiesgo());
					asegEquipo.setDetalleObjetoEqElec(objeto.getDetalle());
					asegEquipo.setValorObjEqElec(objeto.getValorObjeto());
					asegEquipo.setDescObjEqElec(objeto.getDescripcion());

					Usuario usuario = usuarioBean.getSessionUser();
					asegEquipo.setIdUsuarioCreacion(usuario.getIdUsuario());
					asegEquipo.setFechaCreacion(new Date());
					asegEquipo.setEstado(EstadoEnum.A);
					listObjetos.add(asegEquipo);
				}
				equipoElectronico.setObjAsegEquipos(listObjetos);
			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save.Obj"));
			}

			ramoEquipoElectronicoService.guardarRamoEquipoElectronico(equipoElectronico, poliza);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
			
			equipoElectronico = new RamoEquipoElectronico();
			ramoEquipoElectronicoBean.getOrderlist().clear();
		
		} catch (HiperionException e) {

			log.error("Error al momento de guardar el ramo equipo electronico", e);
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
		List<CobertEquipo> coberturas = new ArrayList<>();
		for (CoberturaDTO coberturaDTO : coberturasDTO) {
			if (coberturaDTO.getSeleccion()) {
				contCoberturas++;
				CobertEquipo cobertura = new CobertEquipo();
				cobertura.setCoberturaEqElec(coberturaDTO.getCobertura());

				coberturas.add(cobertura);
			}
		}

		if (contCoberturas == 0) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.coberturas"));
		} else {
			equipoElectronico.setCobertEquipos(coberturas);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.coberturas"));
		}
	}


	/**
	 * 
	 * <b> permite setear las coberturas adicionales seleccionadas en el Bean. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/07/2015]
	 * </p>
	 * 
	 */
	public void setearCoberturasAdd() {
		int contCoberturas = 0;
		List<CobertAddEquipo> coberturas = new ArrayList<>();
		for (CoberturaAdicionalDTO coberturaDTO : coberturasAddDTO) {
			if (coberturaDTO.getSeleccion()) {
				contCoberturas++;
				CobertAddEquipo cobertura = new CobertAddEquipo();
				cobertura.setCoberturaAddEqElec(coberturaDTO.getCobertura());

				coberturas.add(cobertura);
			}
		}

		if (contCoberturas == 0) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.coberturasAdd"));
		} else {
			equipoElectronico.setCobertAddEquipos(coberturas);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.coberturasAdd"));
		}
	}

	/**
	 * 
	 * <b> permite setear las clausualas adicionales seleccionadas. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/07/2015]
	 * </p>
	 * 
	 */
	public void setearClausulasAdd() {

		int contClausulas = 0;
		List<ClausulasAddEquipo> clausulas = new ArrayList<>();
		for (ClausulaAdicionalDTO clausualaDTO : clausulasAdicionalesDTO) {
			if (clausualaDTO.getSeleccion()) {
				contClausulas++;
				ClausulasAddEquipo clausula = new ClausulasAddEquipo();
				clausula.setClausulaEqElec(clausualaDTO.getClausula());
				clausula.setEstado(EstadoEnum.A);
				clausula.setFechaCreacion(new Date());
				clausula.setIdUsuarioCreacion(usuario.getIdUsuario());

				clausulas.add(clausula);
			}
		}
		if (contClausulas == 0) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.clausulasAdd"));
		} else {
			equipoElectronico.setClausulasAddEquipos(clausulas);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.clausulasAdd"));
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
	 * <b> Permite editar un registro de la tabla</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditCoberturaAdd(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((CoberturaAdicionalDTO) event.getObject()).getCobertura());
		FacesContext.getCurrentInstance().addMessage(null, msg);
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
	public void onEditClausulasAdd(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ClausulaAdicionalDTO) event.getObject()).getClausula());
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
	 * @return the ramoEquipoElectronicoBean
	 */
	public RamoEquipoElectronicoBean getRamoEquipoElectronicoBean() {
		return ramoEquipoElectronicoBean;
	}

	/**
	 * @param ramoEquipoElectronicoBean
	 *            the ramoEquipoElectronicoBean to set
	 */
	public void setRamoEquipoElectronicoBean(RamoEquipoElectronicoBean ramoEquipoElectronicoBean) {
		this.ramoEquipoElectronicoBean = ramoEquipoElectronicoBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * @param detalleItems
	 *            the detalleItems to set
	 */
	public void setDetalleItems(List<SelectItem> detalleItems) {
		this.detalleItems = detalleItems;
	}

	/**
	 * 
	 * <b> Permite descargar la informacion del ramo dinero y valores. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/04/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descargarEquipoElectronicoPDF() throws HiperionException {
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarAchivoPDFEquipoElectronico(equipoElectronico));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();

		} catch (Exception e) {
			log.error("Error al momento generar el documento PDF", e);
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
	 * @return the garantiasDTO
	 */
	public List<GarantiaPolizaDTO> getGarantiasDTO() {
		return garantiasDTO;
	}

	/**
	 * @param garantiasDTO
	 *            the garantiasDTO to set
	 */
	public void setGarantiasDTO(List<GarantiaPolizaDTO> garantiasDTO) {
		this.garantiasDTO = garantiasDTO;
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
