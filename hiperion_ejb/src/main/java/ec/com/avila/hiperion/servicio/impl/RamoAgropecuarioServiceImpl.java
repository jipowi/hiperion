/**
 * 
 */
package ec.com.avila.hiperion.servicio.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dao.DetalleAnexoDao;
import ec.com.avila.hiperion.dao.ObjAsegAgropecuarioDao;
import ec.com.avila.hiperion.dao.RamoAgropecuarioDao;
import ec.com.avila.hiperion.emision.entities.ArchivoBase;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.ObjAsegAgropecuario;
import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;
import ec.com.avila.hiperion.servicio.RamoAgropecuarioService;

/**
 * <b>Permite implementar los metodos de las interfaces y llamar a los metodos del DAO</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Jul 15, 2014
 * @since JDK1.6
 */
@Stateless
public class RamoAgropecuarioServiceImpl implements RamoAgropecuarioService {

	@EJB
	private RamoAgropecuarioDao ramoAgropecuarioDao;
	@EJB
	private ObjAsegAgropecuarioDao objAsegAgropecuarioDao;
	@EJB
	private DetalleAnexoDao detalleAnexoDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoAgropecuarioService#guardarAgropecuario(ec.com.avila.hiperion.emision.entities.RamoAgropecuario)
	 */
	@Override
	public void guardarAgropecuario(RamoAgropecuario ramoAgropecuario) throws HiperionException {
		ramoAgropecuarioDao.persist(ramoAgropecuario);
		for (ObjAsegAgropecuario objeto : ramoAgropecuario.getObjAsegAgropecuarios()) {
			objAsegAgropecuarioDao.persist(objeto);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.RamoAgropecuarioService#guardarArchivoPoliza(ec.com.avila.hiperion.emision.entities.ArchivoBase)
	 */
	@Override
	public void guardarArchivoPoliza(ArchivoBase file) throws HiperionException {
		ramoAgropecuarioDao.guardarArchivoPoliza(file);

	}

	/* (non-Javadoc)
	 * @see ec.com.avila.hiperion.servicio.RamoAgropecuarioService#consultarDetalleAnexoById(java.lang.Long)
	 */
	@Override
	public DetalleAnexo consultarDetalleAnexoById(Long idDetalle) throws HiperionException {
		return detalleAnexoDao.findById(idDetalle);
	}

	/* (non-Javadoc)
	 * @see ec.com.avila.hiperion.servicio.RamoAgropecuarioService#consultarDetallesByTitulo(java.lang.Long, java.lang.Integer)
	 */
	@Override
	public List<DetalleAnexo> consultarDetallesByTitulo(Long idRamo, Long idTitulo) throws HiperionException {
		return detalleAnexoDao.consultarDetallesByTitulo(idRamo, idTitulo);
	}

}
