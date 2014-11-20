/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoVehiculo;

/**
 * <b> Servicio de interface remota para realizar operaciones sobre la tabla RamoVehiculo </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,29/12/2013
 * @since JDK1.6
 */
@Remote
public interface RamoVehiculoServiceRemote {

	/**
	 * 
	 * <b> Permite guardar los objetos de la tabla RamoVehiculos. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param vehiculo
	 * @throws HiperionException
	 */
	public void guardarRamoVehiculo(RamoVehiculo vehiculo) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de Ramovehiculo que se encuentran en la base de datos. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoVehiculo> consultarRamoVehiculo() throws HiperionException;

}
