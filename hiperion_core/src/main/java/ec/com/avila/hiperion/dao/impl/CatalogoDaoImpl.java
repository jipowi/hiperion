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

import ec.com.avila.hiperion.dao.CatalogoDao;
import ec.com.avila.hiperion.emision.entities.Catalogo;

/**
 * 
 * <b> Permite implementar las operaciones de la tabla Catalogo </b>
 * 
 * @author Franklin
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Stateless
public class CatalogoDaoImpl implements CatalogoDao {

	@PersistenceContext(unitName = "sgs_pu")
	private EntityManager em;

	public CatalogoDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	public List<Catalogo> consultarCatalogos() {
		return em.createNamedQuery("Catalogo.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	public Catalogo consultarCatalogoById(Integer idCatalogo) {
		Query query = em.createNamedQuery("Catalogo.findById");
		query.setParameter("idCatalogo", idCatalogo);
		List<Catalogo> catalogo = query.getResultList();
		return catalogo.get(0);
	}

	public void guardarCatalogo(Catalogo catalogo) {
		em.persist(catalogo);
	}

	public void modificarCatalogo(Catalogo catalogo) {
		em.merge(catalogo);
	}
}
