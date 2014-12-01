/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.RamoTransporteBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ObjetoAseguradoTransporteDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.ObjAsegTransporte;
import ec.com.avila.hiperion.emision.entities.RamoTransporte;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.servicio.RamoTransporteService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Transporte. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class TransporteBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{ramoTransporteBean}")
	private RamoTransporteBean ramoTransporteBean;

	private List<SelectItem> tipoTransporteItems;

	RamoTransporte ramoTransporte = new RamoTransporte();

	@EJB
	private RamoService ramoService;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private RamoTransporteService ramoTransporteService;

	Logger log = Logger.getLogger(TransporteBacking.class);

	/**
	 * 
	 * <b> Permite setear la informacion del ramo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Nov 8, 2014]
	 * </p>
	 *
	 * @throws HiperionException
	 */
	public void setearInfRammo() throws HiperionException {

		ramoTransporte.setTasaTransporte(ramoTransporteBean.getTasa());
		ramoTransporte.setCondImportantesTransporte(ramoTransporteBean.getCondImportantes());
		ramoTransporte.setSiniestroTrans(ramoTransporteBean.getPorcentajeSiniestro());
		ramoTransporte.setMinimoSiniestroTrans(ramoTransporteBean.getMinimoSiniestro());
		ramoTransporte.setEmbarqueTrans(ramoTransporteBean.getPorcentajeEmbarque());
		ramoTransporte.setMinimoEmbarqueTrans(ramoTransporteBean.getMinimoEmbarque());

		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.setearInformacion"));
	}

	/**
	 * 
	 * <b> Permite guardar la informacion del ramo y el objeto asegurado en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Nov 8, 2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 *
	 */
	public void guardarRamo() throws HiperionException {
		try {
			if (!ramoTransporteBean.getObjetoaseguradolist().isEmpty()) {

				List<ObjAsegTransporte> listObjetos = new ArrayList<>();
				for (ObjetoAseguradoTransporteDTO objeto : ramoTransporteBean.getObjetoaseguradolist()) {
					ObjAsegTransporte objAsegTransporte = new ObjAsegTransporte();

					objAsegTransporte.setItemTransporte(objeto.getItem());
					objAsegTransporte.setLimiteMovilizacionAnual(new BigDecimal(objeto.getLimiteMovilizacionAnual()));
					objAsegTransporte.setLimiteEmbarqueTransporte(new BigDecimal(objeto.getLimiteEmbarque()));
					objAsegTransporte.setMedioTransporte(objeto.getMedioTransporte());
					objAsegTransporte.setTrayectoDesde(objeto.getTrayectoDesde());
					objAsegTransporte.setTrayectoHasta(objeto.getTrayectoHasta());
					objAsegTransporte.setTipoEmbalaje(objeto.getTipoEmbalaje());
					objAsegTransporte.setValuacion(objeto.getValuacion().toString());

					listObjetos.add(objAsegTransporte);
				}
				ramoTransporte.setObjAsegTransportes(listObjetos);
				ramoTransporteService.guardarRamoTransporte(ramoTransporte);

				MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
				ramoTransporte = new RamoTransporte();
				ramoTransporteBean.getObjetoaseguradolist().clear();

			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save.Obj"));
			}
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo de transporte", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));

			throw new HiperionException(e);
		}
	}

	/**
	 * @return the ramoTransporteBean
	 */
	public RamoTransporteBean getRamoTransporteBean() {
		return ramoTransporteBean;
	}

	/**
	 * @param ramoTransporteBean
	 *            the ramoTransporteBean to set
	 */
	public void setRamoTransporteBean(RamoTransporteBean ramoTransporteBean) {
		this.ramoTransporteBean = ramoTransporteBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * @return the tipoTransporteItems
	 * @throws HiperionException
	 */
	public List<SelectItem> getTipoTransporteItems() throws HiperionException {

		this.tipoTransporteItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoMedioTransporte"));
		List<DetalleCatalogo> tipos = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : tipos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tipoTransporteItems.add(selectItem);
		}

		return tipoTransporteItems;
	}

	/**
	 * @param tipoTransporteItems
	 *            the tipoTransporteItems to set
	 */
	public void setTipoTransporteItems(List<SelectItem> tipoTransporteItems) {
		this.tipoTransporteItems = tipoTransporteItems;
	}

}