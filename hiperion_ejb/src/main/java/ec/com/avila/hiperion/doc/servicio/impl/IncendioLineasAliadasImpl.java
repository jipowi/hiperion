/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocIncendiLineasAliadas;
import ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada;

/** 
 * <b>
 * Clase que se encarga de generar el documento PDF 
 * </b>
 *  
 * @author Franklin Pozo B.
 * @version 1.0,11/05/2015
 * @since JDK1.6
 */
@Stateless
public class IncendioLineasAliadasImpl implements GenerarDocIncendiLineasAliadas {

	/* (non-Javadoc)
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocIncendiLineasAliadas#generarXmlIncendioLineasAliadas(ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada)
	 */
	@Override
	public String generarXmlIncendioLineasAliadas(RamoIncendioLineasAliada incendioLineasAliada) throws HiperionException {
		// TODO Auto-generated method stub
		return null;
	}

}
