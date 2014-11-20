/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.web.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <b> Permiete contener metodos para el manejo de fechas en el sistema </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Oct 12, 2014
 * @since JDK1.6
 */
public class FechasUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static FechasUtil INSTANCIA = new FechasUtil();

	// Devuelve la unica instancia de la clase
	public static FechasUtil getInstancia() {
		return INSTANCIA;
	}

	/**
	 * 
	 * <b> Permite convertir una feha a String a algo como martes 9 de julio de 2014 </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Oct 12, 2014]
	 * </p>
	 *
	 * @param fecha
	 * @return
	 */
	public String dateForStringFull(Date fecha) {
		DateFormat formato = DateFormat.getDateInstance(DateFormat.FULL, new Locale("es"));
		return formato.format(fecha);
	}

}
