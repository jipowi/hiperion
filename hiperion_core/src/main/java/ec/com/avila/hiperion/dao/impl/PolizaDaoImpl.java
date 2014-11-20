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
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.emision.entities.Poliza;

/**
 * <b>Permite implementar las operaciones de la tabla Poliza </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@Stateless
public class PolizaDaoImpl implements PolizaDao {

	Logger log = Logger.getLogger(PolizaDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

	public void guardarPoliza(Poliza poliza) throws HiperionException {
		try {

			em.persist(poliza);

		} catch (Exception e) {
			log.error("Error no se pudo guardar la poliza ", e);
			throw new HiperionException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Poliza> consultarPoliza() throws HiperionException {

		try {

			return em.createNamedQuery("Poliza.findAll").getResultList();

		} catch (Exception e) {
			log.error("Error no se pudo consultar las polizas ", e);
			throw new HiperionException(e);
		}
	}

	public void modificarPoliza(Poliza poliza) throws HiperionException {
		
		try{
			
			em.merge(poliza);
			
		} catch (Exception e) {
			log.error("Error no se pudo modicar la poliza ", e);
			throw new HiperionException(e);
		}

	}

}
