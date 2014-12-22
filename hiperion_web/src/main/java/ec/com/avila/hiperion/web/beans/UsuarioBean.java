package ec.com.avila.hiperion.web.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ec.com.avila.hiperion.emision.entities.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombreUsuario;
	private String password;
	private Exception exception;

	private Usuario sessionUser;

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario
	 *            the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the sessionUser
	 */
	public Usuario getSessionUser() {
		return sessionUser;
	}

	/**
	 * @param sessionUser
	 *            the sessionUser to set
	 */
	public void setSessionUser(Usuario sessionUser) {
		this.sessionUser = sessionUser;
	}

	/**
	 * @return the exception
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * @param exception
	 *            the exception to set
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}

}
