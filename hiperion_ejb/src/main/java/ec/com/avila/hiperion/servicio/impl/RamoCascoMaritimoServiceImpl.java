/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoCascoMaritimoDao;
import ec.com.avila.hiperion.emision.entities.RamoCascoMaritimo;
import ec.com.avila.hiperion.servicio.RamoCascoMaritimoService;
import ec.com.avila.hiperion.servicio.RamoCascoMaritimoServiceRemote;

/**
 * <b>Permite implementar los operaciones que se realizan sobre la tabla RamoCascoMaritimo</b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoCascoMaritimoServiceImpl implements RamoCascoMaritimoService, RamoCascoMaritimoServiceRemote {

	@EJB
	private RamoCascoMaritimoDao ramoCascoMaritimoDao;

	public void guardarRamoCascoMaritimo(RamoCascoMaritimo ramoCascoMaritimo) throws HiperionException {
		ramoCascoMaritimoDao.persist(ramoCascoMaritimo);
	}

	public List<RamoCascoMaritimo> consultarRamoCascoMaritimo() throws HiperionException {
		return ramoCascoMaritimoDao.findAll();
	}

}
