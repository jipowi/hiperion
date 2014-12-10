/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.DetalleAnexoBean;
import ec.com.avila.emision.web.beans.RamoEquipoMaquinaraBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ObjetoAseguradoEquipoMaqDTO;
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
import ec.com.avila.hiperion.web.model.AnexosDataModel;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Dinero y Valores. </b>
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

	Logger log = Logger.getLogger(EquipoMaquinariaBacking.class);

	private AnexosDataModel anexosDataModel;
	private List<DetalleAnexo> anexos;

	private List<DetalleAnexoBean> coberturasTodoRiesgo;
	private List<DetalleAnexoBean> coberturasAdicionales;
	private DetalleAnexoBean[] selectCoberturasTodoRiesgo;
	private DetalleAnexoBean[] selectCoberturasAdicionales;

	@PostConstruct
	public void inicializar() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("EM");
			anexos = ramo.getDetalleAnexos();
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Coberturas con titulo Todo Riesgo para el Ramo Equipo Maquinaria. </b>
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
	 * <b> Permite obtener las Coberturas Adicionales del Ramo Equipo Maquinaria. </b>
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
	 * @param usuarioBean the usuarioBean to set
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

}
