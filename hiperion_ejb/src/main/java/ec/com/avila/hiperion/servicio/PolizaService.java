/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Poliza;

/**
 * <b> Servicio de interface local para realizar las operaciones sobre la tabla
 * Poliza </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@Local
public interface PolizaService {

	/**
	 * 
	 * <b> Permite guardar los registros en la tabla de Poliza </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 18, 2013]
	 * </p>
	 * 
	 * @param poliza
	 * @throws HiperionException
	 */
	public void guardarPoliza(Poliza poliza)throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de polizas que se encuantran en la base de
	 * datos. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 18, 2013]
	 * </p>
	 * 
	 * @return lista de polizas
	 * @throws HiperionException
	 */
	public List<Poliza> consultarPoliza() throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar los objetos del atabla Poliza. </b>
	 * <p>
	 * [Author: Franklin, Date: 29/12/2013]
	 * </p>
	 * 
	 * @param poliza
	 * @throws HiperionException
	 */
	public void modificarPoliza(Poliza poliza) throws HiperionException;

}
