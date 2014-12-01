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
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.RamoAgropecuarioService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.model.AnexosDataModel;
import ec.com.avila.hiperion.web.util.ArchivoUtil;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
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

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{ramoAgropecuarioBean}")
	private RamoAgropecuarioBean ramoAgropecuarioBean;

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
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: DARVIN, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCoberturasTransporte() {
		coberturasTransporte = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2 && anexo.getTitulo().getIdTitulo() == 1)
					coberturasTransporte.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(coberturasTransporte);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Incluir aqui­ la descripcion del metodo. </b>
	 * <p>
	 * [Author: DARVIN, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCoberturasVida() {
		coberturasVida = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 2 && anexo.getTitulo().getIdTitulo() == 2)
					coberturasVida.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
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
		agropecuario.setTasaAgro(ramoAgropecuarioBean.getTasa());
		agropecuario.setDeducAgro(ramoAgropecuarioBean.getDeducible());
		agropecuario.setValorAseguradoAgro(ramoAgropecuarioBean.getValorAsegurado());
		agropecuario.setDetalleAgro(ramoAgropecuarioBean.getDetalle());
		agropecuario.setUbicacionAgro(ramoAgropecuarioBean.getUbicacion());

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

}
