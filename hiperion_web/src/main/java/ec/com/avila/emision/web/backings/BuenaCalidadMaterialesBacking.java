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
import ec.com.avila.emision.web.beans.RamoBuenaCalMatBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.TablaAmortizacionDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.CobertMateriale;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoBuenaCalMat;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.RamoBuenaCalMatService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b> Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Buena Calidad de Materiales.
 * </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,18/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class BuenaCalidadMaterialesBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<SelectItem> sectorItems;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;
	@EJB
	private RamoBuenaCalMatService ramoBuenaCalMatService;

	private List<DetalleAnexo> anexos;

	private List<CobertMateriale> coberturas;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();

	@ManagedProperty(value = "#{ramoBuenaCalMatBean}")
	private RamoBuenaCalMatBean ramoBuenaCalMatBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@ManagedProperty(value = "#{polizaBean}")
	private PolizaBean polizaBean;

	private Usuario usuario;
	Logger log = Logger.getLogger(BuenaCalidadMaterialesBacking.class);

	RamoBuenaCalMat buenaCalidadMateriales = new RamoBuenaCalMat();

	@PostConstruct
	public void inicializar() {
		try {
			usuario = usuarioBean.getSessionUser();

			Ramo ramo = ramoService.consultarRamoPorCodigo("BCM");
			anexos = ramo.getDetalleAnexos();
			obtenerCoberturas();
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas de Ramo Buena Calidad de Materiales. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public void obtenerCoberturas() {
		coberturas = new ArrayList<CobertMateriale>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertMateriale cobertura = new CobertMateriale();
					cobertura.setCoberturaMateriales(anexo.getNombreDetalleAnexo());

					coberturas.add(cobertura);
				}
			}

			for (CobertMateriale cobertura : coberturas) {
				CoberturaDTO coberturaDTO = new CoberturaDTO();
				coberturaDTO.setCobertura(cobertura.getCoberturaMateriales());

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

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 27/07/2015]
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
	 * <b> Permite setear las coberturas seleccionadas en el Bean. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 14/07/2015]
	 * </p>
	 * 
	 */
	public void setearCoberturas() {
		int contCoberturas = 0;
		List<CobertMateriale> coberturas = new ArrayList<>();
		for (CoberturaDTO coberturaDTO : coberturasDTO) {
			if (coberturaDTO.getSeleccion()) {
				contCoberturas++;
				CobertMateriale cobertura = new CobertMateriale();
				cobertura.setCoberturaMateriales(coberturaDTO.getCobertura());

				coberturas.add(cobertura);
			}
		}

		if (contCoberturas == 0) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.coberturas"));
		} else {
			buenaCalidadMateriales.setCobertMateriales(coberturas);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.coberturas"));
		}
	}

	/**
	 * 
	 * <b> Permite consultar los sectores que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 30, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getSectorItems() throws HiperionException {

		this.sectorItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoSector"));
		List<DetalleCatalogo> sectores = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : sectores) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			sectorItems.add(selectItem);
		}

		return sectorItems;
	}

	/**
	 * 
	 * <b> Permite guardar un objeto RamoBuenaCalidad de Materiales a la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 10/08/2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {

		Usuario usuario = usuarioBean.getSessionUser();
		Poliza poliza = setearDatosPoliza();

		buenaCalidadMateriales.setSectorCalMat(ramoBuenaCalMatBean.getSector());
		buenaCalidadMateriales.setObjAsegCalMat(ramoBuenaCalMatBean.getObjetoAsegurado());
		buenaCalidadMateriales.setValorContratoMateriales(ramoBuenaCalMatBean.getValorContrato());
		buenaCalidadMateriales.setValorPolizaMateriales(ramoBuenaCalMatBean.getValorPoliza());

		buenaCalidadMateriales.setIdUsuarioCreacion(usuario.getIdUsuario());
		buenaCalidadMateriales.setFechaCreacion(new Date());
		buenaCalidadMateriales.setEstado(EstadoEnum.A);

		try {

			ramoBuenaCalMatService.guardarRamoBuenaCalMat(buenaCalidadMateriales, poliza);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.sOjeto"));

		} catch (HiperionException e) {

			log.error("Error al momento de guardar el ramo Buena Calidad de materiales", e);
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
	 * @return the ramoBuenaCalMatBean
	 */
	public RamoBuenaCalMatBean getRamoBuenaCalMatBean() {
		return ramoBuenaCalMatBean;
	}

	/**
	 * @param ramoBuenaCalMatBean
	 *            the ramoBuenaCalMatBean to set
	 */
	public void setRamoBuenaCalMatBean(RamoBuenaCalMatBean ramoBuenaCalMatBean) {
		this.ramoBuenaCalMatBean = ramoBuenaCalMatBean;
	}

	/**
	 * 
	 * <b> Permite generar y descargar informacion Ramo Buena Calidad Materiales PDF </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 28/04/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descargarBuenaCalidadMaterialesPDF() throws HiperionException {
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR,
					GenerarPdfUtil.generarAchivoPDFBuenaCalidadMat(buenaCalidadMateriales));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();

		} catch (Exception e) {
			log.error("Error al momento generar el docuento PDF", e);
			throw new HiperionException(e);
		}
	}

	/**
	 * @return the coberturas
	 */
	public List<CobertMateriale> getCoberturas() {
		return coberturas;
	}

	/**
	 * @param coberturas
	 *            the coberturas to set
	 */
	public void setCoberturas(List<CobertMateriale> coberturas) {
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
