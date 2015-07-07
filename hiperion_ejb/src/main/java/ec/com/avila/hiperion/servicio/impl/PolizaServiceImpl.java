/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.dao.AseguradoraDao;
import ec.com.avila.hiperion.dao.PolizaDao;
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

	@EJB
	private AseguradoraDao aseguradoraDao;

	
	

}
