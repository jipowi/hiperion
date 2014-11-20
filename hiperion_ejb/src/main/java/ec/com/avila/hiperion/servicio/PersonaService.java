/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Persona;

/**
 * 
 * <b> Interface local del servicio que permite realizar las operaciones sobre la tabla Persona </b>
 * 
 * @author Dario Vinueza
 * @version 1.0, Nov 10, 2013
 * @since JDK1.6
 */
@Local
public interface PersonaService {

	/**
	 * 
	 * <b> Permite guardar un registro a la tabla Persona </b>
	 * <p>
	 * [Author: Darvin, Date: Nov 10, 2013]
	 * </p>
	 * 
	 * @param persona
	 *            objeto de tipo persona
	 * @throws HiperionException
	 */
	public void guardarPersona(Persona persona) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener lista personas que se encuentran en la base de datos</b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 27/11/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<Persona> consultarPersonas() throws HiperionException;

	/**
	 * 
	 * <b>Permite modificar los dato de una Persona</b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 27/11/2013]
	 * </p>
	 * 
	 * @param persona
	 * @throws HiperionException
	 */
	public void modificarPersona(Persona persona) throws HiperionException;

}
