/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;

/**
 * 
 * <b> Servicio de interface remota para realizar las operaciones sobre la tabla Detalle Catalogo</b>
 * 
 * @author Franklin
 * @version 1.0,21/12/2013
 * @since JDK1.6
 */
@Remote
public interface DetalleCatalogoServiceRemote {

	/**
	 * 
	 * <b> Consulta por codigo Detalle Catalogo </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @param idCatalogo
	 * @return
	 * @throws HiperionException
	 */
	public List<DetalleCatalogo> consultarDetalleCatalogoByCodCatalogo(Integer idCatalogo) throws HiperionException;

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param codDepCatalogo
	 * @param codDepDetCatalogo
	 * @return
	 * @throws HiperionException
	 */
	public List<DetalleCatalogo> consultarDetalleCatalogoByDepCatalogo(String codDepCatalogo, String codDepDetCatalogo) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de detalle Catalogo que se encuentra en la base de datos</b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 21/12/2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<DetalleCatalogo> consultarDetalleCatalogo() throws HiperionException;

	/**
	 * 
	 * <b> Permite guardar los registros de la tabla Detalle Catalogo </b>
	 * <p>
	 * [Author: Franklin, Date: 21/12/2013]
	 * </p>
	 * 
	 * @param detalle
	 * @throws HiperionException
	 */
	public void guardarDetalleCatalogo(DetalleCatalogo detalle) throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar los registros de la tabla DetalleCatalogo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param detalle
	 * @throws HiperionException
	 */
	public void modificarDetalleCatalogo(DetalleCatalogo detalle) throws HiperionException;
	
	/**
	 * 
	 * <b> Catalogo utilizado para consultar los registros por medio del ID_CATALOGO y del COD_DEP_DETALLE_CATALOGO </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 28, 2014]
	 * </p>
	 * 
	 * @param codDepCatalogo
	 * @param idCatalogo
	 * @return
	 * @throws HiperionException
	 */
	public List<DetalleCatalogo> consultarDetalleCatalogoByCodDetalle(String codDepCatalogo, Integer idCatalogo) throws HiperionException;
	
	/**
	 * 
	 * <b> Permite consultar un detalle de catalogo por medio del idCatalogo y idDetalle </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 27, 2014]
	 * </p>
	 * 
	 * @param codCatalogo
	 * @param codDetCalogo
	 * @return
	 * @throws HiperionException
	 */
	public DetalleCatalogo consultarDetalleByCatalogoAndDetalle(Integer codCatalogo, Integer codDetCalogo) throws HiperionException;

}
