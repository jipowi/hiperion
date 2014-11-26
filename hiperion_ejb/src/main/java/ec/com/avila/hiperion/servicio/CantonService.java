/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Canton;

/**
 * 
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla Canton</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Local
public interface CantonService {

	/**
	 * 
	 * <b> Permite obtener la lista de Cantones que se encuentran en la base de Datos. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 15/06/2014]
	 * </p>
	 * 
	 * @return lista de cantones
	 * @throws HiperionException
	 */
	public List<Canton> consultarCantonesPorProvincia(String codProvincia) throws HiperionException;

	public Canton consultarCantonPorId(Integer idCanton) throws HiperionException;
}
