/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Mar 2, 2014
 * @since JDK1.6
 */
public class ObjetoAseguradoMontajeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String detalle;

	public ObjetoAseguradoMontajeBean(String detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle
	 *            the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}
