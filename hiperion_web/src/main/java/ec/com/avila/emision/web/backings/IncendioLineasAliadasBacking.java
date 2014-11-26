/**
 * 
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
import ec.com.avila.emision.web.beans.RamoIncendioLineasAliadaBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ObjetoAseguradoIlaDTO;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.ObjAsegIncendio;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoIncendioLineasAliada;
import ec.com.avila.hiperion.servicio.RamoIncendioLineasAliadaService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.model.AnexosDataModel;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b>Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Incendio y/o Lineas
 * Aliadas. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,17/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class IncendioLineasAliadasBacking implements Serializable {

	/**
	 * @return the ramoIncendioLineasAliadaBean
	 */
	public RamoIncendioLineasAliadaBean getRamoIncendioLineasAliadaBean() {
		return ramoIncendioLineasAliadaBean;
	}

	/**
	 * @param ramoIncendioLineasAliadaBean
	 *            the ramoIncendioLineasAliadaBean to set
	 */
	public void setRamoIncendioLineasAliadaBean(RamoIncendioLineasAliadaBean ramoIncendioLineasAliadaBean) {
		this.ramoIncendioLineasAliadaBean = ramoIncendioLineasAliadaBean;
	}

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{ramoIncendioLineasAliadaBean}")
	private RamoIncendioLineasAliadaBean ramoIncendioLineasAliadaBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoIncendioLineasAliadaService ramoIncendioLineasAliadaService;

	Logger log = Logger.getLogger(IncendioLineasAliadasBacking.class);

	private AnexosDataModel anexosDataModel;
	private List<DetalleAnexo> anexos;

	private List<DetalleAnexoBean> clausulasAdicionales;
	private List<DetalleAnexoBean> coberturas;
	private List<DetalleAnexoBean> coberturasAdicionales;
	private List<DetalleAnexoBean> condicionesEspecialesDineroValor;
	private List<DetalleAnexoBean> condicionesEspecialesEdificioInstalaciones;
	private List<DetalleAnexoBean> condicionesMaquinariaEquipos;
	private List<DetalleAnexoBean> condicionesActivosFlotantes;
	private List<DetalleAnexoBean> condicionesMueblesEnseres;
	private DetalleAnexoBean[] selectClausulasAdicionales;
	private DetalleAnexoBean[] selectCoberturas;
	private DetalleAnexoBean[] selectCoberturasAdicionales;
	private DetalleAnexoBean[] selectCondicionesEspecialesDineroValor;
	private DetalleAnexoBean[] selectCondicionesEspecialesEdificioInstalaciones;
	private DetalleAnexoBean[] selectCondicionesMaquinariaEquipos;
	private DetalleAnexoBean[] selectCondicionesActivosFlotantes;
	private DetalleAnexoBean[] selectCondicionesMueblesEnseres;

	RamoIncendioLineasAliada ramoIncendioLineasAliada = new RamoIncendioLineasAliada();

	@PostConstruct
	public void inicializar() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("ILA");
			anexos = ramo.getDetalleAnexos();
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las Clausulas Adicionales del Ramo Incendio Lineas Aliadas. </b>
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
	 * <b> Permite obtener las Coberturas del Ramo Incendio Lineas Aliadas. </b>
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
	 * <b> Permite obtener las Coberturas Adicionales del Ramo Incendio Lineas Aliadas. </b>
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
	 * <b> Permite obtener las Condiciones Especiales con titulo Dinero y Valores del Ramo Incendio Lineas Aliadas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCondicionesEspecialesDineroValores() {
		condicionesEspecialesDineroValor = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3 && anexo.getTitulo().getIdTitulo() == 8)
					condicionesEspecialesDineroValor.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(condicionesEspecialesDineroValor);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Condiciones Especiales Edificio e Instalaciones del Ramo Incendio Lineas Aliadas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCondicionesEspecialesEdificioInstalaciones() {
		condicionesEspecialesEdificioInstalaciones = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3 && anexo.getTitulo().getIdTitulo() == 9)
					condicionesEspecialesEdificioInstalaciones.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(condicionesEspecialesEdificioInstalaciones);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Condiciones Especiales con titulo Maquinaria y Equipos del Ramo Incendio Lineas Aliadas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCondicionesMaquinariaEquipos() {
		condicionesMaquinariaEquipos = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3 && anexo.getTitulo().getIdTitulo() == 10)
					condicionesMaquinariaEquipos.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(condicionesMaquinariaEquipos);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Condiciones Especiales con titulo Mercaderias y/o Activos Flotantes del Ramo Incendio Lineas Aliadas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCondicionesActivosFlotantes() {
		condicionesActivosFlotantes = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3 && anexo.getTitulo().getIdTitulo() == 11)
					condicionesActivosFlotantes.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(condicionesActivosFlotantes);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite obtener las Condiciones Especiales con titulo Muebles, Enseres y Equipos de Oficina del Ramo Incendio Lineas Aliadas. </b>
	 * <p>
	 * [Author: Dario Vinueza, Date: 20/04/2014]
	 * </p>
	 * 
	 * @return
	 */
	public AnexosDataModel obtenerCondicionesMueblesEnseres() {
		condicionesMueblesEnseres = new ArrayList<DetalleAnexoBean>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 3 && anexo.getTitulo().getIdTitulo() == 12)
					condicionesMueblesEnseres.add(new DetalleAnexoBean(anexo.getIdDetalleAnexo(), anexo.getNombreDetalleAnexo()));
			}

			anexosDataModel = new AnexosDataModel(condicionesMueblesEnseres);
		}

		return anexosDataModel;
	}

	/**
	 * 
	 * <b> Permite Ingresar Datos del ramo Incendio y Lineas Aliadas </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 04/09/2014]
	 * </p>
	 * 
	 * @throws HiperionException
	 */
	public void guardarRamo() throws HiperionException {
		try {

			if (!ramoIncendioLineasAliadaBean.getObjetolist().isEmpty()) {
				List<ObjAsegIncendio> objetosList = new ArrayList<>();
				for (ObjetoAseguradoIlaDTO objeto : ramoIncendioLineasAliadaBean.getObjetolist()) {
					ObjAsegIncendio objAsegIncendio = new ObjAsegIncendio();
					objAsegIncendio.setItemIncendio(objeto.getNumeroItem().toString());
					objAsegIncendio.setUbicacionIncendio(objeto.getUbicacionRiesgo());
					objAsegIncendio.setDetalleIncendio(objeto.getDetalle());
					// Falta agregar el campo valor
					objetosList.add(objAsegIncendio);
				}
				ramoIncendioLineasAliada.setObjAsegIncendios(objetosList);

			} else {
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.incendio.Obj"));
			}

			ramoIncendioLineasAliadaService.guardarRamoIncendioLineasAliada(ramoIncendioLineasAliada);

			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.incendioLineasAliadas"));

			ramoIncendioLineasAliada = new RamoIncendioLineasAliada();
			ramoIncendioLineasAliadaBean.getObjetolist().clear();

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el Ramo Incendio y Lineas Aliadas", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.incendioLineasAliadas"));
			throw new HiperionException(e);
		}
	}

	/**
	 * 
	 * <b> Permite guardar en memoria los datos del ramo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Oct 25, 2014]
	 * </p>
	 *
	 */
	public void setearInfRamo() {

		ramoIncendioLineasAliada.setValorItemsIncendio(ramoIncendioLineasAliadaBean.getValorItems());
		ramoIncendioLineasAliada.setConsideracionesImpIncendio(ramoIncendioLineasAliadaBean.getConsideracionesImp());
		ramoIncendioLineasAliada.setDeducTerremoto(ramoIncendioLineasAliadaBean.getMinimoTerremoto());
		ramoIncendioLineasAliada.setDeducLluvia(ramoIncendioLineasAliadaBean.getMinimoLluvia());
		ramoIncendioLineasAliada.setDeducOtros(ramoIncendioLineasAliadaBean.getMinimoOtrosEventos());
		ramoIncendioLineasAliada.setDeducVidrios(ramoIncendioLineasAliadaBean.getPorcentajeVidrios());
		ramoIncendioLineasAliada.setTasaComprensivaIncendio(ramoIncendioLineasAliadaBean.getTasaComprensiva());
		ramoIncendioLineasAliada.setTasaRemocion(ramoIncendioLineasAliadaBean.getTasaRemocionEscombros());
		ramoIncendioLineasAliada.setTasaDocumentos(ramoIncendioLineasAliadaBean.getTasaDocumentosModelos());
		ramoIncendioLineasAliada.setTasaHonorarios(ramoIncendioLineasAliadaBean.getTasaHonorarios());
		ramoIncendioLineasAliada.setTasaClaElectrica(ramoIncendioLineasAliadaBean.getTasaClausulaElectrica());
		ramoIncendioLineasAliada.setTasaAutoexplosion(ramoIncendioLineasAliadaBean.getTasaAutoexplosion());
		ramoIncendioLineasAliada.setTasaVidrios(ramoIncendioLineasAliadaBean.getTasaVidrios());
		// TODO Falta agregar los minimos del deducible
		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.setearDatos"));

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
	 * @return the selectCondicionesEspecialesDineroValor
	 */
	public DetalleAnexoBean[] getSelectCondicionesEspecialesDineroValor() {
		return selectCondicionesEspecialesDineroValor;
	}

	/**
	 * @param selectCondicionesEspecialesDineroValor
	 *            the selectCondicionesEspecialesDineroValor to set
	 */
	public void setSelectCondicionesEspecialesDineroValor(DetalleAnexoBean[] selectCondicionesEspecialesDineroValor) {
		this.selectCondicionesEspecialesDineroValor = selectCondicionesEspecialesDineroValor;
	}

	/**
	 * @return the selectCondicionesEspecialesEdificioInstalaciones
	 */
	public DetalleAnexoBean[] getSelectCondicionesEspecialesEdificioInstalaciones() {
		return selectCondicionesEspecialesEdificioInstalaciones;
	}

	/**
	 * @param selectCondicionesEspecialesEdificioInstalaciones
	 *            the selectCondicionesEspecialesEdificioInstalaciones to set
	 */
	public void setSelectCondicionesEspecialesEdificioInstalaciones(DetalleAnexoBean[] selectCondicionesEspecialesEdificioInstalaciones) {
		this.selectCondicionesEspecialesEdificioInstalaciones = selectCondicionesEspecialesEdificioInstalaciones;
	}

	/**
	 * @return the selectCondicionesMaquinariaEquipos
	 */
	public DetalleAnexoBean[] getSelectCondicionesMaquinariaEquipos() {
		return selectCondicionesMaquinariaEquipos;
	}

	/**
	 * @param selectCondicionesMaquinariaEquipos
	 *            the selectCondicionesMaquinariaEquipos to set
	 */
	public void setSelectCondicionesMaquinariaEquipos(DetalleAnexoBean[] selectCondicionesMaquinariaEquipos) {
		this.selectCondicionesMaquinariaEquipos = selectCondicionesMaquinariaEquipos;
	}

	/**
	 * @return the selectCondicionesActivosFlotantes
	 */
	public DetalleAnexoBean[] getSelectCondicionesActivosFlotantes() {
		return selectCondicionesActivosFlotantes;
	}

	/**
	 * @param selectCondicionesActivosFlotantes
	 *            the selectCondicionesActivosFlotantes to set
	 */
	public void setSelectCondicionesActivosFlotantes(DetalleAnexoBean[] selectCondicionesActivosFlotantes) {
		this.selectCondicionesActivosFlotantes = selectCondicionesActivosFlotantes;
	}

	/**
	 * @return the selectCondicionesMueblesEnseres
	 */
	public DetalleAnexoBean[] getSelectCondicionesMueblesEnseres() {
		return selectCondicionesMueblesEnseres;
	}

	/**
	 * @param selectCondicionesMueblesEnseres
	 *            the selectCondicionesMueblesEnseres to set
	 */
	public void setSelectCondicionesMueblesEnseres(DetalleAnexoBean[] selectCondicionesMueblesEnseres) {
		this.selectCondicionesMueblesEnseres = selectCondicionesMueblesEnseres;
	}
}