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
	 * <b> Permite consultar los clientes ingresados </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 08/01/2015]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<Cliente> consultarClientes() throws HiperionException;

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
	
	/**
	 * 
	 * <b> Permite buscar clientes por nombre y apellido. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 11/01/2016]
	 * </p>
	 * 
	 * @param nombre
	 * @param apellido
	 * @return
	 * @throws HiperionException
	 */
	public List<Cliente> consultarClienteByNombres(String nombre, String apellido) throws HiperionException;
}
