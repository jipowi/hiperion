package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_add_casco database table.
 * 
 */
@Entity
@Table(name="cobert_add_casco")
@NamedQuery(name="CobertAddCasco.findAll", query="SELECT c FROM CobertAddCasco c")
public class CobertAddCasco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_ad_casco")
	private Integer idCobertAdCasco;

	@Column(name="cobertura_casco")
	private String coberturaCasco;

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

	//bi-directional many-to-one association to RamoCascoMaritimo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_casco")
	private RamoCascoMaritimo ramoCascoMaritimo;

	public CobertAddCasco() {
	}

	public Integer getIdCobertAdCasco() {
		return this.idCobertAdCasco;
	}

	public void setIdCobertAdCasco(Integer idCobertAdCasco) {
		this.idCobertAdCasco = idCobertAdCasco;
	}

	public String getCoberturaCasco() {
		return this.coberturaCasco;
	}

	public void setCoberturaCasco(String coberturaCasco) {
		this.coberturaCasco = coberturaCasco;
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

	public RamoCascoMaritimo getRamoCascoMaritimo() {
		return this.ramoCascoMaritimo;
	}

	public void setRamoCascoMaritimo(RamoCascoMaritimo ramoCascoMaritimo) {
		this.ramoCascoMaritimo = ramoCascoMaritimo;
	}

}