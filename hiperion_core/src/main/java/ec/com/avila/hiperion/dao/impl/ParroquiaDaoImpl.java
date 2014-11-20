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
import ec.com.avila.hiperion.dao.ParroquiaDao;
import ec.com.avila.hiperion.entities.Parroquia;

/**
 * 
 * <b> Permite implementar las operaciones de la tabla Parroquia. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Stateless
public class ParroquiaDaoImpl implements ParroquiaDao {

	Logger log = Logger.getLogger(ClienteDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	private EntityManager em;

	public ParroquiaDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<Parroquia> consultarParroquiasPorCanton(Integer idCanton) throws HiperionException {
		try {
			Query query = em.createNamedQuery("Parroquia.findByIdCanton");
			query.setParameter("idCanton", idCanton);
			List<Parroquia> parroquias = query.getResultList();
			return parroquias;
		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> ParroquiaDaoImpl.consultarParroquiasPorCanton: Line 40", ex);
			throw new HiperionException(ex);
		}
	}

	@SuppressWarnings("unchecked")
	public Parroquia consultarParroquiaPorId(Integer idParroquia) throws HiperionException {
		try {
			Query query = em.createNamedQuery("Parroquia.findByIdParroquia");
			query.setParameter("idParroquia", idParroquia);
			List<Parroquia> parroquias = query.getResultList();
			return parroquias.get(0);
		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> ParroquiaDaoImpl.consultarParroquiaPorId: Line 49", ex);
			throw new HiperionException(ex);
		}
	}
}
