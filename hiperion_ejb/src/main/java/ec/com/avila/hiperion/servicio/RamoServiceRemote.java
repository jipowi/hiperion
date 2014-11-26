/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Ramo;

/**
 * <b> Servicio de interface remota para realizar las oepraciones sobre la tabla poliza </b>
 * 
 * @author Susana Diaz
 * @version 1.0, 16/01/2014
 * @since JDK1.6
 */
@Remote
public interface RamoServiceRemote {

	/**
	 * 
	 * <b> permite guardar los registros en la tabla Ramo </b>
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
	 * <b> Permite obtener la lista de Ramos que se encuentran en la base de datos </b>
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
