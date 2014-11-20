package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_fidelidad database table.
 * 
 */
@Entity
@Table(name="clausulas_add_fidelidad")
@NamedQuery(name="ClausulasAddFidelidad.findAll", query="SELECT c FROM ClausulasAddFidelidad c")
public class ClausulasAddFidelidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_fidelidad")
	private Integer idClausulaAdFidelidad;

	@Column(name="clausula_fidelidad")
	private String clausulaFidelidad;

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

	@Column(name="numero_dias_fidelilad")
	private Integer numeroDiasFidelilad;

	//bi-directional many-to-one association to RamoFidelidad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fidelidad")
	private RamoFidelidad ramoFidelidad;

	public ClausulasAddFidelidad() {
	}

	public Integer getIdClausulaAdFidelidad() {
		return this.idClausulaAdFidelidad;
	}

	public void setIdClausulaAdFidelidad(Integer idClausulaAdFidelidad) {
		this.idClausulaAdFidelidad = idClausulaAdFidelidad;
	}

	public String getClausulaFidelidad() {
		return this.clausulaFidelidad;
	}

	public void setClausulaFidelidad(String clausulaFidelidad) {
		this.clausulaFidelidad = clausulaFidelidad;
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

	public Integer getNumeroDiasFidelilad() {
		return this.numeroDiasFidelilad;
	}

	public void setNumeroDiasFidelilad(Integer numeroDiasFidelilad) {
		this.numeroDiasFidelilad = numeroDiasFidelilad;
	}

	public RamoFidelidad getRamoFidelidad() {
		return this.ramoFidelidad;
	}

	public void setRamoFidelidad(RamoFidelidad ramoFidelidad) {
		this.ramoFidelidad = ramoFidelidad;
	}

}