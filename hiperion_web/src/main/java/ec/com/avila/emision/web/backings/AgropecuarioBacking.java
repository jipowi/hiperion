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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import ec.com.avila.emision.web.beans.DetalleAnexoBean;
import ec.com.avila.emision.web.beans.RamoAgropecuarioBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ObjetoAseguradoAgropecuarioDTO;
import ec.com.avila.hiperion.emision.entities.ArchivoBase;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.ObjAsegAgropecuario;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoAgropecuario;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.RamoAgropecuarioService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.model.AnexosDataModel;
import ec.com.avila.hiperion.web.util.ArchivoUtil;
import ec.com.avila.hiperion.web.util.ConstantesUtil;
import ec.com.avila.hiperion.web.util.GenerarPdfUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.JsfUtil;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Agropecuario. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class AgropecuarioBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private RamoService ramoService;

	@EJB
	private RamoAgropecuarioService ramoAgropecuarioService;

	@EJB
	private CatalogoService catalogoService;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{ramoAgropecuarioBean}")
	private RamoAgropecuarioBean ramoAgropecuarioBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	private AnexosDataModel anexosDataModel;
	private List<DetalleAnexo> anexos;
	private List<DetalleAnexoBean> clausulasAdicionales;
	private List<DetalleAnexoBean> coberturasTransporte;
	private List<DetalleAnexoBean> coberturasVida;
	private DetalleAnexoBean[] selectClausulasAdicionales;
	private DetalleAnexoBean[] selectCoberturasTransporte;
	private DetalleAnexoBean[] selectCoberturasVida;
	private UploadedFile file;
	private List<SelectItem> sexoItems;
	private List<SelectItem> tipoObjetoItems;

	Logger log = Logger.getLogger(AgropecuarioBacking.class);

	RamoAgropecuario agropecuario = new RamoAgropecuario();

	@PostConstruct
	public void inicializar() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("AGP");
			anexos = ramo.getDetalleAnexos();
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Clausulas Adicionales del Ramo Accidentes Personales. </b>
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
	 * <b>Permite obtener las coberturas de transporte </b>
	 * <p>
	 * [Author: DARVIN, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public AnexosDataModel obtenerCoberturasTransporte() throws HiperionException {

		coberturasTransporte = new ArrayList<DetalleAnexoBean>();

		if (anexos != null && anexos.size() > 0) {
			List<DetalleAnexo> detallesTransporte = new ArrayList<>();
			for (DetalleAnexo detalleAnexo : anexos) {
				if (detalleAnexo.getTitulo() != null) {
					detallesTransporte = ramoAgropecuarioService.consultarDetallesByTitulo(detalleAnexo.getRamo().getIdRamo(), new Long(1));
				}
			}
			for (DetalleAnexo detalle : detallesTransporte) {
				coberturasTransporte.add(new DetalleAnexoBean(detalle.getIdDetalleAnexo(), detalle.getNombreDetalleAnexo()));
			}
			anexosDataModel = new AnexosDataModel(coberturasTransporte);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b>Permite obtener las coberturas por medio del ramo </b>
	 * <p>
	 * [Author: DARVIN, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public AnexosDataModel obtenerCoberturasVida() throws HiperionException {
		coberturasVida = new ArrayList<DetalleAnexoBean>();

		if (anexos != null && anexos.size() > 0) {
			List<DetalleAnexo> detallesVida = new ArrayList<>();
			for (DetalleAnexo detalleAnexo : anexos) {
				if (detalleAnexo.getTitulo() != null) {
					detallesVida = ramoAgropecuarioService.consultarDetallesByTitulo(detalleAnexo.getRamo().getIdRamo(), new Long(2));
				}
			}
			for (DetalleAnexo detalle : detallesVida) {
				coberturasVida.add(new DetalleAnexoBean(detalle.getIdDetalleAnexo(), detalle.getNombreDetalleAnexo()));
			}
			anexosDataModel = new AnexosDataModel(coberturasVida);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite setaer la informacion del ramo antes de guardar en la base </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 28, 2014]
	 * </p>
	 * 
	 */
	public void setearRamo() {
		Usuario usuario = usuarioBean.getSessionUser();

		agropecuario.setTasaAgro(ramoAgropecuarioBean.getTasa());
		agropecuario.setDeducAgro(ramoAgropecuarioBean.getDeducible());
		agropecuario.setValorAseguradoAgro(ramoAgropecuarioBean.getValorAsegurado());
		agropecuario.setDetalleAgro(ramoAgropecuarioBean.getDetalle());
		agropecuario.setUbicacionAgro(ramoAgropecuarioBean.getUbicacion());
		agropecuario.setIdUsuarioCreacion(usuario.getIdUsuario());
		agropecuario.setFechaCreacion(new Date());
		agropecuario.setEstado(EstadoEnum.A);

		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.setearInformacion"));
	}

	/**
	 * 
	 * <b> Permite guardar la informacion en la base de datos </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 15, 2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {

		try {
			if (!ramoAgropecuarioBean.getObjetoAseguradoList().isEmpty()) {

				List<ObjAsegAgropecuario> listObjetos = new ArrayList<>();
				for (ObjetoAseguradoAgropecuarioDTO objeto : ramoAgropecuarioBean.getObjetoAseguradoList()) {
					ObjAsegAgropecuario objAsegAgropecuario = new ObjAsegAgropecuario();

					objAsegAgropecuario.setRamoAgropecuario(agropecuario);
					objAsegAgropecuario.setItemObjAgro(objeto.getItem());
					objAsegAgropecuario.setNombreObjAgro(objeto.getNombre());
					objAsegAgropecuario.setSexoObjAgro(objeto.getSexo());
					objAsegAgropecuario.setRazaObjAgro(objeto.getRaza());
					objAsegAgropecuario.setColorObjAgro(objeto.getColor());
					objAsegAgropecuario.setEdadObjAgro(objeto.getEdad());
					objAsegAgropecuario.setMontoAsegObjAgro(objeto.getMontoAsegurado());

					Usuario usuario = usuarioBean.getSessionUser();
					objAsegAgropecuario.setIdUsuarioCreacion(usuario.getIdUsuario());
					objAsegAgropecuario.setFechaCreacion(new Date());
					objAsegAgropecuario.setEstado(EstadoEnum.A);
					listObjetos.add(objAsegAgropecuario);
				}
				agropecuario.setObjAsegAgropecuarios(listObjetos);
			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save.Obj"));
			}

			// if (ramoAgropecuarioBean.getFilePolizaVigente() != null) {
			// ramoAgropecuarioService.guardarArchivoPoliza(ramoAgropecuarioBean.getFilePolizaVigente());
			ramoAgropecuarioService.guardarAgropecuario(agropecuario);

			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
			agropecuario = new RamoAgropecuario();
			ramoAgropecuarioBean.getObjetoAseguradoList().clear();
			// } else {
			// MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.agropecuario"));
			// }

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el ramo agropecuario", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));

			throw new HiperionException(e);
		}

	}

	/**
	 * 
	 * <b> Permite cargar el archivo en memoria antes de ser guardado </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Sep 28, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void cargarArchivoPoliza(FileUploadEvent event) {

		if (event.getFile() != null) {

			try {

				UploadedFile file = event.getFile();

				ArchivoBase archivoBase = new ArchivoBase();

				ramoAgropecuarioBean.setFilePolizaVigente(archivoBase);
				ArchivoUtil.getInstancia().agregarArchivo(archivoBase, file);

				FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, message);

			} catch (Exception e) {
				log.error("Error {}", e);
			}
		}
	}

	/**
	 * 
	 * <b> Permite obtner la lista de sexos disponibles en el catalogo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Sep 27, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getSexoItems() throws HiperionException {

		this.sexoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoSexo"));
		List<DetalleCatalogo> sexos = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : sexos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			sexoItems.add(selectItem);
		}

		return sexoItems;
	}

	/**
	 * @param sexoItems
	 *            the sexoItems to set
	 */
	public void setSexoItems(List<SelectItem> sexoItems) {
		this.sexoItems = sexoItems;
	}

	/**
	 * 
	 * <b>
	 * Permite obtener la lista de del los objetos asegurados
	 * </b>
	 * <p>[Author: Franklin Pozo, Date: 27/01/2015]</p>
	 *
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getTipoObjetoItems() throws HiperionException {
		this.tipoObjetoItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoTipoObjetoAgropecuario"));
		List<DetalleCatalogo> sexos = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : sexos) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			tipoObjetoItems.add(selectItem);
		}
		return tipoObjetoItems;
	}

	/**
	 * @param tipoObjetoItems
	 *            the tipoObjetoItems to set
	 */
	public void setTipoObjetoItems(List<SelectItem> tipoObjetoItems) {
		this.tipoObjetoItems = tipoObjetoItems;
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
	 * @return the ramoAgropecuarioBean
	 */
	public RamoAgropecuarioBean getRamoAgropecuarioBean() {
		return ramoAgropecuarioBean;
	}

	/**
	 * @param ramoAgropecuarioBean
	 *            the ramoAgropecuarioBean to set
	 */
	public void setRamoAgropecuarioBean(RamoAgropecuarioBean ramoAgropecuarioBean) {
		this.ramoAgropecuarioBean = ramoAgropecuarioBean;
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
	 * @return the selectCoberturasTransporte
	 */
	public DetalleAnexoBean[] getSelectCoberturasTransporte() {
		return selectCoberturasTransporte;
	}

	/**
	 * @param selectCoberturasTransporte
	 *            the selectCoberturasTransporte to set
	 */
	public void setSelectCoberturasTransporte(DetalleAnexoBean[] selectCoberturasTransporte) {
		this.selectCoberturasTransporte = selectCoberturasTransporte;
	}

	/**
	 * @return the selectCoberturasVida
	 */
	public DetalleAnexoBean[] getSelectCoberturasVida() {
		return selectCoberturasVida;
	}

	/**
	 * @param selectCoberturasVida
	 *            the selectCoberturasVida to set
	 */
	public void setSelectCoberturasVida(DetalleAnexoBean[] selectCoberturasVida) {
		this.selectCoberturasVida = selectCoberturasVida;
	}

	/**
	 * @return the file
	 */
	public UploadedFile getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(UploadedFile file) {
		this.file = file;
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
	 * <b> Permite generar y descargar la hoja de vida en formato PDF. </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 01/03/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void descargarAgropecuarioPDF() throws HiperionException {
		try {
			Map<String, Object> parametrosReporte = new HashMap<String, Object>();

			parametrosReporte.put(ConstantesUtil.CONTENT_TYPE_IDENTIFICADOR, ConstantesUtil.CONTENT_TYPE_PDF);
			parametrosReporte.put(ConstantesUtil.NOMBRE_ARCHIVO_IDENTIFICADOR, usuarioBean.getSessionUser().getIdentificacionUsuario());

			parametrosReporte.put(ConstantesUtil.CONTENIDO_BYTES_IDENTIFICADOR,GenerarPdfUtil.generarAchivoPDFAgropecuario(agropecuario));

			JsfUtil.setSessionAttribute(ConstantesUtil.PARAMETROS_DESCARGADOR_IDENTIFICADOR, parametrosReporte);
			JsfUtil.downloadFile();

		} catch (Exception e) {
			log.error("Error al momento generar el a hoja de vida en PDF", e);
			throw new HiperionException(e);
		}

	}
	
}
