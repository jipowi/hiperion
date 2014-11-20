/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoGarantiaAduaneraDao;
import ec.com.avila.hiperion.emision.entities.RamoGarantiaAduanera;
import ec.com.avila.hiperion.servicio.RamoGarantiaAduaneraService;
import ec.com.avila.hiperion.servicio.RamoGarantiaAduaneraServiceRemote;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoGarantiaAduaneraServiceImpl implements RamoGarantiaAduaneraService, RamoGarantiaAduaneraServiceRemote {

	@EJB
	private RamoGarantiaAduaneraDao ramoGarantiaAduaneraDao;

	public void guardarRamoGarantiaAduanera(RamoGarantiaAduanera ramoGarantiaAduanera) throws HiperionException {
		ramoGarantiaAduaneraDao.persist(ramoGarantiaAduanera);
	}

	public List<RamoGarantiaAduanera> consultarRamoGarantiaAduanera() throws HiperionException {
		return ramoGarantiaAduaneraDao.findAll();
	}
}
