package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_acc_pers database table.
 * 
 */
@Entity
@Table(name="clausulas_add_acc_pers")
@NamedQuery(name="ClausulasAddAccPer.findAll", query="SELECT c FROM ClausulasAddAccPer c")
public class ClausulasAddAccPer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_acidente")
	private Integer idClausulaAdAcidente;

	@Column(name="clausula_acc_personales")
	private String clausulaAccPersonales;

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

	//bi-directional many-to-one association to RamoAccidentesPersonale
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_accidentes")
	private RamoAccidentesPersonale ramoAccidentesPersonale;

	public ClausulasAddAccPer() {
	}

	public Integer getIdClausulaAdAcidente() {
		return this.idClausulaAdAcidente;
	}

	public void setIdClausulaAdAcidente(Integer idClausulaAdAcidente) {
		this.idClausulaAdAcidente = idClausulaAdAcidente;
	}

	public String getClausulaAccPersonales() {
		return this.clausulaAccPersonales;
	}

	public void setClausulaAccPersonales(String clausulaAccPersonales) {
		this.clausulaAccPersonales = clausulaAccPersonales;
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

	public RamoAccidentesPersonale getRamoAccidentesPersonale() {
		return this.ramoAccidentesPersonale;
	}

	public void setRamoAccidentesPersonale(RamoAccidentesPersonale ramoAccidentesPersonale) {
		this.ramoAccidentesPersonale = ramoAccidentesPersonale;
	}

}