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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

import ec.com.avila.emision.web.beans.PolizaBean;
import ec.com.avila.emision.web.beans.RamoAsistenciaMedicaBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.LimitesCostosDTO;
import ec.com.avila.hiperion.dto.TablaAmortizacionDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Financiamiento;
import ec.com.avila.hiperion.emision.entities.LimitesCostosAsm;
import ec.com.avila.hiperion.emision.entities.PagoPoliza;
import ec.com.avila.hiperion.emision.entities.Poliza;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoAsistenciaMedica;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.RamoAstMedicaService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b> Clase que sirve de soporte para un objeto manejado dentro de la aplicacion, permite implementar los conportamientos especificos de la pagina
 * </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Feb 9, 2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class AsistenciaMedicaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private RamoService ramoService;

	@EJB
	private RamoAstMedicaService ramoAstMedicaService;

	@EJB
	private CatalogoService catalogoService;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@ManagedProperty(value = "#{polizaBean}")
	private PolizaBean polizaBean;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{ramoAsistenciaMedicaBean}")
	private RamoAsistenciaMedicaBean ramoAsistenciaMedicaBean;

	private List<DetalleAnexo> anexos;

	private List<LimitesCostosAsm> limitesCostosBeneficios;
	private List<LimitesCostosAsm> limitesCostosBenAdd;
	private List<LimitesCostosAsm> limitesCostosMaternidad;
	private List<LimitesCostosDTO> limitesCostosBeneficiosDTO = new ArrayList<>();
	private List<LimitesCostosDTO> limitesCostosBenAddDTO = new ArrayList<>();
	private List<LimitesCostosDTO> limitesCostosMaternidadDTO = new ArrayList<>();

	private List<SelectItem> parentescoItems;

	RamoAsistenciaMedica asistenciaMedica = new RamoAsistenciaMedica();
	private Usuario usuario;

	Logger log = Logger.getLogger(AsistenciaMedicaBacking.class);

	@PostConstruct
	public void inicializar() {
		try {
			usuario = usuarioBean.getSessionUser();

			Ramo ramo = ramoService.consultarRamoPorCodigo("AM");
			anexos = ramo.getDetalleAnexos();

			obtenerLimitesCostosBeneficios();
			obtenerLimitesCostosBenAdd();
			obtenerLimitesCostosMaternidad();

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener los Limites y Costos con titulo Beneficios del Ramo Asistencia Medica. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public void obtenerLimitesCostosBeneficios() throws HiperionException {
		limitesCostosBeneficios = new ArrayList<LimitesCostosAsm>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {

				Long idTitulo = ramoAstMedicaService.consultarIdTitulo(anexo.getIdDetalleAnexo());

				if (anexo.getAnexo().getIdAnexo() == 4 && idTitulo == 3) {
					LimitesCostosAsm limiteCosto = new LimitesCostosAsm();
					limiteCosto.setLimiteCosto(anexo.getNombreDetalleAnexo());

					limitesCostosBeneficios.add(limiteCosto);
				}
			}
			for (LimitesCostosAsm limite : limitesCostosBeneficios) {
				LimitesCostosDTO limiteDTO = new LimitesCostosDTO();
				limiteDTO.setLimitesCostos(limite.getLimiteCosto());
				limiteDTO.setSeleccion(false);

				limitesCostosBeneficiosDTO.add(limiteDTO);
			}
		}

	}

	/**
	 * 
	 * <b> Permite obtener los Limites y Costos con titulo Beneficios Add del Ramo Asistencia Medica </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 16/06/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void obtenerLimitesCostosBenAdd() throws HiperionException {
		limitesCostosBenAdd = new ArrayList<LimitesCostosAsm>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {

				Long idTitulo = ramoAstMedicaService.consultarIdTitulo(anexo.getIdDetalleAnexo());

				if (anexo.getAnexo().getIdAnexo() == 4 && idTitulo == 4) {

					LimitesCostosAsm limiteCosto = new LimitesCostosAsm();
					limiteCosto.setLimiteCosto(anexo.getNombreDetalleAnexo());

					limitesCostosBenAdd.add(limiteCosto);
				}
			}
			for (LimitesCostosAsm limite : limitesCostosBenAdd) {
				LimitesCostosDTO limiteDTO = new LimitesCostosDTO();
				limiteDTO.setLimitesCostos(limite.getLimiteCosto());
				limiteDTO.setSeleccion(false);

				limitesCostosBenAddDTO.add(limiteDTO);
			}
		}

	}

	/**
	 * 
	 * <b> Permite obtener los Limites y Costos con titulo de Materniadad del Ramo Asistencia Medica. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 16/06/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void obtenerLimitesCostosMaternidad() throws HiperionException {
		limitesCostosMaternidad = new ArrayList<LimitesCostosAsm>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {

				Long idTitulo = ramoAstMedicaService.consultarIdTitulo(anexo.getIdDetalleAnexo());

				if (anexo.getAnexo().getIdAnexo() == 4 && idTitulo == 5) {

					LimitesCostosAsm limiteCosto = new LimitesCostosAsm();
					limiteCosto.setLimiteCosto(anexo.getNombreDetalleAnexo());

					limitesCostosMaternidad.add(limiteCosto);
				}
			}
			for (LimitesCostosAsm limite : limitesCostosMaternidad) {
				LimitesCostosDTO limiteDTO = new LimitesCostosDTO();
				limiteDTO.setLimitesCostos(limite.getLimiteCosto());
				limiteDTO.setSeleccion(false);

				limitesCostosMaternidadDTO.add(limiteDTO);
			}
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
	 * <b> Permite guardar los datos del ramo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 25/07/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardar() throws HiperionException {
		try {

			Poliza poliza = setearDatosPoliza();

			asistenciaMedica.setTotalMensualGrupoAsm(ramoAsistenciaMedicaBean.getTotalMensualGrupo());
			asistenciaMedica.setIdUsuarioCreacion(usuario.getIdUsuario());
			asistenciaMedica.setFechaCreacion(new Date());
			asistenciaMedica.setEstado(EstadoEnum.A);

			ramoAstMedicaService.guardarRamoAsistenciaMedica(asistenciaMedica, poliza);

			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo accidentes personales", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));

			throw new HiperionException(e);
		}

	}

	/**
	 * 
	 * <b> Permite setear los beneficios. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 25/07/2015]
	 * </p>
	 * 
	 */
	public void setearBeneficios() {

		int contBeneficios = 0;
		List<LimitesCostosAsm> limites = new ArrayList<>();
		for (LimitesCostosDTO beneficioBTO : limitesCostosBeneficiosDTO) {
			if (beneficioBTO.getSeleccion()) {
				contBeneficios++;
				LimitesCostosAsm limiteCosto = new LimitesCostosAsm();
				limiteCosto.setLimiteCosto(beneficioBTO.getLimitesCostos());
				limiteCosto.setTipoLimite(1);

				limiteCosto.setEstado(EstadoEnum.A);
				limiteCosto.setFechaCreacion(new Date());
				limiteCosto.setIdUsuarioCreacion(usuario.getIdUsuario());

				limites.add(limiteCosto);
			}
		}
		if (contBeneficios == 0) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.beneficios"));
		} else {
			asistenciaMedica.setLimitesCostosAsms(limites);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.beneficios"));
		}
	}

	/**
	 * 
	 * <b> Permite setear los beneficios adicionales. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 25/07/2015]
	 * </p>
	 * 
	 */
	public void setearBeneficiosAdd() {

		int contBeneficios = 0;
		List<LimitesCostosAsm> limites = new ArrayList<>();
		for (LimitesCostosDTO beneficioBTO : limitesCostosBenAddDTO) {
			if (beneficioBTO.getSeleccion()) {
				contBeneficios++;
				LimitesCostosAsm limiteCosto = new LimitesCostosAsm();
				limiteCosto.setLimiteCosto(beneficioBTO.getLimitesCostos());
				limiteCosto.setTipoLimite(2);

				limiteCosto.setEstado(EstadoEnum.A);
				limiteCosto.setFechaCreacion(new Date());
				limiteCosto.setIdUsuarioCreacion(usuario.getIdUsuario());

				limites.add(limiteCosto);
			}
		}
		if (contBeneficios == 0) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.beneficiosAdd"));
		} else {
			for (LimitesCostosAsm limite : limites) {
				asistenciaMedica.getLimitesCostosAsms().add(limite);
			}
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.beneficiosAdd"));
		}

	}

	/**
	 * 
	 * <b> Permite setear los limites y costos de maternidad. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 25/07/2015]
	 * </p>
	 * 
	 */
	public void setearMaternidad() {

		int contMaternidad = 0;
		List<LimitesCostosAsm> limites = new ArrayList<>();
		for (LimitesCostosDTO beneficioBTO : limitesCostosMaternidadDTO) {
			if (beneficioBTO.getSeleccion()) {
				contMaternidad++;
				LimitesCostosAsm limiteCosto = new LimitesCostosAsm();
				limiteCosto.setLimiteCosto(beneficioBTO.getLimitesCostos());
				limiteCosto.setTipoLimite(3);

				limiteCosto.setEstado(EstadoEnum.A);
				limiteCosto.setFechaCreacion(new Date());
				limiteCosto.setIdUsuarioCreacion(usuario.getIdUsuario());

				limites.add(limiteCosto);
			}
		}
		if (contMaternidad == 0) {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.maternidad"));
		} else {
			for (LimitesCostosAsm limite : limites) {
				asistenciaMedica.getLimitesCostosAsms().add(limite);
			}
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.maternidad"));
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
	public void onEditBeneficios(RowEditEvent event) {

		FacesMessage msg = new FacesMessage("Item Edited", ((LimitesCostosDTO) event.getObject()).getLimitesCostos());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * @return the parentescoItems
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
	 * @param parentescoItems
	 *            the parentescoItems to set
	 */
	public void setParentescoItems(List<SelectItem> parentescoItems) {
		this.parentescoItems = parentescoItems;
	}

	/**
	 * @return the limitesCostosBeneficiosDTO
	 */
	public List<LimitesCostosDTO> getLimitesCostosBeneficiosDTO() {
		return limitesCostosBeneficiosDTO;
	}

	/**
	 * @param limitesCostosBeneficiosDTO
	 *            the limitesCostosBeneficiosDTO to set
	 */
	public void setLimitesCostosBeneficiosDTO(List<LimitesCostosDTO> limitesCostosBeneficiosDTO) {
		this.limitesCostosBeneficiosDTO = limitesCostosBeneficiosDTO;
	}

	/**
	 * @return the limitesCostosBenAddDTO
	 */
	public List<LimitesCostosDTO> getLimitesCostosBenAddDTO() {
		return limitesCostosBenAddDTO;
	}

	/**
	 * @param limitesCostosBenAddDTO
	 *            the limitesCostosBenAddDTO to set
	 */
	public void setLimitesCostosBenAddDTO(List<LimitesCostosDTO> limitesCostosBenAddDTO) {
		this.limitesCostosBenAddDTO = limitesCostosBenAddDTO;
	}

	/**
	 * @return the limitesCostosMaternidadDTO
	 */
	public List<LimitesCostosDTO> getLimitesCostosMaternidadDTO() {
		return limitesCostosMaternidadDTO;
	}

	/**
	 * @param limitesCostosMaternidadDTO
	 *            the limitesCostosMaternidadDTO to set
	 */
	public void setLimitesCostosMaternidadDTO(List<LimitesCostosDTO> limitesCostosMaternidadDTO) {
		this.limitesCostosMaternidadDTO = limitesCostosMaternidadDTO;
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
	 * @return the ramoAsistenciaMedicaBean
	 */
	public RamoAsistenciaMedicaBean getRamoAsistenciaMedicaBean() {
		return ramoAsistenciaMedicaBean;
	}

	/**
	 * @param ramoAsistenciaMedicaBean
	 *            the ramoAsistenciaMedicaBean to set
	 */
	public void setRamoAsistenciaMedicaBean(RamoAsistenciaMedicaBean ramoAsistenciaMedicaBean) {
		this.ramoAsistenciaMedicaBean = ramoAsistenciaMedicaBean;
	}

}
