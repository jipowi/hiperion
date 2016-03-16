package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.model.chart.PieChartModel;

import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.PolizaService;

@ManagedBean
@ViewScoped
public class ReportePolizaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ClienteService clienteService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	@EJB
	private PolizaService polizaService;

	private List<Poliza> polizas;

	private Date fechaDesde;
	private Date fechaHasta;
	private String estado;
	private int numEmitidas = 0;
	private int numCotizadas = 0;
	private int numRechazadas = 0;
	private boolean activarGrafico = false;

	private PieChartModel piePolizas1;

	Logger log = Logger.getLogger(ReportePolizaBacking.class);

	@PostConstruct
	public void init() {
		createPiePolizas();
	}

	/**
	 * 
	 * <b> Permite presentar el reporte con los parametros ingresados. </b>
	 * <p>
	 * [Author: HIPERION, Date: 24/02/2016]
	 * </p>
	 * 
	 */
	public void generarReporte() {

		polizas = polizaService.obtenerReporteFechas(fechaDesde, fechaHasta);

		for (Poliza poliza : polizas) {
			if (poliza.getEstadoPoliza().equals("COTIZADO")) {
				numCotizadas++;
			} else if (poliza.getEstadoPoliza().equals("EMITIDO")) {
				numEmitidas++;
			}
		}

		activarGrafico = true;
		createPiePolizas();
	}

	/**
	 * 
	 * <b> Permite generar el grafico del total de polizas. </b>
	 * <p>
	 * [Author: HIPERION, Date: 15/03/2016]
	 * </p>
	 * 
	 */
	private void createPiePolizas() {
		piePolizas1 = new PieChartModel();

		piePolizas1.set("Emitidas", numEmitidas);
		piePolizas1.set("Cotizadas", numCotizadas);
		piePolizas1.setTitle("Polizas");
		piePolizas1.setLegendPosition("w");
		piePolizas1.setFill(true);
		piePolizas1.setShowDataLabels(true);
		piePolizas1.setDiameter(100);

	}

	/**
	 * @return the polizas
	 */
	public List<Poliza> getPolizas() {
		return polizas;
	}

	/**
	 * @param polizas
	 *            the polizas to set
	 */
	public void setPolizas(List<Poliza> polizas) {
		this.polizas = polizas;
	}

	/**
	 * @return the fechaDesde
	 */
	public Date getFechaDesde() {
		return fechaDesde;
	}

	/**
	 * @param fechaDesde
	 *            the fechaDesde to set
	 */
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	/**
	 * @return the fechaHasta
	 */
	public Date getFechaHasta() {
		return fechaHasta;
	}

	/**
	 * @param fechaHasta
	 *            the fechaHasta to set
	 */
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the numEmitidas
	 */
	public int getNumEmitidas() {
		return numEmitidas;
	}

	/**
	 * @param numEmitidas
	 *            the numEmitidas to set
	 */
	public void setNumEmitidas(int numEmitidas) {
		this.numEmitidas = numEmitidas;
	}

	/**
	 * @return the numCotizadas
	 */
	public int getNumCotizadas() {
		return numCotizadas;
	}

	/**
	 * @param numCotizadas
	 *            the numCotizadas to set
	 */
	public void setNumCotizadas(int numCotizadas) {
		this.numCotizadas = numCotizadas;
	}

	/**
	 * @return the numRechazadas
	 */
	public int getNumRechazadas() {
		return numRechazadas;
	}

	/**
	 * @param numRechazadas
	 *            the numRechazadas to set
	 */
	public void setNumRechazadas(int numRechazadas) {
		this.numRechazadas = numRechazadas;
	}

	/**
	 * @return the piePolizas1
	 */
	public PieChartModel getPiePolizas1() {
		return piePolizas1;
	}

	/**
	 * @param piePolizas1
	 *            the piePolizas1 to set
	 */
	public void setPiePolizas1(PieChartModel piePolizas1) {
		this.piePolizas1 = piePolizas1;
	}

	/**
	 * @return the activarGrafico
	 */
	public boolean isActivarGrafico() {
		return activarGrafico;
	}

	/**
	 * @param activarGrafico
	 *            the activarGrafico to set
	 */
	public void setActivarGrafico(boolean activarGrafico) {
		this.activarGrafico = activarGrafico;
	}

}
