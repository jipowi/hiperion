/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoAsistenciaMedica;

/**
 * <b> Interface local de servicio que permite realizar las operaciones sobre la tabla RamoAstVehiculo </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,31/12/2013
 * @since JDK1.6
 */
@Remote
public interface RamoAstMedicaServiceRemote {

	/**
	 * 
	 * <b> Permite guardar registros en la tabla RamoAstMedica </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 31/12/2013]
	 * </p>
	 * 
	 * @param ramoAstMedica
	 * @throws HiperionException
	 */
	public void guardarRamoAsistenciaMedica(RamoAsistenciaMedica ramoAstMedica) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de RamoAstMedica que se encuentra en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 31/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoAsistenciaMedica> consultarRamoAsistenciaMedica() throws HiperionException;

}
