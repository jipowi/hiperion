package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import ec.com.avila.emision.web.beans.DireccionBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.CantonDTO;
import ec.com.avila.hiperion.dto.DireccionDTO;
import ec.com.avila.hiperion.dto.ParroquiaDTO;
import ec.com.avila.hiperion.dto.ProvinciaDTO;
import ec.com.avila.hiperion.emision.entities.Canton;
import ec.com.avila.hiperion.emision.entities.Parroquia;
import ec.com.avila.hiperion.emision.entities.Provincia;
import ec.com.avila.hiperion.emision.entities.TipoDireccion;
import ec.com.avila.hiperion.servicio.CantonService;
import ec.com.avila.hiperion.servicio.ParroquiaService;
import ec.com.avila.hiperion.servicio.ProvinciaService;
import ec.com.avila.hiperion.servicio.TipoDireccionService;

@ManagedBean(name = "direccionBacking")
@ViewScoped
public class DireccionBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{direccionBean}")
	private DireccionBean direccionBean;

	@EJB
	private TipoDireccionService tipoDireccionService;
	@EJB
	private ProvinciaService provinciaService;
	@EJB
	private CantonService cantonService;
	@EJB
	private ParroquiaService parroquiaService;

	private List<ProvinciaDTO> provinciasDTO;
	private List<CantonDTO> cantonesDTO;
	private List<ParroquiaDTO> parroquiasDTO;
	private List<DireccionDTO> direcciones;
	private List<SelectItem> tipoDireccionItems;

	private DireccionDTO direccionDto;

	@PostConstruct
	public void inicializar() {
		setDirecciones(new ArrayList<DireccionDTO>());
		direccionBean.setDireccionesRegistradas(new ArrayList<DireccionDTO>());
		obtenerTiposDireccion();
	}

	public void obtenerProvincias() {
		try {
			this.provinciasDTO = new ArrayList<ProvinciaDTO>();
			List<Provincia> provincias = provinciaService.consultarProvincias();

			if (provincias != null && provincias.size() > 0) {
				for (Provincia provincia : provincias) {
					ProvinciaDTO provinciaDto = new ProvinciaDTO(provincia.getCodigo(), provincia.getNombreProvincia());
					provinciasDTO.add(provinciaDto);
				}

				ProvinciaDTO provinciaDto = provinciasDTO.get(0);
				direccionBean.setProvinciaDTO(provinciaDto);
				obtenerCantonesPorProvincia();
			}
		} catch (HiperionException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener los Cantones por Provincia del Ecuador, en base a la Provincia seleccionada. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/08/2014]
	 * </p>
	 * 
	 */
	public void obtenerCantonesPorProvincia() {
		try {
			this.cantonesDTO = new ArrayList<CantonDTO>();
			if (direccionBean.getProvinciaDTO() != null) {
				List<Canton> cantones = cantonService.consultarCantonesPorProvincia(direccionBean.getProvinciaDTO().getCodProvincia());

				if (cantones != null && cantones.size() > 0) {
					for (Canton canton : cantones) {
						CantonDTO cantonDto = new CantonDTO(canton.getIdCanton(), canton.getNombreCanton());
						cantonesDTO.add(cantonDto);
					}

					CantonDTO cantonDTO = cantonesDTO.get(0);
					direccionBean.setCantonDTO(cantonDTO);
					obtenerParroquiasPorCanton();
				}
			}
		} catch (HiperionException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Parroquias del Ecuador, en base a los Cantones que sea seleccionado. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 16/06/2014]
	 * </p>
	 * 
	 */
	public void obtenerParroquiasPorCanton() {
		try {
			this.parroquiasDTO = new ArrayList<ParroquiaDTO>();
			if (direccionBean.getCantonDTO() != null) {
				List<Parroquia> parroquias = parroquiaService.consultarParroquiasPorCanton(direccionBean.getCantonDTO().getCodCanton());

				if (parroquias != null && parroquias.size() > 0) {
					for (Parroquia parroquia : parroquias) {
						ParroquiaDTO parroquiaDto = new ParroquiaDTO(parroquia.getIdParroquia(), parroquia.getNombreParroquia());
						parroquiasDTO.add(parroquiaDto);
					}
				}
			}
		} catch (HiperionException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite Obtener los Tipos de Direcci&oacute;n que se deben registrar en el sistema (Cobro, Domicilio y Oficina). </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/08/2014]
	 * </p>
	 * 
	 * @return - lista de direcciones de tipo SelectItem.
	 */
	public List<SelectItem> obtenerTiposDireccion() {
		try {
			this.tipoDireccionItems = new ArrayList<SelectItem>();
			List<TipoDireccion> tiposDireccion = tipoDireccionService.consultarTiposDireccion();
			for (TipoDireccion tipoDireccion : tiposDireccion) {
				SelectItem selectItem = new SelectItem(tipoDireccion.getCodigoTipoDireccion(), tipoDireccion.getDescTipoDireccion());
				tipoDireccionItems.add(selectItem);
			}
		} catch (HiperionException ex) {
			ex.printStackTrace();
		}

		return tipoDireccionItems;
	}

	/**
	 * 
	 * <b> Permite verificar la direcci&oacte;n que se selecciono para registrala al cliente. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 12/08/2014]
	 * </p>
	 * 
	 */
	public void selectTipoDireccion() {
		String codTipoDireccion = direccionBean.getCodTipoDireccion();
		try {
			TipoDireccion tipoDireccion = tipoDireccionService.consultarTipoDireccionByCodigo(codTipoDireccion);
			direccionBean.setTipoDireccion(tipoDireccion.getDescTipoDireccion());
			obtenerProvincias();
			refreshDialogDireccion();
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 12/08/2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void agregarDireccion() {
		direccionDto = new DireccionDTO();
		direccionDto.setProvinciaDTO(direccionBean.getProvinciaDTO());
		direccionDto.setCantonDTO(direccionBean.getCantonDTO());
		direccionDto.setParroquiaDTO(direccionBean.getParroquiaDTO());
		direccionDto.setTipoDireccion(direccionBean.getTipoDireccion());
		direccionDto.setCallePrincipal(direccionBean.getCallePrincipal());
		direccionDto.setNumeracion(direccionBean.getNumeracion());
		direccionDto.setCalleSecundaria(direccionBean.getCalleSecundaria());
		direccionDto.setReferencia(direccionBean.getReferencia());
		// Contacto Telefonico
		direccionDto.setTelefonoConvencional(direccionBean.getTelefonoConvencional());
		direccionDto.setTelefonoMovil(direccionBean.getTelefonoMovil());

		direcciones.add(direccionDto);

		RequestContext.getCurrentInstance().execute("inputDireccionDlg.hide();");

		// Reresca el combo Tipo Direccion
		refreshComboTipoDireccion();
	}

	/**
	 * 
	 * <b> Permite refrescar todos los campos que se solicita paara registrar una Direcci&oacute;n, ya que si existe una cancelaci&oacute;n la misma
	 * no debe ser registrada. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 12/08/2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void cancelarDireccion() {
		refreshDialogDireccion();
		// Permite refrescar el combo de Tipo Direccion.
		direccionBean.setCodTipoDireccion(null);
		RequestContext.getCurrentInstance().reset("direccionFormId:inputDireccionDlgId");
	}

	/**
	 * 
	 * <b> Permite guardar la o las direcciones de un cliente. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 12/08/2014]
	 * </p>
	 * 
	 */
	public void guardarDirecciones() {
		if (direcciones.size() > 0) {
			for (DireccionDTO direccion : direcciones)
				if (!direccionBean.getDireccionesRegistradas().contains(direccion)) {
					direccionBean.getDireccionesRegistradas().add(direccion);
				}
		}
	}

	/**
	 * 
	 * <b> Permite eliminar una Direcci&oacute;n ya registrada para el Cliente. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/08/2014]
	 * </p>
	 * 
	 * @param tipoDireccion
	 *            - tipo de Direcci&oacte;n (Cobro, Domicilio o Oficina).
	 * @throws HiperionException
	 *             - Excepci&oacute;n del Servicio.
	 */
	public void eliminarDireccion(String tipoDireccion) {
		try {

			// Elimana de la lista de direcciones.
			for (int i = 0; i < direcciones.size(); i++) {
				if (direcciones.get(i).getTipoDireccion().equals(tipoDireccion))
					direcciones.remove(i);
			}

			// ELimina de la lista de Direcciones Regitradas (Direcciones que ya fueron Guardadas).
			if (direccionBean.getDireccionesRegistradas() != null && direccionBean.getDireccionesRegistradas().size() > 0) {
				for (int j = 0; j < direccionBean.getDireccionesRegistradas().size(); j++) {
					if (direccionBean.getDireccionesRegistradas().get(j).equals(tipoDireccion)) {
						direccionBean.getDireccionesRegistradas().remove(j);
					}

				}
			}

			// Obtenemos nuevamente el tipo de Direccion que ya fue Registrado en el Sistema para Guardarlo nuevamente de ser necesario.
			TipoDireccion direccion = tipoDireccionService.consultarTipoDireccionByDescripcion(tipoDireccion);
			SelectItem selectItem = new SelectItem(direccion.getCodigoTipoDireccion(), direccion.getDescTipoDireccion());
			tipoDireccionItems.add(selectItem);

			// Permite Ordenar la lista de tipos de Direccion.
			Collections.sort(tipoDireccionItems, new Comparator<SelectItem>() {
				public int compare(SelectItem selectItem1, SelectItem selectItem2) {
					String sItem1Label = selectItem1.getLabel();
					String sItem2Label = selectItem2.getLabel();
					return (sItem1Label.compareTo(sItem2Label));
				}
			});
		} catch (HiperionException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite cancelar la o las direcciones que se quiso guardar en el sistema. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 12/08/2014]
	 * </p>
	 * 
	 */
	public void cancelarDirecciones() {
		direcciones = new ArrayList<DireccionDTO>();
		if (direccionBean.getDireccionesRegistradas().size() > 0) {
			for (DireccionDTO direccionDto : direccionBean.getDireccionesRegistradas())
				direcciones.add(direccionDto);
			setTipoDireccionItems(obtenerTiposDireccionNoRegistradas(direcciones));
		} else {
			obtenerTiposDireccion();
		}

		refreshDialogDireccion();
	}

	/**
	 * 
	 * <b> Permite obtener una lista de direcciones que aun no han sido registrada para el cliente.</b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/08/2014]
	 * </p>
	 * 
	 * @param direcciones
	 *            - lista de direcciones a ser registradas.
	 * @return
	 */
	private List<SelectItem> obtenerTiposDireccionNoRegistradas(List<DireccionDTO> direcciones) {
		List<SelectItem> tipoDireccionItems = obtenerTiposDireccion();
		for (DireccionDTO direccion : direcciones) {
			for (int i = 0; i < tipoDireccionItems.size(); i++) {
				if (direccion.getTipoDireccion().equals(tipoDireccionItems.get(i).getLabel())) {
					tipoDireccionItems.remove(i);
				}
			}
		}

		return tipoDireccionItems;
	}

	/**
	 * 
	 * <b> Permite refrescar el combo Tipo Dircci&oacute;n, para evitar el ingreso de una misma de direcci&oacte;n. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jul 1, 2014]
	 * </p>
	 * 
	 */
	public void refreshComboTipoDireccion() {
		String codTipoDireccion = direccionBean.getCodTipoDireccion();
		for (int i = 0; i < tipoDireccionItems.size(); i++) {
			if (codTipoDireccion.equals(tipoDireccionItems.get(i).getValue())) {
				tipoDireccionItems.remove(i);
				i = tipoDireccionItems.size();
			}
		}
	}

	/**
	 * 
	 * <b> Permite limpiar los campos de la Direcci&oacute;n del Cliente. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: Jul 1, 2014]
	 * </p>
	 * 
	 */
	public void refreshDialogDireccion() {
		direccionBean.setCallePrincipal("");
		direccionBean.setNumeracion("");
		direccionBean.setCalleSecundaria("");
		direccionBean.setReferencia("");
		direccionBean.setTelefonoConvencional("");
		direccionBean.setTelefonoMovil("");
	}

	/**
	 * 
	 * <b> Permite visualizar en pantalla el registro de la Direcci&oacte;n que fue modificado. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/08/2014]
	 * </p>
	 * 
	 * @param event
	 *            - parametro a ser modificado.
	 */
	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Direccion Edited", ((DireccionDTO) event.getObject()).getTipoDireccion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite visualizar en pantalla el registro de la Direcci&oacte;n que no se modifico (se cancelo) </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 31/08/2014]
	 * </p>
	 * 
	 * @param event
	 *            - parametro que no se modifico.
	 */
	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((DireccionDTO) event.getObject()).getTipoDireccion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void refresh() {
	}

	/**
	 * @return the provinciasDto
	 */
	public List<ProvinciaDTO> getProvinciasDTO() {
		return provinciasDTO;
	}

	/**
	 * @return the cantonesDto
	 */
	public List<CantonDTO> getCantonesDTO() {
		return cantonesDTO;
	}

	/**
	 * @return the direccionBean
	 */
	public DireccionBean getDireccionBean() {
		return direccionBean;
	}

	public List<ParroquiaDTO> getParroquiasDTO() {
		return parroquiasDTO;
	}

	/**
	 * @param direccionBean
	 *            the direccionBean to set
	 */
	public void setDireccionBean(DireccionBean direccionBean) {
		this.direccionBean = direccionBean;
	}

	/**
	 * @return the direcciones
	 */
	public List<DireccionDTO> getDirecciones() {
		return direcciones;
	}

	/**
	 * @param direcciones
	 *            the direcciones to set
	 */
	public void setDirecciones(List<DireccionDTO> direcciones) {
		this.direcciones = direcciones;
	}

	public List<SelectItem> getTipoDireccionItems() {
		return tipoDireccionItems;
	}

	public void setTipoDireccionItems(List<SelectItem> tipoDireccionItems) {
		this.tipoDireccionItems = tipoDireccionItems;
	}
}
