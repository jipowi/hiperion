/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Cliente;

/**
 * 
 * <b> Servicio de interface remota para realizar las operaciones sobre la tabla Cliente</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Remote
public interface ClienteServiceRemote {

	/**
	 * 
	 * <b> Permite guardar los registros de la tabla de Cliente </b>
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
	 * <b> Permite obtener la lista de clientes que se encuentran en la de datos</b>
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
