/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.LimitesCostosDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.LimitesCostosAsm;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.RamoAstMedicaService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.util.HiperionMensajes;

/**
 * <b> Clase que sirve de soporte para un objeto manejado dentro de la aplicacion, permite implementar los conportamientos especificos de la pagina
 * </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Feb 9, 2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class AsistenciaMedicaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private RamoService ramoService;

	@EJB
	private RamoAstMedicaService ramoAstMedicaService;

	@EJB
	private CatalogoService catalogoService;

	private List<DetalleAnexo> anexos;

	private List<LimitesCostosAsm> limitesCostosBeneficios;
	private List<LimitesCostosAsm> limitesCostosBenAdd;
	private List<LimitesCostosAsm> limitesCostosMaternidad;
	private List<LimitesCostosDTO> limitesCostosBeneficiosDTO = new ArrayList<>();
	private List<LimitesCostosDTO> limitesCostosBenAddDTO = new ArrayList<>();
	private List<LimitesCostosDTO> limitesCostosMaternidadDTO = new ArrayList<>();

	private List<SelectItem> parentescoItems;

	@PostConstruct
	public void inicializar() {
		try {
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

	public void guardar() {
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

}
