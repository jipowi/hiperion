/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Cliente;

/**
 * 
 * <b> Interfaz local de la tabla CatalogoCliente </b>
 * 
 * @author Dario Vinueza
 * @version 1.0, Nov 9, 2013
 * @since JDK1.6
 */
@Local
public interface ClienteDao {
	/**
	 * 
	 * <b> Permite guardar los registros en la tabla clientes </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Nov 9, 2013]
	 * </p>
	 * 
	 * @param cliente
	 *            objeto de tipo cliente
	 * @throws HiperionException
	 */
	public void guardarCliente(Cliente cliente) throws HiperionException;

	/**
	 * Permite consultar los clientes registrados en la base
	 * 
	 * @return lista de tipo clientes
	 * @throws HiperionException
	 */
	public List<Cliente> consultarClientes() throws HiperionException;

	/**
	 * Permite modificar los datos de un cliente
	 * 
	 * @param cliente
	 * @throws HiperionException
	 */
	public void modificarCliente(Cliente cliente) throws HiperionException;
}
