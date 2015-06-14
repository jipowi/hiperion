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

import ec.com.avila.emision.web.beans.AnexosRamoBean;
import ec.com.avila.emision.web.beans.RamoAccidentesPersonalesBean;
import ec.com.avila.emision.web.domain.ClausulaAdicional;
import ec.com.avila.emision.web.domain.Cobertura;
import ec.com.avila.emision.web.domain.CondicionEspecial;
import ec.com.avila.hiperion.comun.HiperionException;
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

	@ManagedProperty(value = "#{anexosRamoBean}")
	private AnexosRamoBean anexosRamoBean;

	@ManagedProperty(value = "#{ramoAccidentesPersonalesBean}")
	private RamoAccidentesPersonalesBean ramoAccidentesPersonalesBean;

	private List<DetalleAnexo> anexos;
	private List<ClausulaAdicional> clausulasAdicionales;
	private List<ClausulaAdicional> selectClausulasAdicionales;
	private List<Cobertura> coberturas;
	private List<CondicionEspecial> condicionesEspeciales;
	private List<CondicionEspecial> selectCondicionesEspeciales;
	private List<SelectItem> sexoItems;
	private List<SelectItem> parentescoItems;

	Logger log = Logger.getLogger(AccidentesPersonalesBacking.class);

	@PostConstruct
	public void init() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("AP");
			anexos = ramo.getDetalleAnexos();
		} catch (HiperionException e) {
			e.printStackTrace();
		}

		clausulasAdicionales = anexosRamoBean.obtenerClausulasAdicionales(anexos);
		coberturas = anexosRamoBean.obtenerCoberturas(anexos);
		condicionesEspeciales = anexosRamoBean.obtenerCondicionesEspeciales(anexos);
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
	 * @return the anexosRamoBean
	 */
	public AnexosRamoBean getAnexosRamoBean() {
		return anexosRamoBean;
	}

	/**
	 * @param anexosRamoBean
	 *            the anexosRamoBean to set
	 */
	public void setAnexosRamoBean(AnexosRamoBean anexosRamoBean) {
		this.anexosRamoBean = anexosRamoBean;
	}

	/**
	 * @return the clausulasAdicionales
	 */
	public List<ClausulaAdicional> getClausulasAdicionales() {
		return clausulasAdicionales;
	}

	/**
	 * @return the selectClausulasAdicionales
	 */
	public List<ClausulaAdicional> getSelectClausulasAdicionales() {
		return selectClausulasAdicionales;
	}

	/**
	 * @param selectClausulasAdicionales
	 *            the selectClausulasAdicionales to set
	 */
	public void setSelectClausulasAdicionales(List<ClausulaAdicional> selectClausulasAdicionales) {
		this.selectClausulasAdicionales = selectClausulasAdicionales;
	}

	/**
	 * @return the coberturas
	 */
	public List<Cobertura> getCoberturas() {
		return coberturas;
	}

	/**
	 * @return the selectCondicionesEspeciales
	 */
	public List<CondicionEspecial> getSelectCondicionesEspeciales() {
		return selectCondicionesEspeciales;
	}

	/**
	 * @param selectCondicionesEspeciales
	 *            the selectCondicionesEspeciales to set
	 */
	public void setSelectCondicionesEspeciales(List<CondicionEspecial> selectCondicionesEspeciales) {
		this.selectCondicionesEspeciales = selectCondicionesEspeciales;
	}

	/**
	 * @return the condicionesEspeciales
	 */
	public List<CondicionEspecial> getCondicionesEspeciales() {
		return condicionesEspeciales;
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

}
