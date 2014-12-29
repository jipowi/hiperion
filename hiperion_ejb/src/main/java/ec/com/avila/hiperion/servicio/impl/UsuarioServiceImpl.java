package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.MenuDao;
import ec.com.avila.hiperion.dao.RolDao;
import ec.com.avila.hiperion.dao.UsuarioDao;
import ec.com.avila.hiperion.emision.entities.Menu;
import ec.com.avila.hiperion.emision.entities.Rol;
import ec.com.avila.hiperion.emision.entities.RolMenu;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.servicio.UsuarioService;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

	// @EJB(lookup =
	// "java:global/hiperion_core-1.0/UsuarioDaoImpl!ec.com.avila.hiperion.dao.UsuarioDao")
	@EJB
	private UsuarioDao usuarioDao;

	@EJB
	private RolDao rolDao;

	@EJB
	private MenuDao menuDao;

	public void guardarUsuario(Usuario usuario) throws HiperionException {
		usuarioDao.guardarUsuario(usuario);
	}

	public List<Usuario> consultarUsuarios() throws HiperionException {
		return usuarioDao.consultarUsuarios();
	}

	public Usuario loginUser(String nombreUsuario, String clave) throws HiperionException {
		return usuarioDao.loginUser(nombreUsuario, clave);
	}

	public void modificarUsuario(Usuario usuario) throws HiperionException {
		usuarioDao.modificarUsuario(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultarRolByUsuario(ec.com.avila.hiperion.emision.entities.Usuario)
	 */
	@Override
	public List<Rol> consultarRolByUsuario(Usuario usuario) throws HiperionException {
		return rolDao.consultarRolByUsuario(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultarMenuByRol(ec.com.avila.hiperion.emision.entities.Rol)
	 */
	@Override
	public List<RolMenu> consultarRolMenus(Rol rol) throws HiperionException {
		return menuDao.consultarMenuByRol(rol);
	}

	/* (non-Javadoc)
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultarMenu(java.lang.Integer)
	 */
	@Override
	public Menu consultarMenu(Integer idMenu) throws HiperionException {
		return menuDao.findById(new Long(idMenu));
	}
}
