/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClienteDao;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.servicio.ClienteService;

@Stateless
public class ClienteServiceImpl implements ClienteService {

	@EJB
	private ClienteDao clienteDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#consultarClienteByIdentificacion(java.lang.String)
	 */
	@Override
	public Cliente consultarClienteByIdentificacion(String identificacion) throws HiperionException {
		return clienteDao.consultarClienteByIdentificacion(identificacion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#consultarClienteByApellido(java.lang.String)
	 */
	@Override
	public List<Cliente> consultarClienteByApellido(String apellido) throws HiperionException {
		return clienteDao.consultarClienteByApellido(apellido);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#guardarCliente(ec.com.avila.hiperion.emision.entities.Cliente)
	 */
	@Override
	public void guardarCliente(Cliente cliente) throws HiperionException {
		clienteDao.persist(cliente);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#consultarClientes()
	 */
	@Override
	public List<Cliente> consultarClientes() throws HiperionException {
		return clienteDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.ClienteService#consultarClienteByNombres(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Cliente> consultarClienteByNombres(String nombre, String apellido) throws HiperionException {
		return clienteDao.consultarClienteByNombres(nombre, apellido);
	}

}
