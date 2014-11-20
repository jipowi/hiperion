/**
 * 
 */
package ec.com.avila.hiperion.dto;

/**
 * <b> Permiete manejar la informacion de la aseguradora </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Aug 26, 2014
 * @since JDK1.6
 */
public class AseguradoraDTO {

	private String nombreAseguradora;
	private String direcion;
	private String email;
	private String ruc;
	private String telefono;

	/**
	 * @return the nombreAseguradora
	 */
	public String getNombreAseguradora() {
		return nombreAseguradora;
	}

	/**
	 * @param nombreAseguradora
	 *            the nombreAseguradora to set
	 */
	public void setNombreAseguradora(String nombreAseguradora) {
		this.nombreAseguradora = nombreAseguradora;
	}

	/**
	 * @return the direcion
	 */
	public String getDirecion() {
		return direcion;
	}

	/**
	 * @param direcion
	 *            the direcion to set
	 */
	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the ruc
	 */
	public String getRuc() {
		return ruc;
	}

	/**
	 * @param ruc
	 *            the ruc to set
	 */
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
