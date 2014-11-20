/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Aseguradora;
import ec.com.avila.hiperion.entities.Persona;

/**
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla Aseguradora</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 21, 2013
 * @since JDK1.6
 */
@Local
public interface AseguradoraService {

	/**
	 * 
	 * <b> permite guardar los registros en la tabla Aseguradora </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 10, 2014]
	 * </p>
	 * 
	 * @param aseguradora
	 * @param contactos
	 * @throws HiperionException
	 */
	public void guardarAseguradora(Aseguradora aseguradora, List<Persona> contactos) throws HiperionException;

	/**
	 * 
	 * <b> Permite buscar las asegurdoras por medio del nombre o ruc </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 23, 2014]
	 * </p>
	 * 
	 * @param ruc
	 * @param aseguradora
	 * @return
	 * @throws HiperionException
	 */
	public List<Aseguradora> consultarAseguradoraByRucAseg(String ruc, Integer aseguradora) throws HiperionException;

}
