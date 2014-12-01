/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.PolizaDao;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.servicio.PolizaService;

/**
 * <b> Servicio que implementa las operaciones sobre la tabla Poliza </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@Stateless
public class PolizaServiceImpl implements PolizaService {

	@EJB
	private PolizaDao polizaDao;

	public void guardarPoliza(Poliza poliza) throws HiperionException {
		polizaDao.guardarPoliza(poliza);

	}

	public List<Poliza> consultarPoliza() throws HiperionException {
		return polizaDao.consultarPoliza();
	}

	public void modificarPoliza(Poliza poliza) throws HiperionException {
		polizaDao.modificarPoliza(poliza);

	}
}
