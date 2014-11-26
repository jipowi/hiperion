/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.RamoResponsabilidadCivilBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ObjetoAseguradoResponsabilidadDTO;
import ec.com.avila.hiperion.emision.entities.ObjAsegResponsabilidad;
import ec.com.avila.hiperion.emision.entities.RamoResponsabilidadCivil;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.RamoResponsabilidadCivilService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Responsabilidad Civil. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class ResponsabilidadCivilBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private RamoService ramoService;

	@EJB
	private RamoResponsabilidadCivilService ramoResponsabilidadCivilService;

	@ManagedProperty(value = "#{ramoResponsabilidadCivilBean}")
	private RamoResponsabilidadCivilBean ramoResponsabilidadCivilBean;

	RamoResponsabilidadCivil responsabilidadCivil = new RamoResponsabilidadCivil();

	Logger log = Logger.getLogger(ResponsabilidadCivilBacking.class);

	public void setearInfRamo() {
		Usuario usuario = usuarioBean.getSessionUser();

		responsabilidadCivil.setLimiteUnicoAnualResp(Integer.parseInt(ramoResponsabilidadCivilBean.getLimiteUnico().toString()));
		responsabilidadCivil.setTasaResp(ramoResponsabilidadCivilBean.getTasa());
		responsabilidadCivil.setDeducSiniestroResp(ramoResponsabilidadCivilBean.getPorcentajeValorSiniestro());
		responsabilidadCivil.setDeducMinimoResp(ramoResponsabilidadCivilBean.getMinimo());
		responsabilidadCivil.setIdUsuarioCreacion(usuario.getIdUsuario());
		responsabilidadCivil.setFechaCreacion(new Date());
		responsabilidadCivil.setEstado(EstadoEnum.A);
		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.setearInformacion"));
	}

	/**
	 * 
	 * <b> Permite guardar la informacion del ramo y el objeto asegurado en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Nov 1, 2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {

		try {
			if (!ramoResponsabilidadCivilBean.getObjetolist().isEmpty()) {

				List<ObjAsegResponsabilidad> listObjetos = new ArrayList<>();

				for (ObjetoAseguradoResponsabilidadDTO objeto : ramoResponsabilidadCivilBean.getObjetolist()) {
					ObjAsegResponsabilidad objAsegResponsabilidad = new ObjAsegResponsabilidad();
					objAsegResponsabilidad.setItemResp(objeto.getNumeroItem());
					objAsegResponsabilidad.setDescripcionResp(objeto.getDescripcionObjeto());

					Usuario usuario = usuarioBean.getSessionUser();
					objAsegResponsabilidad.setIdUsuarioCreacion(usuario.getIdUsuario());
					objAsegResponsabilidad.setFechaCreacion(new Date());
					objAsegResponsabilidad.setEstado(EstadoEnum.A);
					listObjetos.add(objAsegResponsabilidad);
				}
				responsabilidadCivil.setObjAsegResponsabilidads(listObjetos);
				ramoResponsabilidadCivilService.guardarRamoResponsabilidadCivil(responsabilidadCivil);
				MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
				responsabilidadCivil = new RamoResponsabilidadCivil();
				ramoResponsabilidadCivilBean.getObjetolist().clear();
			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save.Obj"));
			}
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo de responsabilidad civil", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));

			throw new HiperionException(e);
		}
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * @return the ramoResponsabilidadCivilBean
	 */
	public RamoResponsabilidadCivilBean getRamoResponsabilidadCivilBean() {
		return ramoResponsabilidadCivilBean;
	}

	/**
	 * @param ramoResponsabilidadCivilBean
	 *            the ramoResponsabilidadCivilBean to set
	 */
	public void setRamoResponsabilidadCivilBean(RamoResponsabilidadCivilBean ramoResponsabilidadCivilBean) {
		this.ramoResponsabilidadCivilBean = ramoResponsabilidadCivilBean;
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

}