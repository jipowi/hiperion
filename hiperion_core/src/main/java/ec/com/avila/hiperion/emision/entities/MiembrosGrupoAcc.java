package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the miembros_grupo_acc database table.
 * 
 */
@Entity
@Table(name="miembros_grupo_acc")
@NamedQuery(name="MiembrosGrupoAcc.findAll", query="SELECT m FROM MiembrosGrupoAcc m")
public class MiembrosGrupoAcc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_miembro_accp")
	private Integer idMiembroAccp;

	@Column(name="cedula_miembro")
	private String cedulaMiembro;

	@Column(name="edad_miembro")
	private Integer edadMiembro;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento_miembro")
	private Date fechaNacimientoMiembro;

	@Column(name="id_usuario_actualizacion")
	private Integer idUsuarioActualizacion;

	@Column(name="id_usuario_creacion")
	private Integer idUsuarioCreacion;

	@Column(name="modalidad_acc")
	private Integer modalidadAcc;

	@Column(name="nombre_miembro")
	private String nombreMiembro;

	@Column(name="parentezco_miembro")
	private String parentezcoMiembro;

	@Column(name="sexo_miebro")
	private String sexoMiebro;

	//bi-directional many-to-one association to GrupoAccPersonale
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_grupo_accp")
	private GrupoAccPersonale grupoAccPersonale;

	public MiembrosGrupoAcc() {
	}

	public Integer getIdMiembroAccp() {
		return this.idMiembroAccp;
	}

	public void setIdMiembroAccp(Integer idMiembroAccp) {
		this.idMiembroAccp = idMiembroAccp;
	}

	public String getCedulaMiembro() {
		return this.cedulaMiembro;
	}

	public void setCedulaMiembro(String cedulaMiembro) {
		this.cedulaMiembro = cedulaMiembro;
	}

	public Integer getEdadMiembro() {
		return this.edadMiembro;
	}

	public void setEdadMiembro(Integer edadMiembro) {
		this.edadMiembro = edadMiembro;
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

	public Date getFechaNacimientoMiembro() {
		return this.fechaNacimientoMiembro;
	}

	public void setFechaNacimientoMiembro(Date fechaNacimientoMiembro) {
		this.fechaNacimientoMiembro = fechaNacimientoMiembro;
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

	public Integer getModalidadAcc() {
		return this.modalidadAcc;
	}

	public void setModalidadAcc(Integer modalidadAcc) {
		this.modalidadAcc = modalidadAcc;
	}

	public String getNombreMiembro() {
		return this.nombreMiembro;
	}

	public void setNombreMiembro(String nombreMiembro) {
		this.nombreMiembro = nombreMiembro;
	}

	public String getParentezcoMiembro() {
		return this.parentezcoMiembro;
	}

	public void setParentezcoMiembro(String parentezcoMiembro) {
		this.parentezcoMiembro = parentezcoMiembro;
	}

	public String getSexoMiebro() {
		return this.sexoMiebro;
	}

	public void setSexoMiebro(String sexoMiebro) {
		this.sexoMiebro = sexoMiebro;
	}

	public GrupoAccPersonale getGrupoAccPersonale() {
		return this.grupoAccPersonale;
	}

	public void setGrupoAccPersonale(GrupoAccPersonale grupoAccPersonale) {
		this.grupoAccPersonale = grupoAccPersonale;
	}

}