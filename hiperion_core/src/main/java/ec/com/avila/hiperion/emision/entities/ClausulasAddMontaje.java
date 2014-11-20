package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_montaje database table.
 * 
 */
@Entity
@Table(name="clausulas_add_montaje")
@NamedQuery(name="ClausulasAddMontaje.findAll", query="SELECT c FROM ClausulasAddMontaje c")
public class ClausulasAddMontaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_montaje")
	private Integer idClausulaAdMontaje;

	@Column(name="clausula_add_montaje")
	private String clausulaAddMontaje;

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

	@Column(name="num_dias_montaje")
	private Integer numDiasMontaje;

	//bi-directional many-to-one association to RamoRiesgoMontaje
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_riesgo_montaje")
	private RamoRiesgoMontaje ramoRiesgoMontaje;

	public ClausulasAddMontaje() {
	}

	public Integer getIdClausulaAdMontaje() {
		return this.idClausulaAdMontaje;
	}

	public void setIdClausulaAdMontaje(Integer idClausulaAdMontaje) {
		this.idClausulaAdMontaje = idClausulaAdMontaje;
	}

	public String getClausulaAddMontaje() {
		return this.clausulaAddMontaje;
	}

	public void setClausulaAddMontaje(String clausulaAddMontaje) {
		this.clausulaAddMontaje = clausulaAddMontaje;
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

	public Integer getNumDiasMontaje() {
		return this.numDiasMontaje;
	}

	public void setNumDiasMontaje(Integer numDiasMontaje) {
		this.numDiasMontaje = numDiasMontaje;
	}

	public RamoRiesgoMontaje getRamoRiesgoMontaje() {
		return this.ramoRiesgoMontaje;
	}

	public void setRamoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje) {
		this.ramoRiesgoMontaje = ramoRiesgoMontaje;
	}

}