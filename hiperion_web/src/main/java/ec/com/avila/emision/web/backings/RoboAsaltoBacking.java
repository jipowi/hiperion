/**
 * 
 */
package ec.com.avila.emision.web.backings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.RamoRoboAsaltoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ObjetoAseguradoRoboDTO;
import ec.com.avila.hiperion.emision.entities.ObjAsegRobo;
import ec.com.avila.hiperion.emision.entities.RamoRoboAsalto;
import ec.com.avila.hiperion.servicio.RamoRoboAsaltoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
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

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoRoboAsaltoService ramoRoboAsaltoService;

	Logger log = Logger.getLogger(RoboAsaltoBacking.class);

	RamoRoboAsalto ramoRoboAsalto = new RamoRoboAsalto();

	/**
	 * 
	 * <b> Permite setear la informacion del ramo Robo Asalto </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 08/09/2014]
	 * </p>
	 * 
	 */
	public void setearInfRamo() throws HiperionException {

		ramoRoboAsalto.setTasaRoboAsalto(ramoRoboAsaltoBean.getTasaRobo());
		ramoRoboAsalto.setTasaHurtoRobo(ramoRoboAsaltoBean.getMinimoHurto());
		ramoRoboAsalto.setTasaPropiedad(ramoRoboAsaltoBean.getTasaPropiedad());
		ramoRoboAsalto.setTasaContenidos(ramoRoboAsaltoBean.getTasaContenidos());
		//TODO agregar deducibles modelo
		
		
		MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.setearInformacion"));

	}

	public void guadraRamo() throws HiperionException{
		try{
			if(ramoRoboAsaltoBean.getObjetoaseguradolist().isEmpty()){
				List<ObjAsegRobo>listObjetos = new ArrayList<>();
				for(ObjetoAseguradoRoboDTO objeto : ramoRoboAsaltoBean.getObjetoaseguradolist()){
					ObjAsegRobo objAsegRobo = new ObjAsegRobo();
					
					objAsegRobo.setItemRoboAsalto(objeto.getNumeroItem());
					objAsegRobo.setValorObjRobo(objeto.getValorDetalleObjeto());
					//TODO revisar en el modelo
					//objAsegRobo.setUbicacionObjRobo(objeto.getUbicacionRiesgo());
					//objAsegRobo.setDetalleObjRobo(objeto.getDetalleObjeto());
					objAsegRobo.setMueblesObjRobo(objeto.getMueblesEnseresEquipos());
					objAsegRobo.setJoyasObjRobo(objeto.getJoyasObrasArte());
					objAsegRobo.setMaquinariaObjRobo(objeto.getMaquinaria());
					objAsegRobo.setDineroObjRobo(objeto.getDineroPermanencia());
					objAsegRobo.setMarcaderiaObjRobo(objeto.getMercaderia());
					listObjetos.add(objAsegRobo);
					
				}
				ramoRoboAsalto.setObjAsegRobos(listObjetos);
			}else{
				MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));
			}
			ramoRoboAsaltoService.guardarRamoRoboAsalto(ramoRoboAsalto);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save"));
			ramoRoboAsalto = new RamoRoboAsalto();
			ramoRoboAsaltoBean.getObjetoaseguradolist().clear();
		}catch(HiperionException e){
			log.error("Error al momento de guardar el ramo robo y/o asalto", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));

			throw new HiperionException(e);
		}
		
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
}