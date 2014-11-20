/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ObjAsegLcIncendioDao;
import ec.com.avila.hiperion.dao.RamoLucroCesanteIncendioDao;
import ec.com.avila.hiperion.emision.entities.ObjAsegLcIn;
import ec.com.avila.hiperion.emision.entities.RamoLcIncendio;
import ec.com.avila.hiperion.servicio.RamoLucroCesanteIncendioService;
import ec.com.avila.hiperion.servicio.RamoLucroCesanteIncendioServiceRemote;

/**
 * <b>Servicio que implementa las operacions del DAO para acceso a la tabla RamoLucroCesanteIncendio</b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoLucroCesanteIncendioServiceImpl implements RamoLucroCesanteIncendioService, RamoLucroCesanteIncendioServiceRemote {

	@EJB
	private RamoLucroCesanteIncendioDao ramoLucroCesanteIncendioDao;
	
	@EJB
	private ObjAsegLcIncendioDao objAsegLcIncendioDao;

	public void guardarRamoLucroCesanteIncendio(RamoLcIncendio ramoLucroCesanteIncendio) throws HiperionException {
		ramoLucroCesanteIncendioDao.persist(ramoLucroCesanteIncendio);
		for(ObjAsegLcIn objeto : ramoLucroCesanteIncendio.getObjAsegLcIns()){
			objAsegLcIncendioDao.persist(objeto);
		}
	}

	public List<RamoLcIncendio> consultarRamoLucroCesanteIncendio() throws HiperionException {
		return ramoLucroCesanteIncendioDao.findAll();
	}

}
