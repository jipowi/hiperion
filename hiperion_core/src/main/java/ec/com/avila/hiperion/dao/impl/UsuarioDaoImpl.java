package ec.com.avila.hiperion.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.avila.hiperion.dao.UsuarioDao;
import ec.com.avila.hiperion.entities.Usuario;

/**
 * 
 * <b> Permite implementar las operaciones de la tabla Usuarios </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Stateless
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext(unitName = "sgs_pu")
	private EntityManager em;

	public UsuarioDaoImpl() {
	}

	public void guardarUsuario(Usuario usuario) {
		em.persist(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> consultarUsuarios() {
		return em.createNamedQuery("Usuario.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	public Usuario consultarUsuarioByAlias(String nombreUsuario) {
		Query query = em.createNamedQuery("Usuario.findByNombre");
		query.setParameter("nombreUsuario", nombreUsuario);
		List<Usuario> usuarios = query.getResultList();
		return usuarios.get(0);
	}

	public void modificarUsuario(Usuario usuario) {
		em.merge(usuario);
	}
}
