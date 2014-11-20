/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoEquipoElectronico;

/**
 * <b> Servicio de interface remota para realizar las oepraciones sobre la tabla poliza </b>
 * 
 * @author Susana Diaz
 * @version 1.0, 16/01/2014
 * @since JDK1.6
 */
@Remote
public interface RamoEquipoElectronicoServiceRemote {

	/**
	 * 
	 * <b> permite guardar los registros en la tabla RamoEquipoElectronico </b>
	 * <p>
	 * [Author: Susana Diaz, Date: 16/01/2014]
	 * </p>
	 * 
	 * @param ramoEquipoElectronico
	 * @throws HiperionException
	 */
	public void guardarRamoEquipoElectronico(RamoEquipoElectronico ramoEquipoElectronico) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de RamoEquipoElectronicos que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Susana Diaz, Date: 16/01/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoEquipoElectronico> consultarRamoEquipoElectronico() throws HiperionException;

}
