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
import ec.com.avila.hiperion.entities.Cliente;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.ClienteServiceRemote;

@Stateless
public class ClienteServiceImpl implements ClienteService, ClienteServiceRemote {

	@EJB
	private ClienteDao clienteDao;

	public ClienteServiceImpl() {
	}

	public void guardarCliente(Cliente cliente) throws HiperionException {
		clienteDao.guardarCliente(cliente);
	}

	public List<Cliente> consultarClientes() throws HiperionException {
		return clienteDao.consultarClientes();
	}

	public void modificarCliente(Cliente cliente) throws HiperionException {
		clienteDao.modificarCliente(cliente);
	}
}
