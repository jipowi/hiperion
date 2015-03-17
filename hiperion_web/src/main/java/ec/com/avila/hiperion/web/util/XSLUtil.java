/**
 * 
 */
package ec.com.avila.hiperion.web.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.jdom.Document;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocAgropecuario;
import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;
import ec.com.avila.hiperion.xsl.XSLHelper;
import ec.com.kruger.framework.common.util.TransformerUtil;

/**
 * @author jarana
 * 
 */
public class XSLUtil {

	private XSLUtil() {
	}

	private static final XSLUtil INSTANCIA = new XSLUtil();

	public static XSLUtil getInstancia() {
		return INSTANCIA;
	}

	private static final String tagInicioDocumento = "<documento>";
	private static final String tagFinDocumento = "</documento>";

	Logger log = Logger.getLogger(XSLUtil.class);

	/**
	 * 
	 * <b> Permite generar un contenido XML. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 01/03/2015]
	 * </p>
	 * 
	 * @param docente
	 * @return
	 */
	public String generarXmlAgropecuario(RamoAgropecuario agropecuario) {
		StringBuilder xml = new StringBuilder();

		try {
			xml.append(tagInicioDocumento);

			try {
				String nombreClase = "java:app/hiperion_web/AgropecuarioImpl";
				GenerarDocAgropecuario generarDocumento = (GenerarDocAgropecuario) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlAgropecuario(agropecuario));

			} catch (Exception e) {
				log.error("Error, generacion xml reporte, e{}", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {
			log.error("Error", e);

		}
		return xml.toString();
	}

	

	/**
	 * 
	 * <b> Permite generar el HTML de la hoja de vida. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 09/03/2015]
	 * </p>
	 * 
	 * @param docente
	 * @param formacionesC
	 * @param formacionesA
	 * @return
	 */
	public String obtenerHtmlAgropecuario(RamoAgropecuario agropecuario) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("AgropecuarioHTML.xsl");
			InputStreamReader is = new InputStreamReader(in);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();

			}

			String contenidoXSL = sb.toString();

			// Se genera el XML con los datos del documento
			String contenidoXml = generarXmlAgropecuario(agropecuario);
			Document docXML = TransformerUtil.stringToXMLDocument(contenidoXml.toString());
			Document docXSL = TransformerUtil.stringToXML(contenidoXSL);
			Document result = TransformerUtil.transformar(docXML, docXSL);
			html = TransformerUtil.xmlToString(result);
			html = html.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replace("UTF-8", "ISO-8859-1");

		} catch (Exception e) {
			log.error("Error ", e);

		}

		return html;
	}

	
	/**
	 * <b>Obtiene el servicio de Seguridad del sistema de mercado de valores</b>
	 * <p>
	 * [Author: gyandun, Date: 07/05/2014]
	 * </p>
	 * 
	 * @return
	 * @throws MercadoValoresException
	 *             En caso de no encontrar el EJB
	 */
	public Object getObjectByJndi(String jndiName) throws HiperionException {
		try {
			return getContext().lookup(jndiName);
		} catch (Exception e) {
			throw new HiperionException(e);
		}
	}

	/**
	 * <b> Permite inicializar el InitialContext. </b>
	 * <p>
	 * [Author: gyandun, Date: 16/03/2014]
	 * </p>
	 * 
	 * @return Context
	 * @throws NamingException
	 *             NamingException
	 */
	public Context getContext() throws NamingException {
		return new InitialContext();
	}

}
