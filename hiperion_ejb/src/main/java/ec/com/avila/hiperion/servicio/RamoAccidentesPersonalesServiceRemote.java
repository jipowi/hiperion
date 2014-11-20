/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale;

/**
 * <b> Interfaz local del servicio que permite realizar las operaciones sobre la tabla RamoAccidentesPersonales </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,31/12/2013
 * @since JDK1.6
 */
@Remote
public interface RamoAccidentesPersonalesServiceRemote {

	/**
	 * 
	 * <b> Permite guardar registros en la tabla RamoAccidentesPersonales </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 31/12/2013]
	 * </p>
	 * 
	 * @param ramoAccidentesPersonales
	 * @throws HiperionException
	 */
	public void guardarRamoAccidentesPersonales(RamoAccidentesPersonale ramoAccidentesPersonales) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de RamoAccidentesPersonales que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 31/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoAccidentesPersonale> consultarRamoAccidentesPersonales() throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar los registros en la tabla RamoAccidentesPersonales </b>
	 * <p>
	 * [Author: Franklin, Date: 31/12/2013]
	 * </p>
	 * 
	 * @param ramoAccidentesPersonale
	 * @throws HiperionException
	 */
	public void modificarRamoAccidentesPersonales(RamoAccidentesPersonale ramoAccidentesPersonale) throws HiperionException;

}
