package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_add_riesgos database table.
 * 
 */
@Entity
@Table(name="cobert_add_riesgos")
@NamedQuery(name="CobertAddRiesgo.findAll", query="SELECT c FROM CobertAddRiesgo c")
public class CobertAddRiesgo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_ad_riesgos")
	private Integer idCobertAdRiesgos;

	@Column(name="cobertura_add_riesgos")
	private String coberturaAddRiesgos;

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

	public CobertAddRiesgo() {
	}

	public Integer getIdCobertAdRiesgos() {
		return this.idCobertAdRiesgos;
	}

	public void setIdCobertAdRiesgos(Integer idCobertAdRiesgos) {
		this.idCobertAdRiesgos = idCobertAdRiesgos;
	}

	public String getCoberturaAddRiesgos() {
		return this.coberturaAddRiesgos;
	}

	public void setCoberturaAddRiesgos(String coberturaAddRiesgos) {
		this.coberturaAddRiesgos = coberturaAddRiesgos;
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