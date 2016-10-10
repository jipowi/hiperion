/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Direccion;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,10/09/2014
 * @since JDK1.6
 */
@Local
public interface DireccionDao extends GenericDAO<Direccion, Long> {

	/**
	 * 
	 * <b> Permite guardar un registro de direccion en la base de datos. </b>
	 * <p>
	 * [Author: kruger, Date: Oct 10, 2016]
	 * </p>
	 * 
	 * @param direccion
	 * @throws HiperionException
	 */
	public void guardarDireccion(Direccion direccion) throws HiperionException;

	/**
	 * 
	 * <b> Permite guardar mas de una direccion en la base de datos. </b>
	 * <p>
	 * [Author: kruger, Date: Oct 10, 2016]
	 * </p>
	 * 
	 * @param direcciones
	 * @throws HiperionException
	 */
	public void guardarDirecciones(List<Direccion> direcciones) throws HiperionException;
}
