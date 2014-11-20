package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_robo database table.
 * 
 */
@Entity
@Table(name="clausulas_add_robo")
@NamedQuery(name="ClausulasAddRobo.findAll", query="SELECT c FROM ClausulasAddRobo c")
public class ClausulasAddRobo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_robo")
	private Integer idClausulaAdRobo;

	@Column(name="clausula_add_robo")
	private String clausulaAddRobo;

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

	@Column(name="num_dias_robo")
	private Integer numDiasRobo;

	//bi-directional many-to-one association to RamoRoboAsalto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_robo")
	private RamoRoboAsalto ramoRoboAsalto;

	public ClausulasAddRobo() {
	}

	public Integer getIdClausulaAdRobo() {
		return this.idClausulaAdRobo;
	}

	public void setIdClausulaAdRobo(Integer idClausulaAdRobo) {
		this.idClausulaAdRobo = idClausulaAdRobo;
	}

	public String getClausulaAddRobo() {
		return this.clausulaAddRobo;
	}

	public void setClausulaAddRobo(String clausulaAddRobo) {
		this.clausulaAddRobo = clausulaAddRobo;
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

	public Integer getNumDiasRobo() {
		return this.numDiasRobo;
	}

	public void setNumDiasRobo(Integer numDiasRobo) {
		this.numDiasRobo = numDiasRobo;
	}

	public RamoRoboAsalto getRamoRoboAsalto() {
		return this.ramoRoboAsalto;
	}

	public void setRamoRoboAsalto(RamoRoboAsalto ramoRoboAsalto) {
		this.ramoRoboAsalto = ramoRoboAsalto;
	}

}