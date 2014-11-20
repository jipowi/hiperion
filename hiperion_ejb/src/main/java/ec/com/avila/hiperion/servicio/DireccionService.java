/**
 * 
 */
package ec.com.avila.hiperion.servicio;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Direccion;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza.
 * @version 1.0,10/09/2014
 * @since JDK1.6
 */
@Local
public interface DireccionService {

	public void guardarDireccion(Direccion direccion) throws HiperionException;
}
