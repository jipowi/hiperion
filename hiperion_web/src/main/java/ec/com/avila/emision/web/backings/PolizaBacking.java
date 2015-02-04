/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.TablaAmortizacionDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.servicio.AseguradoraService;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.PolizaService;
import ec.com.avila.hiperion.servicio.UsuarioService;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b> Clase que�sirve�de�soporte�para�un�objeto manejado�dentro�de�la�aplicacion se�codifican�los�comportamientos
 * especificos�asociados�a�cada�control�del�Managed�Bean�representado�por�la�pagina</b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Dec 18, 2013
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class PolizaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{polizaBean}")
	private PolizaBean polizaBean;

	@EJB
	private PolizaService polizaService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private UsuarioService usuarioService;
	@EJB
	private ClienteService clienteService;
	@EJB
	private AseguradoraService aseguradoraService;

	private List<SelectItem> formasPagoItems;
	private List<SelectItem> tarjetasCreditoItems;
	private List<SelectItem> ramosItems;
	private List<SelectItem> cuotaIniacialItems;
	private List<SelectItem> pagoTarjetaItems;
	private List<SelectItem> bancoItems;
	private List<SelectItem> cuentaBancoItems;
	private List<SelectItem> pagoFinanciadoItems;
	private List<SelectItem> aseguradorasItems;
	private List<SelectItem> tarjetaCreditoItems;

	private Usuario ejecutivo;

	private List<TablaAmortizacionDTO> tablaAmortizacionList = new ArrayList<TablaAmortizacionDTO>();
	private Boolean activarPanelPagoContado = false;
	private Boolean activarPanelPagoFinanciado = false;
	private Boolean activarPanelPagoTarjetaCredito = false;
	private Boolean activarPanelPagoDebitoBancario = false;
	private Boolean activarDatosCliente = false;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	Logger log = Logger.getLogger(PolizaBacking.class);

	/**
	 * 
	 * <b> Permite visualizar el nombre del ejecutivo </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 12/01/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	@PostConstruct
	public void inicializar() throws HiperionException {
		Usuario usuario = usuarioBean.getSessionUser();
		ejecutivo = usuario;
	}

	/**
	 * 
	 * <b> Permite buscar un cliente por medi ode la cedula de identidad. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 02/02/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void buscarCliente() throws HiperionException {
		try {
			Cliente cliente = new Cliente();
			if (!polizaBean.getIdentificacion().equals("")) {
				cliente = clienteService.consultarClienteByIdentificacion(polizaBean.getIdentificacion());
				if (cliente == null) {
					MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.buscar"));
				} else {
					activarDatosCliente = true;
					polizaBean.setNombreCliente(cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno() + " " + cliente.getNombrePersona());
				}
			}

		} catch (HiperionException e) {
			log.error("Error al momento de buscar clientes", e);
			throw new HiperionException(e);
		}
	}

	/**
	 * 
	 * <b> Permite obtener una lista de formas de Pago. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Feb 2, 2014]
	 * </p>
	 * 
	 * @return - Lista de las Formas de Pago
	 * @throws HiperionException
	 */
	public List<SelectItem> getFormasPagoItems() throws HiperionException {
		this.formasPagoItems = new ArrayList<SelectItem>();
		// Busqueda por el Codigo de Formas de Pago (4)
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoFormasPago"));
		List<DetalleCatalogo> formasPago = catalogo.getDetalleCatalogos();
		for (DetalleCatalogo detalle : formasPago) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			formasPagoItems.add(selectItem);
		}

		return formasPagoItems;
	}

	/**
	 * 
	 * <b> Permite obtener una lista de las Tarjetas de Credito. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Feb 2, 2014]
	 * </p>
	 * 
	 * @return - Lista de nombres de Tarjetas de Credito
	 * @throws HiperionException
	 */
	public List<SelectItem> getTarjetasCreditoItems() throws HiperionException {
		this.tarjetasCreditoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(new Long(7));
		List<DetalleCatalogo> formasPago = catalogo.getDetalleCatalogos();
		for (DetalleCatalogo detalle : formasPago) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tarjetasCreditoItems.add(selectItem);
		}

		return tarjetasCreditoItems;
	}

	/**
	 * 
	 * <b> Lista de Ramos del Broker. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 25, 2014]
	 * </p>
	 * 
	 * @return - Lista de Ramos
	 * @throws HiperionException
	 */
	public List<SelectItem> getRamosItems() throws HiperionException {
		this.ramosItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(new Long(4));
		List<DetalleCatalogo> ramos = catalogo.getDetalleCatalogos();
		for (DetalleCatalogo detalle : ramos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			ramosItems.add(selectItem);
		}

		return ramosItems;
	}

	/**
	 * 
	 * <b> Permite activar los paneles segun la forma de pago que selecciono el usuario. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Feb 3, 2014]
	 * </p>
	 * 
	 */
	public void selectFormaDePago() {
		if (polizaBean.getIdFormaPago() == 1) {
			setActivarPanelPagoContado(true);
		} else if (polizaBean.getIdFormaPago() == 2) {
			setActivarPanelPagoFinanciado(true);
		} else if (polizaBean.getIdFormaPago() == 3) {
			setActivarPanelPagoTarjetaCredito(true);
		} else if (polizaBean.getIdFormaPago() == 4) {
			setActivarPanelPagoDebitoBancario(true);
		}
	}

	/**
	 * 
	 * <b> Permite generar una tabla de amortizacion con valores ingresados en la pantalla. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 15/01/2015]
	 * </p>
	 * 
	 */
	public void generarTablaAmortizacion() {

		tablaAmortizacionList = new ArrayList<>();

		Double total = polizaBean.getTotal().doubleValue();
		Double numDebitos = polizaBean.getNumeroDebitos().doubleValue();
		Double valorLetras = total / numDebitos;
		valorLetras = redondear(valorLetras, 2);
		polizaBean.setValorDebitos(new BigDecimal(valorLetras));

		int cont = 1;

		for (int i = 0; i < polizaBean.getNumeroDebitos(); i++) {

			TablaAmortizacionDTO tablaAmortizacionDTO = new TablaAmortizacionDTO();
			tablaAmortizacionDTO.setLetra("Letra " + cont);
			tablaAmortizacionDTO.setValor(valorLetras);

			tablaAmortizacionList.add(tablaAmortizacionDTO);
			cont++;
		}

	}

	public double redondear(double numero, int decimales) {
		return Math.round(numero * Math.pow(10, decimales)) / Math.pow(10, decimales);
	}

	/**
	 * 
	 * <b> Permite editar un registro de la tabla de amortizacion </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditTable(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((TablaAmortizacionDTO) event.getObject()).getLetra());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite calcular los valores de super de bancos y seguro campesino </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 22/01/2015]
	 * </p>
	 * 
	 */
	public void calcularValoresPago() {
		if (polizaBean.getPrimaNeta() != null) {
			Double valorSuperBan = redondear((polizaBean.getPrimaNeta() * 0.035), 2);
			Double seguroCampesino = redondear((polizaBean.getPrimaNeta() * 0.005), 2);

			polizaBean.setSuperBanSeguros(BigDecimal.valueOf(valorSuperBan));
			polizaBean.setSeguroCampesino(seguroCampesino);
		}
	}

	public PolizaBean getPolizaBean() {
		return polizaBean;
	}

	public void setPolizaBean(PolizaBean polizaBean) {
		this.polizaBean = polizaBean;
	}

	/**
	 * @return the activarPanelPagoContado
	 */
	public Boolean getActivarPanelPagoContado() {
		return activarPanelPagoContado;
	}

	/**
	 * @param activarPanelPagoContado
	 *            the activarPanelPagoContado to set
	 */
	public void setActivarPanelPagoContado(Boolean activarPanelPagoContado) {
		this.activarPanelPagoContado = activarPanelPagoContado;
	}

	/**
	 * @return the activarPanelPagoFinanciado
	 */
	public Boolean getActivarPanelPagoFinanciado() {
		return activarPanelPagoFinanciado;
	}

	/**
	 * @param activarPanelPagoFinanciado
	 *            the activarPanelPagoFinanciado to set
	 */
	public void setActivarPanelPagoFinanciado(Boolean activarPanelPagoFinanciado) {
		this.activarPanelPagoFinanciado = activarPanelPagoFinanciado;
	}

	/**
	 * @return the activarPanelPagoTarjetaCredito
	 */
	public Boolean getActivarPanelPagoTarjetaCredito() {
		return activarPanelPagoTarjetaCredito;
	}

	/**
	 * @param activarPanelPagoTarjetaCredito
	 *            the activarPanelPagoTarjetaCredito to set
	 */
	public void setActivarPanelPagoTarjetaCredito(Boolean activarPanelPagoTarjetaCredito) {
		this.activarPanelPagoTarjetaCredito = activarPanelPagoTarjetaCredito;
	}

	/**
	 * @return the activarPanelPagoDebitoBancario
	 */
	public Boolean getActivarPanelPagoDebitoBancario() {
		return activarPanelPagoDebitoBancario;
	}

	/**
	 * @param activarPanelPagoDebitoBancario
	 *            the activarPanelPagoDebitoBancario to set
	 */
	public void setActivarPanelPagoDebitoBancario(Boolean activarPanelPagoDebitoBancario) {
		this.activarPanelPagoDebitoBancario = activarPanelPagoDebitoBancario;
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
	 * @return the ejecutivo
	 */
	public Usuario getEjecutivo() {
		return ejecutivo;
	}

	/**
	 * @param ejecutivo
	 *            the ejecutivo to set
	 */
	public void setEjecutivo(Usuario ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	/**
	 * 
	 * <b> Crea el metodo combo cuota inicial </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 14/01/2015]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getCuotaIniacialItems() throws HiperionException {
		this.cuotaIniacialItems = new ArrayList<SelectItem>();

		SelectItem selectItem20 = new SelectItem(1, "20%");
		cuotaIniacialItems.add(selectItem20);
		SelectItem selectItem30 = new SelectItem(2, "30%");
		cuotaIniacialItems.add(selectItem30);
		return cuotaIniacialItems;
	}

	/**
	 * @param cuotaIniacialItems
	 *            the cuotaIniacialItems to set
	 */
	public void setCuotaIniacialItems(List<SelectItem> cuotaIniacialItems) {
		this.cuotaIniacialItems = cuotaIniacialItems;
	}

	/**
	 * @return the pagoTarjetaItems
	 */
	public List<SelectItem> getPagoTarjetaItems() throws HiperionException {
		this.pagoTarjetaItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoPagoTarjeta"));
		List<DetalleCatalogo> pagoTarjeta = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : pagoTarjeta) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			pagoTarjetaItems.add(selectItem);
		}

		return pagoTarjetaItems;
	}

	/**
	 * 
	 * <b> metodo que epermite crear el combo pago tarjeta </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 14/01/2015]
	 * </p>
	 * 
	 * @param pagoTarjetaItems
	 * @throws HiperionException
	 */
	public void setPagoTarjetaItems(List<SelectItem> pagoTarjetaItems) throws HiperionException {
		this.pagoTarjetaItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoPagoTarjeta"));
		List<DetalleCatalogo> pagoTarjeta = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : pagoTarjeta) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			pagoTarjetaItems.add(selectItem);
		}

		this.pagoTarjetaItems = pagoTarjetaItems;
	}

	/**
	 * 
	 * <b> metodo que crea el combo de bancos. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 14/01/2015]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getBancoItems() throws HiperionException {
		this.bancoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoBancos"));
		List<DetalleCatalogo> banco = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : banco) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			bancoItems.add(selectItem);
		}
		return bancoItems;
	}

	/**
	 * @param bancoItems
	 *            the bancoItems to set
	 */
	public void setBancoItems(List<SelectItem> bancoItems) {
		this.bancoItems = bancoItems;
	}

	/**
	 * 
	 * <b> Permite crear el combo de tipo de cuenta </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 14/01/2015]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getCuentaBancoItems() throws HiperionException {
		this.cuentaBancoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoCuentaBanco"));
		List<DetalleCatalogo> cuentaBanco = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : cuentaBanco) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			cuentaBancoItems.add(selectItem);
		}
		return cuentaBancoItems;
	}

	/**
	 * @return the pagoFinanciadoItems
	 */
	public List<SelectItem> getPagoFinanciadoItems() throws HiperionException {
		this.pagoFinanciadoItems = new ArrayList<SelectItem>();

		for (int i = 1; i <= 12; i++) {

			SelectItem pago = new SelectItem();
			pago = new SelectItem(i, "" + i);
			pagoFinanciadoItems.add(pago);

		}

		return pagoFinanciadoItems;
	}

	/**
	 * @param pagoFinanciadoItems
	 *            the pagoFinanciadoItems to set
	 */
	public void setPagoFinanciadoItems(List<SelectItem> pagoFinanciadoItems) {
		this.pagoFinanciadoItems = pagoFinanciadoItems;
	}

	/**
	 * @param cuentaBancoItems
	 *            the cuentaBancoItems to set
	 */
	public void setCuentaBancoItems(List<SelectItem> cuentaBancoItems) {
		this.cuentaBancoItems = cuentaBancoItems;
	}

	/**
	 * @return the tablaAmortizacionList
	 */
	public List<TablaAmortizacionDTO> getTablaAmortizacionList() {
		return tablaAmortizacionList;
	}

	/**
	 * @param tablaAmortizacionList
	 *            the tablaAmortizacionList to set
	 */
	public void setTablaAmortizacionList(List<TablaAmortizacionDTO> tablaAmortizacionList) {
		this.tablaAmortizacionList = tablaAmortizacionList;
	}

	/**
	 * 
	 * <b> Metodo que me permite generar el combo de tarjetas de credito. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 03/02/2015]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getTarjetaCreditoItems() throws HiperionException {
		this.tarjetaCreditoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoTipoTarjetaCredito"));

		List<DetalleCatalogo> tarjetaCredito = catalogo.getDetalleCatalogos();
		for (DetalleCatalogo detalle : tarjetaCredito) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tarjetaCreditoItems.add(selectItem);
		}
		return tarjetaCreditoItems;
	}

	/**
	 * @param tarjetaCreditoItems
	 *            the tarjetaCreditoItems to set
	 */
	public void setTarjetaCreditoItems(List<SelectItem> tarjetaCreditoItems) {
		this.tarjetaCreditoItems = tarjetaCreditoItems;
	}

	/**
	 * @return the aseguradorasItems
	 */
	public List<SelectItem> getAseguradorasItems() throws HiperionException {

		this.aseguradorasItems = new ArrayList<SelectItem>();

		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoAseguradoras"));

		List<DetalleCatalogo> aseguradoras = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : aseguradoras) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			aseguradorasItems.add(selectItem);
		}

		return aseguradorasItems;
	}

	/**
	 * @param aseguradorasItems
	 *            the aseguradorasItems to set
	 */
	public void setAseguradorasItems(List<SelectItem> aseguradorasItems) {
		this.aseguradorasItems = aseguradorasItems;
	}

	/**
	 * @return the activarDatosCliente
	 */
	public Boolean getActivarDatosCliente() {
		return activarDatosCliente;
	}

	/**
	 * @param activarDatosCliente
	 *            the activarDatosCliente to set
	 */
	public void setActivarDatosCliente(Boolean activarDatosCliente) {
		this.activarDatosCliente = activarDatosCliente;
	}

}