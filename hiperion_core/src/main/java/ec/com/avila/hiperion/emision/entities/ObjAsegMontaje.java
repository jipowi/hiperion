package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the obj_aseg_montaje database table.
 * 
 */
@Entity
@Table(name="obj_aseg_montaje")
@NamedQuery(name="ObjAsegMontaje.findAll", query="SELECT o FROM ObjAsegMontaje o")
public class ObjAsegMontaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_obj_aseg_montaje")
	private Integer idObjAsegMontaje;

	@Column(name="detalle_obj_montaje")
	private String detalleObjMontaje;

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

	//bi-directional many-to-one association to RamoRiesgoMontaje
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_riesgo_montaje")
	private RamoRiesgoMontaje ramoRiesgoMontaje;

	public ObjAsegMontaje() {
	}

	public Integer getIdObjAsegMontaje() {
		return this.idObjAsegMontaje;
	}

	public void setIdObjAsegMontaje(Integer idObjAsegMontaje) {
		this.idObjAsegMontaje = idObjAsegMontaje;
	}

	public String getDetalleObjMontaje() {
		return this.detalleObjMontaje;
	}

	public void setDetalleObjMontaje(String detalleObjMontaje) {
		this.detalleObjMontaje = detalleObjMontaje;
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

	public RamoRiesgoMontaje getRamoRiesgoMontaje() {
		return this.ramoRiesgoMontaje;
	}

	public void setRamoRiesgoMontaje(RamoRiesgoMontaje ramoRiesgoMontaje) {
		this.ramoRiesgoMontaje = ramoRiesgoMontaje;
	}

}