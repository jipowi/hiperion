package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.RamoVehiculoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ClausulaAdicionalDTO;
import ec.com.avila.hiperion.dto.CondicionEspecialDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.ClausulasAddVh;
import ec.com.avila.hiperion.emision.entities.CondEspVh;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoVehiculo;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.servicio.RamoVehiculoService;
import ec.com.avila.hiperion.web.beans.MarcasDto;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informacion que se maneje en las paginas web que utilicen el Ramo Vehiculo. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class VehiculosBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoVehiculoBean}")
	private RamoVehiculoBean ramoVehiculoBean;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	@EJB
	private RamoVehiculoService ramoVehiculoService;

	@EJB
	private RamoService ramoService;

	Logger log = Logger.getLogger(VehiculosBacking.class);

	RamoVehiculo ramoVehiculo = new RamoVehiculo();

	private List<SelectItem> tipoVehiculoItems;
	private List<SelectItem> claseVehiculoItems;
	private List<SelectItem> usoVehiculoItems;
	private List<SelectItem> modeloItems;
	private List<DetalleAnexo> anexos;
	private List<ClausulasAddVh> clausulasAdicionales;
	private List<ClausulaAdicionalDTO> clausulasAdicionalesDTO = new ArrayList<>();
	private List<CondEspVh> condicionesEspeciales;
	private List<CondicionEspecialDTO> condicionesEspecialesDTO = new ArrayList<>();

	private Boolean activarMarcaAuto;
	private Boolean activarMarcaPesado;
	private Boolean activarMarcaMoto;

	@PostConstruct
	public void inicializar() {
		try {

			Ramo ramo = ramoService.consultarRamoPorCodigo("VH");

			anexos = ramo.getDetalleAnexos();

			obtenerClausulasAdicionales();
			obtenerCondicionesEspeciales();

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las clausulas adicionales del ramo Vehiculos. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 17/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerClausulasAdicionales() {
		clausulasAdicionales = new ArrayList<ClausulasAddVh>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1) {
					ClausulasAddVh clausula = new ClausulasAddVh();
					clausula.setClausulaAddVh(anexo.getNombreDetalleAnexo());

					clausulasAdicionales.add(clausula);
				}

			}
			for (ClausulasAddVh clausula : clausulasAdicionales) {
				ClausulaAdicionalDTO clausulaDTO = new ClausulaAdicionalDTO();
				clausulaDTO.setClausula(clausula.getClausulaAddVh());
				clausulaDTO.setSeleccion(false);

				clausulasAdicionalesDTO.add(clausulaDTO);
			}

		}

	}

	/**
	 * 
	 * <b> Permite obtener las condiciones especiales del ramo Vehiculos. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 17/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerCondicionesEspeciales() {
		condicionesEspeciales = new ArrayList<CondEspVh>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3) {
					CondEspVh condicion = new CondEspVh();
					condicion.setCondicionEspVh(anexo.getNombreDetalleAnexo());

					condicionesEspeciales.add(condicion);
				}

			}
			for (CondEspVh condicion : condicionesEspeciales) {
				CondicionEspecialDTO condicionDTO = new CondicionEspecialDTO();
				condicionDTO.setCondicionEspecial(condicion.getCondicionEspVh());
				condicionDTO.setSeleccion(false);

				condicionesEspecialesDTO.add(condicionDTO);
			}

		}

	}

	/**
	 * 
	 * <b> Permite guardar objetos en el Ramo Vehiculos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 12/09/2014]
	 * </p>
	 * 
	 */
	public void guardarRamo() throws HiperionException {
		Usuario usuario = usuarioBean.getSessionUser();

		ramoVehiculo.setClaseVh(ramoVehiculoBean.getClaseVehiculo());
		ramoVehiculo.setTipoVh(ramoVehiculoBean.getTipoVehiculo());
		ramoVehiculo.setUsoVh(ramoVehiculoBean.getUso());
		ramoVehiculo.setModeloVh(ramoVehiculoBean.getModelo());
		ramoVehiculo.setDetalleModeloVh(ramoVehiculoBean.getDetalleModelo());
		ramoVehiculo.setItemVh(ramoVehiculoBean.getItem());
		ramoVehiculo.setPropietarioVh(ramoVehiculoBean.getPropietario());
		ramoVehiculo.setPlacaVh(ramoVehiculoBean.getPlaca());
		ramoVehiculo.setMotorVh(ramoVehiculoBean.getMotor());
		ramoVehiculo.setChasisVh(ramoVehiculoBean.getChasis());
		ramoVehiculo.setAnioFabricaccionVh(ramoVehiculoBean.getAnio());
		ramoVehiculo.setColorVh(ramoVehiculoBean.getColor());
		ramoVehiculo.setValorAsegVh(ramoVehiculoBean.getValorAsegurado());
		ramoVehiculo.setValorTotalItemsVh(ramoVehiculoBean.getValorTotalItem());
		ramoVehiculo.setTasaVh(ramoVehiculoBean.getTasa());
		ramoVehiculo.setConsideracionesImpVh(ramoVehiculoBean.getConsideraciones());
		ramoVehiculo.setAmparoPatrimonialVh(ramoVehiculoBean.getAmparoPatrimonial());
		ramoVehiculo.setCoberturaPactoAndino(ramoVehiculoBean.getCoberturaPactoAndino());
		ramoVehiculo.setAsistenciaVehicular(ramoVehiculoBean.getAsistenciaVehicular());
		ramoVehiculo.setAutoSustituto(ramoVehiculoBean.getAutoSustituto());
		ramoVehiculo.setDeducPorcentajeVh(ramoVehiculoBean.getPorcentajeDeducible());
		ramoVehiculo.setDeducSiniestroVh(ramoVehiculoBean.getPorcentajeSiniestro());
		ramoVehiculo.setDeducValorAsegVh(ramoVehiculoBean.getPorcentajeValorAsegurado());

		ramoVehiculo.setIdUsuarioCreacion(usuario.getIdUsuario());
		ramoVehiculo.setFechaCreacion(new Date());
		ramoVehiculo.setEstado(EstadoEnum.A);

		try {
			ramoVehiculoService.guardarRamoVehiculo(ramoVehiculo);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.sOjeto"));

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el Ramo Vehículos", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));
			throw new HiperionException(e);

		}
	}

	/**
	 * 
	 * <b> Permite presentar en la pantalla el la lista de marcas dependiento de la clase de vehiculo seleccionada </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 22, 2014]
	 * </p>
	 * 
	 */
	public void selectClaseVehiculo() {
		if (ramoVehiculoBean.getClaseVehiculo().equals("LIVIANO")) {
			activarMarcaAuto = true;
			activarMarcaPesado = false;
			activarMarcaMoto = false;
		}
		if (ramoVehiculoBean.getClaseVehiculo().equals("PESADO")) {
			activarMarcaPesado = true;
			activarMarcaAuto = false;
			activarMarcaMoto = false;
		}
		if (ramoVehiculoBean.getClaseVehiculo().equals("MOTO")) {
			activarMarcaMoto = true;
			activarMarcaAuto = false;
			activarMarcaPesado = false;
		}
	}

	/**
	 * 
	 * <b> Permite obtener los tipos de vehiculo</b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 15, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getTipoVehiculoItems() throws HiperionException {

		this.tipoVehiculoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoTipoVehiculo"));
		List<DetalleCatalogo> tipos = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : tipos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tipoVehiculoItems.add(selectItem);
		}

		return tipoVehiculoItems;
	}

	/**
	 * @param tipoVehiculoItems
	 *            the tipoVehiculoItems to set
	 */
	public void setTipoVehiculoItems(List<SelectItem> tipoVehiculoItems) {
		this.tipoVehiculoItems = tipoVehiculoItems;
	}

	/**
	 * 
	 * <b> Permite obtener las clases de vehiculos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 15, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getClaseVehiculoItems() throws HiperionException {

		this.claseVehiculoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoClaseVehiculo"));
		List<DetalleCatalogo> clases = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : clases) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			claseVehiculoItems.add(selectItem);
		}

		return claseVehiculoItems;
	}

	/**
	 * 
	 * <b> Permite obtener el modelo correspondiente a la marca seleccionada </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 28, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */

	public void obtenerModelo(MarcasDto selectedMarca) throws HiperionException {

		this.modeloItems = new ArrayList<SelectItem>();

		List<DetalleCatalogo> catalogos = new ArrayList<DetalleCatalogo>();

		if (ramoVehiculoBean.getClaseVehiculo().equals("LIVIANO"))
			catalogos = detalleCatalogoService.consultarDetalleCatalogoByCodDetalle(selectedMarca.getMarca(), HiperionMensajes.getInstancia()
					.getLong("ec.gob.avila.hiperion.recursos.catalogoModeloVehiculoLiviano"));

		if (ramoVehiculoBean.getClaseVehiculo().equals("PESADO"))
			catalogos = detalleCatalogoService.consultarDetalleCatalogoByCodDetalle(selectedMarca.getMarca(), HiperionMensajes.getInstancia()
					.getLong("ec.gob.avila.hiperion.recursos.catalogoModeloVehiculoPesado"));

		if (ramoVehiculoBean.getClaseVehiculo().equals("MOTO"))
			catalogos = detalleCatalogoService.consultarDetalleCatalogoByCodDetalle(selectedMarca.getMarca(), HiperionMensajes.getInstancia()
					.getLong("ec.gob.avila.hiperion.recursos.catalogoModeloVehiculoMoto"));

		for (DetalleCatalogo detalle : catalogos) {
			SelectItem selectItem = new SelectItem(detalle.getIdDetalleCatalogo(), detalle.getDescDetCatalogo());
			modeloItems.add(selectItem);
		}

	}

	/**
	 * @return the modeloItems
	 */
	public List<SelectItem> getModeloItems() {
		return modeloItems;
	}

	/**
	 * @param modeloItems
	 *            the modeloItems to set
	 */
	public void setModeloItems(List<SelectItem> modeloItems) {
		this.modeloItems = modeloItems;
	}

	/**
	 * @param claseVehiculoItems
	 *            the claseVehiculoItems to set
	 */
	public void setClaseVehiculoItems(List<SelectItem> claseVehiculoItems) {
		this.claseVehiculoItems = claseVehiculoItems;
	}

	/**
	 * 
	 * <b> Permite obtener los usos del vehiculo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 15, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getUsoVehiculoItems() throws HiperionException {

		this.usoVehiculoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoUsoVehiculo"));
		List<DetalleCatalogo> usos = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : usos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			usoVehiculoItems.add(selectItem);
		}

		return usoVehiculoItems;
	}

	/**
	 * @param usoVehiculoItems
	 *            the usoVehiculoItems to set
	 */
	public void setUsoVehiculoItems(List<SelectItem> usoVehiculoItems) {
		this.usoVehiculoItems = usoVehiculoItems;
	}

	/**
	 * @return the activarMarcaAuto
	 */
	public Boolean getActivarMarcaAuto() {
		return activarMarcaAuto;
	}

	/**
	 * @param activarMarcaAuto
	 *            the activarMarcaAuto to set
	 */
	public void setActivarMarcaAuto(Boolean activarMarcaAuto) {
		this.activarMarcaAuto = activarMarcaAuto;
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
	 * @return the activarMarcaPesado
	 */
	public Boolean getActivarMarcaPesado() {
		return activarMarcaPesado;
	}

	/**
	 * @param activarMarcaPesado
	 *            the activarMarcaPesado to set
	 */
	public void setActivarMarcaPesado(Boolean activarMarcaPesado) {
		this.activarMarcaPesado = activarMarcaPesado;
	}

	/**
	 * @return the activarMarcaMoto
	 */
	public Boolean getActivarMarcaMoto() {
		return activarMarcaMoto;
	}

	/**
	 * @param activarMarcaMoto
	 *            the activarMarcaMoto to set
	 */
	public void setActivarMarcaMoto(Boolean activarMarcaMoto) {
		this.activarMarcaMoto = activarMarcaMoto;
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
	 * @return the ramoVehiculoBean
	 */
	public RamoVehiculoBean getRamoVehiculoBean() {
		return ramoVehiculoBean;
	}

	/**
	 * @param ramoVehiculoBean
	 *            the ramoVehiculoBean to set
	 */
	public void setRamoVehiculoBean(RamoVehiculoBean ramoVehiculoBean) {
		this.ramoVehiculoBean = ramoVehiculoBean;
	}

	/**
	 * 
	 * <b> Permite generar y descargar el documento PDF </b>
	 * <p>
	 * [Author: Franklin Poz B, Date: 07/06/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descargarVehiculosPDF() throws HiperionException {
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarArchivoPDFVehiculos(ramoVehiculo));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		} catch (Exception e) {
			log.error("Error al momento generar el documento Vehiculos en PDF", e);
			throw new HiperionException(e);
		}

	}

	/**
	 * @return the clausulasAdicionales
	 */
	public List<ClausulasAddVh> getClausulasAdicionales() {
		return clausulasAdicionales;
	}

	/**
	 * @param clausulasAdicionales
	 *            the clausulasAdicionales to set
	 */
	public void setClausulasAdicionales(List<ClausulasAddVh> clausulasAdicionales) {
		this.clausulasAdicionales = clausulasAdicionales;
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
	 * @return the condicionesEspeciales
	 */
	public List<CondEspVh> getCondicionesEspeciales() {
		return condicionesEspeciales;
	}

	/**
	 * @param condicionesEspeciales
	 *            the condicionesEspeciales to set
	 */
	public void setCondicionesEspeciales(List<CondEspVh> condicionesEspeciales) {
		this.condicionesEspeciales = condicionesEspeciales;
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

}