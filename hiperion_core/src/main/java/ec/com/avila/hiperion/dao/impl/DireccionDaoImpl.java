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
import ec.com.avila.hiperion.dao.DireccionDao;
import ec.com.avila.hiperion.emision.entities.Aseguradora;
import ec.com.avila.hiperion.emision.entities.Direccion;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,10/09/2014
 * @since JDK1.6
 */
@Stateless
public class DireccionDaoImpl extends GenericDAOImpl<Direccion, Long> implements DireccionDao {

	Logger log = Logger.getLogger(ClienteDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

	public void guardarDireccion(Direccion direccion) throws HiperionException {
		try {
			em.persist(direccion);
		} catch (Exception e) {
			log.error("Error no se pudo guardar la cliente", e);
			throw new HiperionException(e);
		}
	}

	/* (non-Javadoc)
	 * @see ec.com.avila.hiperion.dao.DireccionDao#guardarDirecciones(java.util.List)
	 */
	@Override
	public void guardarDirecciones(List<Direccion> direcciones) throws HiperionException {
		try {
			for (Direccion direccion : direcciones) {
				em.persist(direccion);
			}
		} catch (Exception e) {
			log.error("Error no se pudo guardar la cliente", e);
			throw new HiperionException(e);
		}
		
	}

}
