package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the grupo_asm database table.
 * 
 */
@Entity
@Table(name="grupo_asm")
@NamedQuery(name="GrupoAsm.findAll", query="SELECT g FROM GrupoAsm g")
public class GrupoAsm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_grupo_asm")
	private Integer idGrupoAsm;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Column(name="id_usuario_actualizacion")
	private Integer idUsuarioActualizacion;

	@Column(name="id_usuario_creacion")
	private Integer idUsuarioCreacion;

	@Column(name="nombre_grupo_asm")
	private String nombreGrupoAsm;

	@Column(name="numero_personas_asm")
	private Integer numeroPersonasAsm;

	//bi-directional many-to-one association to RamoAsistenciaMedica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ast_medica")
	private RamoAsistenciaMedica ramoAsistenciaMedica;

	//bi-directional many-to-one association to MiembrosGrupoAsm
	@OneToMany(mappedBy="grupoAsm")
	private List<MiembrosGrupoAsm> miembrosGrupoAsms;

	public GrupoAsm() {
	}

	public Integer getIdGrupoAsm() {
		return this.idGrupoAsm;
	}

	public void setIdGrupoAsm(Integer idGrupoAsm) {
		this.idGrupoAsm = idGrupoAsm;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getIdUsuarioActualizacion() {
		return this.idUsuarioActualizacion;
	}

	public void setIdUsuarioActualizacion(Integer idUsuarioActualizacion) {
		this.idUsuarioActualizacion = idUsuarioActualizacion;
	}

	public Integer getIdUsuarioCreacion() {
		return this.idUsuarioCreacion;
	}

	public void setIdUsuarioCreacion(Integer idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}

	public String getNombreGrupoAsm() {
		return this.nombreGrupoAsm;
	}

	public void setNombreGrupoAsm(String nombreGrupoAsm) {
		this.nombreGrupoAsm = nombreGrupoAsm;
	}

	public Integer getNumeroPersonasAsm() {
		return this.numeroPersonasAsm;
	}

	public void setNumeroPersonasAsm(Integer numeroPersonasAsm) {
		this.numeroPersonasAsm = numeroPersonasAsm;
	}

	public RamoAsistenciaMedica getRamoAsistenciaMedica() {
		return this.ramoAsistenciaMedica;
	}

	public void setRamoAsistenciaMedica(RamoAsistenciaMedica ramoAsistenciaMedica) {
		this.ramoAsistenciaMedica = ramoAsistenciaMedica;
	}

	public List<MiembrosGrupoAsm> getMiembrosGrupoAsms() {
		return this.miembrosGrupoAsms;
	}

	public void setMiembrosGrupoAsms(List<MiembrosGrupoAsm> miembrosGrupoAsms) {
		this.miembrosGrupoAsms = miembrosGrupoAsms;
	}

	public MiembrosGrupoAsm addMiembrosGrupoAsm(MiembrosGrupoAsm miembrosGrupoAsm) {
		getMiembrosGrupoAsms().add(miembrosGrupoAsm);
		miembrosGrupoAsm.setGrupoAsm(this);

		return miembrosGrupoAsm;
	}

	public MiembrosGrupoAsm removeMiembrosGrupoAsm(MiembrosGrupoAsm miembrosGrupoAsm) {
		getMiembrosGrupoAsms().remove(miembrosGrupoAsm);
		miembrosGrupoAsm.setGrupoAsm(null);

		return miembrosGrupoAsm;
	}

}