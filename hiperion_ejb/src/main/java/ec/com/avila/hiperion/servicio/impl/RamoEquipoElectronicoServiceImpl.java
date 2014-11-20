/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ObjAsegEquipoElectronicoDao;
import ec.com.avila.hiperion.dao.RamoEquipoElectronicoDao;
import ec.com.avila.hiperion.emision.entities.ObjAsegEquipo;
import ec.com.avila.hiperion.emision.entities.RamoEquipoElectronico;
import ec.com.avila.hiperion.servicio.RamoEquipoElectronicoService;
import ec.com.avila.hiperion.servicio.RamoEquipoElectronicoServiceRemote;

/**
 * <b>Permite implementar las operaciones necesarias de la tabla RamoEquipoElectronico </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoEquipoElectronicoServiceImpl implements RamoEquipoElectronicoService, RamoEquipoElectronicoServiceRemote {

	@EJB
	private RamoEquipoElectronicoDao ramoEquipoElectronicoDao;
	@EJB
	private ObjAsegEquipoElectronicoDao objAsegEquipoElectronicoDao;

	public void guardarRamoEquipoElectronico(RamoEquipoElectronico ramoEquipoElectronico) throws HiperionException {
		ramoEquipoElectronicoDao.persist(ramoEquipoElectronico);
		for (ObjAsegEquipo objeto : ramoEquipoElectronico.getObjAsegEquipos()) {
			objAsegEquipoElectronicoDao.persist(objeto);
		}
	}

	public List<RamoEquipoElectronico> consultarRamoEquipoElectronico() throws HiperionException {
		return ramoEquipoElectronicoDao.findAll();
	}

}
