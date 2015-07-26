/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

import ec.com.avila.emision.web.beans.PolizaBean;
import ec.com.avila.emision.web.beans.RamoBuenUsoAnticipoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.TablaAmortizacionDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.CobertBuenUsoAnt;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.html.UtilsHtml;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.RamoBuenUsoAnticipoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.FechasUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Backing que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Buen Uso de Anticipo.</p>
 * 
 * @author Dario Vinueza
 * @version 1.0,16/02/2014
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class BuenUsoAnticipoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<SelectItem> sectorItems;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@ManagedProperty(value = "#{polizaBean}")
	private PolizaBean polizaBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;
	@EJB
	private RamoBuenUsoAnticipoService ramoBuenUsoAnticipoService;

	private List<DetalleAnexo> anexos;

	private List<CobertBuenUsoAnt> coberturas;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();
	private List<SelectItem> aseguradorasItems;

	@ManagedProperty(value = "#{ramoBuenUsoAnticipoBean}")
	private RamoBuenUsoAnticipoBean ramoBuenUsoAnticipoBean;

	private Usuario usuario;

	Logger log = Logger.getLogger(BuenUsoAnticipoBacking.class);

	RamoBuenUsoAnt buenUsoAnt = new RamoBuenUsoAnt();

	@PostConstruct
	public void inicializar() {
		try {

			usuario = usuarioBean.getSessionUser();

			Ramo ramo = ramoService.consultarRamoPorCodigo("BUA");
			anexos = ramo.getDetalleAnexos();

			obtenerCoberturas();

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas del ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public void obtenerCoberturas() {
		coberturas = new ArrayList<CobertBuenUsoAnt>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertBuenUsoAnt cobertura = new CobertBuenUsoAnt();
					cobertura.setCoberturaAnticipo(anexo.getNombreDetalleAnexo());

					coberturas.add(cobertura);
				}
			}
			for (CobertBuenUsoAnt cobertura : coberturas) {
				CoberturaDTO coberturaDTO = new CoberturaDTO();
				coberturaDTO.setCobertura(cobertura.getCoberturaAnticipo());

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

		Usuario usuario = usuarioBean.getSessionUser();
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

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
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
	 * <b> Permite generar un PDF a partir de un formato definido en HTML y lo guarda en un repositorio en el servidor</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 02/02/2015]
	 * </p>
	 * 
	 * @throws IOException
	 */
	public void createPdfCotizacion(String idRamo) throws IOException {

		Usuario usuario = usuarioBean.getSessionUser();
		String fechaActual = FechasUtil.getInstancia().dateFormated(new Date());
		String path = "cotizacion_" + usuario.getNombreUsuario() + " " + fechaActual + "_" + idRamo + ".pdf";

		FileOutputStream archivo = new FileOutputStream("C:\\Cotizaciones\\" + path);
		/*
		 * Declaramos documento como un objeto Document asignamos el tamaño de hoja y los margenes
		 */
		Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);

		// writer es declarado como el método utilizado para escribir en el archivo
		PdfWriter writer = null;

		try {
			// Obtenemos la instancia del archivo a utilizar
			writer = PdfWriter.getInstance(documento, archivo);
		} catch (DocumentException ex) {
			ex.getMessage();
		}

		String fechaDocumento = FechasUtil.getInstancia().dateForStringFull(new Date());
		String mensajeCabecera = UtilsHtml.getInstancia().obtenerContenidoHTML("formatoCotizacionAseguradoraCab.html")
				.replace("#{FechaActual}", fechaDocumento);
		String mensajeDetalle = UtilsHtml.getInstancia().obtenerContenidoHTML("formatoCotAgropecuarioAseg.html").replace("#{tasa}", fechaDocumento);
		// Agregamos un titulo al archivo
		documento.addTitle("Archivo pdf generado desde Java");

		// Agregamos el autor del archivo
		documento.addAuthor("JIPOVI");

		// Abrimos el documento para edición
		documento.open();

		// Declaramos un texto como Paragraph
		// Le podemos dar formado como alineación, tamaño y color a la fuente.
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Paragraph.ALIGN_CENTER);
		parrafo.setFont(FontFactory.getFont("Sans", 20, Font.BOLD, BaseColor.BLUE));
		parrafo.add("COTIZACION ASEGURADORA");

		try {
			// Agregamos el texto al documento
			documento.add(parrafo);
		} catch (DocumentException ex) {
			ex.getMessage();
		}

		documento.newPage(); // Podemos agregar una nueva página

		HTMLWorker htmlWorker = new HTMLWorker(documento);
		htmlWorker.parse(new StringReader(mensajeCabecera));

		documento.newPage(); // Podemos agregar una nueva página
		htmlWorker.parse(new StringReader(mensajeDetalle));
		documento.close(); // Cerramos el documento
		writer.close(); // Cerramos writer
	}

	/**
	 * @return the aseguradorasItems
	 * @throws HiperionException
	 */
	public List<SelectItem> getAseguradorasItems() throws HiperionException {

		if (this.aseguradorasItems == null) {
			this.aseguradorasItems = new ArrayList<SelectItem>();
		}

		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoAseguradoras"));

		List<DetalleCatalogo> aseguradoras = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : aseguradoras) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			aseguradorasItems.add(selectItem);
		}

		return aseguradorasItems;
	}

	/**
	 * @param sectorItems
	 *            the sectorItems to set
	 */
	public void setSectorItems(List<SelectItem> sectorItems) {
		this.sectorItems = sectorItems;
	}

	/**
	 * 
	 * <b> Permite guardar datos en la base de datos del Ramo Buen Uso Anticipo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 17/08/2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 * @throws IOException
	 */
	public void guardarRamo() throws HiperionException, IOException {

		Poliza poliza = setearDatosPoliza();

		buenUsoAnt.setSectorAnticipo(ramoBuenUsoAnticipoBean.getSector());
		buenUsoAnt.setObjAsegAnticipo(ramoBuenUsoAnticipoBean.getObjetoAsegurado());
		buenUsoAnt.setValorContratoAnticipo(ramoBuenUsoAnticipoBean.getValorContrato());
		buenUsoAnt.setValorPolizaAnticipo(ramoBuenUsoAnticipoBean.getValorPoliza());

		buenUsoAnt.setIdUsuarioCreacion(usuario.getIdUsuario());
		buenUsoAnt.setFechaCreacion(new Date());
		buenUsoAnt.setEstado(EstadoEnum.A);

		try {
			ramoBuenUsoAnticipoService.guardarRamoBuenUsoAnticipo(buenUsoAnt, poliza);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));

			createPdfCotizacion(buenUsoAnt.getIndBuenUsoAnt().toString());
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.generate"));

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo Buen Uso de Anticipo", e);
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
		List<CobertBuenUsoAnt> coberturas = new ArrayList<>();
		for (CoberturaDTO coberturaDTO : coberturasDTO) {
			if (coberturaDTO.getSeleccion()) {
				contCoberturas++;
				CobertBuenUsoAnt cobertura = new CobertBuenUsoAnt();
				cobertura.setCoberturaAnticipo(coberturaDTO.getCobertura());

				coberturas.add(cobertura);
			}
		}

		if (contCoberturas == 0) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.coberturas"));
		} else {
			buenUsoAnt.setCobertBuenUsoAnts(coberturas);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.coberturas"));
		}
	}

	/**
	 * 
	 * <b> Permite editar el registro de la tabla de coberturas. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 26/07/2015]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditCobertura(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((CoberturaDTO) event.getObject()).getCobertura());
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
	 * @return the ramoBuenUsoAnticipoBean
	 */
	public RamoBuenUsoAnticipoBean getRamoBuenUsoAnticipoBean() {
		return ramoBuenUsoAnticipoBean;
	}

	/**
	 * @param ramoBuenUsoAnticipoBean
	 *            the ramoBuenUsoAnticipoBean to set
	 */
	public void setRamoBuenUsoAnticipoBean(RamoBuenUsoAnticipoBean ramoBuenUsoAnticipoBean) {
		this.ramoBuenUsoAnticipoBean = ramoBuenUsoAnticipoBean;
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

	/**
	 * 
	 * <b> Permite generar y descargar el documento en PDF. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 22/04/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descargarBuenUsoAnticipoPDF() throws HiperionException {
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarArchivoPDFBuenUsoAnticipo(buenUsoAnt));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		} catch (Exception e) {
			log.error("Error al momento generar el documento Buen Uso de Anticipo en PDF", e);
			throw new HiperionException(e);
		}
	}

	/**
	 * @return the coberturas
	 */
	public List<CobertBuenUsoAnt> getCoberturas() {
		return coberturas;
	}

	/**
	 * @param coberturas
	 *            the coberturas to set
	 */
	public void setCoberturas(List<CobertBuenUsoAnt> coberturas) {
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

}
