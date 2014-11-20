package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_agro database table.
 * 
 */
@Entity
@Table(name="clausulas_add_agro")
@NamedQuery(name="ClausulasAddAgro.findAll", query="SELECT c FROM ClausulasAddAgro c")
public class ClausulasAddAgro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad")
	private Integer idClausulaAd;

	@Column(name="clausula_add_agro")
	private String clausulaAddAgro;

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

	@Column(name="num_dias_agro")
	private Integer numDiasAgro;

	//bi-directional many-to-one association to RamoAgropecuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_agropecuario")
	private RamoAgropecuario ramoAgropecuario;

	public ClausulasAddAgro() {
	}

	public Integer getIdClausulaAd() {
		return this.idClausulaAd;
	}

	public void setIdClausulaAd(Integer idClausulaAd) {
		this.idClausulaAd = idClausulaAd;
	}

	public String getClausulaAddAgro() {
		return this.clausulaAddAgro;
	}

	public void setClausulaAddAgro(String clausulaAddAgro) {
		this.clausulaAddAgro = clausulaAddAgro;
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

	public Integer getNumDiasAgro() {
		return this.numDiasAgro;
	}

	public void setNumDiasAgro(Integer numDiasAgro) {
		this.numDiasAgro = numDiasAgro;
	}

	public RamoAgropecuario getRamoAgropecuario() {
		return this.ramoAgropecuario;
	}

	public void setRamoAgropecuario(RamoAgropecuario ramoAgropecuario) {
		this.ramoAgropecuario = ramoAgropecuario;
	}

}