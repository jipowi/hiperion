/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.AseguradoraDao;
import ec.com.avila.hiperion.dao.ClienteDao;
import ec.com.avila.hiperion.emision.entities.Aseguradora;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.AseguradoraService;

/**
 * <b>Implementacion del servicio de aseguradora</b>
 * 
 * @author kruger
 * @version 1.0,Dec 21, 2013
 * @since JDK1.6
 */
@Stateless
public class AseguradoraServiceImpl implements AseguradoraService {

	@EJB
	private AseguradoraDao aseguradoraDao;

	@EJB
	private ClienteDao clienteDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.PolizaService#guardarAseguradora(ec.com.avila.hiperion.emision.entities.Aseguradora, java.util.List)
	 */
	@Override
	public void guardarAseguradora(Aseguradora aseguradora, List<Cliente> contactos, boolean save) throws HiperionException {

		if (save) {
			aseguradoraDao.persist(aseguradora);

			for (Cliente cliente : contactos) {
				cliente.setAseguradora(aseguradora);
				clienteDao.persist(cliente);
			}
		} else {
			aseguradoraDao.update(aseguradora);
			
			List<Cliente> clientesDB = clienteDao.consultarClienteByAseguradora(aseguradora.getCodigoAseguradora());
			// Eliminar registros
			for (Cliente cliente : clientesDB) {
				cliente.setAseguradora(aseguradora);
				cliente.setEstado(EstadoEnum.I);
				clienteDao.delete(cliente);
			}
			// Agregar registros actualizados
			for (Cliente cliente : contactos) {
				cliente.setAseguradora(aseguradora);
				clienteDao.persist(cliente);
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.AseguradoraService#consultarAseguradoraByRucAseg(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Aseguradora consultarAseguradoraByRucAseg(String ruc, Integer aseguradora) throws HiperionException {
		return aseguradoraDao.consultarAseguradora(ruc, aseguradora);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.AseguradoraService#consultarClienteByAseguradora(java.lang.String)
	 */
	@Override
	public List<Cliente> consultarClienteByAseguradora(String aseguradora) throws HiperionException {
		return clienteDao.consultarClienteByAseguradora(aseguradora);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.AseguradoraService#consultarAseguradoraById(java.lang.Integer)
	 */
	@Override
	public Aseguradora consultarAseguradoraById(Long idAseguradora) throws HiperionException {
		return aseguradoraDao.findById(idAseguradora);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.AseguradoraService#consultarAseguradoraByCodigo(java.lang.Integer)
	 */
	@Override
	public Aseguradora consultarAseguradoraByCodigo(String codigo) throws HiperionException {
		return aseguradoraDao.consultarAseguradoraByCodigo(codigo);
	}

}
