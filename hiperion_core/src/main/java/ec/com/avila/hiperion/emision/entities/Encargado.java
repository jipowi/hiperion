package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the encargado database table.
 * 
 */
@Entity
@NamedQuery(name="Encargado.findAll", query="SELECT e FROM Encargado e")
public class Encargado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_encargado")
	private Integer idEncargado;

	@Column(name="apellido_materno_encargado")
	private String apellidoMaternoEncargado;

	@Column(name="apellido_paterno_encargado")
	private String apellidoPaternoEncargado;

	private String cargo;

	@Column(name="nombre_encargado")
	private String nombreEncargado;

	@Column(name="tipo_titulo")
	private String tipoTitulo;

	//bi-directional many-to-one association to Contacto
	@OneToMany(mappedBy="encargado")
	private List<Contacto> contactos;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_persona")
	private Persona persona;

	public Encargado() {
	}

	public Integer getIdEncargado() {
		return this.idEncargado;
	}

	public void setIdEncargado(Integer idEncargado) {
		this.idEncargado = idEncargado;
	}

	public String getApellidoMaternoEncargado() {
		return this.apellidoMaternoEncargado;
	}

	public void setApellidoMaternoEncargado(String apellidoMaternoEncargado) {
		this.apellidoMaternoEncargado = apellidoMaternoEncargado;
	}

	public String getApellidoPaternoEncargado() {
		return this.apellidoPaternoEncargado;
	}

	public void setApellidoPaternoEncargado(String apellidoPaternoEncargado) {
		this.apellidoPaternoEncargado = apellidoPaternoEncargado;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNombreEncargado() {
		return this.nombreEncargado;
	}

	public void setNombreEncargado(String nombreEncargado) {
		this.nombreEncargado = nombreEncargado;
	}

	public String getTipoTitulo() {
		return this.tipoTitulo;
	}

	public void setTipoTitulo(String tipoTitulo) {
		this.tipoTitulo = tipoTitulo;
	}

	public List<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Contacto addContacto(Contacto contacto) {
		getContactos().add(contacto);
		contacto.setEncargado(this);

		return contacto;
	}

	public Contacto removeContacto(Contacto contacto) {
		getContactos().remove(contacto);
		contacto.setEncargado(null);

		return contacto;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}