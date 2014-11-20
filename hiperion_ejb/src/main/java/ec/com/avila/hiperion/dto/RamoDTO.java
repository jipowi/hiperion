/**
 * 
 */
package ec.com.avila.hiperion.dto;

import java.math.BigDecimal;

/**
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Aug 10, 2014
 * @since JDK1.6
 */
public class RamoDTO {

	private String nombreRamo;
	private BigDecimal comision;

	/**
	 * @param nombreRamo
	 * @param comision
	 */
	public RamoDTO(String nombreRamo, BigDecimal comision) {
		super();
		this.nombreRamo = nombreRamo;
		this.comision = comision;
	}

	/**
	 * @return the nombreRamo
	 */
	public String getNombreRamo() {
		return nombreRamo;
	}

	/**
	 * @param nombreRamo
	 *            the nombreRamo to set
	 */
	public void setNombreRamo(String nombreRamo) {
		this.nombreRamo = nombreRamo;
	}

	/**
	 * @return the comision
	 */
	public BigDecimal getComision() {
		return comision;
	}

	/**
	 * @param comision
	 *            the comision to set
	 */
	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

}
