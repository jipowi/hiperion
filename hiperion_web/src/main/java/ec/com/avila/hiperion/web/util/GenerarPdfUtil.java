package ec.com.avila.hiperion.web.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.xml.transform.TransformerException;

import org.jdom.JDOMException;

import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;
import ec.com.kruger.framework.common.util.pdf.HtmltoPDF;

public class GenerarPdfUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * <b> Permite generar la hoja de vida en formato PDF. </b>
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
		String pHtml = XSLUtil.getInstancia().obtenerHtmlAgropecuario(agropecuario);

		byte[] contenido = obtenerCadenaBytes(pHtml);

		// Agregar marca de agua al Pdf
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
