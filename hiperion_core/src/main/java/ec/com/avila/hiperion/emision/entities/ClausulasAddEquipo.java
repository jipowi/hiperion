package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_equipo database table.
 * 
 */
@Entity
@Table(name="clausulas_add_equipo")
@NamedQuery(name="ClausulasAddEquipo.findAll", query="SELECT c FROM ClausulasAddEquipo c")
public class ClausulasAddEquipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_equipo")
	private Integer idClausulaAdEquipo;

	@Column(name="clausula_eq_elec")
	private String clausulaEqElec;

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

	//bi-directional many-to-one association to RamoEquipoElectronico
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_equipo")
	private RamoEquipoElectronico ramoEquipoElectronico;

	public ClausulasAddEquipo() {
	}

	public Integer getIdClausulaAdEquipo() {
		return this.idClausulaAdEquipo;
	}

	public void setIdClausulaAdEquipo(Integer idClausulaAdEquipo) {
		this.idClausulaAdEquipo = idClausulaAdEquipo;
	}

	public String getClausulaEqElec() {
		return this.clausulaEqElec;
	}

	public void setClausulaEqElec(String clausulaEqElec) {
		this.clausulaEqElec = clausulaEqElec;
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

	public RamoEquipoElectronico getRamoEquipoElectronico() {
		return this.ramoEquipoElectronico;
	}

	public void setRamoEquipoElectronico(RamoEquipoElectronico ramoEquipoElectronico) {
		this.ramoEquipoElectronico = ramoEquipoElectronico;
	}

}