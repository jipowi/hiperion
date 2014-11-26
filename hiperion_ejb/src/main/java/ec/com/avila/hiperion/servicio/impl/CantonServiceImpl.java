/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.CantonDao;
import ec.com.avila.hiperion.emision.entities.Canton;
import ec.com.avila.hiperion.servicio.CantonService;
import ec.com.avila.hiperion.servicio.CantonServiceRemote;

@Stateless
public class CantonServiceImpl implements CantonService, CantonServiceRemote {

	@EJB
	private CantonDao cantonDao;

	public CantonServiceImpl() {
	}

	public List<Canton> consultarCantonesPorProvincia(String codProvincia) throws HiperionException {
		return cantonDao.consultarCantonesPorProvincia(codProvincia);
	}

	public Canton consultarCantonPorId(Integer idCanton) throws HiperionException {
		return cantonDao.consultarCantonPorId(idCanton);
	}
}
