package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.IngresarDatosSiniestroBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Cliente;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.ClienteService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.EmisionUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

@ManagedBean
@ViewScoped
public class SiniestrosBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ingresarDatosSiniestroBean}")
	private IngresarDatosSiniestroBean ingresarDatosSiniestroBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private ClienteService clienteService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	private List<Cliente> clientes;
	private List<Cliente> clientesObtenidos;

	Logger log = Logger.getLogger(SiniestrosBacking.class);

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
			ingresarDatosSiniestroBean.setNumerico(EmisionUtil.obtenerCodigoSiniestro(clientes.size() + 1));
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
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
	 * 
	 * <b> Permite buscar un cliente por medio del ingreso de la indetificacion. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 13/12/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void buscarCliente() throws HiperionException {
		try {
			clientesObtenidos = new ArrayList<>();

			if (!ingresarDatosSiniestroBean.getIdentificacion().equals("")) {
				Cliente clienteObtenido = clienteService.consultarClienteByIdentificacion(ingresarDatosSiniestroBean.getIdentificacion());
				if (clienteObtenido == null) {
					MessagesController.addWarn(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.warn.buscar"));
				} else {
					clientesObtenidos.add(clienteObtenido);
				}
			}

		} catch (HiperionException e) {
			log.error("Error al momento de buscar clientes", e);
			throw new HiperionException(e);
		}
	}

	/**
	 * @return the ingresarDatosSiniestroBean
	 */
	public IngresarDatosSiniestroBean getIngresarDatosSiniestroBean() {
		return ingresarDatosSiniestroBean;
	}

	/**
	 * @param ingresarDatosSiniestroBean
	 *            the ingresarDatosSiniestroBean to set
	 */
	public void setIngresarDatosSiniestroBean(IngresarDatosSiniestroBean ingresarDatosSiniestroBean) {
		this.ingresarDatosSiniestroBean = ingresarDatosSiniestroBean;
	}

}
