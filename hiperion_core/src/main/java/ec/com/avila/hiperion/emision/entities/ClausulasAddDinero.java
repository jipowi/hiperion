package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the clausulas_add_dinero database table.
 * 
 */
@Entity
@Table(name="clausulas_add_dinero")
@NamedQuery(name="ClausulasAddDinero.findAll", query="SELECT c FROM ClausulasAddDinero c")
public class ClausulasAddDinero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clausula_ad_dinero")
	private Integer idClausulaAdDinero;

	@Column(name="clausula_add_dinero")
	private String clausulaAddDinero;

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

	@Column(name="num_dias_dinero")
	private Integer numDiasDinero;

	//bi-directional many-to-one association to RamoDineroValore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_dinero")
	private RamoDineroValore ramoDineroValore;

	public ClausulasAddDinero() {
	}

	public Integer getIdClausulaAdDinero() {
		return this.idClausulaAdDinero;
	}

	public void setIdClausulaAdDinero(Integer idClausulaAdDinero) {
		this.idClausulaAdDinero = idClausulaAdDinero;
	}

	public String getClausulaAddDinero() {
		return this.clausulaAddDinero;
	}

	public void setClausulaAddDinero(String clausulaAddDinero) {
		this.clausulaAddDinero = clausulaAddDinero;
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

	public Integer getNumDiasDinero() {
		return this.numDiasDinero;
	}

	public void setNumDiasDinero(Integer numDiasDinero) {
		this.numDiasDinero = numDiasDinero;
	}

	public RamoDineroValore getRamoDineroValore() {
		return this.ramoDineroValore;
	}

	public void setRamoDineroValore(RamoDineroValore ramoDineroValore) {
		this.ramoDineroValore = ramoDineroValore;
	}

}