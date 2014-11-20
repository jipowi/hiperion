/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Provincia;

/**
 * 
 * <b> Interfaz local de la tabla Provincia para realizar las operaciones necesarias</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,28/11/2013
 * @since JDK1.6
 */
@Local
public interface ProvinciaDao {

	/**
	 * 
	 * <b> Permite obtener lista de Provincias que se encuentran registradas en la base de datos </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 29/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<Provincia> consultarProvincias() throws HiperionException;

	public Provincia consultarProvinciaPorCodigo(String codProvicia) throws HiperionException;
}