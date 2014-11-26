/**
 * 
 */
package ec.com.avila.hiperion.servicio;

import javax.ejb.Remote;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Direccion;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza.
 * @version 1.0,10/09/2014
 * @since JDK1.6
 */
@Remote
public interface DireccionServiceRemote {

	public void guardarDireccion(Direccion direccion) throws HiperionException;
}
