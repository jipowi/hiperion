/**
 * 
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoRiesgosEspecialesDao;
import ec.com.avila.hiperion.emision.entities.RamoRiesgosEsp;
import ec.com.avila.hiperion.servicio.RamoRiesgosEspecialesService;
import ec.com.avila.hiperion.servicio.RamoRiesgosEspecialesServiceRemote;

/**
 * <b> Permite implementar las operaciones necesarias para el ramo de riesgos especiales </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/11/2014
 * @since JDK1.6
 */
@Stateless
public class RamoRiesgosEspecialesServiceImpl implements RamoRiesgosEspecialesService, RamoRiesgosEspecialesServiceRemote{

	@EJB
	private RamoRiesgosEspecialesDao ramoRiesgosEspecialesDao;
	
	/* (non-Javadoc)
	 * @see ec.com.avila.hiperion.servicio.RamoRiesgosEspecialesService#guardarRamoRiesgosEspeciales(ec.com.avila.hiperion.emision.entities.RamoRiesgosEsp)
	 */
	@Override
	public void guardarRamoRiesgosEspeciales(RamoRiesgosEsp ramoRiesgosEsp) throws HiperionException {
		ramoRiesgosEspecialesDao.persist(ramoRiesgosEsp);
		
	}

	/* (non-Javadoc)
	 * @see ec.com.avila.hiperion.servicio.RamoRiesgosEspecialesService#consultarRamoRiesgoEspeciales()
	 */
	@Override
	public List<RamoRiesgosEsp> consultarRamoRiesgoEspeciales() throws HiperionException {
		
		return ramoRiesgosEspecialesDao.findAll();
	}

}
