/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Cliente;

/**
 * 
 * <b> Interfaz local de la tabla Cliente </b>
 * 
 * @author Dario Vinueza
 * @version 1.0, Nov 9, 2013
 * @since JDK1.6
 */
@Local
public interface ClienteDao extends GenericDAO<Cliente, Long> {

		
	/**
	 * 
	 * <b> Permite consultar el cliente por medio de la cedula de identidad </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param identificacion
	 * @return
	 * @throws HiperionException
	 */
	public Cliente consultarClienteByIdentificacion(String identificacion) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar un cliente por medio de su apellido paterno </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param apellido
	 * @return
	 * @throws HiperionException
	 */
	public List<Cliente> consultarClienteByApellido(String apellido) throws HiperionException;

	
}
