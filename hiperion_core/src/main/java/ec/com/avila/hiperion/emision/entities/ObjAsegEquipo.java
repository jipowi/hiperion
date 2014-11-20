package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the obj_aseg_equipo database table.
 * 
 */
@Entity
@Table(name="obj_aseg_equipo")
@NamedQuery(name="ObjAsegEquipo.findAll", query="SELECT o FROM ObjAsegEquipo o")
public class ObjAsegEquipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto_aseg_equipo")
	private Integer idObjetoAsegEquipo;

	@Column(name="desc_obj_eq_elec")
	private String descObjEqElec;

	@Column(name="detalle_objeto_eq_elec")
	private String detalleObjetoEqElec;

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

	@Column(name="item_obj_eq_elec")
	private Integer itemObjEqElec;

	@Column(name="ubicacion_obj_eq_elec")
	private String ubicacionObjEqElec;

	@Column(name="valor_obj_eq_elec")
	private BigDecimal valorObjEqElec;

	//bi-directional many-to-one association to RamoEquipoElectronico
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_equipo")
	private RamoEquipoElectronico ramoEquipoElectronico;

	public ObjAsegEquipo() {
	}

	public Integer getIdObjetoAsegEquipo() {
		return this.idObjetoAsegEquipo;
	}

	public void setIdObjetoAsegEquipo(Integer idObjetoAsegEquipo) {
		this.idObjetoAsegEquipo = idObjetoAsegEquipo;
	}

	public String getDescObjEqElec() {
		return this.descObjEqElec;
	}

	public void setDescObjEqElec(String descObjEqElec) {
		this.descObjEqElec = descObjEqElec;
	}

	public String getDetalleObjetoEqElec() {
		return this.detalleObjetoEqElec;
	}

	public void setDetalleObjetoEqElec(String detalleObjetoEqElec) {
		this.detalleObjetoEqElec = detalleObjetoEqElec;
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

	public Integer getItemObjEqElec() {
		return this.itemObjEqElec;
	}

	public void setItemObjEqElec(Integer itemObjEqElec) {
		this.itemObjEqElec = itemObjEqElec;
	}

	public String getUbicacionObjEqElec() {
		return this.ubicacionObjEqElec;
	}

	public void setUbicacionObjEqElec(String ubicacionObjEqElec) {
		this.ubicacionObjEqElec = ubicacionObjEqElec;
	}

	public BigDecimal getValorObjEqElec() {
		return this.valorObjEqElec;
	}

	public void setValorObjEqElec(BigDecimal valorObjEqElec) {
		this.valorObjEqElec = valorObjEqElec;
	}

	public RamoEquipoElectronico getRamoEquipoElectronico() {
		return this.ramoEquipoElectronico;
	}

	public void setRamoEquipoElectronico(RamoEquipoElectronico ramoEquipoElectronico) {
		this.ramoEquipoElectronico = ramoEquipoElectronico;
	}

}