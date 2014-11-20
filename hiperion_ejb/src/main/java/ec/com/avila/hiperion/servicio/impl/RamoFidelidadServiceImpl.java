/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoFidelidadDao;
import ec.com.avila.hiperion.emision.entities.RamoFidelidad;
import ec.com.avila.hiperion.servicio.RamoFidelidadService;
import ec.com.avila.hiperion.servicio.RamoFidelidadServiceRemote;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoFidelidadServiceImpl implements RamoFidelidadService, RamoFidelidadServiceRemote {

	@EJB
	private RamoFidelidadDao ramoFidelidadDao;

	public void guardarRamoFidelidad(RamoFidelidad ramoFidelidad) throws HiperionException {
		ramoFidelidadDao.persist(ramoFidelidad);
	}

	public List<RamoFidelidad> consultarRamoFidelidad() throws HiperionException {
		return ramoFidelidadDao.findAll();
	}

	public void modificarRamoFidelidad(RamoFidelidad ramoFidelidad) throws HiperionException {

		ramoFidelidadDao.update(ramoFidelidad);

	}

}
