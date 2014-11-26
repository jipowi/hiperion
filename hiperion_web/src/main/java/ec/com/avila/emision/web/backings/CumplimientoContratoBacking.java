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

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.DetalleAnexoBean;
import ec.com.avila.emision.web.beans.RamoCumplimientoContratoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoCumplimientoContrato;
import ec.com.avila.hiperion.servicio.RamoCumplimientoContratoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.model.AnexosDataModel;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Cumplimiento Contrato. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class CumplimientoContratoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoCumplimientoContratoService ramoCumplimientoContratoService;

	@ManagedProperty(value = "#{ramoCumplimientoContratoBean}")
	private RamoCumplimientoContratoBean ramoCumplimientoContratoBean;

	Logger log = Logger.getLogger(CumplimientoContratoBacking.class);

	private AnexosDataModel anexosDataModel;
	private List<DetalleAnexo> anexos;

	private List<DetalleAnexoBean> coberturas;
	private DetalleAnexoBean[] selectCoberturas;

	@PostConstruct
	public void inicializar() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("CC");
			anexos = ramo.getDetalleAnexos();
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas de Ramo Cumplimiento Contrato. </b>
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
	 * <b> Permite guardar datos en el Ramo Cumplimiento de Contrato en la base de datos. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 19/08/2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {
		RamoCumplimientoContrato cumplimientoContrato = new RamoCumplimientoContrato();

		cumplimientoContrato.setObjetoAsegContrato(ramoCumplimientoContratoBean.getObjetoAsegurado());
		cumplimientoContrato.setValorContrato(ramoCumplimientoContratoBean.getValorContrato());
		cumplimientoContrato.setValorAseguradoContrato(ramoCumplimientoContratoBean.getValorAsegurado());
		cumplimientoContrato.setTipoContragarantiaContrato(ramoCumplimientoContratoBean.getTipoContragarantia());

		try {
			ramoCumplimientoContratoService.guardarRamoCumplimientoContrato(cumplimientoContrato);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.sOjeto"));
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el Ramo Cumplimiento de contrato", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));
			throw new HiperionException(e);
		}
	}

	/**
	 * @return the ramoCumplimientoContratoBean
	 */
	public RamoCumplimientoContratoBean getRamoCumplimientoContratoBean() {
		return ramoCumplimientoContratoBean;
	}

	/**
	 * @param ramoCumplimientoContratoBean
	 *            the ramoCumplimientoContratoBean to set
	 */
	public void setRamoCumplimientoContratoBean(RamoCumplimientoContratoBean ramoCumplimientoContratoBean) {
		this.ramoCumplimientoContratoBean = ramoCumplimientoContratoBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
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
}
