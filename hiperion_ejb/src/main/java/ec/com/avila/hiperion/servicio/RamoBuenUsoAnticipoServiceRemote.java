/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio;

import java.util.List;

import javax.ejb.Remote;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.RamoBuenUsoAnt;

/**
 * <b> Servicio de interfaz remota para realizar las operaciones sobre la tabla RamoBuenUsoAnticipo </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,13/08/2014
 * @since JDK1.6
 */
@Remote
public interface RamoBuenUsoAnticipoServiceRemote {

	/**
	 * 
	 * <b> Permite guardar los registros en la tabla RamoBuenUsoAnticipo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 13/08/2014]
	 * </p>
	 * 
	 * @param ramoBuenUsoAnt
	 * @throws HiperionException
	 */
	public void guardarRamoBuenUsoAnticipo(RamoBuenUsoAnt ramoBuenUsoAnt) throws HiperionException;

	/**
	 * 
	 * <b> Permite Obtener la lista de RamoBuenUsoAnticipo que se encuentra en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 13/08/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<RamoBuenUsoAnt> consultarRamoBuenUsoAnticipo() throws HiperionException;

}
