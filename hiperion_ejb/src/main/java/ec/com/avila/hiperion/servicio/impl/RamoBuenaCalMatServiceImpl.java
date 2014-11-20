/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoBuenaCalMatDao;
import ec.com.avila.hiperion.emision.entities.RamoBuenaCalMat;
import ec.com.avila.hiperion.servicio.RamoBuenaCalMatService;
import ec.com.avila.hiperion.servicio.RamoBuenaCalMatServiceRemote;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoBuenaCalMatServiceImpl implements RamoBuenaCalMatService, RamoBuenaCalMatServiceRemote {

	@EJB
	private RamoBuenaCalMatDao ramoBuenaCalMatDao;

	public void guardarRamoBuenaCalMat(RamoBuenaCalMat ramoBuenaCalMat) throws HiperionException {
		ramoBuenaCalMatDao.persist(ramoBuenaCalMat);
	}

	public List<RamoBuenaCalMat> consultarRamoBuenaCalMat() throws HiperionException {
		return ramoBuenaCalMatDao.findAll();
	}

}
