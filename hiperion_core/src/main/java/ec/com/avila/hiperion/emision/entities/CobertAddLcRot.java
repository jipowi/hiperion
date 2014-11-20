package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_add_lc_rot database table.
 * 
 */
@Entity
@Table(name="cobert_add_lc_rot")
@NamedQuery(name="CobertAddLcRot.findAll", query="SELECT c FROM CobertAddLcRot c")
public class CobertAddLcRot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_ad_cesante")
	private Integer idCobertAdCesante;

	@Column(name="cobertura_add_lc_rotura")
	private String coberturaAddLcRotura;

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

	//bi-directional many-to-one association to RamoLcRotMaq
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cesante")
	private RamoLcRotMaq ramoLcRotMaq;

	public CobertAddLcRot() {
	}

	public Integer getIdCobertAdCesante() {
		return this.idCobertAdCesante;
	}

	public void setIdCobertAdCesante(Integer idCobertAdCesante) {
		this.idCobertAdCesante = idCobertAdCesante;
	}

	public String getCoberturaAddLcRotura() {
		return this.coberturaAddLcRotura;
	}

	public void setCoberturaAddLcRotura(String coberturaAddLcRotura) {
		this.coberturaAddLcRotura = coberturaAddLcRotura;
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

	public RamoLcRotMaq getRamoLcRotMaq() {
		return this.ramoLcRotMaq;
	}

	public void setRamoLcRotMaq(RamoLcRotMaq ramoLcRotMaq) {
		this.ramoLcRotMaq = ramoLcRotMaq;
	}

}