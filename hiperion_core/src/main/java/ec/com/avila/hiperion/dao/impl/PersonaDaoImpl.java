package ec.com.avila.hiperion.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.PersonaDao;
import ec.com.avila.hiperion.emision.entities.Persona;

/**
 * <b> Permite implementar las operaciones de la tabla Persona </b>
 * 
 * @author Dario Vinueza
 * @version 1.0, 20/10/2013
 * @since JDK1.6
 */
@Stateless
public class PersonaDaoImpl implements PersonaDao {

	Logger log = Logger.getLogger(PolizaDaoImpl.class);

	@PersistenceContext(unitName = "sgs_pu")
	protected EntityManager em;

	public void guardarPersona(Persona persona) throws HiperionException {
		try {
			em.persist(persona);
		} catch (Exception ex) {
			log.error("Error PersonaDaoImpl:guardarPersona ---> " + ex);
			throw new HiperionException(ex);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Persona> consultarPersonas() throws HiperionException {
		try {
			return em.createNamedQuery("Persona.findAll").getResultList();
		} catch (Exception ex) {
			log.error("Error PersonaDaoImpl:consultarPersonas --->" + ex);
			throw new HiperionException(ex);
		}
	}

	public void modificarPersona(Persona persona) throws HiperionException {
		try {
			em.merge(persona);
		} catch (Exception ex) {
			log.error("Error PersonaDaoImpl:modificarPersona --->" + ex);
			throw new HiperionException(ex);
		}
	}
}
