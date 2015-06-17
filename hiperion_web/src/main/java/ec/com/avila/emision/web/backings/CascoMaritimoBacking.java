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
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import ec.com.avila.emision.web.beans.RamoCascoMaritimoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.CoberturaAdicionalDTO;
import ec.com.avila.hiperion.emision.entities.Catalogo;
import ec.com.avila.hiperion.emision.entities.CobertAddCasco;
import ec.com.avila.hiperion.emision.entities.DetalleAnexo;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.emision.entities.Ramo;
import ec.com.avila.hiperion.emision.entities.RamoCascoMaritimo;
import ec.com.avila.hiperion.emision.entities.Usuario;
import ec.com.avila.hiperion.enumeration.EstadoEnum;
import ec.com.avila.hiperion.servicio.CatalogoService;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;
import ec.com.avila.hiperion.servicio.RamoCascoMaritimoService;
import ec.com.avila.hiperion.servicio.RamoService;
import ec.com.avila.hiperion.web.beans.RamoBean;
import ec.com.avila.hiperion.web.beans.UsuarioBean;
import ec.com.avila.hiperion.web.util.HiperionMensajes;
import ec.com.avila.hiperion.web.util.MessagesController;

/**
 * <b> Clase Baking que permite gestionar la informaci&oacute;n que se maneje en las p&acute;ginas web que utilicen el Ramo Casco Maritimo. </b>
 * 
 * @author Dario Vinueza
 * @version 1.0,18/02/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class CascoMaritimoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{ramoBean}")
	private RamoBean ramoBean;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private RamoService ramoService;
	@EJB
	private RamoCascoMaritimoService ramoCascoMaritimoService;

	@ManagedProperty(value = "#{ramoCascoMaritimoBean}")
	private RamoCascoMaritimoBean ramoCascoMaritimoBean;

	private List<SelectItem> embarcacionItems;
	private List<SelectItem> zonasItems;
	private List<CobertAddCasco> coberturasAdd;
	private List<CoberturaAdicionalDTO> coberturasAddDTO = new ArrayList<>();
	private List<DetalleAnexo> anexos;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	Logger log = Logger.getLogger(CascoMaritimoBacking.class);

	@PostConstruct
	public void inicializar() {
		try {
			Ramo ramo = ramoService.consultarRamoPorCodigo("CM");
			anexos = ramo.getDetalleAnexos();
			obtenerCoberturasAdicionales();
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * <b> Permite obtener las coberturas adicionales del ramo Casco Maritimo </b>
	 * <p>
	 * [Author: Franklin Pozo B., Date: 16/06/2015]
	 * </p>
	 * 
	 */
	public void obtenerCoberturasAdicionales() {
		coberturasAdd = new ArrayList<CobertAddCasco>();
		if (anexos != null && anexos.size() > 0) {
			for (DetalleAnexo anexo : anexos) {
				if (anexo.getAnexo().getIdAnexo() == 6) {
					CobertAddCasco cobertura = new CobertAddCasco();
					cobertura.setCoberturaCasco(anexo.getNombreDetalleAnexo());

					coberturasAdd.add(cobertura);
				}
			}

			for (CobertAddCasco coberturaAdd : coberturasAdd) {
				CoberturaAdicionalDTO coberturaAdicionalDTO = new CoberturaAdicionalDTO();
				coberturaAdicionalDTO.setCobertura(coberturaAdd.getCoberturaCasco());

				coberturasAddDTO.add(coberturaAdicionalDTO);
			}
		}
	}

	/**
	 * 
	 * <b> Permite guardar un objeto Ramo Casco Maritimo en la base de datos </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 15/08/2014]
	 * </p>
	 * 
	 */
	public void guardarRamo() throws HiperionException {
		Usuario usuario = usuarioBean.getSessionUser();
		RamoCascoMaritimo cascoMaritimo = new RamoCascoMaritimo();

		cascoMaritimo.setNombreNave(ramoCascoMaritimoBean.getNombreNave());
		cascoMaritimo.setNumeroRegistro(ramoCascoMaritimoBean.getNumeroRegistro());
		cascoMaritimo.setTonelajeBruto(ramoCascoMaritimoBean.getTonelajeBruto());
		cascoMaritimo.setClaseEmbarcacion(ramoCascoMaritimoBean.getClaseEmbarcacion());
		cascoMaritimo.setBandera(ramoCascoMaritimoBean.getBandera());
		cascoMaritimo.setZonaNavegacion(ramoCascoMaritimoBean.getZonaNavegacion());
		cascoMaritimo.setEslora(ramoCascoMaritimoBean.getEslora());
		cascoMaritimo.setPuntal(ramoCascoMaritimoBean.getPuntal());
		cascoMaritimo.setAnioConstrMaritimo(ramoCascoMaritimoBean.getAnioConstruccion());
		cascoMaritimo.setManga(ramoCascoMaritimoBean.getManga());
		cascoMaritimo.setMarcaMotorMaritimo(ramoCascoMaritimoBean.getMarcaMotor());
		cascoMaritimo.setValorCascoMaritimo(ramoCascoMaritimoBean.getValorCasco());
		cascoMaritimo.setValorMaquinariaMaritimo(ramoCascoMaritimoBean.getValorMaquina());
		cascoMaritimo.setValorRedes(ramoCascoMaritimoBean.getValorRedes());
		cascoMaritimo.setOtrosMaritimo(ramoCascoMaritimoBean.getOtros());
		cascoMaritimo.setTotalMaritimo(ramoCascoMaritimoBean.getOtros());

		cascoMaritimo.setIdUsuarioCreacion(usuario.getIdUsuario());
		cascoMaritimo.setFechaCreacion(new Date());
		cascoMaritimo.setEstado(EstadoEnum.A);

		try {
			ramoCascoMaritimoService.guardarRamoCascoMaritimo(cascoMaritimo);
			MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.save.sOjeto"));

		} catch (HiperionException e) {
			log.error("Error al momento de guardar el Ramo Casco Maritimo", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("Hiperion.mensaje.error.cascoMaritimo"));
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
	 * 
	 * <b> Permite consultar el catalogo de embarcaciones </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Apr 12, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getEmbarcacionItems() throws HiperionException {
		this.embarcacionItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoClaseEmbarcacion"));
		List<DetalleCatalogo> embarcaciones = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : embarcaciones) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			embarcacionItems.add(selectItem);
		}

		return embarcacionItems;
	}

	/**
	 * 
	 * <b> Permite consultar las zonas de navegacion </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Apr 12, 2014]
	 * </p>
	 * 
	 * @return
	 * @throws HiperionException
	 */
	public List<SelectItem> getZonasItems() throws HiperionException {
		this.zonasItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"ec.gob.avila.hiperion.recursos.catalogoZonaNavegacion"));
		List<DetalleCatalogo> zonas = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : zonas) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			zonasItems.add(selectItem);
		}

		return zonasItems;
	}

	/**
	 * @return the ramoCascoMaritimoBean
	 */
	public RamoCascoMaritimoBean getRamoCascoMaritimoBean() {
		return ramoCascoMaritimoBean;
	}

	/**
	 * @param ramoCascoMaritimoBean
	 *            the ramoCascoMaritimoBean to set
	 */
	public void setRamoCascoMaritimoBean(RamoCascoMaritimoBean ramoCascoMaritimoBean) {
		this.ramoCascoMaritimoBean = ramoCascoMaritimoBean;
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
