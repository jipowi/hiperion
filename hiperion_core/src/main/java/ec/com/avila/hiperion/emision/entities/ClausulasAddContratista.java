package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_contratista database table.
 * 
 */
@Entity
@Table(name="clausulas_add_contratista")
@NamedQuery(name="ClausulasAddContratista.findAll", query="SELECT c FROM ClausulasAddContratista c")
public class ClausulasAddContratista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_contratista")
	private Integer idClausulaAdContratista;

	@Column(name="clausula_add_contratista")
	private String clausulaAddContratista;

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

	@Column(name="num_dias_contratista")
	private Integer numDiasContratista;

	//bi-directional many-to-one association to RamoRiesgoContratista
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_contratista")
	private RamoRiesgoContratista ramoRiesgoContratista;

	public ClausulasAddContratista() {
	}

	public Integer getIdClausulaAdContratista() {
		return this.idClausulaAdContratista;
	}

	public void setIdClausulaAdContratista(Integer idClausulaAdContratista) {
		this.idClausulaAdContratista = idClausulaAdContratista;
	}

	public String getClausulaAddContratista() {
		return this.clausulaAddContratista;
	}

	public void setClausulaAddContratista(String clausulaAddContratista) {
		this.clausulaAddContratista = clausulaAddContratista;
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

	public Integer getNumDiasContratista() {
		return this.numDiasContratista;
	}

	public void setNumDiasContratista(Integer numDiasContratista) {
		this.numDiasContratista = numDiasContratista;
	}

	public RamoRiesgoContratista getRamoRiesgoContratista() {
		return this.ramoRiesgoContratista;
	}

	public void setRamoRiesgoContratista(RamoRiesgoContratista ramoRiesgoContratista) {
		this.ramoRiesgoContratista = ramoRiesgoContratista;
	}

}