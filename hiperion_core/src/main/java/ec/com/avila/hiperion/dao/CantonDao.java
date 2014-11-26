/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Canton;

/**
 * 
 * <b> Interfaz local de la tabla Canton para realizar las operaciones necesarias</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,28/11/2013
 * @since JDK1.6
 */
@Local
public interface CantonDao {

	/**
	 * 
	 * <b> Permite obtener lista de Cantones por codigo de la Provincia que se encuentran registradas en la base de datos </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 29/12/2013]
	 * </p>
	 * 
	 * @return lsta de Cantones por Provincia.
	 * @throws HiperionException
	 */
	public List<Canton> consultarCantonesPorProvincia(String codProvincia) throws HiperionException;

	public Canton consultarCantonPorId(Integer idCanton) throws HiperionException;
}
