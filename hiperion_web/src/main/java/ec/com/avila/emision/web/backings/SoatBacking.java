/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
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

import ec.com.avila.emision.web.beans.RamoSoatBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.RamoSoat;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.servicio.RamoSoatService;
import ec.com.avila.hiperion.web.beans.MarcasDto;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo SOAT. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class SoatBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	private List<SelectItem> tipoVehiculoItems;
	private List<SelectItem> tipoSoatItems;
	private List<SelectItem> modeloItems;

	@EJB
	private RamoService ramoService;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	@EJB
	private RamoSoatService ramoSoatService;

	@ManagedProperty(value = "#{ramoSoatBean}")
	private RamoSoatBean ramoSoatBean;

	Logger log = Logger.getLogger(SoatBacking.class);

	private Boolean activarMarcaAuto;
	private Boolean activarMarcaPesado;
	private Boolean activarMarcaMoto;

	public void guardarRamo() throws HiperionException {
		RamoSoat ramoSoat = new RamoSoat();

		ramoSoat.setAsegurado(ramoSoatBean.getAsegurado());
		ramoSoat.setColorSoat(ramoSoatBean.getColor());
		ramoSoat.setPlacaSoat(ramoSoatBean.getPlaca());
		ramoSoat.setChasisSoat(ramoSoatBean.getChasis());
		ramoSoat.setAnioSoat(ramoSoatBean.getAnio());
		ramoSoat.setCilindrajeSoat(ramoSoatBean.getCilindraje());

		try {
			ramoSoatService.guardarRamoSoat(ramoSoat);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.soat"));
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el Ramo Soat", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.soat"));
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
		if (ramoSoatBean.getTipoVehiculo().equals("2") || ramoSoatBean.getTipoVehiculo().equals("1") || ramoSoatBean.getTipoVehiculo().equals("4")) {
			activarMarcaAuto = true;
			activarMarcaPesado = false;
			activarMarcaMoto = false;
		}
		if (ramoSoatBean.getTipoVehiculo().equals("3")) {
			activarMarcaPesado = true;
			activarMarcaAuto = false;
			activarMarcaMoto = false;
		}
		if (ramoSoatBean.getTipoVehiculo().equals("5")) {
			activarMarcaMoto = true;
			activarMarcaAuto = false;
			activarMarcaPesado = false;
		}
	}

	/**
	 * 
	 * <b> Permite obtenerlos tipos de vehiculos que se encuentran en la tabla de catalogos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 15, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getTipoVehiculoItems() throws HiperionException {

		this.tipoVehiculoItems = new ArrayList<SelectItem>();
		Long idCatalogo = Long.parseLong(HiperionMensajes.getInstancia().getInteger("ec.gob.avila.hiperion.recursos.catalogoTipoVehiculoSoat")
				.toString());
		Catalogo catalogo = catalogoService.consultarCatalogoById(idCatalogo);
		List<DetalleCatalogo> tipos = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : tipos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tipoVehiculoItems.add(selectItem);
		}

		return tipoVehiculoItems;
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
	 * @param tipoVehiculoItems
	 *            the tipoVehiculoItems to set
	 */
	public void setTipoVehiculoItems(List<SelectItem> tipoVehiculoItems) {
		this.tipoVehiculoItems = tipoVehiculoItems;
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
	 * @param tipoSoatItems
	 *            the tipoSoatItems to set
	 */
	public void setTipoSoatItems(List<SelectItem> tipoSoatItems) {
		this.tipoSoatItems = tipoSoatItems;
	}

	/**
	 * @return the ramoSoatBean
	 */
	public RamoSoatBean getRamoSoatBean() {
		return ramoSoatBean;
	}

	/**
	 * @param ramoSoatBean
	 *            the ramoSoatBean to set
	 */
	public void setRamoSoatBean(RamoSoatBean ramoSoatBean) {
		this.ramoSoatBean = ramoSoatBean;
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
	 * 
	 * <b> Permite obtener los tipos de soat que se encuentran en la tabla de catalogos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jun 15, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getTipoSoatItems() throws HiperionException {

		this.tipoSoatItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoTipoSoat"));
		List<DetalleCatalogo> tipos = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : tipos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tipoSoatItems.add(selectItem);
		}

		return tipoSoatItems;
	}

	/**
	 * 
	 * <b> Permite obtener los modelos de autos dependiente de la marca seleccionada </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 15, 2014]
	 * </p>
	 * 
	 * @param selectedMarca
	 * @throws HiperionException
	 */
	public void obtenerModelo(MarcasDto selectedMarca) throws HiperionException {

		this.modeloItems = new ArrayList<SelectItem>();

		List<DetalleCatalogo> catalogos = new ArrayList<DetalleCatalogo>();

		if (!ramoSoatBean.getTipoVehiculo().equals("3") && !ramoSoatBean.getTipoVehiculo().equals("5"))
			catalogos = detalleCatalogoService.consultarDetalleCatalogoByCodDetalle(selectedMarca.getMarca(), HiperionMensajes.getInstancia()
					.getInteger("ec.gob.avila.hiperion.recursos.catalogoModeloVehiculoLiviano"));

		if (ramoSoatBean.getTipoVehiculo().equals("3"))
			catalogos = detalleCatalogoService.consultarDetalleCatalogoByCodDetalle(selectedMarca.getMarca(), HiperionMensajes.getInstancia()
					.getInteger("ec.gob.avila.hiperion.recursos.catalogoModeloVehiculoPesado"));

		if (ramoSoatBean.getTipoVehiculo().equals("5"))
			catalogos = detalleCatalogoService.consultarDetalleCatalogoByCodDetalle(selectedMarca.getMarca(), HiperionMensajes.getInstancia()
					.getInteger("ec.gob.avila.hiperion.recursos.catalogoModeloVehiculoMoto"));

		for (DetalleCatalogo detalle : catalogos) {
			SelectItem selectItem = new SelectItem(detalle.getIdDetalleCatalogo(), detalle.getDescDetCatalogo());
			modeloItems.add(selectItem);
		}

	}
}