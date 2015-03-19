/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocDineroValores;
import ec.com.avila.hiperion.emision.entities.RamoDineroValore;

/**
 * <b> Clase que se encarga de generar el documento PDF. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/03/2015
 * @since JDK1.6
 */
public class DineroValoresImpl implements GenerarDocDineroValores {

	private static String tagInicioTasa = "<tasa>";
	private static String tagFinTasa = "</tasa>";
	private static String tagInicioPorcentajeSiniestro = "<porcentajeSiniestro>";
	private static String tagFinPorceSiniestro = "</porcentajeSiniestro>";
	private static String tagInicioValorMinimoSiniestro = "<valorMinimoSiniestro>";
	private static String tagFinValorMinimoSiniestro = "</valorMinimoSiniestro>";
	private static String tagInicioPorcentajeEmbarque = "<porcentajeEmbarque>";
	private static String tagFinPorcentajeEmbarque = "</porcentajeEmbarque>";
	private static String tagInicioItem = "<item>";
	private static String tagFinItem = "</item>";
	private static String tagInicioDineroValores = "<dineroValores>";
	private static String tagFinDineroValores = "</dineroValores>";
	private static String tagInicioLimiteEstimadoAnual = "<limiteEstimadoAnual>";
	private static String tagFinLimiteEstimadoAnual = "</limiteEstimadoAnual>";
	private static String tagInicioLimiteEmbarque = "<limiteEmbarque>";
	private static String tagFinLimiteEmbarque = "</limiteEmbarque>";
	private static String tagInicioTrayectoriaDesde = "<trayectoriaDesde>";
	private static String tagFinTrayectoriaDesde = "</trayectoriaDesde>";
	private static String tagInicioTrayectoriaHasta = "<trayectoriaHasta>";
	private static String tagFinTrayectoriaHasta = "</trayectoriaHasta>";
	private static String tagInicioMedioTransporte = "<medioTransporte>";
	private static String tagFinMedioTransporte = "</medioTransporte>";
	private static String tagInicioCoberturas = "<cobertras>";
	private static String tagFinCoberturas = "</coberturas>";
	private static String tagInicioClausulasAdicionales = "<clausulasAdicionales>";
	private static String tagFinClausulasAdicionales = "</clausulasAdicionales>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocDineroValores#generarXmlAgropecuario(ec.com.avila.hiperion.emision.entities.RamoDineroValore)
	 */
	@Override
	public String generarXmlAgropecuario(RamoDineroValore dineroValore) throws HiperionException {
		// TODO Auto-generated method stub
		return null;
	}

}
