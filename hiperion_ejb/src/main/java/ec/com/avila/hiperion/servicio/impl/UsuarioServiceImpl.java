package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.UsuarioDao;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.servicio.UsuarioService;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

	// @EJB(lookup =
	// "java:global/hiperion_core-1.0/UsuarioDaoImpl!ec.com.avila.hiperion.dao.UsuarioDao")
	@EJB
	private UsuarioDao usuarioDao;

	public void guardarUsuario(Usuario usuario) throws HiperionException {
		usuarioDao.guardarUsuario(usuario);
	}

	public List<Usuario> consultarUsuarios() throws HiperionException {
		return usuarioDao.consultarUsuarios();
	}

	public Usuario consultarUsuarioByAlias(String nombreUsuario) throws HiperionException {
		return usuarioDao.consultarUsuarioByAlias(nombreUsuario);
	}

	public void modificarUsuario(Usuario usuario) throws HiperionException {
		usuarioDao.modificarUsuario(usuario);
	}
}
