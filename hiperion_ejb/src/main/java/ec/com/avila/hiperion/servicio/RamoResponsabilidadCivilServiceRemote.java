/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoResponsabilidadCivil;

/**
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla RamoResponsabilidadCivil </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,03/08/2014
 * @since JDK1.6
 */
@Remote
public interface RamoResponsabilidadCivilServiceRemote {

	/**
	 * 
	 * <b> Permite guardar los registro en la tabla Ramo Responsabilidad </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 03/08/2014]
	 * </p>
	 *
	 * @param ramoResponsabilidadCivil
	 * @throws HiperionException
	 */
	public void guardarRamoResponsabilidadCivil(RamoResponsabilidadCivil ramoResponsabilidadCivil) throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar los registros de la tabla Responsabilidad Civil </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 03/08/2014]
	 * </p>
	 *
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoResponsabilidadCivil> consultarRamoResponsabilidadCivil() throws HiperionException;

}
