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
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.RamoRoboAsaltoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ClausulaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaAdicionalDTO;
import ec.com.avila.hiperion.dto.CoberturaDTO;
import ec.com.avila.hiperion.dto.CondicionEspecialDTO;
import ec.com.avila.hiperion.dto.ObjetoAseguradoRoboDTO;
import ec.com.avila.hiperion.emision.entities.ClausulasAddRobo;
import ec.com.avila.hiperion.emision.entities.CobertAddRobo;
import ec.com.avila.hiperion.emision.entities.CoberturaRobo;
import ec.com.avila.hiperion.emision.entities.CondEspRobo;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.ObjAsegRobo;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoRoboAsalto;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.RamoRoboAsaltoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Robo y/o Asalto. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RoboAsaltoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;
	@ManagedProperty(value = "#{ramoRoboAsaltoBean}")
	private RamoRoboAsaltoBean ramoRoboAsaltoBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoRoboAsaltoService ramoRoboAsaltoService;

	Logger log = Logger.getLogger(RoboAsaltoBacking.class);

	RamoRoboAsalto ramoRoboAsalto = new RamoRoboAsalto();
	
	private List<CoberturaRobo> coberturas;
	private List<CoberturaDTO> coberturasDTO = new ArrayList<>();
	private List<CobertAddRobo> coberturasAdd;
	private List<CoberturaAdicionalDTO> coberturasAddDTO = new ArrayList<>();
	private List<ClausulasAddRobo> clausulasAdicionales;
	private List<ClausulaAdicionalDTO> clausulasAdicionalesDTO = new ArrayList<>();
	private List<CondEspRobo> condicionesEspeciales;
	private List<CondicionEspecialDTO> condicionesEspecialesDTO = new ArrayList<>();
	private List<DetalleAnexo> anexos;

	
	@PostConstruct
	public void inicializar() {
		try {

			Ramo ramo = ramoService.consultarRamoPorCodigo("RE");

			anexos = ramo.getDetalleAnexos();

			obtenerCoberturas();
			obtenerCoberturasAdicionales();
			obtenerClausulasAdicionales();
			obtenerCondicionesEspeciales();

		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * <b> Permite setear la informacion del ramo Robo Asalto </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 08/09/2014]
	 * </p>
	 * 
	 */
	public void setearInfRamo() throws HiperionException {

		Usuario usuario = usuarioBean.getSessionUser();

		ramoRoboAsalto.setTasaRoboAsalto(ramoRoboAsaltoBean.getTasaRobo());
		ramoRoboAsalto.setTasaHurtoRobo(ramoRoboAsaltoBean.getMinimoHurto());
		ramoRoboAsalto.setTasaPropiedad(ramoRoboAsaltoBean.getTasaPropiedad());
		ramoRoboAsalto.setTasaContenidos(ramoRoboAsaltoBean.getTasaContenidos());
		// TODO agregar deducibles modelo

		ramoRoboAsalto.setIdUsuarioCreacion(usuario.getIdUsuario());
		ramoRoboAsalto.setFechaCreacion(new Date());
		ramoRoboAsalto.setEstado(EstadoEnum.A);

		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.setearInformacion"));

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

		coberturas = new ArrayList<CoberturaRobo>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2) {
					CoberturaRobo cobertura = new CoberturaRobo();
					cobertura.setCoberturaRobo(anexo.getNombreDetalleAnexo());

					coberturas.add(cobertura);
				}

			}

			for (CoberturaRobo cobertura : coberturas) {
				CoberturaDTO coberturaDTO = new CoberturaDTO();
				coberturaDTO.setCobertura(cobertura.getCoberturaRobo());
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
	 * <b> Permite obtener las clausulas adicionales del ramo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 17/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerClausulasAdicionales() {
		clausulasAdicionales = new ArrayList<ClausulasAddRobo>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 1) {
					ClausulasAddRobo clausula = new ClausulasAddRobo();
					clausula.setClausulaAddRobo(anexo.getNombreDetalleAnexo());

					clausulasAdicionales.add(clausula);
				}

			}
			for (ClausulasAddRobo clausula : clausulasAdicionales) {
				ClausulaAdicionalDTO clausulaDTO = new ClausulaAdicionalDTO();
				clausulaDTO.setClausula(clausula.getClausulaAddRobo());
				clausulaDTO.setSeleccion(false);

				
				clausulasAdicionalesDTO.add(clausulaDTO);
			}

		}

	}

	/**
	 * 
	 * <b> Permite obtener las condiciones especiales del ramo. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 17/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerCondicionesEspeciales() {
		condicionesEspeciales = new ArrayList<CondEspRobo>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3) {
					CondEspRobo condicion = new CondEspRobo();
					condicion.setCondicionEspRobo(anexo.getNombreDetalleAnexo());

					condicionesEspeciales.add(condicion);
				}

			}
			for (CondEspRobo condicion : condicionesEspeciales) {
				CondicionEspecialDTO condicionDTO = new CondicionEspecialDTO();
				condicionDTO.setCondicionEspecial(condicion.getCondicionEspRobo());
				condicionDTO.setSeleccion(false);

				condicionesEspecialesDTO.add(condicionDTO);
			}

		}

	}

	
	public void guadraRamo() throws HiperionException {
		try {
			if (ramoRoboAsaltoBean.getObjetoaseguradolist().isEmpty()) {
				List<ObjAsegRobo> listObjetos = new ArrayList<>();
				for (ObjetoAseguradoRoboDTO objeto : ramoRoboAsaltoBean.getObjetoaseguradolist()) {
					ObjAsegRobo objAsegRobo = new ObjAsegRobo();

					objAsegRobo.setItemRoboAsalto(objeto.getNumeroItem());
					objAsegRobo.setValorObjRobo(objeto.getValorDetalleObjeto());
					objAsegRobo.setUbicacionObjRobo(objeto.getUbicacionRiesgo());
					objAsegRobo.setDetalleObjRobo(objeto.getDetalleObjeto());
					objAsegRobo.setMueblesObjRobo(objeto.getMueblesEnseresEquipos());
					objAsegRobo.setJoyasObjRobo(objeto.getJoyasObrasArte());
					objAsegRobo.setMaquinariaObjRobo(objeto.getMaquinaria());
					objAsegRobo.setDineroObjRobo(objeto.getDineroPermanencia());
					objAsegRobo.setMarcaderiaObjRobo(objeto.getMercaderia());

					Usuario usuario = usuarioBean.getSessionUser();
					objAsegRobo.setIdUsuarioCreacion(usuario.getIdUsuario());
					objAsegRobo.setFechaCreacion(new Date());
					objAsegRobo.setEstado(EstadoEnum.A);
					listObjetos.add(objAsegRobo);

				}
				ramoRoboAsalto.setObjAsegRobos(listObjetos);
			} else {
				MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));
			}
			ramoRoboAsaltoService.guardarRamoRoboAsalto(ramoRoboAsalto);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
			ramoRoboAsalto = new RamoRoboAsalto();
			ramoRoboAsaltoBean.getObjetoaseguradolist().clear();
		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo robo y/o asalto", e);
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
	 * @return the ramoRoboAsaltoBeans
	 */
	public RamoRoboAsaltoBean getRamoRoboAsaltoBean() {
		return ramoRoboAsaltoBean;
	}

	/**
	 * @param ramoRoboAsaltoBean
	 *            the ramoRoboAsaltoBean to set
	 */
	public void setRamoRoboAsaltoBean(RamoRoboAsaltoBean ramoRoboAsaltoBean) {
		this.ramoRoboAsaltoBean = ramoRoboAsaltoBean;
	}

	public RamoBean getRamoBean() {
		return ramoBean;
	}

	public void setRamoBean(RamoBean ramoBean) {
		this.ramoBean = ramoBean;
	}

	/**
	 * 
	 * <b> Permite generar y descargar el documento en PDF </b>
	 * <p>
	 * [Author: Franklin Pozo B, Date: 25/05/2015]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void descarRoboAsaltoPDF() throws HiperionException {

		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR, GenerarPdfUtil.generarArchivoPDFRoboAsalto(ramoRoboAsalto));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();
		} catch (Exception e) {
			log.error("Error al momento generar el documento Robo y/o Asalto en PDF", e);
			throw new HiperionException(e);
		}

	}

	/**
	 * @return the clausulasAdicionales
	 */
	public List<ClausulasAddRobo> getClausulasAdicionales() {
		return clausulasAdicionales;
	}

	/**
	 * @param clausulasAdicionales
	 *            the clausulasAdicionales to set
	 */
	public void setClausulasAdicionales(List<ClausulasAddRobo> clausulasAdicionales) {
		this.clausulasAdicionales = clausulasAdicionales;
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

	/**
	 * @return the coberturas
	 */
	public List<CoberturaRobo> getCoberturas() {
		return coberturas;
	}

	/**
	 * @param coberturas
	 *            the coberturas to set
	 */
	public void setCoberturas(List<CoberturaRobo> coberturas) {
		this.coberturas = coberturas;
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
	 * @return the coberturasAdd
	 */
	public List<CobertAddRobo> getCoberturasAdd() {
		return coberturasAdd;
	}

	/**
	 * @param coberturasAdd
	 *            the coberturasAdd to set
	 */
	public void setCoberturasAdd(List<CobertAddRobo> coberturasAdd) {
		this.coberturasAdd = coberturasAdd;
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

	/**
	 * @return the condicionesEspeciales
	 */
	public List<CondEspRobo> getCondicionesEspeciales() {
		return condicionesEspeciales;
	}

	/**
	 * @param condicionesEspeciales
	 *            the condicionesEspeciales to set
	 */
	public void setCondicionesEspeciales(List<CondEspRobo> condicionesEspeciales) {
		this.condicionesEspeciales = condicionesEspeciales;
	}

	/**
	 * @return the condicionesEspecialesDTO
	 */
	public List<CondicionEspecialDTO> getCondicionesEspecialesDTO() {
		return condicionesEspecialesDTO;
	}

	/**
	 * @param condicionesEspecialesDTO
	 *            the condicionesEspecialesDTO to set
	 */
	public void setCondicionesEspecialesDTO(List<CondicionEspecialDTO> condicionesEspecialesDTO) {
		this.condicionesEspecialesDTO = condicionesEspecialesDTO;
	}

}