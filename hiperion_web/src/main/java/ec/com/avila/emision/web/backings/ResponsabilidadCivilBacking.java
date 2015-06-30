/**
 * 
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
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.RamoResponsabilidadCivilBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ClausulaAdicionalDTO;
import ec.com.avila.hiperion.dto.ObjetoAseguradoResponsabilidadDTO;
import ec.com.avila.hiperion.emision.entities.ClausulasAddResp;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.ObjAsegResponsabilidad;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoResponsabilidadCivil;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.RamoResponsabilidadCivilService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
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

	private List<ClausulasAddResp> clausulasAdicionales;
	private List<ClausulaAdicionalDTO> clausulasAdicionalesDTO = new ArrayList<>();
	private List<DetalleAnexo> anexos;

	@PostConstruct
	public void inicializar() {
		try {

			Ramo ramo = ramoService.consultarRamoPorCodigo("RC");

			anexos = ramo.getDetalleAnexos();

			obtenerClausulasAdicionales();

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las clausulas adicionales. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 29/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerClausulasAdicionales() {
		clausulasAdicionales = new ArrayList<ClausulasAddResp>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1) {
					ClausulasAddResp clausula = new ClausulasAddResp();
					clausula.setClausulaResp(anexo.getNombreDetalleAnexo());

					clausulasAdicionales.add(clausula);
				}

			}
			for (ClausulasAddResp clausula : clausulasAdicionales) {
				ClausulaAdicionalDTO clausulaDTO = new ClausulaAdicionalDTO();
				clausulaDTO.setClausula(clausula.getClausulaResp());
				clausulaDTO.setSeleccion(false);

				clausulasAdicionalesDTO.add(clausulaDTO);
			}

		}

	}

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

	/**
	 * 
	 * <b> Permite generar y descargar el documento en PDF </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 21/05/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descargarResponsabilidadCivilPDF() throws HiperionException {
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR,
					GenerarPdfUtil.generarArchivoPDFResponsabilidadCivil(responsabilidadCivil));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		} catch (Exception e) {
			log.error("Error al momento generar el documento Responsabilidad Civil  en PDF", e);
			throw new HiperionException(e);
		}
	}

	/**
	 * @return the clausulasAdicionalesDTO
	 */
	public List<ClausulaAdicionalDTO> getClausulasAdicionalesDTO() {
		return clausulasAdicionalesDTO;
	}

	/**
	 * @param clausulasAdicionalesDTO
	 *            the clausulasAdicionalesDTO to set
	 */
	public void setClausulasAdicionalesDTO(List<ClausulaAdicionalDTO> clausulasAdicionalesDTO) {
		this.clausulasAdicionalesDTO = clausulasAdicionalesDTO;
	}

}