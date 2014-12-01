/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ParroquiaDao;
import ec.com.avila.hiperion.emision.entities.Parroquia;
import ec.com.avila.hiperion.servicio.ParroquiaService;

@Stateless
public class ParroquiaServiceImpl implements ParroquiaService {

	@EJB
	private ParroquiaDao parroquiaDao;

	public ParroquiaServiceImpl() {
	}

	public List<Parroquia> consultarParroquiasPorCanton(Integer idCanton) throws HiperionException {
		return parroquiaDao.consultarParroquiasPorCanton(idCanton);
	}

	public Parroquia consultarParroquiaPorId(Integer idParroquia) throws HiperionException {
		return parroquiaDao.consultarParroquiaPorId(idParroquia);
	}
}
