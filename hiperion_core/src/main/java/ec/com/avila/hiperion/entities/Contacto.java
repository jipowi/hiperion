package ec.com.avila.hiperion.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The persistent class for the contacto database table.
 * 
 */
@Entity
public class Contacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contacto")
	private String idContacto;

	@Column(name = "descripcion_contacto")
	private String descripcionContacto;

	@Column(name = "tipo_contacto")
	private String tipoContacto;

	// bi-directional many-to-one association to Encargado
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_encargado")
	private Encargado encargado;

	// bi-directional many-to-one association to Persona
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona")
	private Persona persona;

	public Contacto() {
	}

	public String getIdContacto() {
		return this.idContacto;
	}

	public void setIdContacto(String idContacto) {
		this.idContacto = idContacto;
	}

	public String getDescripcionContacto() {
		return this.descripcionContacto;
	}

	public void setDescripcionContacto(String descripcionContacto) {
		this.descripcionContacto = descripcionContacto;
	}

	public String getTipoContacto() {
		return this.tipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public Encargado getEncargado() {
		return this.encargado;
	}

	public void setEncargado(Encargado encargado) {
		this.encargado = encargado;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}