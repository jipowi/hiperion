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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;

import ec.com.avila.emision.web.beans.ContactoBean;
import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.dto.ContactoDTO;
import ec.com.avila.hiperion.emision.entities.DetalleCatalogo;
import ec.com.avila.hiperion.servicio.DetalleCatalogoService;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Dario VInueza
 * @version 1.0,31/10/2014
 * @since JDK1.6
 */
@ManagedBean(name = "contactoBacking")
@ViewScoped
public class ContactoBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{contactoBean}")
	private ContactoBean contactoBean;

	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	private List<SelectItem> tipoContactosItems;

	@PostConstruct
	public void inicializar() {
		contactoBean.setActivarContacto(true);
		contactoBean.setContactosDTO(new ArrayList<ContactoDTO>());
		obtenerContactos();
	}

	public List<SelectItem> obtenerContactos() {
		try {
			List<DetalleCatalogo> detalleCatalogos = detalleCatalogoService.consultarDetalleCatalogoByCodCatalogo(new Long(23));
			if (detalleCatalogos != null && detalleCatalogos.size() > 0) {
				tipoContactosItems = new ArrayList<SelectItem>();
				for (DetalleCatalogo detalleCatalogo : detalleCatalogos) {
					SelectItem selectItem = new SelectItem(detalleCatalogo.getCodDetalleCatalogo(), detalleCatalogo.getDescDetCatalogo());
					tipoContactosItems.add(selectItem);
				}
			}
		} catch (HiperionException e) {
			e.printStackTrace();
		}

		return tipoContactosItems;
	}

	public void validarContacto() {
		if (!contactoBean.getTipoContacto().equals("")) {
			contactoBean.setActivarContacto(false);
			if (contactoBean.getTipoContacto().equals("CELULAR"))
				contactoBean.setLongitudDescripcionContacto(10);
			else if (contactoBean.getTipoContacto().equals("EMAIL"))
				contactoBean.setLongitudDescripcionContacto(50);
		} else {
			contactoBean.setActivarContacto(true);
		}
	}

	public void refreshContacto() {
		contactoBean.setActivarContacto(true);
		contactoBean.setDescripcionContacto("");
		contactoBean.setTipoContacto("");
	}

	public void guardarContacto() {
		ContactoDTO contactoDTO = new ContactoDTO();
		contactoDTO.setTipoContacto(contactoBean.getTipoContacto());
		contactoDTO.setDescripcionContacto(contactoBean.getDescripcionContacto());

		contactoBean.getContactosDTO().add(contactoDTO);

		// Cerramos el Dialogo.
		RequestContext.getCurrentInstance().execute("agregarContactoDlg.hide();");

		// Refrescamos los campos del Contacto
		refreshContacto();
	}

	public void cancelarContacto() {
		refreshContacto();
	}

	public void guardarContactos() {
	}

	public void cancelarContactos() {
		contactoBean.setContactosDTO(new ArrayList<ContactoDTO>());
	}

	/**
	 * @return the contactoBean
	 */
	public ContactoBean getContactoBean() {
		return contactoBean;
	}

	/**
	 * @param contactoBean
	 *            the contactoBean to set
	 */
	public void setContactoBean(ContactoBean contactoBean) {
		this.contactoBean = contactoBean;
	}

	/**
	 * @return the tipoContactosItems
	 */
	public List<SelectItem> getTipoContactosItems() {
		return tipoContactosItems;
	}

	/**
	 * @param tipoContactosItems
	 *            the tipoContactosItems to set
	 */
	public void setTipoContactosItems(List<SelectItem> tipoContactosItems) {
		this.tipoContactosItems = tipoContactosItems;
	}
}
