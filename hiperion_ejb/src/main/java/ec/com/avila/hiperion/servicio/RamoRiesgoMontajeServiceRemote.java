/**
 * 
 */
package ec.com.avila.hiperion.servicio;

import javax.ejb.Remote;
import java.util.List;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje;

/**
 * <b> Servicio de interface remota para realizar las oepraciones sobre la tabla poliza </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,12/10/2014
 * @since JDK1.6
 */
@Remote
public interface RamoRiesgoMontajeServiceRemote {

	/**
	 * 
	 * <b> permite guardar los registros en la tabla RamoRiesgoMantenimiento </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 12/10/2014]
	 * </p>
	 *
	 * @param ramoRiesgoMontaje
	 * @throws HiperionException
	 */
	public void guardarRamoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de RamoRiesgoMontaje que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 12/10/2014]
	 * </p>
	 *
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoRiesgoMontaje> consultarRamoRiesgoMontaje() throws HiperionException;

}