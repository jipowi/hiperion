/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.DetalleAnexoBean;
import ec.com.avila.emision.web.beans.RamoFidelidadBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoFidelidad;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.RamoFidelidadService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.model.AnexosDataModel;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Fidelidad. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class FidelidadBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<SelectItem> sectorItems;
	private List<SelectItem> modalidadItems;

	@ManagedProperty(value = "#{ramoFidelidadBean}")
	private RamoFidelidadBean fidelidadBean;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private DetalleCatalogoService detalleCatalogoService;
	@EJB
	private RamoFidelidadService ramoFidelidadService;

	@ManagedProperty(value = "#{ramoFidelidadBean}")
	private RamoFidelidadBean ramoFidelidadBean;

	Logger log = Logger.getLogger(FidelidadBacking.class);

	private AnexosDataModel anexosDataModel;
	private List<DetalleAnexo> anexos;

	private List<DetalleAnexoBean> clausulasAdicionales;
	private List<DetalleAnexoBean> coberturas;
	private DetalleAnexoBean[] selectClausulasAdicionales;
	private DetalleAnexoBean[] selectCoberturas;

	private Boolean activarFileModalidad;

	@PostConstruct
	public void inicializar() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("FD");
			anexos = ramo.getDetalleAnexos();
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Clausulas Adicionales del Ramo Fidelidad. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerClausulasAdicionales() {
		clausulasAdicionales = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1)
					clausulasAdicionales.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(clausulasAdicionales);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas de Ramo Dinero y Valores. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCoberturas() {
		coberturas = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2)
					coberturas.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(coberturas);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite guardar datos en el Ramo Fidelidad en la base datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 29/08/2014]
	 * </p>
	 * 
	 */
	public void guardarRamo() throws HiperionException {
		RamoFidelidad ramoFidelidad = new RamoFidelidad();

		ramoFidelidad.setValorColusorio(ramoFidelidadBean.getValorColusorio());
		ramoFidelidad.setValorIndividual(ramoFidelidadBean.getValorIndividual());
		ramoFidelidad.setDeducMinimoFidelidad(ramoFidelidadBean.getMinimoSiniestro());
		ramoFidelidad.setDeducSiniestroFidelidad(ramoFidelidadBean.getPorcentajeValorSiniestro());
		ramoFidelidad.setSectorFidelidad(ramoFidelidadBean.getSector());
		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.fidelidad"));
	}

	/**
	 * @return the ramoFidelidadBean
	 */
	public RamoFidelidadBean getRamoFidelidadBean() {
		return ramoFidelidadBean;
	}

	/**
	 * @param ramoFidelidadBean
	 *            the ramoFidelidadBean to set
	 */
	public void setRamoFidelidadBean(RamoFidelidadBean ramoFidelidadBean) {
		this.ramoFidelidadBean = ramoFidelidadBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * 
	 * <b> Permite consultar los sectores que se encuentran en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 30, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getSectorItems() throws HiperionException {

		this.sectorItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoSector"));
		List<DetalleCatalogo> sectores = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : sectores) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			sectorItems.add(selectItem);
		}

		return sectorItems;
	}

	/**
	 * 
	 * <b> permite consultar los tipos de modalidades del ramo fidelidad </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: May 18, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getModalidadItems() throws HiperionException {
		this.modalidadItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoModalidadFidelidad"));
		List<DetalleCatalogo> modalidades = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : modalidades) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			modalidadItems.add(selectItem);
		}

		return modalidadItems;
	}

	/**
	 * 
	 * <b> Permite obtener el tipo de modalidad seleccionada </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: May 18, 2014]
	 * </p>
	 * 
	 */
	public void selectModalidad() {
		if (fidelidadBean.getIdModalidad() == 1)
			setActivarFileModalidad(false);
		else
			setActivarFileModalidad(true);
	}

	/**
	 * @param sectorItems
	 *            the sectorItems to set
	 */
	public void setSectorItems(List<SelectItem> sectorItems) {
		this.sectorItems = sectorItems;
	}

	/**
	 * @return the selectCoberturas
	 */
	public DetalleAnexoBean[] getSelectCoberturas() {
		return selectCoberturas;
	}

	/**
	 * @param selectCoberturas
	 *            the selectCoberturas to set
	 */
	public void setSelectCoberturas(DetalleAnexoBean[] selectCoberturas) {
		this.selectCoberturas = selectCoberturas;
	}

	/**
	 * @return the selectClausulasAdicionales
	 */
	public DetalleAnexoBean[] getSelectClausulasAdicionales() {
		return selectClausulasAdicionales;
	}

	/**
	 * @param selectClausulasAdicionales
	 *            the selectClausulasAdicionales to set
	 */
	public void setSelectClausulasAdicionales(DetalleAnexoBean[] selectClausulasAdicionales) {
		this.selectClausulasAdicionales = selectClausulasAdicionales;
	}

	/**
	 * @return the activarFileModalidad
	 */
	public Boolean getActivarFileModalidad() {
		return activarFileModalidad;
	}

	/**
	 * @param activarFileModalidad
	 *            the activarFileModalidad to set
	 */
	public void setActivarFileModalidad(Boolean activarFileModalidad) {
		this.activarFileModalidad = activarFileModalidad;
	}

	/**
	 * @return the fidelidadBean
	 */
	public RamoFidelidadBean getFidelidadBean() {
		return fidelidadBean;
	}

	/**
	 * @param fidelidadBean
	 *            the fidelidadBean to set
	 */
	public void setFidelidadBean(RamoFidelidadBean fidelidadBean) {
		this.fidelidadBean = fidelidadBean;
	}

}