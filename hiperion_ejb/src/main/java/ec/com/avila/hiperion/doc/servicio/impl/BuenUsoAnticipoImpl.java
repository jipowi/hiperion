/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocBuenUsoAnticipo;
import ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,17/03/2015
 * @since JDK1.6
 */
@Stateless
public class BuenUsoAnticipoImpl implements GenerarDocBuenUsoAnticipo {

	private static String tagInicioSector = "<sector>";
	private static String tagFinSector = "</sector>";
	private static String tagInicioValorContrato = "<valorContrato>";
	private static String tagFinValorContrato = "</valorContrato>";
	private static String tagInicioValorPoliza = "<valorPoliza>";
	private static String tagFinValorPoliza = "</valorPoliza>";
	private static String tagInicioObjetoAsegurado = "<objetoAsegurado>";
	private static String tagFinObjetoAsegurado = "</objetoAsegurado>";
	private static String tagInicioCoberturas = "<coberturas>";
	private static String tagFinCoberturas = "</coberturas>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocBuenUsoAnticipo#generarXmlBuenUsoAnticipo(ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt)
	 */
	@Override
	public String generarXmlBuenUsoAnticipo(RamoBuenUsoAnt buenUsoAnt) throws HiperionException {
		// TODO Auto-generated method stub
		return null;
	}

}
