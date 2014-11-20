/**
 * 
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ObjAsegRiesgoMontajeDao;
import ec.com.avila.hiperion.dao.RamoRiesgoMontajeDao;
import ec.com.avila.hiperion.emision.entities.ObjAsegMontaje;
import ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje;
import ec.com.avila.hiperion.servicio.RamoRiesgoMontajeService;
import ec.com.avila.hiperion.servicio.RamoRiesgoMontajeServiceRemote;

/**
 * <b> Servicio que implmenta las operaciones sobre la tabla RamoRiesgoMontaje </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,12/10/2014
 * @since JDK1.6
 */
@Stateless
public class RamoRiesgoMontajeServiceImpl implements RamoRiesgoMontajeService, RamoRiesgoMontajeServiceRemote {

	@EJB
	private RamoRiesgoMontajeDao ramoRiesgoMontajeDao;
	@EJB
	private ObjAsegRiesgoMontajeDao objAsegRiesgoMontajeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoRiesgoMontajeService#guardarRamoRiesgoMontaje(ec.com.avila.hiperion.emision.entities.RamoRiesgoMontaje)
	 */
	@Override
	public void guardarRamoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje) throws HiperionException {
		ramoRiesgoMontajeDao.persist(ramoRiesgoMontaje);
		for (ObjAsegMontaje objeto : ramoRiesgoMontaje.getObjAsegMontajes()) {
			objAsegRiesgoMontajeDao.persist(objeto);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoRiesgoMontajeService#consultarRamoRiesgoMontaje()
	 */
	@Override
	public List<RamoRiesgoMontaje> consultarRamoRiesgoMontaje() throws HiperionException {

		return ramoRiesgoMontajeDao.findAll();
	}

}
