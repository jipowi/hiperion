/**
 * 
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ObjAsegResponsabilidadDao;
import ec.com.avila.hiperion.dao.RamoResponsabilidadCivilDao;
import ec.com.avila.hiperion.emision.entities.ObjAsegResponsabilidad;
import ec.com.avila.hiperion.emision.entities.RamoResponsabilidadCivil;
import ec.com.avila.hiperion.servicio.RamoResponsabilidadCivilService;

/**
 * <b> Permite implementar las operaciones necesarias para el ramo de responsabilidad civil </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,03/08/2014
 * @since JDK1.6
 */
@Stateless
public class RamoResponsabilidadCivilServiceImpl implements RamoResponsabilidadCivilService {

	@EJB
	private RamoResponsabilidadCivilDao ramoResponsabilidadCivilDao;
	@EJB
	private ObjAsegResponsabilidadDao objAsegResponsabilidadDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoResponsabilidadCivilService#guardarRamoResponsabilidadCivil(ec.com.avila.hiperion.emision.entities.RamoResponsabilidadCivil)
	 */
	@Override
	public void guardarRamoResponsabilidadCivil(RamoResponsabilidadCivil ramoResponsabilidadCivil) throws HiperionException {
		ramoResponsabilidadCivilDao.persist(ramoResponsabilidadCivil);
		for (ObjAsegResponsabilidad objeto : ramoResponsabilidadCivil.getObjAsegResponsabilidads()) {
			objAsegResponsabilidadDao.persist(objeto);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoResponsabilidadCivilService#consultarRamoResponsabilidadCivil()
	 */
	@Override
	public List<RamoResponsabilidadCivil> consultarRamoResponsabilidadCivil() throws HiperionException {
		return ramoResponsabilidadCivilDao.findAll();
	}

}
