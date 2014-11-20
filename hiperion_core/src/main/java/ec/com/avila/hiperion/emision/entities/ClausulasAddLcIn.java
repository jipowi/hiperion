package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_lc_in database table.
 * 
 */
@Entity
@Table(name="clausulas_add_lc_in")
@NamedQuery(name="ClausulasAddLcIn.findAll", query="SELECT c FROM ClausulasAddLcIn c")
public class ClausulasAddLcIn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_lucro")
	private Integer idClausulaAdLucro;

	@Column(name="clausula_add_lc_incendio")
	private String clausulaAddLcIncendio;

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

	@Column(name="num_dias_lc_incendio")
	private Integer numDiasLcIncendio;

	//bi-directional many-to-one association to RamoLcIncendio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_lucro")
	private RamoLcIncendio ramoLcIncendio;

	public ClausulasAddLcIn() {
	}

	public Integer getIdClausulaAdLucro() {
		return this.idClausulaAdLucro;
	}

	public void setIdClausulaAdLucro(Integer idClausulaAdLucro) {
		this.idClausulaAdLucro = idClausulaAdLucro;
	}

	public String getClausulaAddLcIncendio() {
		return this.clausulaAddLcIncendio;
	}

	public void setClausulaAddLcIncendio(String clausulaAddLcIncendio) {
		this.clausulaAddLcIncendio = clausulaAddLcIncendio;
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

	public Integer getNumDiasLcIncendio() {
		return this.numDiasLcIncendio;
	}

	public void setNumDiasLcIncendio(Integer numDiasLcIncendio) {
		this.numDiasLcIncendio = numDiasLcIncendio;
	}

	public RamoLcIncendio getRamoLcIncendio() {
		return this.ramoLcIncendio;
	}

	public void setRamoLcIncendio(RamoLcIncendio ramoLcIncendio) {
		this.ramoLcIncendio = ramoLcIncendio;
	}

}