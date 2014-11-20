/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoVida;

/**
 * <b> Servicio de interface remota para realizar operaciones sobre la tabla RamoVida </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,30/12/2013
 * @since JDK1.6
 */
@Remote
public interface RamoVidaServiceRemote {

	/**
	 * 
	 * <b> Permite guardar registros en la tabla RamoVida </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 30/12/2013]
	 * </p>
	 * 
	 * @param vida
	 * @throws HiperionException
	 */
	public void guardarRamoVida(RamoVida vida) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de RamoVida que se encuentra en la base de datos </b>
	 * <p>
	 * [Author: Franklin, Date: 30/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoVida> consultarRamoVida() throws HiperionException;

}
