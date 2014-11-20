/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoRoboAsalto;

/**
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla RamoRoboAsalto</b>
 * 
 * @author Susana Diaz
 * @version 1.0,16/01/2014
 * @since JDK1.6
 */
@Local
public interface RamoRoboAsaltoService {
	/**
	 * 
	 * <b> Permite guardar los registros en la tabla RamoRoboAsalto. </b>
	 * <p>
	 * [Author: Susana Diaz, Date: 16/01/2014]
	 * </p>
	 * 
	 * @param ramoRoboAsalto
	 * @throws HiperionException
	 */

	public void guardarRamoRoboAsalto(RamoRoboAsalto ramoRoboAsalto) throws HiperionException;

	/**
	 * 
	 * <b> Permite Obtener la lista de RamoRoboAsalto que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Susana Diaz, Date: 16/01/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoRoboAsalto> consultarRamoRoboAsalto() throws HiperionException;

}
