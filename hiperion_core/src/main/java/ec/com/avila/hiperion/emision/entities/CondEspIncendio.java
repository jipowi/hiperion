package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cond_esp_incendio database table.
 * 
 */
@Entity
@Table(name="cond_esp_incendio")
@NamedQuery(name="CondEspIncendio.findAll", query="SELECT c FROM CondEspIncendio c")
public class CondEspIncendio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_condicion_esp_incendio")
	private Integer idCondicionEspIncendio;

	@Column(name="condicion_esp_incendio")
	private String condicionEspIncendio;

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

	//bi-directional many-to-one association to RamoIncendioLineasAliada
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_incendio")
	private RamoIncendioLineasAliada ramoIncendioLineasAliada;

	public CondEspIncendio() {
	}

	public Integer getIdCondicionEspIncendio() {
		return this.idCondicionEspIncendio;
	}

	public void setIdCondicionEspIncendio(Integer idCondicionEspIncendio) {
		this.idCondicionEspIncendio = idCondicionEspIncendio;
	}

	public String getCondicionEspIncendio() {
		return this.condicionEspIncendio;
	}

	public void setCondicionEspIncendio(String condicionEspIncendio) {
		this.condicionEspIncendio = condicionEspIncendio;
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

	public RamoIncendioLineasAliada getRamoIncendioLineasAliada() {
		return this.ramoIncendioLineasAliada;
	}

	public void setRamoIncendioLineasAliada(RamoIncendioLineasAliada ramoIncendioLineasAliada) {
		this.ramoIncendioLineasAliada = ramoIncendioLineasAliada;
	}

}