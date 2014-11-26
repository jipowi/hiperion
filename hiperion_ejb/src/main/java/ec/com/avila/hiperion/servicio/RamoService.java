/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Ramo;

/**
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla Ramo</b>
 * 
 * @author Susana Diaz
 * @version 1.0,16/01/2014
 * @since JDK1.6
 */
@Local
public interface RamoService {
	/**
	 * 
	 * <b> Permite guardar los registros en la tabla Ramo. </b>
	 * <p>
	 * [Author: Susana Diaz, Date: 16/01/2014]
	 * </p>
	 * 
	 * @param ramo
	 * @throws HiperionException
	 */

	public void guardarRamo(Ramo ramo) throws HiperionException;

	/**
	 * 
	 * <b> Permite Obtener la lista de Ramo que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Susana Diaz, Date: 16/01/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<Ramo> consultarRamo() throws HiperionException;

	/**
	 * 
	 * <b> Permite Obtener el Ramo en base al codigo del Ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 09/03/2014]
	 * </p>
	 * 
	 * @param codigoRamo
	 *            - C&oacute;digo del Ramo
	 * @return - Ramo
	 * @throws HiperionException
	 *             - Excepci&oacute;n del servicio
	 */
	public Ramo consultarRamoPorCodigo(String codigoRamo) throws HiperionException;

}
