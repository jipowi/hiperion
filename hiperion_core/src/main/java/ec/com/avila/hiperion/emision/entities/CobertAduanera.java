package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_aduanera database table.
 * 
 */
@Entity
@Table(name="cobert_aduanera")
@NamedQuery(name="CobertAduanera.findAll", query="SELECT c FROM CobertAduanera c")
public class CobertAduanera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_aduanera")
	private Integer idCobertAduanera;

	@Column(name="cobertura_aduanera")
	private String coberturaAduanera;

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

	//bi-directional many-to-one association to RamoGarantiaAduanera
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_aduanera")
	private RamoGarantiaAduanera ramoGarantiaAduanera;

	public CobertAduanera() {
	}

	public Integer getIdCobertAduanera() {
		return this.idCobertAduanera;
	}

	public void setIdCobertAduanera(Integer idCobertAduanera) {
		this.idCobertAduanera = idCobertAduanera;
	}

	public String getCoberturaAduanera() {
		return this.coberturaAduanera;
	}

	public void setCoberturaAduanera(String coberturaAduanera) {
		this.coberturaAduanera = coberturaAduanera;
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

	public RamoGarantiaAduanera getRamoGarantiaAduanera() {
		return this.ramoGarantiaAduanera;
	}

	public void setRamoGarantiaAduanera(RamoGarantiaAduanera ramoGarantiaAduanera) {
		this.ramoGarantiaAduanera = ramoGarantiaAduanera;
	}

}