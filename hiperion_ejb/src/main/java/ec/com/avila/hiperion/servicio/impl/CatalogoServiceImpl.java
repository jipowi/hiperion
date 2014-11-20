/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.CatalogoDao;
import ec.com.avila.hiperion.entities.Catalogo;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.CatalogoServiceRemote;

@Stateless
public class CatalogoServiceImpl implements CatalogoService, CatalogoServiceRemote {

	// @EJB(lookup =
	// "java:global/hiperion_core-1.0/CatalogoDaoImpl!ec.com.avila.hiperion.dao.CatalogoDao")
	@EJB
	private CatalogoDao catalogoDao;

	public CatalogoServiceImpl() {
	}

	public List<Catalogo> consultarCatalogos() throws HiperionException {
		return catalogoDao.consultarCatalogos();
	}

	public Catalogo consultarCatalogoById(Integer idCatalogo) throws HiperionException {
		return catalogoDao.consultarCatalogoById(idCatalogo);
	}

	public void guardarCatalogo(Catalogo catalogo) throws HiperionException {
		catalogoDao.guardarCatalogo(catalogo);
	}

	public void modificarCatalogo(Catalogo catalogo) throws HiperionException {
		catalogoDao.modificarCatalogo(catalogo);

	}
}
