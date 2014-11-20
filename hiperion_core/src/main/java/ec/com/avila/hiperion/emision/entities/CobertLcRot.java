package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_lc_rot database table.
 * 
 */
@Entity
@Table(name="cobert_lc_rot")
@NamedQuery(name="CobertLcRot.findAll", query="SELECT c FROM CobertLcRot c")
public class CobertLcRot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_cesante")
	private Integer idCobertCesante;

	@Column(name="cobertura_lc_rotura")
	private String coberturaLcRotura;

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

	public CobertLcRot() {
	}

	public Integer getIdCobertCesante() {
		return this.idCobertCesante;
	}

	public void setIdCobertCesante(Integer idCobertCesante) {
		this.idCobertCesante = idCobertCesante;
	}

	public String getCoberturaLcRotura() {
		return this.coberturaLcRotura;
	}

	public void setCoberturaLcRotura(String coberturaLcRotura) {
		this.coberturaLcRotura = coberturaLcRotura;
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