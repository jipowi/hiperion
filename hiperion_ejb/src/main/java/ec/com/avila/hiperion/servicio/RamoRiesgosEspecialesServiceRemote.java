/**
 * 
 */
package ec.com.avila.hiperion.servicio;

import javax.ejb.Remote;
import java.util.List;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoRiesgosEsp;

/** 
 * <b>
 * Servicio de interfaz remota para realizar las operaciones sobre la tabla Ramo Riesgos especiales .
 * </b>
 *  
 * @author Franklin Pozo
 * @version 1.0,24/10/2014
 * @since JDK1.6
 */
@Remote
public interface RamoRiesgosEspecialesServiceRemote {
	
	/**
	 * 
	 * <b>
	 * permite guardar los registros en la tabla RamoRiesgosEspeciales.
	 * </b>
	 * <p>[Author: Franklin Pozo, Date: 27/10/2014]</p>
	 *
	 * @param ramoRiesgosEsp
	 * @throws HiperionException
	 */
	public void guardarRamoRiesgosEspeciales(RamoRiesgosEsp ramoRiesgosEsp)throws HiperionException;

	/**
	 * 
	 * <b>
	 * Permite obtener la lista de RamoRiesgosEspeciales que se encuentran en la base de datos 
	 * </b>
	 * <p>[Author: Franklin Pozo, Date: 27/10/2014]</p>
	 *
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoRiesgosEsp>consultarRamoRiesgoEspeciales()throws HiperionException;
	

}
