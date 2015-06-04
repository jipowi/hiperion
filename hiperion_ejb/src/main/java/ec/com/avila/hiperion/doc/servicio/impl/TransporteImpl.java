/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocTransporte;
import ec.com.avila.hiperion.emision.entities.RamoTransporte;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo B
 * @version 1.0,02/06/2015
 * @since JDK1.6
 */
@Stateless
public class TransporteImpl implements GenerarDocTransporte {
	
	private static String tagInicioTasa = "<tasa>";
	private static String tagFinTasa = "</tasa>";
	private static String tagInicioCondicionesImportantes = "<condicionesImportantes>";
	private static String tagFinCondicionesImportantes = "</condiconesImportantes>";

	/* (non-Javadoc)
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocTransporte#generarXmlTransporte(ec.com.avila.hiperion.emision.entities.RamoTransporte)
	 */
	@Override
	public String generarXmlTransporte(RamoTransporte ramoTransporte) throws HiperionException {
		
		StringBuffer buffer = new StringBuffer();
		
		return buffer.toString();
	}

}
