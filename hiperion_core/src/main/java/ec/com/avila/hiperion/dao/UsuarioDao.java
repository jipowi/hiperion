/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Usuario;

/**
 * 
 * <b> Interface local de la tabla Usuario para realizar las operaciones necesarias </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@Local
public interface UsuarioDao {

	/**
	 * 
	 * <b> Permite guardar un usuario en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 21, 2013]
	 * </p>
	 * 
	 * @param usuario
	 * @throws HiperionException
	 */
	public void guardarUsuario(Usuario usuario) throws HiperionException;

	/**
	 * 
	 * <b> Permite guardar los registros de la tabla Usuario </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 18, 2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<Usuario> consultarUsuarios() throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de usuarios que se encuentran en la base de datos</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 18, 2013]
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
	 * <b> Permite modificar los objetos de la tabla usuarios. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param usuario
	 * @throws HiperionException
	 */
	public void modificarUsuario(Usuario usuario) throws HiperionException;
}
