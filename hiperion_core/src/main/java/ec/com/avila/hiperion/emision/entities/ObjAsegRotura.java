package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the obj_aseg_rotura database table.
 * 
 */
@Entity
@Table(name="obj_aseg_rotura")
@NamedQuery(name="ObjAsegRotura.findAll", query="SELECT o FROM ObjAsegRotura o")
public class ObjAsegRotura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto_rotura")
	private Integer idObjetoRotura;

	@Column(name="descripcion_obj_rotura")
	private String descripcionObjRotura;

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

	@Column(name="item_obj_rotura")
	private Integer itemObjRotura;

	@Column(name="total_obj_rotura")
	private BigDecimal totalObjRotura;

	@Column(name="ubicacion_obj_rotura")
	private String ubicacionObjRotura;

	//bi-directional many-to-one association to RamoRoturaMaquinaria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rotura")
	private RamoRoturaMaquinaria ramoRoturaMaquinaria;

	public ObjAsegRotura() {
	}

	public Integer getIdObjetoRotura() {
		return this.idObjetoRotura;
	}

	public void setIdObjetoRotura(Integer idObjetoRotura) {
		this.idObjetoRotura = idObjetoRotura;
	}

	public String getDescripcionObjRotura() {
		return this.descripcionObjRotura;
	}

	public void setDescripcionObjRotura(String descripcionObjRotura) {
		this.descripcionObjRotura = descripcionObjRotura;
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

	public Integer getItemObjRotura() {
		return this.itemObjRotura;
	}

	public void setItemObjRotura(Integer itemObjRotura) {
		this.itemObjRotura = itemObjRotura;
	}

	public BigDecimal getTotalObjRotura() {
		return this.totalObjRotura;
	}

	public void setTotalObjRotura(BigDecimal totalObjRotura) {
		this.totalObjRotura = totalObjRotura;
	}

	public String getUbicacionObjRotura() {
		return this.ubicacionObjRotura;
	}

	public void setUbicacionObjRotura(String ubicacionObjRotura) {
		this.ubicacionObjRotura = ubicacionObjRotura;
	}

	public RamoRoturaMaquinaria getRamoRoturaMaquinaria() {
		return this.ramoRoturaMaquinaria;
	}

	public void setRamoRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) {
		this.ramoRoturaMaquinaria = ramoRoturaMaquinaria;
	}

}