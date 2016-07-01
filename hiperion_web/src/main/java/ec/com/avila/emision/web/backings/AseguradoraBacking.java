/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import ec.com.avila.emision.web.beans.AseguradoraBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.PersonaContactoAseguradoraDTO;
import ec.com.avila.hiperion.emision.entities.Aseguradora;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.emision.entities.Contacto;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.AseguradoraService;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.servlet.ReportServlet;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>permite manejar las operaciones necesarias para manejar la logica de las aseguradoras</b>
 * 
 * @author kruger
 * @version 1.0,Dec 21, 2013
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class AseguradoraBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{aseguradoraBean}")
	private AseguradoraBean aseguradoraBean;

	@EJB
	private AseguradoraService aseguradoraService;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	private List<SelectItem> aseguradorasItems;

	@Resource(mappedName = "java:/AvilaSgsDS")
	private DataSource dataSource;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	private String rutaReporte;

	@PostConstruct
	public void inicializar() throws HiperionException {
		// consultarAseguradoras();
	}

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Dec 1, 2014]
	 * </p>
	 * 
	 * @throws SQLException
	 * 
	 */
	public void cargarReporte(String tipoReporte) throws SQLException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		Map<String, Object> parametros = new HashMap<String, Object>();
		if (tipoReporte.equals("pdf"))
			parametros.put("TIPO_REPORTE", "pdf");
		else
			parametros.put("TIPO_REPORTE", "excel");

		request.getSession().setAttribute(ReportServlet.OBJETO_REPORTE, parametros);
	}

	/**
	 * 
	 * <b> Permite guardar una aseguradora en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 10, 2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarAseguradora() throws HiperionException {
		Usuario usuario = usuarioBean.getSessionUser();
		boolean save = false;
		Aseguradora aseguradora = aseguradoraService.consultarAseguradoraByCodigo(aseguradoraBean.getCodAseguradora().toString());

		if (aseguradora == null) {
			save = true;
		}

		aseguradora.setCodigoAseguradora(aseguradoraBean.getCodAseguradora().toString());
		aseguradora.setDirecion(aseguradoraBean.getDireccion());
		aseguradora.setEmailAseguradora(aseguradoraBean.getMailAseguradora());
		aseguradora.setRuc(aseguradoraBean.getRuc());
		aseguradora.setTelfConvencionalAseg((aseguradoraBean.getTelefono()));
		aseguradora.setIdUsuarioCreacion(usuario.getIdUsuario());
		aseguradora.setFechaCreacion(new Date());
		aseguradora.setEstado(EstadoEnum.A);

		if (aseguradoraBean.getContactoList() != null) {
			List<Cliente> contactosAseguradora = new ArrayList<>();

			for (PersonaContactoAseguradoraDTO contactoAseguradora : aseguradoraBean.getContactoList()) {

				Cliente persona = new Cliente();

				persona.setNombrePersona(contactoAseguradora.getNombre());
				persona.setApellidoPaterno(contactoAseguradora.getApellidoPaterno());
				persona.setApellidoMaterno(contactoAseguradora.getApellidoMaterno());
				persona.setIdentificacionPersona(contactoAseguradora.getIdentificacion());
				persona.setActividadProfesion(contactoAseguradora.getCargo());
				persona.setIdUsuarioCreacion(usuario.getIdUsuario());
				persona.setFechaCreacion(new Date());
				persona.setEstado(EstadoEnum.A);

				Contacto contactoTelefono = new Contacto();
				contactoTelefono.setTipoContacto("TELEFONO");
				contactoTelefono.setDescripcionContacto(contactoAseguradora.getTelefonoContacto());

				Contacto contactoMail = new Contacto();
				contactoMail.setTipoContacto("MAIL");
				contactoMail.setDescripcionContacto(contactoAseguradora.getEmail());

				List<Contacto> contactos = new ArrayList<Contacto>();

				contactos.add(contactoTelefono);
				contactos.add(contactoMail);

				persona.setContactos(contactos);

				contactosAseguradora.add(persona);
			}

			aseguradoraService.guardarAseguradora(aseguradora, contactosAseguradora, save);

			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.aseguradora"));
			aseguradoraBean.setContactoList(null);
			aseguradora = new Aseguradora();
			contactosAseguradora = new ArrayList<>();
		} else {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("Es necesario agregar contactos para la aseguradora"));
		}
	}

	/**
	 * 
	 * <b> Permite consultar las aseguradoras ingresadas en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 17, 2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void consultarAseguradoras() throws HiperionException {

		Aseguradora aseguradora = aseguradoraService.consultarAseguradoraByRucAseg(aseguradoraBean.getRuc(), aseguradoraBean.getCodAseguradora());
		if (aseguradora != null) {

			aseguradoraBean.setRuc(aseguradora.getRuc());
			aseguradoraBean.setDireccion(aseguradora.getDirecion());
			aseguradoraBean.setMailAseguradora(aseguradora.getEmailAseguradora());
			aseguradoraBean.setTelefono(aseguradora.getTelfConvencionalAseg());

			aseguradoraBean.setActivarNewAseguradora(true);
			
			//Obtener contactos de la aseguradora seleccionada
			List<Cliente> clientesAseguradora = aseguradoraService.consultarClienteByAseguradora(aseguradora.getCodigoAseguradora());
			List<PersonaContactoAseguradoraDTO> contactos = new ArrayList<>();
			
			for (Cliente cliente : clientesAseguradora) {
				PersonaContactoAseguradoraDTO personaDTO = new PersonaContactoAseguradoraDTO();
				
				personaDTO.setNombre(cliente.getNombrePersona());
				personaDTO.setIdentificacion(cliente.getIdentificacionPersona());
				personaDTO.setApellidoPaterno(cliente.getApellidoPaterno());
				personaDTO.setApellidoMaterno(cliente.getApellidoMaterno());
				personaDTO.setCargo(cliente.getActividadProfesion());
				
				contactos.add(personaDTO);
			}
			
			aseguradoraBean.setContactoList(contactos);
		} else {
			MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.war.aseguradora"));
			aseguradoraBean.setActivarNewAseguradora(true);
		}
	}

	/**
	 * 
	 * <b> Permite activar la pantalla para crear una nueva aseguradora </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 18, 2014]
	 * </p>
	 * 
	 */
	public void crearAseguradora() {
		aseguradoraBean.setActivarNewAseguradora(true);
	}

	/**
	 * @return the aseguradoraBean
	 */
	public AseguradoraBean getAseguradoraBean() {
		return aseguradoraBean;
	}

	/**
	 * @param aseguradoraBean
	 *            the aseguradoraBean to set
	 */
	public void setAseguradoraBean(AseguradoraBean aseguradoraBean) {
		this.aseguradoraBean = aseguradoraBean;
	}

	/**
	 * @return the aseguradorasItems
	 * @throws HiperionException
	 */
	public List<SelectItem> getAseguradorasItems() throws HiperionException {

		if (this.aseguradorasItems == null) {
			this.aseguradorasItems = new ArrayList<SelectItem>();
		}

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
	 * @return the rutaReporte
	 */
	public String getRutaReporte() {
		return rutaReporte;
	}

	/**
	 * @param rutaReporte
	 *            the rutaReporte to set
	 */
	public void setRutaReporte(String rutaReporte) {
		this.rutaReporte = rutaReporte;
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
