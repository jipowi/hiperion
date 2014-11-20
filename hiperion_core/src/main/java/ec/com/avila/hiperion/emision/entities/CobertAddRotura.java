package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the cobert_add_rotura database table.
 * 
 */
@Entity
@Table(name="cobert_add_rotura")
@NamedQuery(name="CobertAddRotura.findAll", query="SELECT c FROM CobertAddRotura c")
public class CobertAddRotura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_ad_rotura")
	private Integer idCobertAdRotura;

	@Column(name="cobertura_add_rotura")
	private String coberturaAddRotura;

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

	@Column(name="valor_cob_rotura")
	private BigDecimal valorCobRotura;

	//bi-directional many-to-one association to RamoRoturaMaquinaria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_rotura")
	private RamoRoturaMaquinaria ramoRoturaMaquinaria;

	public CobertAddRotura() {
	}

	public Integer getIdCobertAdRotura() {
		return this.idCobertAdRotura;
	}

	public void setIdCobertAdRotura(Integer idCobertAdRotura) {
		this.idCobertAdRotura = idCobertAdRotura;
	}

	public String getCoberturaAddRotura() {
		return this.coberturaAddRotura;
	}

	public void setCoberturaAddRotura(String coberturaAddRotura) {
		this.coberturaAddRotura = coberturaAddRotura;
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

	public BigDecimal getValorCobRotura() {
		return this.valorCobRotura;
	}

	public void setValorCobRotura(BigDecimal valorCobRotura) {
		this.valorCobRotura = valorCobRotura;
	}

	public RamoRoturaMaquinaria getRamoRoturaMaquinaria() {
		return this.ramoRoturaMaquinaria;
	}

	public void setRamoRoturaMaquinaria(RamoRoturaMaquinaria ramoRoturaMaquinaria) {
		this.ramoRoturaMaquinaria = ramoRoturaMaquinaria;
	}

}