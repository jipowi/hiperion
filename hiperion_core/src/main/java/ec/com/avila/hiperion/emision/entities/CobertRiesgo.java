package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_riesgos database table.
 * 
 */
@Entity
@Table(name="cobert_riesgos")
@NamedQuery(name="CobertRiesgo.findAll", query="SELECT c FROM CobertRiesgo c")
public class CobertRiesgo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_riesgos")
	private Integer idCobertRiesgos;

	@Column(name="cobertura_riesgos")
	private String coberturaRiesgos;

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

	//bi-directional many-to-one association to RamoRiesgosEsp
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_riesgo")
	private RamoRiesgosEsp ramoRiesgosEsp;

	public CobertRiesgo() {
	}

	public Integer getIdCobertRiesgos() {
		return this.idCobertRiesgos;
	}

	public void setIdCobertRiesgos(Integer idCobertRiesgos) {
		this.idCobertRiesgos = idCobertRiesgos;
	}

	public String getCoberturaRiesgos() {
		return this.coberturaRiesgos;
	}

	public void setCoberturaRiesgos(String coberturaRiesgos) {
		this.coberturaRiesgos = coberturaRiesgos;
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

	public RamoRiesgosEsp getRamoRiesgosEsp() {
		return this.ramoRiesgosEsp;
	}

	public void setRamoRiesgosEsp(RamoRiesgosEsp ramoRiesgosEsp) {
		this.ramoRiesgosEsp = ramoRiesgosEsp;
	}

}