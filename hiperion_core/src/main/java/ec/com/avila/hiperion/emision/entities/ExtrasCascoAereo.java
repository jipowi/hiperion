package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the extras_casco_aereo database table.
 * 
 */
@Entity
@Table(name="extras_casco_aereo")
@NamedQuery(name="ExtrasCascoAereo.findAll", query="SELECT e FROM ExtrasCascoAereo e")
public class ExtrasCascoAereo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_extra_casco_aereo")
	private Integer idExtraCascoAereo;

	private String estado;

	@Column(name="extra_casco_aereo")
	private String extraCascoAereo;

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

	@Column(name="valor_extra_aereo")
	private BigDecimal valorExtraAereo;

	//bi-directional many-to-one association to RamoCascoAereo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_casco_aereo")
	private RamoCascoAereo ramoCascoAereo;

	public ExtrasCascoAereo() {
	}

	public Integer getIdExtraCascoAereo() {
		return this.idExtraCascoAereo;
	}

	public void setIdExtraCascoAereo(Integer idExtraCascoAereo) {
		this.idExtraCascoAereo = idExtraCascoAereo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getExtraCascoAereo() {
		return this.extraCascoAereo;
	}

	public void setExtraCascoAereo(String extraCascoAereo) {
		this.extraCascoAereo = extraCascoAereo;
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

	public BigDecimal getValorExtraAereo() {
		return this.valorExtraAereo;
	}

	public void setValorExtraAereo(BigDecimal valorExtraAereo) {
		this.valorExtraAereo = valorExtraAereo;
	}

	public RamoCascoAereo getRamoCascoAereo() {
		return this.ramoCascoAereo;
	}

	public void setRamoCascoAereo(RamoCascoAereo ramoCascoAereo) {
		this.ramoCascoAereo = ramoCascoAereo;
	}

}