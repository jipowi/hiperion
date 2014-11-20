/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.PersonaDao;
import ec.com.avila.hiperion.entities.Persona;
import ec.com.avila.hiperion.servicio.PersonaService;
import ec.com.avila.hiperion.servicio.PersonaServiceRemote;

@Stateless
public class PersonaServiceImpl implements PersonaService, PersonaServiceRemote {

	// @EJB(lookup = "java:global/hiperion_core-1.0/PersonaDaoImpl!ec.com.avila.hiperion.dao.PersonaDao")
	@EJB
	private PersonaDao personaDao;

	public void guardarPersona(Persona persona) throws HiperionException {
		personaDao.guardarPersona(persona);
	}

	public List<Persona> consultarPersonas() throws HiperionException {
		return personaDao.consultarPersonas();
	}

	public void modificarPersona(Persona persona) throws HiperionException {
		personaDao.modificarPersona(persona);
	}
}
