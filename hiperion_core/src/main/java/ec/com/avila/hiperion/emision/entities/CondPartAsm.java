package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cond_part_asm database table.
 * 
 */
@Entity
@Table(name="cond_part_asm")
@NamedQuery(name="CondPartAsm.findAll", query="SELECT c FROM CondPartAsm c")
public class CondPartAsm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cond_part_asm")
	private Integer idCondPartAsm;

	@Column(name="condicion_part_asm")
	private String condicionPartAsm;

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

	//bi-directional many-to-one association to RamoAsistenciaMedica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ast_medica")
	private RamoAsistenciaMedica ramoAsistenciaMedica;

	public CondPartAsm() {
	}

	public Integer getIdCondPartAsm() {
		return this.idCondPartAsm;
	}

	public void setIdCondPartAsm(Integer idCondPartAsm) {
		this.idCondPartAsm = idCondPartAsm;
	}

	public String getCondicionPartAsm() {
		return this.condicionPartAsm;
	}

	public void setCondicionPartAsm(String condicionPartAsm) {
		this.condicionPartAsm = condicionPartAsm;
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

	public RamoAsistenciaMedica getRamoAsistenciaMedica() {
		return this.ramoAsistenciaMedica;
	}

	public void setRamoAsistenciaMedica(RamoAsistenciaMedica ramoAsistenciaMedica) {
		this.ramoAsistenciaMedica = ramoAsistenciaMedica;
	}

}