/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Catalogo;

/**
 * 
 * <b> Interfaz local de la tabla Catalogo para realizar las operaciones necesarias</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,28/11/2013
 * @since JDK1.6
 */
@Local
public interface CatalogoDao {

	/**
	 * 
	 * <b> Permite obtener lista de los catalogos que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<Catalogo> consultarCatalogos() throws HiperionException;

	/**
	 * 
	 * <b> Permite Obtener el detalle de un catalogo en base a la identificacion del mismo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 28/11/2013]
	 * </p>
	 * 
	 * @param idCatalogo
	 *            - id o codigo del catalogo con el que esta registrado en la base de datos
	 * @return Objeto de tipo Catalogo
	 * @throws HiperionException
	 */
	public Catalogo consultarCatalogoById(Integer idCatalogo) throws HiperionException;

	/**
	 * 
	 * <b> Permite guardar un objetos en la tabla Catalogo de la base de datos </b>
	 * <p>
	 * [Author: Franklin, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param catalogo
	 * @throws HiperionException
	 */
	public void guardarCatalogo(Catalogo catalogo) throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar un objeto de la tabla Catalogo de la base de datos. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param catalogo
	 * @throws HiperionException
	 */
	public void modificarCatalogo(Catalogo catalogo) throws HiperionException;
}
