/**
 * 
 */
package ec.com.avila.hiperion.doc.servicio.impl;

import javax.ejb.Stateless;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.doc.servicio.GenerarDocCascoMaritimo;
import ec.com.avila.hiperion.emision.entities.RamoCascoMaritimo;

/**
 * <b> Clase que se encarga de generar el documento PDF </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,18/03/2015
 * @since JDK1.6
 */
@Stateless
public class CascoMaritimoImpl implements GenerarDocCascoMaritimo {

	private static String tagInicioNombreNave = "<nombreNave>";
	private static String tagFinNombreNave = "/nombreNave";
	private static String tagInicioRegistroNumero = "registroNumero";
	private static String tagFinRegistroNumero = "/registroNumero";
	private static String tagInicioTonelajeBruto = "<tonelajeBruto>";
	private static String tagFinTonelajeBruto = "</tonelajeBruto>";
	private static String tagInicioClaseEmbarcacion = "<claseEmbarcacion>";
	private static String tagFinClaseEmbarcacion = "</claseEmbarcacion>";
	private static String tagInicioBandera = "<bandera>";
	private static String tagFinBandera = "</bandera>";
	private static String tagInicioZonaNavegacion = "<zonaNavegacion>";
	private static String tagFinZonaNavegaciob = "<zonaNavegacion>";
	private static String tagInicioEslora = "<eslora>";
	private static String tagFinEslora = "</eslora>";
	private static String tagInicioPuntal = "<puntal>";
	private static String tagFinPuntal = "</puntal>";
	private static String tagInicioAnioConstruccion = "<anioConstruccion>";
	private static String tagFinAbioContruccion = "</anioContrucción>";
	private static String tagInicioManga = "<manga>";
	private static String tagFinManga = "</manga>";
	private static String tagInicioMarcaMotor = "<marcaMotor>";
	private static String tagFinMarcaMotor = "</marcaMotor>";
	private static String tagInicioAvaluo = "<avlauo>";
	private static String tagFinAvaluo = "</avaluo>";
	private static String tagInicioValorCasco = "<valorCasco>";
	private static String tagFinValorCasco = "</valorCasco>";
	private static String tagInicioValorMaquinaria = "<valorMaquinaria>";
	private static String tagFinVlorMaquinaria = "</valorMaquinaria>";
	private static String tagInicioValorRedes = "<valorRedes>";
	private static String tagFinValorRedes = "</valorRedes>";
	private static String tagInicioOtros = "<otros>";
	private static String tagFinOtros = "</otros>";
	private static String tagInicioTotal = "<total>";
	private static String tagFinTotal = "</total>";
	private static String tagInicioPorcentajeSiniestro = "<porcentajeSiniestro>";
	private static String tagFinPorcentajeSiniestro = "</porcentajeSiniestro>";
	private static String tagInicioMinimoSiniestro = "<minimoSiniestro>";
	private static String tagFinMinimoSiniestro = "</minimoSiniestro>";
	private static String tagInicioCoberturasAdicionales = "<coberturasAdicionales>";
	private static String tagFinCoberturasAdicionales = "</coberturasAdicionales>";
	private static String tagInicioClausulasAdicionales = "<clausulasAdicionales>";
	private static String tagFinClausulasAdicionales = "</clausulasAdicionales>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.doc.servicio.GenerarDocCascoMaritimo#generarXmlCascoMaritimo(ec.com.avila.hiperion.emision.entities.RamoCascoMaritimo)
	 */
	@Override
	public String generarXmlCascoMaritimo(RamoCascoMaritimo cascoMaritimo) throws HiperionException {
		// TODO Auto-generated method stub
		return null;
	}

}
