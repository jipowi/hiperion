/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoAccidentesPersonalesDao;
import ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale;
import ec.com.avila.hiperion.servicio.RamoAccidentesPersonalesService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,31/12/2013
 * @since JDK1.6
 */
@Stateless
public class RamoAccidentesPersonalesServiceImpl implements RamoAccidentesPersonalesService {

	@EJB
	private RamoAccidentesPersonalesDao ramoAccidentesPersonalesDao;

	public void guardarRamoAccidentesPersonales(RamoAccidentesPersonale ramoAccidentesPersonales) throws HiperionException {
		ramoAccidentesPersonalesDao.persist(ramoAccidentesPersonales);

	}

	public List<RamoAccidentesPersonale> consultarRamoAccidentesPersonales() throws HiperionException {
		return ramoAccidentesPersonalesDao.findAll();
	}

	public void modificarRamoAccidentesPersonales(RamoAccidentesPersonale ramoAccidentesPersonales) throws HiperionException {
		ramoAccidentesPersonalesDao.update(ramoAccidentesPersonales);

	}

}
