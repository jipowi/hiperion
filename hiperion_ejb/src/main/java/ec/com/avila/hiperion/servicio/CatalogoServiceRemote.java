/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Catalogo;

/**
 * 
 * <b> Servicio de interface remota para realizar las operaciones sobre la tabla Catalogo</b>
 * 
 * @author Dario Vinueza
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Remote
public interface CatalogoServiceRemote {

	/**
	 * 
	 * <b> Permite obtener la lista de Catalogos que se encuantran en la base de datos</b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @return lista de catalogos
	 * @throws HiperionException
	 */
	public List<Catalogo> consultarCatalogos() throws HiperionException;

	/**
	 * 
	 * <b> Consulta catalogo por clave primaria </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @param idCatalogo
	 * @return
	 * @throws HiperionException
	 */
	public Catalogo consultarCatalogoById(Integer idCatalogo) throws HiperionException;

	/**
	 * 
	 * <b> Permite guardar objetos en la tabla Catalogo</b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @param catalogo
	 * @throws HiperionException
	 */
	public void guardarCatalogo(Catalogo catalogo) throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar los registros de la tabla Catalogo. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param catalogo
	 * @throws HiperionException
	 */
	public void modificarCatalogo(Catalogo catalogo) throws HiperionException;

}
