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
import ec.com.avila.emision.web.beans.RamoEquipoElectronicoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ObjetoAseguradoEquipoElectronicoDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.ObjAsegEquipo;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoEquipoElectronico;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.RamoEquipoElectronicoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.model.AnexosDataModel;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Equipo Electronico. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class EquipoElectronicoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private CatalogoService catalogoService;
	@EJB
	private RamoEquipoElectronicoService ramoEquipoElectronicoService;

	@ManagedProperty(value = "#{ramoEquipoElectronicoBean}")
	private RamoEquipoElectronicoBean ramoEquipoElectronicoBean;

	Logger log = Logger.getLogger(EquipoElectronicoBacking.class);

	RamoEquipoElectronico equipoElectronico = new RamoEquipoElectronico();

	private AnexosDataModel anexosDataModel;
	private List<DetalleAnexo> anexos;

	private List<DetalleAnexoBean> clausulasAdicionales;
	private List<DetalleAnexoBean> coberturasAdicionales;
	private List<DetalleAnexoBean> coberturasTodoRiesgo;
	private List<DetalleAnexoBean> garantiasPoliza;
	private DetalleAnexoBean[] selectClausulasAdicionales;
	private DetalleAnexoBean[] selectCoberturasAdicionales;
	private DetalleAnexoBean[] selectCoberturasTodoRiesgo;
	private DetalleAnexoBean[] selectGarantiasPoliza;

	private List<SelectItem> detalleItems;

	@PostConstruct
	public void inicializar() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("EE");
			anexos = ramo.getDetalleAnexos();
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener los valor del detalle de los equipos electronicos de un catalogo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 11, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getDetalleItems() throws HiperionException {
		this.detalleItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getInteger(
				"ec.gob.avila.hiperion.recursos.catalogoDetalleEquipoElectronico"));
		List<DetalleCatalogo> sectores = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : sectores) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			detalleItems.add(selectItem);
		}

		return detalleItems;
	}

	/**
	 * 
	 * <b> Permite obtener las Clausulas Adicionales del Ramo Equipo Electronico. </b>
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
	 * <b> Permite obtener las Coberturas con titulo Todo Riesgo para el Ramo Equipo Electronico. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCoberturasTodoRiesgo() {
		coberturasTodoRiesgo = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2 && anexo.getTitulo().getIdTitulo() == 6)
					coberturasTodoRiesgo.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(coberturasTodoRiesgo);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas Adicionales del Ramo Equipo Elecrtonico. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCoberturasAdicionales() {
		coberturasAdicionales = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 6)
					coberturasAdicionales.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(coberturasAdicionales);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Garantias de la Poliza del Ramo Equipo Electronico. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerGarantiasPoliza() {
		garantiasPoliza = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 5)
					garantiasPoliza.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(garantiasPoliza);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite setear la informacion del ramo Equipo Electronico </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 27/08/2014]
	 * </p>
	 * 
	 */
	public void setearInfRamo() throws HiperionException {
		equipoElectronico.setTasaEquiposFijos(ramoEquipoElectronicoBean.getTasaFijos());
		equipoElectronico.setTasaExtDatos(ramoEquipoElectronicoBean.getTasaDatos());
		equipoElectronico.setTasaOperacion(ramoEquipoElectronicoBean.getTasaOperacion());
		equipoElectronico.setTasaEquiposPortatiles(ramoEquipoElectronicoBean.getTasaPortatiles());
		equipoElectronico.setTasaCelulares(ramoEquipoElectronicoBean.getTasaCelulares());
		equipoElectronico.setTasaHurtoEqElec(ramoEquipoElectronicoBean.getTasaHurto());
		equipoElectronico.setTasaHurtoEqElec(ramoEquipoElectronicoBean.getTasaOtros());

		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.setearInformacion"));

	}

	/**
	 * 
	 * <b> Permite guardar la informacion del ramo y objeto asegurado en sus respectivas tablas </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Nov 7, 2014]
	 * </p>
	 *
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {

		try {
			if (!ramoEquipoElectronicoBean.getOrderlist().isEmpty()) {

				List<ObjAsegEquipo> listObjetos = new ArrayList<>();
				for (ObjetoAseguradoEquipoElectronicoDTO objeto : ramoEquipoElectronicoBean.getOrderlist()) {
					ObjAsegEquipo asegEquipo = new ObjAsegEquipo();

					asegEquipo.setItemObjEqElec(objeto.getNumeroItem());
					asegEquipo.setUbicacionObjEqElec(objeto.getUbicacionRiesgo());
					asegEquipo.setDetalleObjetoEqElec(objeto.getDetalle());
					asegEquipo.setValorObjEqElec(objeto.getValorObjeto());
					asegEquipo.setDescObjEqElec(objeto.getDescripcion());
					listObjetos.add(asegEquipo);
				}
				equipoElectronico.setObjAsegEquipos(listObjetos);
			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save.Obj"));
			}

			ramoEquipoElectronicoService.guardarRamoEquipoElectronico(equipoElectronico);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
			equipoElectronico = new RamoEquipoElectronico();
			ramoEquipoElectronicoBean.getOrderlist().clear();
		} catch (HiperionException e) {

			log.error("Error al momento de guardar el ramo equipo electronico", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));

			throw new HiperionException(e);
		}

	}

	/**
	 * @return the ramoEquipoElectronicoBean
	 */
	public RamoEquipoElectronicoBean getRamoEquipoElectronicoBean() {
		return ramoEquipoElectronicoBean;
	}

	/**
	 * @param ramoEquipoElectronicoBean
	 *            the ramoEquipoElectronicoBean to set
	 */
	public void setRamoEquipoElectronicoBean(RamoEquipoElectronicoBean ramoEquipoElectronicoBean) {
		this.ramoEquipoElectronicoBean = ramoEquipoElectronicoBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
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
	 * @return the selectCoberturasAdicionales
	 */
	public DetalleAnexoBean[] getSelectCoberturasAdicionales() {
		return selectCoberturasAdicionales;
	}

	/**
	 * @param selectCoberturasAdicionales
	 *            the selectCoberturasAdicionales to set
	 */
	public void setSelectCoberturasAdicionales(DetalleAnexoBean[] selectCoberturasAdicionales) {
		this.selectCoberturasAdicionales = selectCoberturasAdicionales;
	}

	/**
	 * @return the selectCoberturasTodoRiesgo
	 */
	public DetalleAnexoBean[] getSelectCoberturasTodoRiesgo() {
		return selectCoberturasTodoRiesgo;
	}

	/**
	 * @param selectCoberturasTodoRiesgo
	 *            the selectCoberturasTodoRiesgo to set
	 */
	public void setSelectCoberturasTodoRiesgo(DetalleAnexoBean[] selectCoberturasTodoRiesgo) {
		this.selectCoberturasTodoRiesgo = selectCoberturasTodoRiesgo;
	}

	/**
	 * @return the selectGarantiasPoliza
	 */
	public DetalleAnexoBean[] getSelectGarantiasPoliza() {
		return selectGarantiasPoliza;
	}

	/**
	 * @param selectGarantiasPoliza
	 *            the selectGarantiasPoliza to set
	 */
	public void setSelectGarantiasPoliza(DetalleAnexoBean[] selectGarantiasPoliza) {
		this.selectGarantiasPoliza = selectGarantiasPoliza;
	}

	/**
	 * @param detalleItems
	 *            the detalleItems to set
	 */
	public void setDetalleItems(List<SelectItem> detalleItems) {
		this.detalleItems = detalleItems;
	}

}
