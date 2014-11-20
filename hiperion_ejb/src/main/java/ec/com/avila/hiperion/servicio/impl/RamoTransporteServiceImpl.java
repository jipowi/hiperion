/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ObjAsegTransporteDao;
import ec.com.avila.hiperion.dao.RamoTransporteDao;
import ec.com.avila.hiperion.emision.entities.ObjAsegTransporte;
import ec.com.avila.hiperion.emision.entities.RamoTransporte;
import ec.com.avila.hiperion.servicio.RamoTransporteService;
import ec.com.avila.hiperion.servicio.RamoTransporteServiceRemote;

/**
 * <b> Servicio que implementa las operaciones en la tabla RamoTransporte </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,30/12/2013
 * @since JDK1.6
 */
@Stateless
public class RamoTransporteServiceImpl implements RamoTransporteService, RamoTransporteServiceRemote {

	@EJB
	private RamoTransporteDao ramoTranspoteDao;
	@EJB
	private ObjAsegTransporteDao objAsegTransporteDao;

	public void guardarRamoTransporte(RamoTransporte transporte) throws HiperionException {
		ramoTranspoteDao.persist(transporte);
		for (ObjAsegTransporte objeto : transporte.getObjAsegTransportes()) {
			objAsegTransporteDao.persist(objeto);
		}

	}

	public List<RamoTransporte> consultarRamoTransporte() throws HiperionException {
		return ramoTranspoteDao.findAll();
	}

}
