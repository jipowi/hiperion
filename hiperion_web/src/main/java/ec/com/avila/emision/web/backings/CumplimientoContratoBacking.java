/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.RamoCumplimientoContratoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.emision.entities.CobertContrato;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoCumplimientoContrato;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.RamoCumplimientoContratoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
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

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	Logger log = Logger.getLogger(CumplimientoContratoBacking.class);
	RamoCumplimientoContrato cumplimientoContrato = new RamoCumplimientoContrato();

	private List<DetalleAnexo> anexos;

	private List<CobertContrato> coberturas;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();

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
	 * <b> Permite obtener las coberturas del ramo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 17/06/2015]
	 * </p>
	 * 
	 * @param anexos
	 */
	public void obtenerCoberturas() {

		coberturas = new ArrayList<CobertContrato>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertContrato cobertura = new CobertContrato();
					cobertura.setCoberturaContrato(anexo.getNombreDetalleAnexo());

					coberturas.add(cobertura);
				}

			}

			for (CobertContrato cobertura : coberturas) {
				CoberturaDTO coberturaDTO = new CoberturaDTO();
				coberturaDTO.setCobertura(cobertura.getCoberturaContrato());
				coberturaDTO.setSeleccion(false);

				coberturasDTO.add(coberturaDTO);
			}
		}

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
		Usuario usuario = usuarioBean.getSessionUser();

		cumplimientoContrato.setObjetoAsegContrato(ramoCumplimientoContratoBean.getObjetoAsegurado());
		cumplimientoContrato.setValorContrato(ramoCumplimientoContratoBean.getValorContrato());
		cumplimientoContrato.setValorAseguradoContrato(ramoCumplimientoContratoBean.getValorAsegurado());
		cumplimientoContrato.setTipoContragarantiaContrato(ramoCumplimientoContratoBean.getTipoContragarantia());

		cumplimientoContrato.setIdUsuarioCreacion(usuario.getIdUsuario());
		cumplimientoContrato.setFechaCreacion(new Date());
		cumplimientoContrato.setEstado(EstadoEnum.A);

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
	 * @return the usuarioBean
	 */
	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	/**
	 * @param usuarioBean
	 *            the usuarioBean to set
	 */
	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
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
	 * 
	 * <b> Permite generar y descargar el documento en PDF </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 22/04/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descargarCumplimientoContratoPDF() throws HiperionException {
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR,
					GenerarPdfUtil.generarArchivoPDFCumplimientoContrato(cumplimientoContrato));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		} catch (Exception e) {
			log.error("Error al momento generar el documento Cumplimiento Contrato en PDF", e);
			throw new HiperionException(e);
		}
	}
}
