/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada;

/**
 * <b> Servicio de interface remota para realizar las oepraciones sobre la tabla poliza </b>
 * 
 * @author Franklin Poz
 * @version 1.0,03/08/2014
 * @since JDK1.6
 */
@Remote
public interface RamoIncendioLineasAliadaServiceRemote {

	/**
	 * 
	 * <b> permite guardar los registros en la tabla Ramo IncendioLineasAliada </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 03/08/2014]
	 * </p>
	 * 
	 * @param ramoIncendioLineasAliada
	 * @throws HiperionException
	 */
	public void guardarRamoIncendioLineasAliada(RamoIncendioLineasAliada ramoIncendioLineasAliada) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de RamoFidelidads que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 03/08/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoIncendioLineasAliada> consultarRamoIncendioLineasAliada() throws HiperionException;

}
