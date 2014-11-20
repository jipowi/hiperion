package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_resp database table.
 * 
 */
@Entity
@Table(name="clausulas_add_resp")
@NamedQuery(name="ClausulasAddResp.findAll", query="SELECT c FROM ClausulasAddResp c")
public class ClausulasAddResp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_responsabilidad")
	private Integer idClausulaAdResponsabilidad;

	@Column(name="clausula_resp")
	private String clausulaResp;

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

	@Column(name="num_dias_resp")
	private Integer numDiasResp;

	//bi-directional many-to-one association to RamoResponsabilidadCivil
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_responsabilidad")
	private RamoResponsabilidadCivil ramoResponsabilidadCivil;

	public ClausulasAddResp() {
	}

	public Integer getIdClausulaAdResponsabilidad() {
		return this.idClausulaAdResponsabilidad;
	}

	public void setIdClausulaAdResponsabilidad(Integer idClausulaAdResponsabilidad) {
		this.idClausulaAdResponsabilidad = idClausulaAdResponsabilidad;
	}

	public String getClausulaResp() {
		return this.clausulaResp;
	}

	public void setClausulaResp(String clausulaResp) {
		this.clausulaResp = clausulaResp;
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

	public Integer getNumDiasResp() {
		return this.numDiasResp;
	}

	public void setNumDiasResp(Integer numDiasResp) {
		this.numDiasResp = numDiasResp;
	}

	public RamoResponsabilidadCivil getRamoResponsabilidadCivil() {
		return this.ramoResponsabilidadCivil;
	}

	public void setRamoResponsabilidadCivil(RamoResponsabilidadCivil ramoResponsabilidadCivil) {
		this.ramoResponsabilidadCivil = ramoResponsabilidadCivil;
	}

}