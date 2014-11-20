/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.backings;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * <b> Permite adminitrar la seguridad de la aplicacion </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Nov 8, 2014
 * @since JDK1.6
 */
@ManagedBean
@SessionScoped
public class SessionBacking {

	private String cedula;
	private String nombre;

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void buscarUsuario(){
		
	}
}
