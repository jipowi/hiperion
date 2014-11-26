/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Cliente;

/**
 * 
 * <b> Servicio de Intreface local para realizar operaciones sobre la tabla Cliente</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Local
public interface ClienteService {

	/**
	 * 
	 * <b> Permite guardar los registros en la tabla Cliente. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @param cliente
	 * @throws HiperionException
	 */
	public void guardarCliente(Cliente cliente) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de clientes que se encuentran en la base de datos</b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<Cliente> consultarClientes() throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar los datos de un cliente </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @param cliente
	 * @throws HiperionException
	 */
	public void modificarCliente(Cliente cliente) throws HiperionException;
}
