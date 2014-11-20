package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_trans database table.
 * 
 */
@Entity
@Table(name="clausulas_add_trans")
@NamedQuery(name="ClausulasAddTran.findAll", query="SELECT c FROM ClausulasAddTran c")
public class ClausulasAddTran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_transporte")
	private Integer idClausulaAdTransporte;

	@Column(name="clausula_trans")
	private String clausulaTrans;

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

	@Column(name="num_dias_trans")
	private Integer numDiasTrans;

	//bi-directional many-to-one association to RamoTransporte
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_transporte")
	private RamoTransporte ramoTransporte;

	public ClausulasAddTran() {
	}

	public Integer getIdClausulaAdTransporte() {
		return this.idClausulaAdTransporte;
	}

	public void setIdClausulaAdTransporte(Integer idClausulaAdTransporte) {
		this.idClausulaAdTransporte = idClausulaAdTransporte;
	}

	public String getClausulaTrans() {
		return this.clausulaTrans;
	}

	public void setClausulaTrans(String clausulaTrans) {
		this.clausulaTrans = clausulaTrans;
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

	public Integer getNumDiasTrans() {
		return this.numDiasTrans;
	}

	public void setNumDiasTrans(Integer numDiasTrans) {
		this.numDiasTrans = numDiasTrans;
	}

	public RamoTransporte getRamoTransporte() {
		return this.ramoTransporte;
	}

	public void setRamoTransporte(RamoTransporte ramoTransporte) {
		this.ramoTransporte = ramoTransporte;
	}

}