/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Canton;

/**
 * 
 * <b> Servicio de interface remota para realizar las operaciones sobre la tabla Canton</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Remote
public interface CantonServiceRemote {

	/**
	 * 
	 * <b> Permite obtener la lista de Cantones que se encuentran en la base de Datos. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 15/06/2014]
	 * </p>
	 * 
	 * @return lista de provincias
	 * @throws HiperionException
	 */
	public List<Canton> consultarCantonesPorProvincia(String codProvincia) throws HiperionException;

	public Canton consultarCantonPorId(Integer idCanton) throws HiperionException;
}
