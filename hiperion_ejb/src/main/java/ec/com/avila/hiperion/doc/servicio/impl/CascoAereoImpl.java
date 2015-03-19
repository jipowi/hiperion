/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocCascoAereo;
import ec.com.avila.hiperion.emision.entities.RamoCascoAereo;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Avila Sistemas
 * @version 1.0,18/03/2015
 * @since JDK1.6
 */
@Stateless
public class CascoAereoImpl implements GenerarDocCascoAereo {
	private static String tagInicioItem = "<item>";
	private static String tagFinItem = "</item>";
	private static String tagInicioMatricula = "<matricula>";
	private static String tagFinMatricula = "</matricula>";
	private static String tagInicioAnioConstruccion = "<anioConstruccion>";
	private static String tagFinAnioConstruccion = "</anioConstruccion>";
	private static String tagInicioPesoMaximoTotal = "<pesoMaximoTotal>";
	private static String tagFinPesoMaximoTotal = "</pesoMaximoTotal>";
	private static String tagInicioValorCasco = "<valorCasco>";
	private static String tagFinValorCasco = "</valorCasco>";
	private static String tagInicioMarca = "<marca>";
	private static String tagFinMarca = "</marca>";
	private static String tagInicioTipoModelo = "<tipoModelo>";
	private static String tagFinTipoModelo = "</tipoModelo>";
	private static String tagInicioHorasVoladas = "<horasVoladas>";
	private static String tagFinHorasVoladas = "</horasVoladas>";
	private static String tagInicioMaximaCargaAutorizada = "<maximaCargaAutorizada>";
	private static String tagFinMaximaCargaAutorizada = "</maximaCargaAutorizada>";
	private static String tagInicioMarcaMotor = "<marcaMotor>";
	private static String tagFinMarcaMotor = "</marcaMotor>";
	private static String tagInicioTipoMotor = "<tipoMotor>";
	private static String tagFinTipoMotor = "</tipoMotor>";
	private static String tagInicioTotalAsegurado = "<totalAsegurado>";
	private static String tagFinTotalAsegurado = "</totalAsegurado>";
	private static String tagInicioTasa = "<tasa>";
	private static String tagInicioPorcentajeSiniestro = "<porcentajeSiniestro>";
	private static String tagFinPorcentajeSiniestro = "</porcentajeSiniestro>";
	private static String tagInicioMinimoSiniestro = "<minimoSiniestro>";
	private static String tagFinMinimoSiniestro = "</minimoSiniestro>";
	private static String tagInicioDetalleExtra = "<detalleExtra>";
	private static String tagFinDetalleExtra = "</detalleExtra>";
	private static String tagInicioValorExtra = "<valorExtra>";
	private static String tagFinValorExtra = "</valorExtra>";
	private static String tagInicioCoberturasAdicionales = "<coberturasAdicionales>";
	private static String tagFinCoberturasAdicionales = "</coberturasAdicionales>";
	private static String tagInicioClausulasAdicionales = "<clausulasAdicionales>";
	private static String tagFinClausulasAdicionales = "</clausulasAdicionales>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocCascoAereo#generarXmlCascoAereo(ec.com.avila.hiperion.emision.entities.RamoCascoAereo)
	 */
	@Override
	public String generarXmlCascoAereo(RamoCascoAereo cascoAereo) throws HiperionException {
		// TODO Auto-generated method stub
		return null;
	}

}
