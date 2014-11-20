package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cla_add_lc_rot database table.
 * 
 */
@Entity
@Table(name="cla_add_lc_rot")
@NamedQuery(name="ClaAddLcRot.findAll", query="SELECT c FROM ClaAddLcRot c")
public class ClaAddLcRot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_cesante")
	private Integer idClausulaAdCesante;

	@Column(name="clausula_add_lc_rotura")
	private String clausulaAddLcRotura;

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

	@Column(name="num_dias_cla_lc_rotura")
	private Integer numDiasClaLcRotura;

	//bi-directional many-to-one association to RamoLcRotMaq
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cesante")
	private RamoLcRotMaq ramoLcRotMaq;

	public ClaAddLcRot() {
	}

	public Integer getIdClausulaAdCesante() {
		return this.idClausulaAdCesante;
	}

	public void setIdClausulaAdCesante(Integer idClausulaAdCesante) {
		this.idClausulaAdCesante = idClausulaAdCesante;
	}

	public String getClausulaAddLcRotura() {
		return this.clausulaAddLcRotura;
	}

	public void setClausulaAddLcRotura(String clausulaAddLcRotura) {
		this.clausulaAddLcRotura = clausulaAddLcRotura;
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

	public Integer getNumDiasClaLcRotura() {
		return this.numDiasClaLcRotura;
	}

	public void setNumDiasClaLcRotura(Integer numDiasClaLcRotura) {
		this.numDiasClaLcRotura = numDiasClaLcRotura;
	}

	public RamoLcRotMaq getRamoLcRotMaq() {
		return this.ramoLcRotMaq;
	}

	public void setRamoLcRotMaq(RamoLcRotMaq ramoLcRotMaq) {
		this.ramoLcRotMaq = ramoLcRotMaq;
	}

}