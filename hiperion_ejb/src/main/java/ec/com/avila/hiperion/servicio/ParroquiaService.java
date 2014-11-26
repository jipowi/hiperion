/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Parroquia;

/**
 * 
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla Parroquia.</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Local
public interface ParroquiaService {
	/**
	 * 
	 * <b> Permite obtener la lista de Parroquias que se encuentran en la base de Datos</b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @return lista de Parroquias.
	 * @throws HiperionException
	 */

	public List<Parroquia> consultarParroquiasPorCanton(Integer idCanton) throws HiperionException;

	public Parroquia consultarParroquiaPorId(Integer idParroquia) throws HiperionException;
}
