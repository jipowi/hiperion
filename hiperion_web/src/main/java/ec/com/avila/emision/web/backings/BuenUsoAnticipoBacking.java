/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

import ec.com.avila.emision.web.beans.DetalleAnexoBean;
import ec.com.avila.emision.web.beans.PolizaBean;
import ec.com.avila.emision.web.beans.RamoBuenUsoAnticipoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
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
import ec.com.avila.hiperion.web.model.AnexosDataModel;
import ec.com.avila.hiperion.web.util.FechasUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
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

	private AnexosDataModel anexosDataModel;
	private List<DetalleAnexo> anexos;

	private List<DetalleAnexoBean> coberturas;
	private DetalleAnexoBean[] selectCoberturas;
	private List<SelectItem> aseguradorasItems;

	@ManagedProperty(value = "#{ramoBuenUsoAnticipoBean}")
	private RamoBuenUsoAnticipoBean ramoBuenUsoAnticipoBean;

	Logger log = Logger.getLogger(BuenUsoAnticipoBacking.class);

	@PostConstruct
	public void inicializar() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("BUA");
			anexos = ramo.getDetalleAnexos();
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas de Ramo Accidentes Personales. </b>
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
		Usuario usuario = usuarioBean.getSessionUser();
		RamoBuenUsoAnt buenUsoAnt = new RamoBuenUsoAnt();

		buenUsoAnt.setSectorAnticipo(ramoBuenUsoAnticipoBean.getSector());
		buenUsoAnt.setObjAsegAnticipo(ramoBuenUsoAnticipoBean.getObjetoAsegurado());
		buenUsoAnt.setValorContratoAnticipo(ramoBuenUsoAnticipoBean.getValorContrato());
		buenUsoAnt.setValorPolizaAnticipo(ramoBuenUsoAnticipoBean.getValorPoliza());

		buenUsoAnt.setIdUsuarioCreacion(usuario.getIdUsuario());
		buenUsoAnt.setFechaCreacion(new Date());
		buenUsoAnt.setEstado(EstadoEnum.A);

		try {
			ramoBuenUsoAnticipoService.guardarRamoBuenUsoAnticipo(buenUsoAnt);
			createPdfCotizacion(buenUsoAnt.getIndBuenUsoAnt().toString());
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.sOjeto"));
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.generate"));

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo Buen Uso de Anticipo", e);
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

}
