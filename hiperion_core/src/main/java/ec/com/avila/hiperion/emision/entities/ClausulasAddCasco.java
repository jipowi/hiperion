package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_casco database table.
 * 
 */
@Entity
@Table(name="clausulas_add_casco")
@NamedQuery(name="ClausulasAddCasco.findAll", query="SELECT c FROM ClausulasAddCasco c")
public class ClausulasAddCasco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_casco")
	private Integer idClausulaAdCasco;

	@Column(name="clausula_add_maritimo")
	private String clausulaAddMaritimo;

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

	@Column(name="num_dias_maritimo")
	private Integer numDiasMaritimo;

	//bi-directional many-to-one association to RamoCascoMaritimo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_casco")
	private RamoCascoMaritimo ramoCascoMaritimo;

	public ClausulasAddCasco() {
	}

	public Integer getIdClausulaAdCasco() {
		return this.idClausulaAdCasco;
	}

	public void setIdClausulaAdCasco(Integer idClausulaAdCasco) {
		this.idClausulaAdCasco = idClausulaAdCasco;
	}

	public String getClausulaAddMaritimo() {
		return this.clausulaAddMaritimo;
	}

	public void setClausulaAddMaritimo(String clausulaAddMaritimo) {
		this.clausulaAddMaritimo = clausulaAddMaritimo;
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

	public Integer getNumDiasMaritimo() {
		return this.numDiasMaritimo;
	}

	public void setNumDiasMaritimo(Integer numDiasMaritimo) {
		this.numDiasMaritimo = numDiasMaritimo;
	}

	public RamoCascoMaritimo getRamoCascoMaritimo() {
		return this.ramoCascoMaritimo;
	}

	public void setRamoCascoMaritimo(RamoCascoMaritimo ramoCascoMaritimo) {
		this.ramoCascoMaritimo = ramoCascoMaritimo;
	}

}