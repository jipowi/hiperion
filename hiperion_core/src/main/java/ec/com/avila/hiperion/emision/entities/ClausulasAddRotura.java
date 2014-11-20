package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_rotura database table.
 * 
 */
@Entity
@Table(name="clausulas_add_rotura")
@NamedQuery(name="ClausulasAddRotura.findAll", query="SELECT c FROM ClausulasAddRotura c")
public class ClausulasAddRotura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_rotura")
	private Integer idClausulaAdRotura;

	@Column(name="clausula_add_rotura")
	private String clausulaAddRotura;

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

	@Column(name="num_dias_rotura")
	private Integer numDiasRotura;

	//bi-directional many-to-one association to RamoRoturaMaquinaria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rotura")
	private RamoRoturaMaquinaria ramoRoturaMaquinaria;

	public ClausulasAddRotura() {
	}

	public Integer getIdClausulaAdRotura() {
		return this.idClausulaAdRotura;
	}

	public void setIdClausulaAdRotura(Integer idClausulaAdRotura) {
		this.idClausulaAdRotura = idClausulaAdRotura;
	}

	public String getClausulaAddRotura() {
		return this.clausulaAddRotura;
	}

	public void setClausulaAddRotura(String clausulaAddRotura) {
		this.clausulaAddRotura = clausulaAddRotura;
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

	public Integer getNumDiasRotura() {
		return this.numDiasRotura;
	}

	public void setNumDiasRotura(Integer numDiasRotura) {
		this.numDiasRotura = numDiasRotura;
	}

	public RamoRoturaMaquinaria getRamoRoturaMaquinaria() {
		return this.ramoRoturaMaquinaria;
	}

	public void setRamoRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) {
		this.ramoRoturaMaquinaria = ramoRoturaMaquinaria;
	}

}