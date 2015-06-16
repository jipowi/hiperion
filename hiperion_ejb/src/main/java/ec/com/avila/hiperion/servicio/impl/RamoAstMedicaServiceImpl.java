/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.DetalleAnexoDao;
import ec.com.avila.hiperion.dao.RamoAsistenciaMedicaDao;
import ec.com.avila.hiperion.emision.entities.RamoAsistenciaMedica;
import ec.com.avila.hiperion.servicio.RamoAstMedicaService;

/**
 * <b> Servicio que implmenta las operaciones sobre la tabla RamoAstMedica </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,31/12/2013
 * @since JDK1.6
 */
@Stateless
public class RamoAstMedicaServiceImpl implements RamoAstMedicaService {

	@EJB
	protected RamoAsistenciaMedicaDao ramoAstMedicaDao;

	@EJB
	protected DetalleAnexoDao detalleAnexoDao;

	public void guardarRamoAsistenciaMedica(RamoAsistenciaMedica ramoAstMedica) throws HiperionException {
		ramoAstMedicaDao.persist(ramoAstMedica);

	}

	public List<RamoAsistenciaMedica> consultarRamoAsistenciaMedica() throws HiperionException {
		return ramoAstMedicaDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoAstMedicaService#consultarIdTitulo(java.lang.Long)
	 */
	@Override
	public Long consultarIdTitulo(Long idDetalleAnexo) throws HiperionException {
		return detalleAnexoDao.consultarIdTitulo(idDetalleAnexo);
	}

}
