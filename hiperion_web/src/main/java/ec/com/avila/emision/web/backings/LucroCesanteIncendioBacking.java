/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.RamoLucroCesanteIncendioBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ObjetoAseguradoCesanteIlaDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.ObjAsegLcIn;
import ec.com.avila.hiperion.emision.entities.RamoLcIncendio;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.RamoLucroCesanteIncendioService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Lucro Cesante Incendio
 * Lineas Aliadas. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class LucroCesanteIncendioBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<SelectItem> formaSeguroItems;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	@EJB
	private RamoService ramoService;

	@EJB
	private RamoLucroCesanteIncendioService ramoLucroCesanteIncendioService;

	@ManagedProperty(value = "#{ramoLucroCesanteIncendioBean}")
	private RamoLucroCesanteIncendioBean ramoLucroCesanteIncendioBean;

	Logger log = Logger.getLogger(LucroCesanteIncendioBacking.class);

	RamoLcIncendio ramoLucroCesanteIncendio = new RamoLcIncendio();

	/**
	 * 
	 * <b> Permite guardar datos en el Ramo Lucro Cesante Incendio </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 04/09/2014]
	 * </p>
	 * 
	 */
	public void setearInfRamo() throws HiperionException {
		ramoLucroCesanteIncendio.setValorItemsLc(ramoLucroCesanteIncendioBean.getValorItems());
		ramoLucroCesanteIncendio.setPeriodoIndemnizacion(ramoLucroCesanteIncendioBean.getPeriodoIndemnizacion());
		ramoLucroCesanteIncendio.setTasaComprensivaLc(ramoLucroCesanteIncendioBean.getTasaComprensiva());
		ramoLucroCesanteIncendio.setDeducCatastroficoLc(ramoLucroCesanteIncendioBean.getDeducibleCatastrofico());
		ramoLucroCesanteIncendio.setDeducOtrosLc(ramoLucroCesanteIncendioBean.getDeducibleOtros());

		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.setearInformacion"));
	}

	/**
	 * 
	 * <b> Permite guardar la informacion del ramo y objeto asegurado en sus respectivas tablas </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 10/11/2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {
		try {
			if (!ramoLucroCesanteIncendioBean.getOrderlist().isEmpty()) {
				List<ObjAsegLcIn> listObjetos = new ArrayList<>();
				for (ObjetoAseguradoCesanteIlaDTO objeto : ramoLucroCesanteIncendioBean.getOrderlist()) {
					ObjAsegLcIn asegLucro = new ObjAsegLcIn();

					asegLucro.setItemObjLcIncendio(objeto.getNumeroItem());
					asegLucro.setUbicacionObjLcIncendio(objeto.getUbicacionRiesgo());
					asegLucro.setFormaSeguroLc(objeto.getFormaSeguro());
					asegLucro.setUtilidadBrutaLcIncendio(objeto.getUtilidad());
					asegLucro.setDetalleObjLcIncendio(objeto.getDetalle());
					listObjetos.add(asegLucro);
				}
				ramoLucroCesanteIncendio.setObjAsegLcIns(listObjetos);
			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save.Obj"));
			}
			ramoLucroCesanteIncendioService.guardarRamoLucroCesanteIncendio(ramoLucroCesanteIncendio);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
			ramoLucroCesanteIncendio = new RamoLcIncendio();
			ramoLucroCesanteIncendioBean.getOrderlist().clear();
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo lucro cesante incendio", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));
			throw new HiperionException(e);
		}

	}

	/**
	 * @return the ramoLucroCesanteIncendioBean
	 */
	public RamoLucroCesanteIncendioBean getRamoLucroCesanteIncendioBean() {
		return ramoLucroCesanteIncendioBean;
	}

	/**
	 * @param ramoLucroCesanteIncendioBean
	 *            the ramoLucroCesanteIncendioBean to set
	 */
	public void setRamoLucroCesanteIncendioBean(RamoLucroCesanteIncendioBean ramoLucroCesanteIncendioBean) {
		this.ramoLucroCesanteIncendioBean = ramoLucroCesanteIncendioBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * 
	 * <b> Permite obtener las formas de suguro almacenadas en la base </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 30, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getFormaSeguroItems() throws HiperionException {
		this.formaSeguroItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoFormaSeguro"));
		List<DetalleCatalogo> formasSeguro = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : formasSeguro) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			formaSeguroItems.add(selectItem);
		}

		return formaSeguroItems;
	}

	/**
	 * @param formaSeguroItems
	 *            the formaSeguroItems to set
	 */
	public void setFormaSeguroItems(List<SelectItem> formaSeguroItems) {
		this.formaSeguroItems = formaSeguroItems;
	}

}