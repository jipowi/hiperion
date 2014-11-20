package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the extras_vh database table.
 * 
 */
@Entity
@Table(name="extras_vh")
@NamedQuery(name="ExtrasVh.findAll", query="SELECT e FROM ExtrasVh e")
public class ExtrasVh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_extra_vehiculo")
	private Integer idExtraVehiculo;

	@Column(name="cantidad_extra_vh")
	private Integer cantidadExtraVh;

	private String estado;

	@Column(name="extra_vh")
	private String extraVh;

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

	@Column(name="valor_extra_vh")
	private BigDecimal valorExtraVh;

	//bi-directional many-to-one association to RamoVehiculo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ramo_vehiculos")
	private RamoVehiculo ramoVehiculo;

	public ExtrasVh() {
	}

	public Integer getIdExtraVehiculo() {
		return this.idExtraVehiculo;
	}

	public void setIdExtraVehiculo(Integer idExtraVehiculo) {
		this.idExtraVehiculo = idExtraVehiculo;
	}

	public Integer getCantidadExtraVh() {
		return this.cantidadExtraVh;
	}

	public void setCantidadExtraVh(Integer cantidadExtraVh) {
		this.cantidadExtraVh = cantidadExtraVh;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getExtraVh() {
		return this.extraVh;
	}

	public void setExtraVh(String extraVh) {
		this.extraVh = extraVh;
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

	public BigDecimal getValorExtraVh() {
		return this.valorExtraVh;
	}

	public void setValorExtraVh(BigDecimal valorExtraVh) {
		this.valorExtraVh = valorExtraVh;
	}

	public RamoVehiculo getRamoVehiculo() {
		return this.ramoVehiculo;
	}

	public void setRamoVehiculo(RamoVehiculo ramoVehiculo) {
		this.ramoVehiculo = ramoVehiculo;
	}

}