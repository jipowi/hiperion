/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Parroquia;

/**
 * 
 * <b> Servicio de interface remota para realizar las operaciones sobre la tabla Parroquia.</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Remote
public interface ParroquiasServiceRemote {

	/**
	 * 
	 * <b> Permite obtener la lista de Parroquias que se encuentran en la base de Datos. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 15/06/2014]
	 * </p>
	 * 
	 * @return lista de parroquias
	 * @throws HiperionException
	 */
	public List<Parroquia> consultarParroquiasPorCanton(Integer idCanton) throws HiperionException;

	public Parroquia consultarParroquiaPorId(Integer idParroquia) throws HiperionException;
}
