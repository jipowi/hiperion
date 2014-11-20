package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_add_eq_maq database table.
 * 
 */
@Entity
@Table(name="cobert_add_eq_maq")
@NamedQuery(name="CobertAddEqMaq.findAll", query="SELECT c FROM CobertAddEqMaq c")
public class CobertAddEqMaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_ad_eq_maq")
	private Integer idCobertAdEqMaq;

	@Column(name="cobertura_add_eq_maq")
	private String coberturaAddEqMaq;

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

	//bi-directional many-to-one association to RamoEquipoMaquinaria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_equipo_maquinaria")
	private RamoEquipoMaquinaria ramoEquipoMaquinaria;

	public CobertAddEqMaq() {
	}

	public Integer getIdCobertAdEqMaq() {
		return this.idCobertAdEqMaq;
	}

	public void setIdCobertAdEqMaq(Integer idCobertAdEqMaq) {
		this.idCobertAdEqMaq = idCobertAdEqMaq;
	}

	public String getCoberturaAddEqMaq() {
		return this.coberturaAddEqMaq;
	}

	public void setCoberturaAddEqMaq(String coberturaAddEqMaq) {
		this.coberturaAddEqMaq = coberturaAddEqMaq;
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

	public RamoEquipoMaquinaria getRamoEquipoMaquinaria() {
		return this.ramoEquipoMaquinaria;
	}

	public void setRamoEquipoMaquinaria(RamoEquipoMaquinaria ramoEquipoMaquinaria) {
		this.ramoEquipoMaquinaria = ramoEquipoMaquinaria;
	}

}