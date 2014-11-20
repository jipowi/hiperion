package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the miembros_grupo_asm database table.
 * 
 */
@Entity
@Table(name="miembros_grupo_asm")
@NamedQuery(name="MiembrosGrupoAsm.findAll", query="SELECT m FROM MiembrosGrupoAsm m")
public class MiembrosGrupoAsm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_miembro_asm")
	private Integer idMiembroAsm;

	@Column(name="cedula_miembro_asm")
	private String cedulaMiembroAsm;

	@Temporal(TemporalType.DATE)
	@Column(name="edad_miembro_asm")
	private Date edadMiembroAsm;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento_asm")
	private Date fechaNacimientoAsm;

	@Column(name="id_usuario_actualizacion")
	private Integer idUsuarioActualizacion;

	@Column(name="id_usuario_creacion")
	private Integer idUsuarioCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name="modalidad_asm")
	private Date modalidadAsm;

	@Column(name="nombre_miembro_asm")
	private String nombreMiembroAsm;

	@Column(name="parentezco_asm")
	private String parentezcoAsm;

	@Column(name="sexo_miembro_asm")
	private String sexoMiembroAsm;

	//bi-directional many-to-one association to GrupoAsm
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_grupo_asm")
	private GrupoAsm grupoAsm;

	public MiembrosGrupoAsm() {
	}

	public Integer getIdMiembroAsm() {
		return this.idMiembroAsm;
	}

	public void setIdMiembroAsm(Integer idMiembroAsm) {
		this.idMiembroAsm = idMiembroAsm;
	}

	public String getCedulaMiembroAsm() {
		return this.cedulaMiembroAsm;
	}

	public void setCedulaMiembroAsm(String cedulaMiembroAsm) {
		this.cedulaMiembroAsm = cedulaMiembroAsm;
	}

	public Date getEdadMiembroAsm() {
		return this.edadMiembroAsm;
	}

	public void setEdadMiembroAsm(Date edadMiembroAsm) {
		this.edadMiembroAsm = edadMiembroAsm;
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

	public Date getFechaNacimientoAsm() {
		return this.fechaNacimientoAsm;
	}

	public void setFechaNacimientoAsm(Date fechaNacimientoAsm) {
		this.fechaNacimientoAsm = fechaNacimientoAsm;
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

	public Date getModalidadAsm() {
		return this.modalidadAsm;
	}

	public void setModalidadAsm(Date modalidadAsm) {
		this.modalidadAsm = modalidadAsm;
	}

	public String getNombreMiembroAsm() {
		return this.nombreMiembroAsm;
	}

	public void setNombreMiembroAsm(String nombreMiembroAsm) {
		this.nombreMiembroAsm = nombreMiembroAsm;
	}

	public String getParentezcoAsm() {
		return this.parentezcoAsm;
	}

	public void setParentezcoAsm(String parentezcoAsm) {
		this.parentezcoAsm = parentezcoAsm;
	}

	public String getSexoMiembroAsm() {
		return this.sexoMiembroAsm;
	}

	public void setSexoMiembroAsm(String sexoMiembroAsm) {
		this.sexoMiembroAsm = sexoMiembroAsm;
	}

	public GrupoAsm getGrupoAsm() {
		return this.grupoAsm;
	}

	public void setGrupoAsm(GrupoAsm grupoAsm) {
		this.grupoAsm = grupoAsm;
	}

}