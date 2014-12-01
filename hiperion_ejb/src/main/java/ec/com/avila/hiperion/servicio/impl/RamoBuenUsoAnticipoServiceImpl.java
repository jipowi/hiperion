/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoBuenUsoAnticipoDao;
import ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt;
import ec.com.avila.hiperion.servicio.RamoBuenUsoAnticipoService;

/**
 * <b> Servicio que implementa las operaciones en la tabla Ramo Buen Uso Anticipo. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,13/08/2014
 * @since JDK1.6
 */
@Stateless
public class RamoBuenUsoAnticipoServiceImpl implements RamoBuenUsoAnticipoService{

	@EJB
	private RamoBuenUsoAnticipoDao ramoBuenUsoAnticipoDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoBuenUsoAnticipoService#guardarRamoBuenUsoAnticipo(ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt)
	 */
	@Override
	public void guardarRamoBuenUsoAnticipo(RamoBuenUsoAnt ramoBuenUsoAnt) throws HiperionException {
		ramoBuenUsoAnticipoDao.persist(ramoBuenUsoAnt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoBuenUsoAnticipoService#consultarRamoBuenUsoAnticipo()
	 */
	@Override
	public List<RamoBuenUsoAnt> consultarRamoBuenUsoAnticipo() throws HiperionException {
		return ramoBuenUsoAnticipoDao.findAll();
	}

}
