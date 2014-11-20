package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_riesgos database table.
 * 
 */
@Entity
@Table(name="clausulas_add_riesgos")
@NamedQuery(name="ClausulasAddRiesgo.findAll", query="SELECT c FROM ClausulasAddRiesgo c")
public class ClausulasAddRiesgo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_riesgos")
	private Integer idClausulaAdRiesgos;

	@Column(name="clausula_add_riesgos")
	private String clausulaAddRiesgos;

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

	//bi-directional many-to-one association to RamoRiesgosEsp
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_riesgo")
	private RamoRiesgosEsp ramoRiesgosEsp;

	public ClausulasAddRiesgo() {
	}

	public Integer getIdClausulaAdRiesgos() {
		return this.idClausulaAdRiesgos;
	}

	public void setIdClausulaAdRiesgos(Integer idClausulaAdRiesgos) {
		this.idClausulaAdRiesgos = idClausulaAdRiesgos;
	}

	public String getClausulaAddRiesgos() {
		return this.clausulaAddRiesgos;
	}

	public void setClausulaAddRiesgos(String clausulaAddRiesgos) {
		this.clausulaAddRiesgos = clausulaAddRiesgos;
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

	public RamoRiesgosEsp getRamoRiesgosEsp() {
		return this.ramoRiesgosEsp;
	}

	public void setRamoRiesgosEsp(RamoRiesgosEsp ramoRiesgosEsp) {
		this.ramoRiesgosEsp = ramoRiesgosEsp;
	}

}