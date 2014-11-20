package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_contratista database table.
 * 
 */
@Entity
@Table(name="cobert_contratista")
@NamedQuery(name="CobertContratista.findAll", query="SELECT c FROM CobertContratista c")
public class CobertContratista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_contratista")
	private Integer idCobertContratista;

	@Column(name="cobertura_contratista")
	private String coberturaContratista;

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

	//bi-directional many-to-one association to RamoRiesgoContratista
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_contratista")
	private RamoRiesgoContratista ramoRiesgoContratista;

	public CobertContratista() {
	}

	public Integer getIdCobertContratista() {
		return this.idCobertContratista;
	}

	public void setIdCobertContratista(Integer idCobertContratista) {
		this.idCobertContratista = idCobertContratista;
	}

	public String getCoberturaContratista() {
		return this.coberturaContratista;
	}

	public void setCoberturaContratista(String coberturaContratista) {
		this.coberturaContratista = coberturaContratista;
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

	public RamoRiesgoContratista getRamoRiesgoContratista() {
		return this.ramoRiesgoContratista;
	}

	public void setRamoRiesgoContratista(RamoRiesgoContratista ramoRiesgoContratista) {
		this.ramoRiesgoContratista = ramoRiesgoContratista;
	}

}