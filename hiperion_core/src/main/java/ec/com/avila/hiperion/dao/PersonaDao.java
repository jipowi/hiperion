package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Persona;

/**
 * <b> Interfaz local de la tabla Persona para realizar las operaciones
 * necesarias</b>
 * 
 * @author Dario Vinueza
 * @version 1.0, 20/10/2013
 * @since JDK1.6
 */
@Local
public interface PersonaDao {

	/**
	 * 
	 * <b> Permite guardar un objeto de tipo Persona. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/10/2013]
	 * </p>
	 * 
	 * @param persona
	 *            - objeto de tipo Persona
	 */
	public void guardarPersona(Persona persona) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener una lista de Personas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 27/11/2013]
	 * </p>
	 * 
	 */
	public List<Persona> consultarPersonas() throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar los dato de una Persona </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 27/11/2013]
	 * </p>
	 * 
	 * @param persona
	 */
	public void modificarPersona(Persona persona) throws HiperionException;
}
