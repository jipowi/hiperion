/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ObjAsegIncendioLineasAliadasDao;
import ec.com.avila.hiperion.dao.RamoIncendioLineasAliadaDao;
import ec.com.avila.hiperion.emision.entities.ObjAsegIncendio;
import ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada;
import ec.com.avila.hiperion.servicio.RamoIncendioLineasAliadaService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,10/08/2014
 * @since JDK1.6
 */
@Stateless
public class RamoIncendioLineasAliadaServiceImpl implements RamoIncendioLineasAliadaService {

	@EJB
	private RamoIncendioLineasAliadaDao ramoIncendioLineasAliadaDao;

	@EJB
	private ObjAsegIncendioLineasAliadasDao incendioLineasAliadasDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoIncendioLineasAliadaServiceRemote#guardarRamoIncendioLineasAliada(ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada)
	 */
	@Override
	public void guardarRamoIncendioLineasAliada(RamoIncendioLineasAliada ramoIncendioLineasAliada) throws HiperionException {
		ramoIncendioLineasAliadaDao.persist(ramoIncendioLineasAliada);
		for (ObjAsegIncendio objeto : ramoIncendioLineasAliada.getObjAsegIncendios()) {
			incendioLineasAliadasDao.persist(objeto);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoIncendioLineasAliadaService#consultarRamoIncendioLineasAliada()
	 */
	@Override
	public List<RamoIncendioLineasAliada> consultarRamoIncendioLineasAliada() throws HiperionException {
		return ramoIncendioLineasAliadaDao.findAll();
	}

}
