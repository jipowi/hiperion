/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ClienteDao;
import ec.com.avila.hiperion.emision.entities.Cliente;

/**
 * 
 * <b> Clase que implementa operaciones de la tabla Cliente </b>
 * 
 * @author Dario Vinueza
 * @version 1.0, Nov 9, 2013
 * @since JDK1.6
 */
@Stateless
public class ClienteDaoImpl extends GenericDAOImpl<Cliente, Long> implements ClienteDao {

	Logger log = Logger.getLogger(ClienteDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.ClienteDao#consultarClienteByIdentificacion()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Cliente consultarClienteByIdentificacion(String identificacion) throws HiperionException {
		Query query = em.createNamedQuery("Cliente.findByIdentificacion");
		query.setParameter("identificacion", identificacion);
		List<Cliente> clientes = query.getResultList();
		return clientes.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.dao.ClienteDao#consultarClienteByApellido(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> consultarClienteByApellido(String apellido) throws HiperionException {
		Query query = em.createNamedQuery("Cliente.findByNombre");
		query.setParameter("nombre", apellido);
		List<Cliente> clientes = query.getResultList();
		return clientes;
	}

	
	
}
