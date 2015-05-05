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
import ec.com.avila.hiperion.doc.servicio.GenerarDocBuenUsoAnticipo;
import ec.com.avila.hiperion.doc.servicio.GenerarDocBuenaCalidadMateriales;
import ec.com.avila.hiperion.doc.servicio.GenerarDocCascoAereo;
import ec.com.avila.hiperion.doc.servicio.GenerarDocCascoMaritimo;
import ec.com.avila.hiperion.doc.servicio.GenerarDocCumplimientoContrato;
import ec.com.avila.hiperion.doc.servicio.GenerarDocDineroValores;
import ec.com.avila.hiperion.doc.servicio.GenerarDocEquipoElectronico;
import ec.com.avila.hiperion.doc.servicio.GenerarDocEquipoMaquinaria;
import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;
import ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt;
import ec.com.avila.hiperion.emision.entities.RamoBuenaCalMat;
import ec.com.avila.hiperion.emision.entities.RamoCascoAereo;
import ec.com.avila.hiperion.emision.entities.RamoCascoMaritimo;
import ec.com.avila.hiperion.emision.entities.RamoCumplimientoContrato;
import ec.com.avila.hiperion.emision.entities.RamoDineroValore;
import ec.com.avila.hiperion.emision.entities.RamoEquipoElectronico;
import ec.com.avila.hiperion.emision.entities.RamoEquipoMaquinaria;
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
	 * <b> Pc </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/04/2015]
	 * </p>
	 * 
	 * @param equipoElectronico
	 * @return
	 */
	public String generarXmlEquipoElectronico(RamoEquipoElectronico equipoElectronico) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);

			try {
				String nombreClase = "java:app/hiperion_web/EquipoElectronicoImpl";
				GenerarDocEquipoElectronico generarDocumento = (GenerarDocEquipoElectronico) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlEquipoElectronico(equipoElectronico));

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
	 * <b> generarXmlEquipoMaquinaria </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/04/2015]
	 * </p>
	 * 
	 * @param equipoMaquinaria
	 * @return
	 */
	public String generarXmlEquipoMaquinaria(RamoEquipoMaquinaria equipoMaquinaria) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);

			try {
				String nombreClase = "java:app/hiperion_web/EquipoMaquinariaImpl";
				GenerarDocEquipoMaquinaria generarDocumento = (GenerarDocEquipoMaquinaria) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlEquipoMaquinaria(equipoMaquinaria));

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
	 * <b> Permite generar un contenedor XML </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 13/04/2015]
	 * </p>
	 * 
	 * @param buenaCalMat
	 * @return
	 */
	public String generarXmlBuenaCalMat(RamoBuenaCalMat buenaCalMat) {
		StringBuilder xml = new StringBuilder();

		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/BuenaCalidadMaterialesImpl";
				GenerarDocBuenaCalidadMateriales generarDocumento = (GenerarDocBuenaCalidadMateriales) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlBuenaCalidadMateriales(buenaCalMat));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar un contenedor XML. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 15/04/2015]
	 * </p>
	 * 
	 * @param buenUsoAnt
	 * @return
	 */
	public String generarXmlBuenUsoAnt(RamoBuenUsoAnt buenUsoAnt) {

		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/BuenUsoAnticipoImpl";
				GenerarDocBuenUsoAnticipo generarDocumento = (GenerarDocBuenUsoAnticipo) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlBuenUsoAnticipo(buenUsoAnt));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar un contenedor XML.. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 15/04/2015]
	 * </p>
	 * 
	 * @param cascoAereo
	 * @return
	 */
	public String generarXmlCascoAereo(RamoCascoAereo cascoAereo) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/CascoAereoImpl";
				GenerarDocCascoAereo generarDocumento = (GenerarDocCascoAereo) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlCascoAereo(cascoAereo));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar un contenedor XML. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 20/04/2015]
	 * </p>
	 * 
	 * @param cascoMaritimo
	 * @return
	 */
	public String generarXmlCascoMaritimo(RamoCascoMaritimo cascoMaritimo) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/CascoAereoImpl";
				GenerarDocCascoMaritimo generarDocumento = (GenerarDocCascoMaritimo) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlCascoMaritimo(cascoMaritimo));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();

	}

	public String generarXmlCumplimientoContrato(RamoCumplimientoContrato cumplimientoContrato) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/CumplimientoContratoImpl";
				GenerarDocCumplimientoContrato generarDocumento = (GenerarDocCumplimientoContrato) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlCumplimientoContrato(cumplimientoContrato));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();
	}

	public String generarXmlDineroValores(RamoDineroValore dineroValore) {
		StringBuilder xml = new StringBuilder();
		try {
			xml.append(tagInicioDocumento);
			try {
				String nombreClase = "java:app/hiperion_web/DineroValoresImpl";
				GenerarDocDineroValores generarDocumento = (GenerarDocDineroValores) getObjectByJndi(nombreClase);
				xml.append(generarDocumento.generarXmlDineroValores(dineroValore));
			} catch (Exception e) {
				log.error("Error", e);
			}
			xml.append(tagFinDocumento);
		} catch (Exception e) {

		}
		return xml.toString();
	}

	/**
	 * 
	 * <b> Permite generar el HTML del ramo Agropecuario. </b>
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
	 * 
	 * <b> Permite generar el HTML del ramo Equipo Electronico </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/04/2015]
	 * </p>
	 * 
	 * @param equipoElectronico
	 * @return
	 */
	public String obtenerHtmlEquipoElectronico(RamoEquipoElectronico equipoElectronico) {

		String html = null;

		try {
			InputStream in = XSLHelper.class.getResourceAsStream("EquipoElectronicoHTML.xsl");
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
			String contenidoXml = generarXmlEquipoElectronico(equipoElectronico);
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
	 * 
	 * <b> Permite generar el HTML del ramo Equipo Maquinaria </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/04/2015]
	 * </p>
	 * 
	 * @param equipoMaquinaria
	 * @return
	 */
	public String obtenerHtmlEquipoMaquinaria(RamoEquipoMaquinaria equipoMaquinaria) {
		String html = null;

		try {
			InputStream in = XSLHelper.class.getResourceAsStream("EquipoElectronicoHTML.xsl");
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
			String contenidoXml = generarXmlEquipoMaquinaria(equipoMaquinaria);
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
	 * 
	 * <b> Permite generar el HTML del ramo Buena Calidad de Materiales. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 13/04/2015]
	 * </p>
	 * 
	 * @param buenaCalMat
	 * @return
	 */
	public String obtenerHtmlBuenaCalidadMat(RamoBuenaCalMat buenaCalMat) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("BuenaCalMatHTML.xsl");
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
			String contenidoXml = generarXmlBuenaCalMat(buenaCalMat);
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
	 * 
	 * <b> Permite generar el HTML del ramo Buen Uso de Anticipo. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 13/04/2015]
	 * </p>
	 * 
	 * @param buenUsoAnt
	 * @return
	 */
	public String obtenerHtmlBuenUsoAnticipo(RamoBuenUsoAnt buenUsoAnt) {

		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("BuenUsoAntHTML.xsl");
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
			String contenidoXml = generarXmlBuenUsoAnt(buenUsoAnt);
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
	 * 
	 * <b> Permite generar el HTML del ramo Casco Aereo. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 20/04/2015]
	 * </p>
	 * 
	 * @param cascoAereo
	 * @return
	 */

	public String obtenerHtmlCascoAereo(RamoCascoAereo cascoAereo) {

		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("CascoAereoHTML.xsl");
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
			String contenidoXml = generarXmlCascoAereo(cascoAereo);
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
	 * 
	 * <b> Permite generar el HTML del ramo Casco Maritimo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 20/04/2015]
	 * </p>
	 * 
	 * @param cascoMaritimo
	 * @return
	 */
	public String obtenerHtmlCascoMaritimo(RamoCascoMaritimo cascoMaritimo) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("CascoMaritimoHTML.xsl");
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
			String contenidoXml = generarXmlCascoMaritimo(cascoMaritimo);
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
	 * 
	 * <b> Permite generar el HTML del ramo Cumplimiento Contrato </b>
	 * <p>
	 * [Author:Franklin Pozo B, Date: 21/04/2015]
	 * </p>
	 * 
	 * @param cumplimientoContrato
	 * @return
	 */
	public String obtenerHtmlCumplimientoContrato(RamoCumplimientoContrato cumplimientoContrato) {
		String html = null;
		try {
			InputStream in = XSLHelper.class.getResourceAsStream("CumplimientoContratoHTML.xsl");
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
			String contenidoXml = generarXmlCumplimientoContrato(cumplimientoContrato);
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
	 * 
	 * <b> Permite generar el HTML del ramo Cumplimiento Contrato. </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 27/04/2015]
	 * </p>
	 * 
	 * @param cumplimientoContrato
	 * @return
	 */
	public String obtenerHtmlDineroValores(RamoDineroValore dineroValore) {

		String html = null;

		try {
			InputStream in = XSLHelper.class.getResourceAsStream("DineroValoresHTML.xsl");
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
			String contenidoXml = generarXmlDineroValores(dineroValore);
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
