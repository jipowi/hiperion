package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_soat database table.
 * 
 */
@Entity
@Table(name="cobert_soat")
@NamedQuery(name="CobertSoat.findAll", query="SELECT c FROM CobertSoat c")
public class CobertSoat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_soat")
	private Integer idCobertSoat;

	@Column(name="cobertura_soat")
	private String coberturaSoat;

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

	//bi-directional many-to-one association to RamoSoat
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_soat")
	private RamoSoat ramoSoat;

	public CobertSoat() {
	}

	public Integer getIdCobertSoat() {
		return this.idCobertSoat;
	}

	public void setIdCobertSoat(Integer idCobertSoat) {
		this.idCobertSoat = idCobertSoat;
	}

	public String getCoberturaSoat() {
		return this.coberturaSoat;
	}

	public void setCoberturaSoat(String coberturaSoat) {
		this.coberturaSoat = coberturaSoat;
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

	public RamoSoat getRamoSoat() {
		return this.ramoSoat;
	}

	public void setRamoSoat(RamoSoat ramoSoat) {
		this.ramoSoat = ramoSoat;
	}

}