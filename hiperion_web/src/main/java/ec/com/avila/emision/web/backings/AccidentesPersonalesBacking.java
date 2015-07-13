/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import ec.com.avila.emision.web.beans.PolizaBean;
import ec.com.avila.emision.web.beans.RamoAccidentesPersonalesBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ClausulaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.CondicionEspecialDTO;
import ec.com.avila.hiperion.dto.TablaAmortizacionDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.ClausulasAddAccPer;
import ec.com.avila.hiperion.emision.entities.CobertAccPer;
import ec.com.avila.hiperion.emision.entities.CondEspAccPer;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.RamoAccidentesPersonalesService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Backing que permite gestionar la informacion que se maneje en las paginas web que utilicen el Ramo ACCIDENTES PERSONALES. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class AccidentesPersonalesBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private RamoService ramoService;

	@EJB
	private RamoAccidentesPersonalesService ramoAccidentesPersonalesService;

	@EJB
	private CatalogoService catalogoService;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@ManagedProperty(value = "#{polizaBean}")
	private PolizaBean polizaBean;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{ramoAccidentesPersonalesBean}")
	private RamoAccidentesPersonalesBean ramoAccidentesPersonalesBean;

	private List<DetalleAnexo> anexos;
	private List<ClausulaAdicionalDTO> clausulasAdicionalesDTO = new ArrayList<>();
	private List<ClausulasAddAccPer> clausulasAdicionales;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();
	private List<CobertAccPer> coberturas;
	private List<CondicionEspecialDTO> condicionesEspecialesDTO = new ArrayList<>();
	private List<CondEspAccPer> condicionesEspeciales;
	private List<SelectItem> sexoItems;
	private List<SelectItem> parentescoItems;

	Logger log = Logger.getLogger(AccidentesPersonalesBacking.class);

	@PostConstruct
	public void init() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("AP");
			anexos = ramo.getDetalleAnexos();

			obtenerClausulasAdicionales(anexos);
			obtenerCoberturas(anexos);

			obtenerCondicionesEspeciales(anexos);

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite setear los datos de la poliza. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 09/07/2015]
	 * </p>
	 * 
	 * @return
	 */
	public Poliza setearDatosPoliza() {

		Usuario usuario = usuarioBean.getSessionUser();
		Poliza poliza = new Poliza();

		poliza.setNumeroPoliza(polizaBean.getNumeroPoliza());
		poliza.setNumeroAnexo(polizaBean.getNumeroAnexo());
		poliza.setEjecutivo(polizaBean.getEjecutivo().getNombreUsuario());
		poliza.setVigenciaDesde(polizaBean.getVigenciaDesde());
		poliza.setVigenciaHasta(polizaBean.getVigenciaHasta());
		poliza.setDiasCobertura(polizaBean.getDiasCobertura());
		poliza.setSumaAsegurada(polizaBean.getSumaAsegurada());
		poliza.setPrimaNeta(BigDecimal.valueOf(polizaBean.getPrimaNeta()));
		poliza.setSuperBanSeguros(polizaBean.getSuperBanSeguros());
		poliza.setSeguroCampesino(BigDecimal.valueOf(polizaBean.getSeguroCampesino()));
		poliza.setDerechoEmision(BigDecimal.valueOf(polizaBean.getDerechoEmision()));
		poliza.setRamo(1);
		poliza.setEstadoPoliza("COTIZADO");

		PagoPoliza pagoPoliza = new PagoPoliza();
		pagoPoliza.setNumeroFactura(polizaBean.getNumeroFactura());
		pagoPoliza.setSubtotal(polizaBean.getSubtotal());
		pagoPoliza.setAdicionalSegCampesino(polizaBean.getAdicionalSegCampesino());
		pagoPoliza.setIva(polizaBean.getIva());
		pagoPoliza.setCuotaInicial(polizaBean.getCuotaInicial());
		pagoPoliza.setValorTotalPagoPoliza(polizaBean.getTotal());
		pagoPoliza.setEstado(EstadoEnum.A);
		pagoPoliza.setFechaCreacion(new Date());
		pagoPoliza.setIdUsuarioCreacion(usuario.getIdUsuario());

		List<Financiamiento> financiamientos = new ArrayList<>();
		for (TablaAmortizacionDTO financiamiento : polizaBean.getFinanciamientos()) {
			Financiamiento financiamientoTemp = new Financiamiento();
			financiamientoTemp.setNumeroCuota(financiamiento.getNumeroLetra());
			financiamientoTemp.setValorLetra(BigDecimal.valueOf(financiamiento.getValor()));
			financiamientoTemp.setFechaVencimiento(financiamiento.getFechaVencimiento());

			financiamientos.add(financiamientoTemp);
		}

		pagoPoliza.setFinanciamientos(financiamientos);

		poliza.setPagoPoliza(pagoPoliza);

		return poliza;
	}

	/**
	 * 
	 * <b> Permite obtener las Condiciones Especiales del Anexo de un Ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public void obtenerCondicionesEspeciales(List<DetalleAnexo> anexos) {
		condicionesEspeciales = new ArrayList<CondEspAccPer>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3) {
					CondEspAccPer condicion = new CondEspAccPer();
					condicion.setCondicionAcc(anexo.getNombreDetalleAnexo());
					condicionesEspeciales.add(condicion);
				}
			}
		}
		for (CondEspAccPer condicion : condicionesEspeciales) {
			CondicionEspecialDTO condicionDTO = new CondicionEspecialDTO();
			condicionDTO.setCondicionEspecial(condicion.getCondicionAcc());
			condicionDTO.setSeleccion(false);

			condicionesEspecialesDTO.add(condicionDTO);
		}

	}

	/**
	 * 
	 * <b> Permite obtener las Clausulas Adicionales del Anexo de una Ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/05/2014]
	 * </p>
	 * 
	 * @return
	 */
	public void obtenerClausulasAdicionales(List<DetalleAnexo> anexos) {
		clausulasAdicionales = new ArrayList<ClausulasAddAccPer>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1) {
					ClausulasAddAccPer clausula = new ClausulasAddAccPer();
					clausula.setClausulaAccPersonales(anexo.getNombreDetalleAnexo());
					clausulasAdicionales.add(clausula);
				}
			}
		}
		for (ClausulasAddAccPer clausula : clausulasAdicionales) {
			ClausulaAdicionalDTO clausulaDTO = new ClausulaAdicionalDTO();
			clausulaDTO.setClausula(clausula.getClausulaAccPersonales());

			clausulasAdicionalesDTO.add(clausulaDTO);
		}

	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas del Anexo de un Ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public void obtenerCoberturas(List<DetalleAnexo> anexos) {
		coberturas = new ArrayList<CobertAccPer>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertAccPer cobertura = new CobertAccPer();
					cobertura.setCoberturaAccPersonales(anexo.getNombreDetalleAnexo());
					coberturas.add(cobertura);
				}
			}
		}
		for (CobertAccPer cobertura : coberturas) {
			CoberturaDTO coberturaDTO = new CoberturaDTO();
			coberturaDTO.setCobertura(cobertura.getCoberturaAccPersonales());

			coberturasDTO.add(coberturaDTO);
		}

	}

	/**
	 * 
	 * <b> Permite guardar los datos del ramo y la poliza. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 10/07/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {

		try {

			Poliza poliza = setearDatosPoliza();

			Usuario usuario = usuarioBean.getSessionUser();

			RamoAccidentesPersonale accidentesPersonales = new RamoAccidentesPersonale();

			accidentesPersonales.setPrimaNetaPersona(ramoAccidentesPersonalesBean.getPrimaNetaPersona());
			accidentesPersonales.setPrimaTotalPersona(ramoAccidentesPersonalesBean.getPrimaTotalPersona());
			accidentesPersonales.setTasaAccidente(ramoAccidentesPersonalesBean.getTasa());
			accidentesPersonales.setFacturacion(ramoAccidentesPersonalesBean.getFacturacion());
			accidentesPersonales.setIdUsuarioCreacion(usuario.getIdUsuario());
			accidentesPersonales.setFechaCreacion(new Date());
			accidentesPersonales.setEstado(EstadoEnum.A);

			// Coberturas
			int contCoberturas = 0;
			List<CobertAccPer> coberturas = new ArrayList<>();
			for (CoberturaDTO coberturaDTO : coberturasDTO) {
				if (coberturaDTO.getSeleccion()) {
					contCoberturas++;
					CobertAccPer cobertura = new CobertAccPer();
					cobertura.setCoberturaAccPersonales(coberturaDTO.getCobertura());

					coberturas.add(cobertura);
				}
			}

			if (contCoberturas == 0) {
				MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.coberturas"));
			} else {
				accidentesPersonales.setCoberturasAcc(coberturas);
			}

			// Clausulas Adicionales
			int contClausulas = 0;
			List<ClausulasAddAccPer> clausulas = new ArrayList<>();
			for (ClausulaAdicionalDTO clausualaDTO : clausulasAdicionalesDTO) {
				if (clausualaDTO.getSeleccion()) {
					contClausulas++;
					ClausulasAddAccPer clausula = new ClausulasAddAccPer();
					clausula.setClausulaAccPersonales(clausualaDTO.getClausula());
					clausula.setEstado(EstadoEnum.A);
					clausula.setFechaCreacion(new Date());
					clausula.setIdUsuarioCreacion(usuario.getIdUsuario());

					clausulas.add(clausula);
				}
			}
			if (contClausulas == 0) {
				MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.clausulasAdd"));
			} else {
				accidentesPersonales.setClausulasAddAccPers(clausulas);
			}

			// Condiciones Especiales
			int contCondicion = 0;
			List<CondEspAccPer> condiciones = new ArrayList<>();
			for (CondicionEspecialDTO condicionDTO : condicionesEspecialesDTO) {
				if (condicionDTO.getSeleccion()) {
					contCondicion++;
					CondEspAccPer condicion = new CondEspAccPer();
					condicion.setCondicionAcc(condicionDTO.getCondicionEspecial());

					condiciones.add(condicion);
				}
			}
			if (contCondicion == 0) {
				MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.condicionesEsp"));
			} else {
				accidentesPersonales.setCondicionesEspAcc(condiciones);
			}

			ramoAccidentesPersonalesService.guardarRamoAccidentesPersonales(accidentesPersonales, poliza);

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo accidentes personales", e);

			throw new HiperionException(e);
		}

	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditCobertura(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((CoberturaDTO) event.getObject()).getCobertura());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditClausula(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ClausulaAdicionalDTO) event.getObject()).getClausula());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditCondicion(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((CondicionEspecialDTO) event.getObject()).getCondicionEspecial());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * @return the ramoBean
	 */
	public RamoBean getRamoBean() {
		return ramoBean;
	}

	/**
	 * @param ramoBean
	 *            the ramoBean to set
	 */
	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * @return the ramoAccidentesPersonalesBean
	 */
	public RamoAccidentesPersonalesBean getRamoAccidentesPersonalesBean() {
		return ramoAccidentesPersonalesBean;
	}

	/**
	 * @param ramoAccidentesPersonalesBean
	 *            the ramoAccidentesPersonalesBean to set
	 */
	public void setRamoAccidentesPersonalesBean(RamoAccidentesPersonalesBean ramoAccidentesPersonalesBean) {
		this.ramoAccidentesPersonalesBean = ramoAccidentesPersonalesBean;
	}

	/**
	 * @return the parentescoItems
	 * @throws HiperionException
	 */
	public List<SelectItem> getParentescoItems() throws HiperionException {

		this.parentescoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia()
				.getLong("ec.gob.avila.hiperion.recursos.parentesco"));
		List<DetalleCatalogo> parentesco = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : parentesco) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			parentescoItems.add(selectItem);
		}
		return parentescoItems;
	}

	/**
	 * @return the sexoItems
	 * @throws HiperionException
	 */
	public List<SelectItem> getSexoItems() throws HiperionException {
		this.sexoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoSexo"));
		List<DetalleCatalogo> sexos = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : sexos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			sexoItems.add(selectItem);
		}

		return sexoItems;
	}

	/**
	 * @param parentescoItems
	 *            the parentescoItems to set
	 */
	public void setParentescoItems(List<SelectItem> parentescoItems) {
		this.parentescoItems = parentescoItems;
	}

	/**
	 * @param sexoItems
	 *            the sexoItems to set
	 */
	public void setSexoItems(List<SelectItem> sexoItems) {
		this.sexoItems = sexoItems;
	}

	/**
	 * @return the clausulasAdicionalesDTO
	 */
	public List<ClausulaAdicionalDTO> getClausulasAdicionalesDTO() {
		return clausulasAdicionalesDTO;
	}

	/**
	 * @param clausulasAdicionalesDTO
	 *            the clausulasAdicionalesDTO to set
	 */
	public void setClausulasAdicionalesDTO(List<ClausulaAdicionalDTO> clausulasAdicionalesDTO) {
		this.clausulasAdicionalesDTO = clausulasAdicionalesDTO;
	}

	/**
	 * @return the coberturasDTO
	 */
	public List<CoberturaDTO> getCoberturasDTO() {
		return coberturasDTO;
	}

	/**
	 * @param coberturasDTO
	 *            the coberturasDTO to set
	 */
	public void setCoberturasDTO(List<CoberturaDTO> coberturasDTO) {
		this.coberturasDTO = coberturasDTO;
	}

	/**
	 * @return the condicionesEspecialesDTO
	 */
	public List<CondicionEspecialDTO> getCondicionesEspecialesDTO() {
		return condicionesEspecialesDTO;
	}

	/**
	 * @param condicionesEspecialesDTO
	 *            the condicionesEspecialesDTO to set
	 */
	public void setCondicionesEspecialesDTO(List<CondicionEspecialDTO> condicionesEspecialesDTO) {
		this.condicionesEspecialesDTO = condicionesEspecialesDTO;
	}

	/**
	 * @return the coberturas
	 */
	public List<CobertAccPer> getCoberturas() {
		return coberturas;
	}

	/**
	 * @param coberturas
	 *            the coberturas to set
	 */
	public void setCoberturas(List<CobertAccPer> coberturas) {
		this.coberturas = coberturas;
	}

	/**
	 * @return the condicionesEspeciales
	 */
	public List<CondEspAccPer> getCondicionesEspeciales() {
		return condicionesEspeciales;
	}

	/**
	 * @param condicionesEspeciales
	 *            the condicionesEspeciales to set
	 */
	public void setCondicionesEspeciales(List<CondEspAccPer> condicionesEspeciales) {
		this.condicionesEspeciales = condicionesEspeciales;
	}

	/**
	 * @return the usuarioBean
	 */
	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	/**
	 * @param usuarioBean
	 *            the usuarioBean to set
	 */
	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	/**
	 * @return the polizaBean
	 */
	public PolizaBean getPolizaBean() {
		return polizaBean;
	}

	/**
	 * @param polizaBean
	 *            the polizaBean to set
	 */
	public void setPolizaBean(PolizaBean polizaBean) {
		this.polizaBean = polizaBean;
	}

	/**
	 * @return the clausulasAdicionales
	 */
	public List<ClausulasAddAccPer> getClausulasAdicionales() {
		return clausulasAdicionales;
	}

	/**
	 * @param clausulasAdicionales
	 *            the clausulasAdicionales to set
	 */
	public void setClausulasAdicionales(List<ClausulasAddAccPer> clausulasAdicionales) {
		this.clausulasAdicionales = clausulasAdicionales;
	}

}
