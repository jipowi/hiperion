/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Aseguradora;

/**
 * <b> Interfaz local de la tabla Aseguradora para realizar las operaciones necesarias</b>
 * 
 * @author Dario Vinueza
 * @version 1.0, 20/10/2013
 * @since JDK1.6
 */
@Local
public interface AseguradoraDao extends GenericDAO<Aseguradora, Long> {

	/**
	 * 
	 * <b> Permite buscar las asegurdoras por medio del nombre o ruc </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 23, 2014]
	 * </p>
	 * 
	 * @param ruc
	 * @param aseguradora
	 * @return
	 * @throws HiperionException
	 */
	public Aseguradora consultarAseguradora(String ruc, Integer aseguradora) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar una aseguradora por el codigo. </b>
	 * <p>
	 * [Author: HIPERION, Date: 29/02/2016]
	 * </p>
	 * 
	 * @param codigo
	 * @return
	 * @throws HiperionException
	 */
	public Aseguradora consultarAseguradoraByCodigo(String codigo) throws HiperionException;

}
