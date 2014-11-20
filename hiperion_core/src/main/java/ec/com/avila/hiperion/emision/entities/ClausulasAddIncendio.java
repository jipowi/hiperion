package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_incendio database table.
 * 
 */
@Entity
@Table(name="clausulas_add_incendio")
@NamedQuery(name="ClausulasAddIncendio.findAll", query="SELECT c FROM ClausulasAddIncendio c")
public class ClausulasAddIncendio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_incendio")
	private Integer idClausulaAdIncendio;

	@Column(name="clausula_add_incendio")
	private String clausulaAddIncendio;

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

	@Column(name="num_dias_incendio")
	private Integer numDiasIncendio;

	//bi-directional many-to-one association to RamoIncendioLineasAliada
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_incendio")
	private RamoIncendioLineasAliada ramoIncendioLineasAliada;

	public ClausulasAddIncendio() {
	}

	public Integer getIdClausulaAdIncendio() {
		return this.idClausulaAdIncendio;
	}

	public void setIdClausulaAdIncendio(Integer idClausulaAdIncendio) {
		this.idClausulaAdIncendio = idClausulaAdIncendio;
	}

	public String getClausulaAddIncendio() {
		return this.clausulaAddIncendio;
	}

	public void setClausulaAddIncendio(String clausulaAddIncendio) {
		this.clausulaAddIncendio = clausulaAddIncendio;
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

	public Integer getNumDiasIncendio() {
		return this.numDiasIncendio;
	}

	public void setNumDiasIncendio(Integer numDiasIncendio) {
		this.numDiasIncendio = numDiasIncendio;
	}

	public RamoIncendioLineasAliada getRamoIncendioLineasAliada() {
		return this.ramoIncendioLineasAliada;
	}

	public void setRamoIncendioLineasAliada(RamoIncendioLineasAliada ramoIncendioLineasAliada) {
		this.ramoIncendioLineasAliada = ramoIncendioLineasAliada;
	}

}