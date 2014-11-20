package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the obj_aseg_fidelidad database table.
 * 
 */
@Entity
@Table(name="obj_aseg_fidelidad")
@NamedQuery(name="ObjAsegFidelidad.findAll", query="SELECT o FROM ObjAsegFidelidad o")
public class ObjAsegFidelidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_mod_obj_asegurado")
	private Integer idModObjAsegurado;

	@Column(name="cargo_fidelidad")
	private String cargoFidelidad;

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

	@Column(name="nombre_fidelidad")
	private String nombreFidelidad;

	@Column(name="tipo_modalidad_fidelidad")
	private Integer tipoModalidadFidelidad;

	//bi-directional many-to-one association to RamoFidelidad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fidelidad")
	private RamoFidelidad ramoFidelidad;

	public ObjAsegFidelidad() {
	}

	public Integer getIdModObjAsegurado() {
		return this.idModObjAsegurado;
	}

	public void setIdModObjAsegurado(Integer idModObjAsegurado) {
		this.idModObjAsegurado = idModObjAsegurado;
	}

	public String getCargoFidelidad() {
		return this.cargoFidelidad;
	}

	public void setCargoFidelidad(String cargoFidelidad) {
		this.cargoFidelidad = cargoFidelidad;
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

	public String getNombreFidelidad() {
		return this.nombreFidelidad;
	}

	public void setNombreFidelidad(String nombreFidelidad) {
		this.nombreFidelidad = nombreFidelidad;
	}

	public Integer getTipoModalidadFidelidad() {
		return this.tipoModalidadFidelidad;
	}

	public void setTipoModalidadFidelidad(Integer tipoModalidadFidelidad) {
		this.tipoModalidadFidelidad = tipoModalidadFidelidad;
	}

	public RamoFidelidad getRamoFidelidad() {
		return this.ramoFidelidad;
	}

	public void setRamoFidelidad(RamoFidelidad ramoFidelidad) {
		this.ramoFidelidad = ramoFidelidad;
	}

}