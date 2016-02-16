/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.enumeration;

/**
 * 
 * <b> Enumeracion que contiene la lista de ramos </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Nov 24, 2014
 * @since JDK1.6
 */
public enum RamoEnum {

	R1("ACCIDEENTES PERSONALES"), 
	R2("AGROPECUARIO");

	private String label;

	RamoEnum(String label) {
		this.label = label;
	}

	/**
	 * @return el valor de la variable label
	 */
	public String getLabel() {
		return label;
	}

}
