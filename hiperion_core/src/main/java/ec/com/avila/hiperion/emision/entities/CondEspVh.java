package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cond_esp_vh database table.
 * 
 */
@Entity
@Table(name="cond_esp_vh")
@NamedQuery(name="CondEspVh.findAll", query="SELECT c FROM CondEspVh c")
public class CondEspVh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_condicion_esp_vehiculo")
	private Integer idCondicionEspVehiculo;

	@Column(name="condicion_esp_vh")
	private String condicionEspVh;

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

	//bi-directional many-to-one association to RamoVehiculo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ramo_vehiculos")
	private RamoVehiculo ramoVehiculo;

	public CondEspVh() {
	}

	public Integer getIdCondicionEspVehiculo() {
		return this.idCondicionEspVehiculo;
	}

	public void setIdCondicionEspVehiculo(Integer idCondicionEspVehiculo) {
		this.idCondicionEspVehiculo = idCondicionEspVehiculo;
	}

	public String getCondicionEspVh() {
		return this.condicionEspVh;
	}

	public void setCondicionEspVh(String condicionEspVh) {
		this.condicionEspVh = condicionEspVh;
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

	public RamoVehiculo getRamoVehiculo() {
		return this.ramoVehiculo;
	}

	public void setRamoVehiculo(RamoVehiculo ramoVehiculo) {
		this.ramoVehiculo = ramoVehiculo;
	}

}