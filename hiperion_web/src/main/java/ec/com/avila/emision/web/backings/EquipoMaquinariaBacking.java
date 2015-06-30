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

import ec.com.avila.emision.web.beans.RamoEquipoMaquinaraBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.CoberturaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.ObjetoAseguradoEquipoMaqDTO;
import ec.com.avila.hiperion.emision.entities.CobertAddRobo;
import ec.com.avila.hiperion.emision.entities.CobertEqMaq;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.ObjAsegEquipoMaq;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoEquipoMaquinaria;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.RamoEquipoMaquinariaService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Backing que permite gestionar la informacion que se maneje en las paginas web que utilicen el Ramo Dinero y Valores. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class EquipoMaquinariaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoEquipoMaquinariaService ramoEquipoMaquinariaService;

	@ManagedProperty(value = "#{ramoEquipoMaquinaraBean}")
	private RamoEquipoMaquinaraBean ramoEquipoMaquinaraBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	RamoEquipoMaquinaria ramoEquipoMaquinaria = new RamoEquipoMaquinaria();
	private List<CobertEqMaq> coberturas;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();
	private List<CobertAddRobo> coberturasAdd;
	private List<CoberturaAdicionalDTO> coberturasAddDTO = new ArrayList<>();
	Logger log = Logger.getLogger(EquipoMaquinariaBacking.class);

	private List<DetalleAnexo> anexos;

	/**
	 * @return the ramoEquipoMaquinaraBean
	 */
	public RamoEquipoMaquinaraBean getRamoEquipoMaquinaraBean() {
		return ramoEquipoMaquinaraBean;
	}

	/**
	 * @param ramoEquipoMaquinaraBean
	 *            the ramoEquipoMaquinaraBean to set
	 */
	public void setRamoEquipoMaquinaraBean(RamoEquipoMaquinaraBean ramoEquipoMaquinaraBean) {
		this.ramoEquipoMaquinaraBean = ramoEquipoMaquinaraBean;
	}

	@PostConstruct
	public void inicializar() {
		try {

			Ramo ramo = ramoService.consultarRamoPorCodigo("EM");

			anexos = ramo.getDetalleAnexos();

			obtenerCoberturas();
			obtenerCoberturasAdicionales();

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

		coberturas = new ArrayList<CobertEqMaq>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CobertEqMaq cobertura = new CobertEqMaq();
					cobertura.setCoberturaEqMaq(anexo.getNombreDetalleAnexo());

					coberturas.add(cobertura);
				}

			}

			for (CobertEqMaq cobertura : coberturas) {
				CoberturaDTO coberturaDTO = new CoberturaDTO();
				coberturaDTO.setCobertura(cobertura.getCoberturaEqMaq());
				coberturaDTO.setSeleccion(false);

				coberturasDTO.add(coberturaDTO);
			}
		}

	}

	/**
	 * 
	 * <b> Permite obetener las coberturas adicionales del ramo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 26/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerCoberturasAdicionales() {

		coberturasAdd = new ArrayList<CobertAddRobo>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 6) {
					CobertAddRobo cobertura = new CobertAddRobo();
					cobertura.setCoberturaAddRobo(anexo.getNombreDetalleAnexo());

					coberturasAdd.add(cobertura);
				}

			}

			for (CobertAddRobo cobertura : coberturasAdd) {
				CoberturaAdicionalDTO coberturaAddDTO = new CoberturaAdicionalDTO();
				coberturaAddDTO.setCobertura(cobertura.getCoberturaAddRobo());
				coberturaAddDTO.setSeleccion(false);

				coberturasAddDTO.add(coberturaAddDTO);
			}
		}

	}

	/**
	 * 
	 * <b> Permite guardar los datos en el Ramo Equipo y Maquinaria en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 27/08/2014]
	 * </p>
	 * 
	 */
	public void setearInfRamo() throws HiperionException {

		Usuario usuario = usuarioBean.getSessionUser();

		ramoEquipoMaquinaria.setTasaEquipoMaq(ramoEquipoMaquinaraBean.getTasa());
		ramoEquipoMaquinaria.setDeducMinimoSiniestroMaq(ramoEquipoMaquinaraBean.getMinimoSiniestro());
		ramoEquipoMaquinaria.setDeducMinAsegMaq(ramoEquipoMaquinaraBean.getMinimoAsegurado());
		ramoEquipoMaquinaria.setDeducPorcSiniestroMaq(ramoEquipoMaquinaraBean.getPorcentajeSiniestro());

		ramoEquipoMaquinaria.setIdUsuarioCreacion(usuario.getIdUsuario());
		ramoEquipoMaquinaria.setFechaCreacion(new Date());
		ramoEquipoMaquinaria.setEstado(EstadoEnum.A);
		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.setearDatos"));
	}

	/**
	 * 
	 * <b> Permite guardar los datos en el Ramo Equipo y Maquinaria en sus respectivas tablas </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 09/11/2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {

		try {
			if (!ramoEquipoMaquinaraBean.getObjetoAseguradoList().isEmpty()) {
				List<ObjAsegEquipoMaq> listObjetos = new ArrayList<>();
				for (ObjetoAseguradoEquipoMaqDTO objeto : ramoEquipoMaquinaraBean.getObjetoAseguradoList()) {
					ObjAsegEquipoMaq objAsegEquipoMaq = new ObjAsegEquipoMaq();

					objAsegEquipoMaq.setItemObjEqMaq(objeto.getItem());
					objAsegEquipoMaq.setMarcaObjEqMaq(objeto.getMarca());
					objAsegEquipoMaq.setModeloObjEqMaq(objeto.getModelo());
					objAsegEquipoMaq.setAnioObjMaq(objeto.getAnio());
					objAsegEquipoMaq.setMotorObjjEqMaq(objeto.getMotor());
					objAsegEquipoMaq.setChasisObjEqMaq(objeto.getChasis());
					objAsegEquipoMaq.setColorObjEqMaq(objeto.getColor());
					objAsegEquipoMaq.setValorAsegObjEqMaq(objeto.getValorAsegurado());
					objAsegEquipoMaq.setNumeroSerieObjMaq(objeto.getSerie());

					Usuario usuario = usuarioBean.getSessionUser();
					objAsegEquipoMaq.setIdUsuarioCreacion(usuario.getIdUsuario());
					objAsegEquipoMaq.setFechaCreacion(new Date());
					objAsegEquipoMaq.setEstado(EstadoEnum.A);
					listObjetos.add(objAsegEquipoMaq);
				}
				ramoEquipoMaquinaria.setObjAsegEquipoMaqs(listObjetos);
			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save.Obj"));
			}
			ramoEquipoMaquinariaService.guardarRamoEquipoMaquinaria(ramoEquipoMaquinaria);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
			ramoEquipoMaquinaria = new RamoEquipoMaquinaria();
			ramoEquipoMaquinaraBean.getObjetoAseguradoList().clear();
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo equipo y maquinaria", e);
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

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * 
	 * <b> Permite generar y descargar informacion Equipo Maquinaria PDF. </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 29/04/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descargarEquipoMaquinariaPDF() throws HiperionException {
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte
					.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarAchivoPDFEquipoMaquinaria(ramoEquipoMaquinaria));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();

		} catch (Exception e) {
			log.error("Error al momento generar el a hoja de vida en PDF", e);
			throw new HiperionException(e);
		}

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
	 * @return the coberturasAddDTO
	 */
	public List<CoberturaAdicionalDTO> getCoberturasAddDTO() {
		return coberturasAddDTO;
	}

	/**
	 * @param coberturasAddDTO
	 *            the coberturasAddDTO to set
	 */
	public void setCoberturasAddDTO(List<CoberturaAdicionalDTO> coberturasAddDTO) {
		this.coberturasAddDTO = coberturasAddDTO;
	}

}
