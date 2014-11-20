/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClienteDao;
import ec.com.avila.hiperion.entities.Cliente;

/**
 * 
 * <b> Clase que implementa operaciones de la tabla Cliente </b>
 * 
 * @author Dario Vinueza
 * @version 1.0, Nov 9, 2013
 * @since JDK1.6
 */
@Stateless
public class ClienteDaoImpl implements ClienteDao {

	Logger log = Logger.getLogger(ClienteDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

	public void guardarCliente(Cliente cliente) throws HiperionException {
		try {
			em.persist(cliente);
		} catch (Exception ex) {
			log.error("Error: No se pudo Guardar el Cliente --> ClienteDaoImpl.guardarCliente: Line 35", ex);
			throw new HiperionException(ex);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> consultarClientes() throws HiperionException {
		try {
			return em.createNamedQuery("Cliente.findAll").getResultList();
		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> ClienteDaoImpl.consultarClientes: Line 45", ex);
			throw new HiperionException(ex);
		}
	}

	public void modificarCliente(Cliente cliente) throws HiperionException {
		try {
			em.merge(cliente);
		} catch (Exception ex) {
			log.error("Error: No se pudo modificar al Cliente --> ClienteDaoImpl.modificarCliente: Line 54", ex);
			throw new HiperionException(ex);
		}
	}
}
