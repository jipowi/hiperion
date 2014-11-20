/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ObjAsegRoturaMaquinariaDao;
import ec.com.avila.hiperion.dao.RamoRoturaMaquinariaDao;
import ec.com.avila.hiperion.emision.entities.ObjAsegRotura;
import ec.com.avila.hiperion.emision.entities.RamoRoturaMaquinaria;
import ec.com.avila.hiperion.servicio.RamoRoturaMaquinariaService;
import ec.com.avila.hiperion.servicio.RamoRoturaMaquinariaServiceRemote;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoRoturaMaquinariaServiceImpl implements RamoRoturaMaquinariaService, RamoRoturaMaquinariaServiceRemote {

	@EJB
	private RamoRoturaMaquinariaDao ramoRoturaMaquinariaDao;
	@EJB
	private ObjAsegRoturaMaquinariaDao objAsegRoturaMaquinariaDao;

	public void guardarRamoRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) throws HiperionException {
		ramoRoturaMaquinariaDao.persist(ramoRoturaMaquinaria);
		for (ObjAsegRotura objeto : ramoRoturaMaquinaria.getObjAsegRoturas()) {
			objAsegRoturaMaquinariaDao.persist(objeto);
		}
	}

	public List<RamoRoturaMaquinaria> consultarRamoRoturaMaquinaria() throws HiperionException {
		return ramoRoturaMaquinariaDao.findAll();
	}

}
