package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_eq_maq database table.
 * 
 */
@Entity
@Table(name="clausulas_add_eq_maq")
@NamedQuery(name="ClausulasAddEqMaq.findAll", query="SELECT c FROM ClausulasAddEqMaq c")
public class ClausulasAddEqMaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_eq_maq")
	private Integer idClausulaAdEqMaq;

	@Column(name="clausula_eq_maq")
	private String clausulaEqMaq;

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

	@Column(name="num_dias_eq_maq")
	private Integer numDiasEqMaq;

	//bi-directional many-to-one association to RamoEquipoMaquinaria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_equipo_maquinaria")
	private RamoEquipoMaquinaria ramoEquipoMaquinaria;

	public ClausulasAddEqMaq() {
	}

	public Integer getIdClausulaAdEqMaq() {
		return this.idClausulaAdEqMaq;
	}

	public void setIdClausulaAdEqMaq(Integer idClausulaAdEqMaq) {
		this.idClausulaAdEqMaq = idClausulaAdEqMaq;
	}

	public String getClausulaEqMaq() {
		return this.clausulaEqMaq;
	}

	public void setClausulaEqMaq(String clausulaEqMaq) {
		this.clausulaEqMaq = clausulaEqMaq;
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

	public Integer getNumDiasEqMaq() {
		return this.numDiasEqMaq;
	}

	public void setNumDiasEqMaq(Integer numDiasEqMaq) {
		this.numDiasEqMaq = numDiasEqMaq;
	}

	public RamoEquipoMaquinaria getRamoEquipoMaquinaria() {
		return this.ramoEquipoMaquinaria;
	}

	public void setRamoEquipoMaquinaria(RamoEquipoMaquinaria ramoEquipoMaquinaria) {
		this.ramoEquipoMaquinaria = ramoEquipoMaquinaria;
	}

}