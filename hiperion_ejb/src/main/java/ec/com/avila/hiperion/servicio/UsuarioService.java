/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Menu;
import ec.com.avila.hiperion.emision.entities.Rol;
import ec.com.avila.hiperion.emision.entities.Usuario;

/**
 * 
 * <b> Servicio de interfaz local para realizar las operaciones sobre la tabla Usuario </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,22/12/2013
 * @since JDK1.6
 */
@Local
public interface UsuarioService {

	/**
	 * 
	 * <b> Permite guardar los registros en la tabla Usuarios. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 22/12/2013]
	 * </p>
	 * 
	 * @param usuario
	 * @throws HiperionException
	 */
	public void guardarUsuario(Usuario usuario) throws HiperionException;

	/**
	 * 
	 * <b> permite obtener lista de usuarios que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 22/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<Usuario> consultarUsuarios() throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar el usuario por medio del alias </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 22/12/2013]
	 * </p>
	 * 
	 * @param nombreUsuario
	 * @param clave
	 * @return
	 * @throws HiperionException
	 */
	public Usuario loginUser(String nombreUsuario, String clave) throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar los objetos de la tabla Usuario </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param usuario
	 * @throws HiperionException
	 */
	public void modificarUsuario(Usuario usuario) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar los roles que tiene un usuario </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 10, 2014]
	 * </p>
	 * 
	 * @param usuario
	 * @return
	 * @throws HiperionException
	 */
	public List<Rol> consultarRolByUsuario(Usuario usuario) throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar los menus a los cuales el usuario tiene acceso </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 10, 2014]
	 * </p>
	 * 
	 * @param rol
	 * @return
	 * @throws HiperionException
	 */
	public List<Menu> consultarMenuByRol(Rol rol) throws HiperionException;
}
