package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_vh database table.
 * 
 */
@Entity
@Table(name="clausulas_add_vh")
@NamedQuery(name="ClausulasAddVh.findAll", query="SELECT c FROM ClausulasAddVh c")
public class ClausulasAddVh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_vehiculo")
	private Integer idClausulaAdVehiculo;

	@Column(name="clausula_add_vh")
	private String clausulaAddVh;

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

	@Column(name="num_dias_vh")
	private Integer numDiasVh;

	//bi-directional many-to-one association to RamoVehiculo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ramo_vehiculos")
	private RamoVehiculo ramoVehiculo;

	public ClausulasAddVh() {
	}

	public Integer getIdClausulaAdVehiculo() {
		return this.idClausulaAdVehiculo;
	}

	public void setIdClausulaAdVehiculo(Integer idClausulaAdVehiculo) {
		this.idClausulaAdVehiculo = idClausulaAdVehiculo;
	}

	public String getClausulaAddVh() {
		return this.clausulaAddVh;
	}

	public void setClausulaAddVh(String clausulaAddVh) {
		this.clausulaAddVh = clausulaAddVh;
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

	public Integer getNumDiasVh() {
		return this.numDiasVh;
	}

	public void setNumDiasVh(Integer numDiasVh) {
		this.numDiasVh = numDiasVh;
	}

	public RamoVehiculo getRamoVehiculo() {
		return this.ramoVehiculo;
	}

	public void setRamoVehiculo(RamoVehiculo ramoVehiculo) {
		this.ramoVehiculo = ramoVehiculo;
	}

}