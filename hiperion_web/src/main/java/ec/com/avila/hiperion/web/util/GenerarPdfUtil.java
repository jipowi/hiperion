package ec.com.avila.hiperion.web.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.xml.transform.TransformerException;

import org.jdom.JDOMException;

import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;
import ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt;
import ec.com.avila.hiperion.emision.entities.RamoBuenaCalMat;
import ec.com.avila.hiperion.emision.entities.RamoCascoAereo;
import ec.com.avila.hiperion.emision.entities.RamoCascoMaritimo;
import ec.com.avila.hiperion.emision.entities.RamoCumplimientoContrato;
import ec.com.avila.hiperion.emision.entities.RamoDineroValore;
import ec.com.kruger.framework.common.util.pdf.HtmltoPDF;

public class GenerarPdfUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * <b> Permite generar el documento ramo agropecuario PDF. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 10/03/2015]
	 * </p>
	 * 
	 * @param docente
	 * @param formacionesA
	 * @param formacionesC
	 * @param experiencias
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFAgropecuario(RamoAgropecuario agropecuario) throws Exception {
		String HTML = XSLUtil.getInstancia().obtenerHtmlAgropecuario(agropecuario);

		byte[] contenido = obtenerCadenaBytes(HTML);

		// Agregar marca de agua al Pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Buena Calidad Materiales. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 07/04/2015]
	 * </p>
	 * 
	 * @param buenaCalMat
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFBuenaCalidadMat(RamoBuenaCalMat buenaCalMat) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlBuenaCalidadMat(buenaCalMat);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Buen Uso de Anticipo. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 13/04/2015]
	 * </p>
	 * 
	 * @param buenUsoAnt
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFBuenUsoAnticipo(RamoBuenUsoAnt buenUsoAnt) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlBuenUsoAnticipo(buenUsoAnt);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Casco Aereo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 20/04/2015]
	 * </p>
	 * 
	 * @param cascoAereo
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFCascoAereo(RamoCascoAereo cascoAereo) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlCascoAereo(cascoAereo);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Casco Maritimo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 20/04/2015]
	 * </p>
	 * 
	 * @param cascoMaritimo
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarAchivoPDFCascoMaritimo(RamoCascoMaritimo cascoMaritimo) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlCascoMaritimo(cascoMaritimo);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);

	}

	/**
	 * 
	 * <b> Permite generar el documento del ramo Cumplimiento Contrato. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 21/04/2015]
	 * </p>
	 * 
	 * @param cumplimientoContrato
	 * @return
	 * @throws Exception
	 */
	public static byte[] generarArchivoPDFCumplimientoContrato(RamoCumplimientoContrato cumplimientoContrato) throws Exception {
		String pHtml = XSLUtil.getInstancia().obtenerHtmlCumplimientoContrato(cumplimientoContrato);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}
	
	public static byte[] generarAchivoPDFDineroValores(RamoDineroValore dineroValore)throws Exception{
		
		String pHtml = XSLUtil.getInstancia().obtenerHtmlDineroValores(dineroValore);
		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al pdf
		return ConcatenadorPdf.numerarMarcar(contenido, Boolean.TRUE, Boolean.TRUE, ConstantesUtil.PATH_MARCA_AGUA_PDF);
	}

	/**
	 * <b> Permite obtener la cadena de bytes del archivo HTML. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 10/03/2015]
	 * </p>
	 * 
	 * @param pHtml
	 * @return
	 * @throws FileNotFoundException
	 * @throws JDOMException
	 * @throws IOException
	 * @throws TransformerException
	 */
	private static byte[] obtenerCadenaBytes(String pHtml) throws FileNotFoundException, JDOMException, IOException, TransformerException {

		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_ISO_XML, "");
		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_XML, "");
		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_XML_STANDALONE, "");
		pHtml = pHtml.replace(ConstantesUtil.ENCABEZADO_XML, "");

		HtmltoPDF htmltoPDF = new HtmltoPDF(FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath(ConstantesUtil.DIRECTORIO_PLANTILLA_XHTML2FO));

		HashMap<String, String> parametros = new HashMap<String, String>();

		byte contenido[] = htmltoPDF.convertir(pHtml, "", "", parametros, null);

		return contenido;
	}
}
