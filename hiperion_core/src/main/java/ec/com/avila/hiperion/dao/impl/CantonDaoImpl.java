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
import ec.com.avila.hiperion.dao.CantonDao;
import ec.com.avila.hiperion.entities.Canton;

/**
 * 
 * <b> Permite implementar las operaciones de la tabla Canton. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Stateless
public class CantonDaoImpl implements CantonDao {

	Logger log = Logger.getLogger(ClienteDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	private EntityManager em;

	public CantonDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<Canton> consultarCantonesPorProvincia(String codProvincia) throws HiperionException {
		try {
			Query query = em.createNamedQuery("Canton.findByCodProvincia");
			query.setParameter("codProvincia", codProvincia);
			List<Canton> cantones = query.getResultList();
			return cantones;
		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> CantonDaoImpl.consultarCantonesPorProvincia: Line 40", ex);
			throw new HiperionException(ex);
		}
	}

	@SuppressWarnings("unchecked")
	public Canton consultarCantonPorId(Integer idCanton) throws HiperionException {
		try {
			Query query = em.createNamedQuery("Canton.findByIdCanton");
			query.setParameter("idCanton", idCanton);
			List<Canton> cantones = query.getResultList();
			return cantones.get(0);
		} catch (Exception ex) {
			log.error("Error: No se pudo realizar la Consulta --> CantonDaoImpl.consultarCantonesPorIdCanton: Line 53", ex);
			throw new HiperionException(ex);
		}
	}
}
