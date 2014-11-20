/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.RamoCumplimientoContratoDao;
import ec.com.avila.hiperion.emision.entities.RamoCumplimientoContrato;
import ec.com.avila.hiperion.servicio.RamoCumplimientoContratoService;
import ec.com.avila.hiperion.servicio.RamoCumplimientoContratoServiceRemote;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoCumplimientoContratoServiceImpl implements RamoCumplimientoContratoService, RamoCumplimientoContratoServiceRemote {

	@EJB
	private RamoCumplimientoContratoDao ramoCumplimientoContratoDao;

	public void guardarRamoCumplimientoContrato(RamoCumplimientoContrato ramoCumplimientoContrato) throws HiperionException {
		ramoCumplimientoContratoDao.persist(ramoCumplimientoContrato);
	}

	public List<RamoCumplimientoContrato> consultarRamoCumplimientoContrato() throws HiperionException {
		return ramoCumplimientoContratoDao.findAll();
	}

}
