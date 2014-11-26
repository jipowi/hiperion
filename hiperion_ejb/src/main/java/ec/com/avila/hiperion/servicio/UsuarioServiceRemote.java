/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Usuario;

/**
 * 
 * <b> Servicio de interfaz remota para realizar las operaciones sobre la tabla Usuario </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,22/12/2013
 * @since JDK1.6
 */
@Remote
public interface UsuarioServiceRemote {

	/**
	 * 
	 * <b> Permite guardar los registros en la tabla Usuario </b>
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
	 * <b> Permite obtener la lista de Usuarios que se encuentran en la base de datos. </b>
	 * <p>
	 * [Author: Paul jimenez, Date: 22/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<Usuario> consultarUsuarios() throws HiperionException;

	/**
	 * 
	 * <b> Permite consultar usurios por su alias </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 22/12/2013]
	 * </p>
	 * 
	 * @param nombreUsuario
	 * @return
	 * @throws HiperionException
	 */
	public Usuario consultarUsuarioByAlias(String nombreUsuario) throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar los objetos de la tabla usuarios. </b>
	 * <p>
	 * [Author: Franklin, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param usuario
	 * @throws HiperionException
	 */
	public void modificarUsuario(Usuario usuario) throws HiperionException;
}
