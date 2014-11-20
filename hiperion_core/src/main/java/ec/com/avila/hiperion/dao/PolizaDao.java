/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Poliza;

/**
 * <b>Interface local de la tabla Poliza para realizar las operaciones
 * necesarias </b>
 * 
 * @author Paul Jimenez
 * @version 1.0, 20/10/2013
 * @since JDK1.6
 */
@Local
public interface PolizaDao {

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
	public void guardarPoliza(Poliza poliza) throws HiperionException;

	/**
	 * 
	 * <b> Permite obtener la lista de polizas que se encuantran en la base de
	 * datos. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 18, 2013]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<Poliza> consultarPoliza() throws HiperionException;

	/**
	 * 
	 * <b> Permite modificar los registros en la tabla de Poliza </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: Dec 29, 2013]
	 * </p>
	 * 
	 * @param poliza
	 * @throws HiperionException
	 */
	public void modificarPoliza(Poliza poliza) throws HiperionException;
}
