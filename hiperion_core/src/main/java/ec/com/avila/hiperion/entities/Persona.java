package ec.com.avila.hiperion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona")
	private Integer idPersona;

	@Column(name="actividad_profesion")
	private String actividadProfesion;

	@Column(name="apellido_materno")
	private String apellidoMaterno;

	@Column(name="apellido_paterno")
	private String apellidoPaterno;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="identificacion_persona")
	private String identificacionPersona;

	@Column(name="nombre_persona")
	private String nombrePersona;

	@Column(name="razon_social")
	private String razonSocial;

	@Column(name="tipo_identificacion")
	private String tipoIdentificacion;

	@Column(name="tipo_persona")
	private String tipoPersona;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="persona", cascade={CascadeType.ALL})
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="persona")
	private List<Direccion> direccions;

	//bi-directional many-to-one association to Encargado
	@OneToMany(mappedBy="persona")
	private List<Encargado> encargados;

	//bi-directional many-to-many association to Aseguradora
	@ManyToMany
	@JoinTable(
		name="persona_aseguradora"
		, joinColumns={
			@JoinColumn(name="id_persona")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_aseguradora")
			}
		)
	private List<Aseguradora> aseguradoras;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="persona")
	private List<Usuario> usuarios;

	//bi-directional many-to-one association to Contacto
	@OneToMany(mappedBy="persona")
	private List<Contacto> contactos;

	public Persona() {
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getActividadProfesion() {
		return this.actividadProfesion;
	}

	public void setActividadProfesion(String actividadProfesion) {
		this.actividadProfesion = actividadProfesion;
	}

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getIdentificacionPersona() {
		return this.identificacionPersona;
	}

	public void setIdentificacionPersona(String identificacionPersona) {
		this.identificacionPersona = identificacionPersona;
	}

	public String getNombrePersona() {
		return this.nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getTipoPersona() {
		return this.tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setPersona(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setPersona(null);

		return cliente;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setPersona(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setPersona(null);

		return direccion;
	}

	public List<Encargado> getEncargados() {
		return this.encargados;
	}

	public void setEncargados(List<Encargado> encargados) {
		this.encargados = encargados;
	}

	public Encargado addEncargado(Encargado encargado) {
		getEncargados().add(encargado);
		encargado.setPersona(this);

		return encargado;
	}

	public Encargado removeEncargado(Encargado encargado) {
		getEncargados().remove(encargado);
		encargado.setPersona(null);

		return encargado;
	}

	public List<Aseguradora> getAseguradoras() {
		return this.aseguradoras;
	}

	public void setAseguradoras(List<Aseguradora> aseguradoras) {
		this.aseguradoras = aseguradoras;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPersona(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPersona(null);

		return usuario;
	}

	public List<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Contacto addContacto(Contacto contacto) {
		getContactos().add(contacto);
		contacto.setPersona(this);

		return contacto;
	}

	public Contacto removeContacto(Contacto contacto) {
		getContactos().remove(contacto);
		contacto.setPersona(null);

		return contacto;
	}

}