package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.ClienteBean;
import ec.com.avila.emision.web.beans.ContactoBean;
import ec.com.avila.emision.web.beans.DireccionBean;
import ec.com.avila.emision.web.validator.ValidatorCedula;
import ec.com.avila.emision.web.validator.ValidatorRuc;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.DireccionDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Direccion;
import ec.com.avila.hiperion.emision.entities.Provincia;
import ec.com.avila.hiperion.emision.entities.TipoDireccion;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.DireccionService;
import ec.com.avila.hiperion.servicio.ProvinciaService;
import ec.com.avila.hiperion.servicio.TipoDireccionService;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.EmisionUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

@ManagedBean
@ViewScoped
public class ClienteBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{clienteBean}")
	private ClienteBean clienteBean;

	@ManagedProperty(value = "#{direccionBean}")
	private DireccionBean direccionBean;

	@ManagedProperty(value = "#{contactoBean}")
	private ContactoBean contactoBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private ClienteService clienteService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;
	@EJB
	private TipoDireccionService tipoDireccionService;
	@EJB
	private ProvinciaService provinciaService;

	@EJB
	private DireccionService direccionService;

	private List<SelectItem> tipoPersonaItems;
	private List<SelectItem> tipoIdentificacionItems;

	private List<Cliente> clientes;
	private List<Cliente> clientesObtenidos;

	private boolean activarPanelPersonaNatural;
	private boolean activarPanelPersonaJuridica;
	private boolean activarPanelDireccionCobro;
	private boolean activarPanelDireccionDomicilio;
	private boolean activarPanelDireccionOficina;

	Logger log = Logger.getLogger(ClienteBacking.class);

	@PostConstruct
	public void inicializar() throws HiperionException {
		obtenerTipoIdentificacion();
	}

	/**
	 * 
	 * <b> Permite obtener el codigo de un nuevo cliente que se va a registrar en la Base de Avila. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 12/09/2014]
	 * </p>
	 * 
	 */
	public void obtenerCodigoCliente() {
		try {
			setClientes(clienteService.consultarClientes());
			clienteBean.setCodigoCliente(EmisionUtil.obtenerCodigoCliente(clientes.size() + 1));
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener la lista de Tipos de Persona registrados en el Sistema. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 19, 2014]
	 * </p>
	 * 
	 * @return - Tipos de Persona
	 * @throws HiperionException
	 */
	public List<SelectItem> getTipoPersonaItems() throws HiperionException {
		this.tipoPersonaItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(new Long(1));
		List<DetalleCatalogo> tiposPersona = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : tiposPersona) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tipoPersonaItems.add(selectItem);
		}

		return tipoPersonaItems;
	}

	/**
	 * 
	 * <b> Permite obtener los tipos de Identificaci&oacute;n de una persona Natural. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 13/09/2014]
	 * </p>
	 * 
	 * @return - Lista de Tipos de Identificaci&oacute;n.
	 */
	public List<SelectItem> obtenerTipoIdentificacion() {
		try {
			this.tipoIdentificacionItems = new ArrayList<SelectItem>();
			Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
					"ec.gob.avila.hiperion.recursos.catalogoTipoIdentificacion"));
			List<DetalleCatalogo> tiposPersona = catalogo.getDetalleCatalogos();

			for (DetalleCatalogo detalle : tiposPersona) {
				SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
				tipoIdentificacionItems.add(selectItem);
			}
		} catch (HiperionException ex) {
			ex.printStackTrace();
		}

		return tipoIdentificacionItems;
	}

	/**
	 * 
	 * <b> Permite validar el n&uacute;mero de caracteres de un campo seg&uacute;n el tipo de identificaci&oacute;n. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 19, 2014]
	 * </p>
	 * 
	 * @param tipoPersona
	 *            - Tipo de Persona: Natural o Juridica
	 */
	public void selectTipoPersona(Integer tipoPersona) {

		// Persona Natural
		if (tipoPersona == 1) {
			setActivarPanelPersonaNatural(true);
			setActivarPanelPersonaJuridica(false);
			clienteBean.setIdentificacion("");
			// Persona Juridica
		} else if (tipoPersona == 2) {
			clienteBean.setTipoIdentificacion("2");
			setActivarPanelPersonaJuridica(true);
			setActivarPanelPersonaNatural(false);
		}
	}

	/**
	 * 
	 * <b> Permite buscar cliente por medio de ingreso de parametros en la pantalla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 07/01/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void buscarCliente() throws HiperionException {
		try {
			clientesObtenidos = new ArrayList<>();

			if (!clienteBean.getIdentificacion().equals("")) {
				Cliente clienteObtenido = clienteService.consultarClienteByIdentificacion(clienteBean.getIdentificacion());
				if (clienteObtenido == null) {
					MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.buscar"));
				} else {
					clientesObtenidos.add(clienteObtenido);
				}
			} else {
				if (clienteBean.getNombre().equals("")) {
					MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.buscar"));
				} else {
					clientesObtenidos = clienteService.consultarClienteByApellido(clienteBean.getNombre());
				}
			}

		} catch (HiperionException e) {
			log.error("Error al momento de buscar clientes", e);
			throw new HiperionException(e);
		}
	}

	/**
	 * 
	 * <b> Permite Guardar a un Nuevo Cliente. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jan 21, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void guardarCliente() {
		try {

			Integer tipoIdentificacion = Integer.parseInt(clienteBean.getTipoIdentificacion());

			if (tipoIdentificacion == 2 && clienteBean.getIdentificacion().length() != 13) {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensage.error.tamanioRuc"));
			} else {

				if (validarDocumentos(clienteBean.getIdentificacion(), tipoIdentificacion)) {
					// Direccion del Cliente
					if (direccionBean.getDireccionesRegistradas() != null && direccionBean.getDireccionesRegistradas().size() > 0) {
						Cliente cliente = new Cliente();
						cliente.setCodigoCliente(clienteBean.getCodigoCliente());

						cliente.setTipoIdentificacion(clienteBean.getTipoIdentificacion());
						cliente.setIdentificacionPersona(clienteBean.getIdentificacion());
						// Tipo de Persona
						int tipoPersona = clienteBean.getTipoPersona();
						if (tipoPersona == 1) {
							// Persona Natural
							cliente.setIdentificacionPersona(clienteBean.getIdentificacion());
							cliente.setNombrePersona(clienteBean.getNombre());
							cliente.setApellidoPaterno(clienteBean.getApePaterno());
							cliente.setApellidoMaterno(clienteBean.getApeMaterno());
							cliente.setActividadProfesion(clienteBean.getActividadProfecion());
							cliente.setFechaNacimiento(clienteBean.getFechaNacimiento());
						} else {
							// Persona Juridica
							cliente.setRazonSocial(clienteBean.getRazonSocial());
						}
						cliente.setTipoPersona(clienteBean.getTipoPersona().toString());
						// Direcciones del Cliente
						List<Direccion> direcciones = new ArrayList<Direccion>();
						for (DireccionDTO direccionDto : direccionBean.getDireccionesRegistradas()) {
							Direccion direccion = new Direccion();
							direccion.setCliente(cliente);
							// Tipo Direccion
							TipoDireccion tipoDireccion = tipoDireccionService.consultarTipoDireccionByDescripcion(direccionDto.getTipoDireccion());
							direccion.setTipoDireccion(tipoDireccion);

							// Provincia
							Provincia provincia = provinciaService.consultarProvinciaPorCodigo(direccionDto.getProvinciaDTO().getCodProvincia());
							direccion.setProvincia(provincia);

							// Calles y Numeracion
							direccion.setCallePrincipal(direccionDto.getCallePrincipal());
							direccion.setNumeracion(direccionDto.getNumeracion());
							direccion.setCalleSecundaria(direccionDto.getCalleSecundaria());
							direccion.setReferencia(direccionDto.getReferencia());

							direcciones.add(direccion);
						}

						cliente.setDireccions(direcciones);
						// Guardamos al Cliente
						Usuario usuario = usuarioBean.getSessionUser();
						cliente.setIdUsuarioCreacion(usuario.getIdUsuario());
						cliente.setFechaCreacion(new Date());
						cliente.setEstado(EstadoEnum.A);
						clienteService.guardarCliente(cliente);
						MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.cliente"));
					} else {
						MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.direccion"));
					}
				} else {
					MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensage.error.identificacionNoValido"));
				}
			}

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite validar el numero de identificacion tanto para cedula como ruc </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 02/02/2015]
	 * </p>
	 * 
	 * @param identificacion
	 * @param tipoIdentificacion
	 * @return
	 */
	public Boolean validarDocumentos(String identificacion, Integer tipoIdentificacion) {
		Boolean pasaValidacion = false;

		if (clienteBean.getTipoPersona() == 1) {
			if (tipoIdentificacion == 1) {
				pasaValidacion = ValidatorCedula.getInstancia().validateCedula(identificacion);
			} else if (tipoIdentificacion == 2) {
				pasaValidacion = ValidatorRuc.getInstancia().validateRUC(identificacion);
			}
		}else{
			pasaValidacion = ValidatorRuc.getInstancia().validateRUC(identificacion);
		}

		return pasaValidacion;
	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	/**
	 * @return the direccionBean
	 */
	public DireccionBean getDireccionBean() {
		return direccionBean;
	}

	/**
	 * @param direccionBean
	 *            the direccionBean to set
	 */
	public void setDireccionBean(DireccionBean direccionBean) {
		this.direccionBean = direccionBean;
	}

	/**
	 * @return the contactoBean
	 */
	public ContactoBean getContactoBean() {
		return contactoBean;
	}

	/**
	 * @param contactoBean
	 *            the contactoBean to set
	 */
	public void setContactoBean(ContactoBean contactoBean) {
		this.contactoBean = contactoBean;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean getActivarPanelPersonaNatural() {
		return activarPanelPersonaNatural;
	}

	public void setActivarPanelPersonaNatural(boolean activarPanelPersonaNatural) {
		this.activarPanelPersonaNatural = activarPanelPersonaNatural;
	}

	public boolean getActivarPanelPersonaJuridica() {
		return activarPanelPersonaJuridica;
	}

	public void setActivarPanelPersonaJuridica(boolean activarPanelPersonaJuridica) {
		this.activarPanelPersonaJuridica = activarPanelPersonaJuridica;
	}

	/**
	 * @return the activarPanelDireccionDomicilio
	 */
	public boolean getActivarPanelDireccionDomicilio() {
		return activarPanelDireccionDomicilio;
	}

	/**
	 * @param activarPanelDireccionDomicilio
	 *            the activarPanelDireccionDomicilio to set
	 */
	public void setActivarPanelDireccionDomicilio(boolean activarPanelDireccionDomicilio) {
		this.activarPanelDireccionDomicilio = activarPanelDireccionDomicilio;
	}

	/**
	 * @return the activarPanelDireccionCobro
	 */
	public boolean getActivarPanelDireccionCobro() {
		return activarPanelDireccionCobro;
	}

	/**
	 * @param activarPanelDireccionCobro
	 *            the activarPanelDireccionCobro to set
	 */
	public void setActivarPanelDireccionCobro(boolean activarPanelDireccionCobro) {
		this.activarPanelDireccionCobro = activarPanelDireccionCobro;
	}

	/**
	 * @return the activarPanelDireccionOficina
	 */
	public boolean getActivarPanelDireccionOficina() {
		return activarPanelDireccionOficina;
	}

	/**
	 * @param activarPanelDireccionOficina
	 *            the activarPanelDireccionOficina to set
	 */
	public void setActivarPanelDireccionOficina(boolean activarPanelDireccionOficina) {
		this.activarPanelDireccionOficina = activarPanelDireccionOficina;
	}

	/**
	 * @return the clientesObtenidos
	 */
	public List<Cliente> getClientesObtenidos() {
		return clientesObtenidos;
	}

	/**
	 * @param clientesObtenidos
	 *            the clientesObtenidos to set
	 */
	public void setClientesObtenidos(List<Cliente> clientesObtenidos) {
		this.clientesObtenidos = clientesObtenidos;
	}

	/**
	 * @return the tipoIdentificacionItems
	 */
	public List<SelectItem> getTipoIdentificacionItems() {
		return tipoIdentificacionItems;
	}

	/**
	 * @param tipoIdentificacionItems
	 *            the tipoIdentificacionItems to set
	 */
	public void setTipoIdentificacionItems(List<SelectItem> tipoIdentificacionItems) {
		this.tipoIdentificacionItems = tipoIdentificacionItems;
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

}
