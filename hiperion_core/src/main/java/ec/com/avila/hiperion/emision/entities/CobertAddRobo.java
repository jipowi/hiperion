package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the cobert_add_robo database table.
 * 
 */
@Entity
@Table(name="cobert_add_robo")
@NamedQuery(name="CobertAddRobo.findAll", query="SELECT c FROM CobertAddRobo c")
public class CobertAddRobo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_ad_robo")
	private Integer idCobertAdRobo;

	@Column(name="cobertura_add_robo")
	private String coberturaAddRobo;

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

	@Column(name="valor_cob_add_robo")
	private BigDecimal valorCobAddRobo;

	//bi-directional many-to-one association to RamoRoboAsalto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_robo")
	private RamoRoboAsalto ramoRoboAsalto;

	public CobertAddRobo() {
	}

	public Integer getIdCobertAdRobo() {
		return this.idCobertAdRobo;
	}

	public void setIdCobertAdRobo(Integer idCobertAdRobo) {
		this.idCobertAdRobo = idCobertAdRobo;
	}

	public String getCoberturaAddRobo() {
		return this.coberturaAddRobo;
	}

	public void setCoberturaAddRobo(String coberturaAddRobo) {
		this.coberturaAddRobo = coberturaAddRobo;
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

	public BigDecimal getValorCobAddRobo() {
		return this.valorCobAddRobo;
	}

	public void setValorCobAddRobo(BigDecimal valorCobAddRobo) {
		this.valorCobAddRobo = valorCobAddRobo;
	}

	public RamoRoboAsalto getRamoRoboAsalto() {
		return this.ramoRoboAsalto;
	}

	public void setRamoRoboAsalto(RamoRoboAsalto ramoRoboAsalto) {
		this.ramoRoboAsalto = ramoRoboAsalto;
	}

}