/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Parroquia;

/**
 * 
 * <b> Interfaz local de la tabla Parroquia para realizar las operaciones necesarias</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,28/11/2013
 * @since JDK1.6
 */
@Local
public interface ParroquiaDao {

	/**
	 * 
	 * <b> Permite obtener lista de Parroquias por id de Canton que se encuentran registradas en la base de datos </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 29/12/2013]
	 * </p>
	 * 
	 * @return lsta de Parroquias por Canton.
	 * @throws HiperionException
	 */
	public List<Parroquia> consultarParroquiasPorCanton(Integer idCanton) throws HiperionException;

	public Parroquia consultarParroquiaPorId(Integer idParroquia) throws HiperionException;
}
