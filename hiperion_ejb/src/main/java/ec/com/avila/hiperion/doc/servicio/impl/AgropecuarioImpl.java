package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import org.apache.commons.lang.StringEscapeUtils;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocAgropecuario;
import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;

/**
 * 
 * <b> Clase que se encarga de generar el documento PDF. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,10/03/2015
 * @since JDK1.6
 */
@Stateless
public class AgropecuarioImpl implements GenerarDocAgropecuario {

	private static String tagInicioTasa = "<tasa>";
	private static String tagFinTasa = "</tasa>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocumentoHojaVida#generarXmlHojaVida(ec.com.avila.hiperion.emision.entities.RamoAgropecuario)
	 */
	@Override
	public String generarXmlAgropecuario(RamoAgropecuario agropecuario) throws HiperionException {
		StringBuffer buffer = new StringBuffer();
		buffer.append(tagInicioTasa).append(StringEscapeUtils.escapeXml(agropecuario.getTasaAgro().toString())).append(tagFinTasa);
		return buffer.toString();
	}
}
