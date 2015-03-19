/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocCumplimientoContrato;
import ec.com.avila.hiperion.emision.entities.RamoCumplimientoContrato;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/03/2015
 * @since JDK1.6
 */
@Stateless
public class CumplimientoContratoImpl implements GenerarDocCumplimientoContrato {
	
	private static String tagInicioObjetoAsegurado="<objetoAsegurado>";
	private static String tagFinObjetoAsegurado="</objetoAsegurado>";
	private static String tagInicioValorContrato="<valorContrato>";
	private static String tagFinValorContrato="</valorContrato>";
	private static String tagInicioValorAsegurado="<valorAsegurado>";
	private static String tagFinValorAsegurado="</valorAsegurado>";
	private static String tagInicioTipoContraGarantia="<tipoContraGaranta>";
	private static String tagFinTipoContraGarantia="</tipoContraGarantia>";
	private static String tagInicioCoberturas="<coberturas>";
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocCumplimientoContrato#generarXmlAgropecuario(ec.com.avila.hiperion.emision.entities.RamoCumplimientoContrato)
	 */
	@Override
	public String generarXmlAgropecuario(RamoCumplimientoContrato cumplimientoContrato) throws HiperionException {
		// TODO Auto-generated method stub
		return null;
	}

}
