package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_fidelidad database table.
 * 
 */
@Entity
@Table(name="cobert_fidelidad")
@NamedQuery(name="CobertFidelidad.findAll", query="SELECT c FROM CobertFidelidad c")
public class CobertFidelidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_fidelidad")
	private Integer idCobertFidelidad;

	@Column(name="cobertura_fidelidad")
	private String coberturaFidelidad;

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

	//bi-directional many-to-one association to RamoFidelidad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fidelidad")
	private RamoFidelidad ramoFidelidad;

	public CobertFidelidad() {
	}

	public Integer getIdCobertFidelidad() {
		return this.idCobertFidelidad;
	}

	public void setIdCobertFidelidad(Integer idCobertFidelidad) {
		this.idCobertFidelidad = idCobertFidelidad;
	}

	public String getCoberturaFidelidad() {
		return this.coberturaFidelidad;
	}

	public void setCoberturaFidelidad(String coberturaFidelidad) {
		this.coberturaFidelidad = coberturaFidelidad;
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

	public RamoFidelidad getRamoFidelidad() {
		return this.ramoFidelidad;
	}

	public void setRamoFidelidad(RamoFidelidad ramoFidelidad) {
		this.ramoFidelidad = ramoFidelidad;
	}

}