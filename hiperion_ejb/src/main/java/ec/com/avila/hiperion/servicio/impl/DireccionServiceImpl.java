/**
 * 
 */
package ec.com.avila.hiperion.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.DireccionDao;
import ec.com.avila.hiperion.emision.entities.Direccion;
import ec.com.avila.hiperion.servicio.DireccionService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,10/09/2014
 * @since JDK1.6
 */
@Stateless
public class DireccionServiceImpl implements DireccionService {

	@EJB
	private DireccionDao direccionDao;

	public DireccionServiceImpl() {
	}

	public void guardarDireccion(Direccion direccion) throws HiperionException {
		direccionDao.guardarDireccion(direccion);
	}

}
