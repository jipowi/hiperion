package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_casco_aereo database table.
 * 
 */
@Entity
@Table(name="clausulas_add_casco_aereo")
@NamedQuery(name="ClausulasAddCascoAereo.findAll", query="SELECT c FROM ClausulasAddCascoAereo c")
public class ClausulasAddCascoAereo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_casco_aereo")
	private Integer idClausulaAdCascoAereo;

	@Column(name="clausula_add_aereo")
	private String clausulaAddAereo;

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

	@Column(name="num_dias_aereo")
	private Integer numDiasAereo;

	//bi-directional many-to-one association to RamoCascoAereo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_casco_aereo")
	private RamoCascoAereo ramoCascoAereo;

	public ClausulasAddCascoAereo() {
	}

	public Integer getIdClausulaAdCascoAereo() {
		return this.idClausulaAdCascoAereo;
	}

	public void setIdClausulaAdCascoAereo(Integer idClausulaAdCascoAereo) {
		this.idClausulaAdCascoAereo = idClausulaAdCascoAereo;
	}

	public String getClausulaAddAereo() {
		return this.clausulaAddAereo;
	}

	public void setClausulaAddAereo(String clausulaAddAereo) {
		this.clausulaAddAereo = clausulaAddAereo;
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

	public Integer getNumDiasAereo() {
		return this.numDiasAereo;
	}

	public void setNumDiasAereo(Integer numDiasAereo) {
		this.numDiasAereo = numDiasAereo;
	}

	public RamoCascoAereo getRamoCascoAereo() {
		return this.ramoCascoAereo;
	}

	public void setRamoCascoAereo(RamoCascoAereo ramoCascoAereo) {
		this.ramoCascoAereo = ramoCascoAereo;
	}

}