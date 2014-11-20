/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.ObjAsegLcRoturaMaquinariaDao;
import ec.com.avila.hiperion.dao.RamoCesanteRoturaMaqDao;
import ec.com.avila.hiperion.emision.entities.ObjAsegLcRotMaq;
import ec.com.avila.hiperion.emision.entities.RamoLcRotMaq;
import ec.com.avila.hiperion.servicio.RamoCesanteRoturaMaqService;
import ec.com.avila.hiperion.servicio.RamoCesanteRoturaMaqServiceRemote;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Susana Diaz
 * @version 1.0,17/01/2014
 * @since JDK1.6
 */
@Stateless
public class RamoCesanteRoturaMaqServiceImpl implements RamoCesanteRoturaMaqService, RamoCesanteRoturaMaqServiceRemote {

	@EJB
	private RamoCesanteRoturaMaqDao ramoCesanteRoturaMaqDao;
	
	@EJB
	private ObjAsegLcRoturaMaquinariaDao asegLcRoturaMaquinariaDao;

	public void guardarRamoCesanteRoturaMaq(RamoLcRotMaq ramoCesanteRoturaMaq) throws HiperionException {
		ramoCesanteRoturaMaqDao.persist(ramoCesanteRoturaMaq);
		for(ObjAsegLcRotMaq objeto : ramoCesanteRoturaMaq.getObjAsegLcRotMaqs()){
			asegLcRoturaMaquinariaDao.persist(objeto);
		}
	}

	public List<RamoLcRotMaq> consultarRamoCesanteRoturaMaq() throws HiperionException {
		return ramoCesanteRoturaMaqDao.findAll();
	}

}
