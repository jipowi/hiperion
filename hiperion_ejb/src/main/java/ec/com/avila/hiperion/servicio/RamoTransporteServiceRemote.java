/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoTransporte;

/**
 * <b> Servicio de interface remota para realizar las operaciones sobre la tabla RamoTranspote </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,30/12/2013
 * @since JDK1.6
 */
@Remote
public interface RamoTransporteServiceRemote {

	/**
	 * 
	 * <b> Permite guardar los registros en la tabla RamoTransporte </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 30/12/2013]
	 * </p>
	 * 
	 * @param transporte
	 * @throws HiperionException
	 */
	public void guardarRamoTransporte(RamoTransporte ramoTransporte) throws HiperionException;

	/**
	 * 
	 * <b> Permite Obtener lista de RamoTransporte que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 30/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoTransporte> consultarRamoTransporte() throws HiperionException;

}
