package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the limites_costos_asm database table.
 * 
 */
@Entity
@Table(name="limites_costos_asm")
@NamedQuery(name="LimitesCostosAsm.findAll", query="SELECT l FROM LimitesCostosAsm l")
public class LimitesCostosAsm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_limite_costo_asm")
	private Integer idLimiteCostoAsm;

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

	@Column(name="limite_costo")
	private String limiteCosto;

	@Column(name="tipo_limite")
	private Integer tipoLimite;

	//bi-directional many-to-one association to RamoAsistenciaMedica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ast_medica")
	private RamoAsistenciaMedica ramoAsistenciaMedica;

	public LimitesCostosAsm() {
	}

	public Integer getIdLimiteCostoAsm() {
		return this.idLimiteCostoAsm;
	}

	public void setIdLimiteCostoAsm(Integer idLimiteCostoAsm) {
		this.idLimiteCostoAsm = idLimiteCostoAsm;
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

	public String getLimiteCosto() {
		return this.limiteCosto;
	}

	public void setLimiteCosto(String limiteCosto) {
		this.limiteCosto = limiteCosto;
	}

	public Integer getTipoLimite() {
		return this.tipoLimite;
	}

	public void setTipoLimite(Integer tipoLimite) {
		this.tipoLimite = tipoLimite;
	}

	public RamoAsistenciaMedica getRamoAsistenciaMedica() {
		return this.ramoAsistenciaMedica;
	}

	public void setRamoAsistenciaMedica(RamoAsistenciaMedica ramoAsistenciaMedica) {
		this.ramoAsistenciaMedica = ramoAsistenciaMedica;
	}

}