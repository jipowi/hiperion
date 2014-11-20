package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_materiales database table.
 * 
 */
@Entity
@Table(name="cobert_materiales")
@NamedQuery(name="CobertMateriale.findAll", query="SELECT c FROM CobertMateriale c")
public class CobertMateriale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_materiales")
	private Integer idCobertMateriales;

	@Column(name="cobertura_materiales")
	private String coberturaMateriales;

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

	//bi-directional many-to-one association to RamoBuenaCalMat
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_material")
	private RamoBuenaCalMat ramoBuenaCalMat;

	public CobertMateriale() {
	}

	public Integer getIdCobertMateriales() {
		return this.idCobertMateriales;
	}

	public void setIdCobertMateriales(Integer idCobertMateriales) {
		this.idCobertMateriales = idCobertMateriales;
	}

	public String getCoberturaMateriales() {
		return this.coberturaMateriales;
	}

	public void setCoberturaMateriales(String coberturaMateriales) {
		this.coberturaMateriales = coberturaMateriales;
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

	public RamoBuenaCalMat getRamoBuenaCalMat() {
		return this.ramoBuenaCalMat;
	}

	public void setRamoBuenaCalMat(RamoBuenaCalMat ramoBuenaCalMat) {
		this.ramoBuenaCalMat = ramoBuenaCalMat;
	}

}