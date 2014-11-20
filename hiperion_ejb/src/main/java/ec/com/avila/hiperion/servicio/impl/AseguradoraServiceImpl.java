/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.AseguradoraDao;
import ec.com.avila.hiperion.entities.Aseguradora;
import ec.com.avila.hiperion.entities.Persona;
import ec.com.avila.hiperion.servicio.AseguradoraService;
import ec.com.avila.hiperion.servicio.AseguradoraServiceRemote;

/**
 * <b>Implementacion del servicio de aseguradora</b>
 * 
 * @author kruger
 * @version 1.0,Dec 21, 2013
 * @since JDK1.6
 */
@Stateless
public class AseguradoraServiceImpl implements AseguradoraService, AseguradoraServiceRemote {

	@EJB
	private AseguradoraDao aseguradoraDao;

	public void guardarAseguradora(Aseguradora aseguradora, List<Persona> contactos) throws HiperionException {
		aseguradoraDao.guardarAseguradora(aseguradora, contactos);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.AseguradoraService#consultarAseguradoraByRucAseg(java.lang.String, java.lang.Integer)
	 */
	@Override
	public List<Aseguradora> consultarAseguradoraByRucAseg(String ruc, Integer aseguradora) throws HiperionException {
		return aseguradoraDao.consultarAseguradora(ruc, aseguradora);
	}

}
