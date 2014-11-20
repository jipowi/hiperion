/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ObjAsegDineroValoresDao;
import ec.com.avila.hiperion.dao.RamoDineroValoreDao;
import ec.com.avila.hiperion.emision.entities.ObjAsegDineroVal;
import ec.com.avila.hiperion.emision.entities.RamoDineroValore;
import ec.com.avila.hiperion.servicio.RamoDineroValoreService;
import ec.com.avila.hiperion.servicio.RamoDineroValoreServiceRemote;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoDineroValoreServiceImpl implements RamoDineroValoreService, RamoDineroValoreServiceRemote {

	@EJB
	private RamoDineroValoreDao ramoDineroValoreDao;

	@EJB
	private ObjAsegDineroValoresDao objAsegDineroValoresDao;

	public void guardarRamoDineroValore(RamoDineroValore ramoDineroValore) throws HiperionException {
		ramoDineroValoreDao.persist(ramoDineroValore);
		for (ObjAsegDineroVal objeto : ramoDineroValore.getObjAsegDineroVals()) {
			objAsegDineroValoresDao.persist(objeto);
		}
	}

	public List<RamoDineroValore> consultarRamoDineroValore() throws HiperionException {
		return ramoDineroValoreDao.findAll();
	}

}
