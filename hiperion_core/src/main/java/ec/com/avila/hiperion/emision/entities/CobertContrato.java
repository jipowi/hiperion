package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_contrato database table.
 * 
 */
@Entity
@Table(name="cobert_contrato")
@NamedQuery(name="CobertContrato.findAll", query="SELECT c FROM CobertContrato c")
public class CobertContrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_contrato")
	private Integer idCobertContrato;

	@Column(name="cobertura_contrato")
	private String coberturaContrato;

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

	//bi-directional many-to-one association to RamoCumplimientoContrato
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_contrato")
	private RamoCumplimientoContrato ramoCumplimientoContrato;

	public CobertContrato() {
	}

	public Integer getIdCobertContrato() {
		return this.idCobertContrato;
	}

	public void setIdCobertContrato(Integer idCobertContrato) {
		this.idCobertContrato = idCobertContrato;
	}

	public String getCoberturaContrato() {
		return this.coberturaContrato;
	}

	public void setCoberturaContrato(String coberturaContrato) {
		this.coberturaContrato = coberturaContrato;
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

	public RamoCumplimientoContrato getRamoCumplimientoContrato() {
		return this.ramoCumplimientoContrato;
	}

	public void setRamoCumplimientoContrato(RamoCumplimientoContrato ramoCumplimientoContrato) {
		this.ramoCumplimientoContrato = ramoCumplimientoContrato;
	}

}