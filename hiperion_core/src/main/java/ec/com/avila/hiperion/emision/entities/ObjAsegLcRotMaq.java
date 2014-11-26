package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the obj_aseg_lc_rot_maq database table.
 * 
 */
@Entity
@Table(name="obj_aseg_lc_rot_maq")
@NamedQuery(name="ObjAsegLcRotMaq.findAll", query="SELECT o FROM ObjAsegLcRotMaq o")
public class ObjAsegLcRotMaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto_aseg_cesante")
	private Integer idObjetoAsegCesante;

	@Column(name="des_obj_lc_rotura")
	private String desObjLcRotura;

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

	@Column(name="item_obj_lc_rotura")
	private Integer itemObjLcRotura;

	@Column(name="ubicacion_obj_lc_rotura")
	private String ubicacionObjLcRotura;

	@Column(name="valor_aseg_obj_lc_rotura")
	private BigDecimal valorAsegObjLcRotura;

	//bi-directional many-to-one association to RamoLcRotMaq
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cesante")
	private RamoLcRotMaq ramoLcRotMaq;

	public ObjAsegLcRotMaq() {
	}

	public Integer getIdObjetoAsegCesante() {
		return this.idObjetoAsegCesante;
	}

	public void setIdObjetoAsegCesante(Integer idObjetoAsegCesante) {
		this.idObjetoAsegCesante = idObjetoAsegCesante;
	}

	public String getDesObjLcRotura() {
		return this.desObjLcRotura;
	}

	public void setDesObjLcRotura(String desObjLcRotura) {
		this.desObjLcRotura = desObjLcRotura;
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

	public Integer getItemObjLcRotura() {
		return this.itemObjLcRotura;
	}

	public void setItemObjLcRotura(Integer itemObjLcRotura) {
		this.itemObjLcRotura = itemObjLcRotura;
	}

	public String getUbicacionObjLcRotura() {
		return this.ubicacionObjLcRotura;
	}

	public void setUbicacionObjLcRotura(String ubicacionObjLcRotura) {
		this.ubicacionObjLcRotura = ubicacionObjLcRotura;
	}

	public BigDecimal getValorAsegObjLcRotura() {
		return this.valorAsegObjLcRotura;
	}

	public void setValorAsegObjLcRotura(BigDecimal valorAsegObjLcRotura) {
		this.valorAsegObjLcRotura = valorAsegObjLcRotura;
	}

	public RamoLcRotMaq getRamoLcRotMaq() {
		return this.ramoLcRotMaq;
	}

	public void setRamoLcRotMaq(RamoLcRotMaq ramoLcRotMaq) {
		this.ramoLcRotMaq = ramoLcRotMaq;
	}

}