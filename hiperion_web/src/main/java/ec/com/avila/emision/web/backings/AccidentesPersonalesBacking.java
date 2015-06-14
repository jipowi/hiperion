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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.RamoAccidentesPersonalesBean;
import ec.com.avila.emision.web.domain.ClausulaAdicional;
import ec.com.avila.emision.web.domain.Cobertura;
import ec.com.avila.emision.web.domain.CondicionEspecial;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ClausulaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.CondicionEspecialDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.RamoAccidentesPersonalesService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo ACCIDENTES PERSONALES. </b>
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

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{ramoAccidentesPersonalesBean}")
	private RamoAccidentesPersonalesBean ramoAccidentesPersonalesBean;

	private List<DetalleAnexo> anexos;
	private List<ClausulaAdicionalDTO> clausulasAdicionalesDTO = new ArrayList<>();
	private List<ClausulaAdicional> clausulasAdicionales;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();
	private List<Cobertura> coberturas;
	private List<CondicionEspecialDTO> condicionesEspecialesDTO = new ArrayList<>();
	private List<CondicionEspecial> condicionesEspeciales;
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
	 * <b> Permite obtener las Condiciones Especiales del Anexo de un Ramo. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public void obtenerCondicionesEspeciales(List<DetalleAnexo> anexos) {
		condicionesEspeciales = new ArrayList<CondicionEspecial>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3)
					condicionesEspeciales.add(new CondicionEspecial(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}
		}
		for (CondicionEspecial condicion : condicionesEspeciales) {
			CondicionEspecialDTO condicionDTO = new CondicionEspecialDTO();
			condicionDTO.setCondicionEspecial(condicion.getNombre());
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
		clausulasAdicionales = new ArrayList<ClausulaAdicional>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1) {
					clausulasAdicionales.add(new ClausulaAdicional(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
				}
			}
		}
		for (ClausulaAdicional clausula : clausulasAdicionales) {
			ClausulaAdicionalDTO clausulaDTO = new ClausulaAdicionalDTO();
			clausulaDTO.setClausula(clausula.getNombre());
			clausulaDTO.setSeleccion(false);

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
		coberturas = new ArrayList<Cobertura>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2)
					coberturas.add(new Cobertura(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}
		}
		for (Cobertura cobertura : coberturas) {
			CoberturaDTO coberturaDTO = new CoberturaDTO();
			coberturaDTO.setCobertura(cobertura.getNombre());
			coberturaDTO.setSeleccion(false);

			coberturasDTO.add(coberturaDTO);
		}

	}

	public void guardarRamo() throws HiperionException {

		RamoAccidentesPersonale accidentesPersonales = new RamoAccidentesPersonale();

		accidentesPersonales.setPrimaNetaPersona(ramoAccidentesPersonalesBean.getPrimaNetaPersona());
		accidentesPersonales.setPrimaTotalPersona(ramoAccidentesPersonalesBean.getPrimaTotalPersona());

		try {

			ramoAccidentesPersonalesService.guardarRamoAccidentesPersonales(accidentesPersonales);

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo accidentes personales", e);

			throw new HiperionException(e);
		}

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
	 * @return the clausulasAdicionales
	 */
	public List<ClausulaAdicional> getClausulasAdicionales() {
		return clausulasAdicionales;
	}

	/**
	 * @param clausulasAdicionales
	 *            the clausulasAdicionales to set
	 */
	public void setClausulasAdicionales(List<ClausulaAdicional> clausulasAdicionales) {
		this.clausulasAdicionales = clausulasAdicionales;
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
	 * @return the coberturas
	 */
	public List<Cobertura> getCoberturas() {
		return coberturas;
	}

	/**
	 * @param coberturas
	 *            the coberturas to set
	 */
	public void setCoberturas(List<Cobertura> coberturas) {
		this.coberturas = coberturas;
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
	 * @return the condicionesEspeciales
	 */
	public List<CondicionEspecial> getCondicionesEspeciales() {
		return condicionesEspeciales;
	}

	/**
	 * @param condicionesEspeciales
	 *            the condicionesEspeciales to set
	 */
	public void setCondicionesEspeciales(List<CondicionEspecial> condicionesEspeciales) {
		this.condicionesEspeciales = condicionesEspeciales;
	}

}
