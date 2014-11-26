package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the obj_aseg_responsabilidad database table.
 * 
 */
@Entity
@Table(name="obj_aseg_responsabilidad")
@NamedQuery(name="ObjAsegResponsabilidad.findAll", query="SELECT o FROM ObjAsegResponsabilidad o")
public class ObjAsegResponsabilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto_aseg_resposabilidad")
	private Integer idObjetoAsegResposabilidad;

	@Column(name="descripcion_resp")
	private String descripcionResp;

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

	@Column(name="item_resp")
	private Integer itemResp;

	//bi-directional many-to-one association to RamoResponsabilidadCivil
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_responsabilidad")
	private RamoResponsabilidadCivil ramoResponsabilidadCivil;

	public ObjAsegResponsabilidad() {
	}

	public Integer getIdObjetoAsegResposabilidad() {
		return this.idObjetoAsegResposabilidad;
	}

	public void setIdObjetoAsegResposabilidad(Integer idObjetoAsegResposabilidad) {
		this.idObjetoAsegResposabilidad = idObjetoAsegResposabilidad;
	}

	public String getDescripcionResp() {
		return this.descripcionResp;
	}

	public void setDescripcionResp(String descripcionResp) {
		this.descripcionResp = descripcionResp;
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

	public Integer getItemResp() {
		return this.itemResp;
	}

	public void setItemResp(Integer itemResp) {
		this.itemResp = itemResp;
	}

	public RamoResponsabilidadCivil getRamoResponsabilidadCivil() {
		return this.ramoResponsabilidadCivil;
	}

	public void setRamoResponsabilidadCivil(RamoResponsabilidadCivil ramoResponsabilidadCivil) {
		this.ramoResponsabilidadCivil = ramoResponsabilidadCivil;
	}

}