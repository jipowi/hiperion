package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_add_casco_aereo database table.
 * 
 */
@Entity
@Table(name="cobert_add_casco_aereo")
@NamedQuery(name="CobertAddCascoAereo.findAll", query="SELECT c FROM CobertAddCascoAereo c")
public class CobertAddCascoAereo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_ad_casco_aereo")
	private Integer idCobertAdCascoAereo;

	@Column(name="cobertura_aereo")
	private String coberturaAereo;

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

	//bi-directional many-to-one association to RamoCascoAereo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_casco_aereo")
	private RamoCascoAereo ramoCascoAereo;

	public CobertAddCascoAereo() {
	}

	public Integer getIdCobertAdCascoAereo() {
		return this.idCobertAdCascoAereo;
	}

	public void setIdCobertAdCascoAereo(Integer idCobertAdCascoAereo) {
		this.idCobertAdCascoAereo = idCobertAdCascoAereo;
	}

	public String getCoberturaAereo() {
		return this.coberturaAereo;
	}

	public void setCoberturaAereo(String coberturaAereo) {
		this.coberturaAereo = coberturaAereo;
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

	public RamoCascoAereo getRamoCascoAereo() {
		return this.ramoCascoAereo;
	}

	public void setRamoCascoAereo(RamoCascoAereo ramoCascoAereo) {
		this.ramoCascoAereo = ramoCascoAereo;
	}

}