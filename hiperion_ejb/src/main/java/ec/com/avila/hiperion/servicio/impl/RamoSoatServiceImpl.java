/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoSoatDao;
import ec.com.avila.hiperion.emision.entities.RamoSoat;
import ec.com.avila.hiperion.servicio.RamoSoatService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoSoatServiceImpl implements RamoSoatService{

	@EJB
	private RamoSoatDao ramoSoatDao;

	public void guardarRamoSoat(RamoSoat ramoSoat) throws HiperionException {
		ramoSoatDao.persist(ramoSoat);
	}

	public List<RamoSoat> consultarRamoSoat() throws HiperionException {
		return ramoSoatDao.findAll();
	}

}
