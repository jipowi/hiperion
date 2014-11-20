package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_trans database table.
 * 
 */
@Entity
@Table(name="cobert_trans")
@NamedQuery(name="CobertTran.findAll", query="SELECT c FROM CobertTran c")
public class CobertTran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_transporte")
	private Integer idCobertTransporte;

	@Column(name="cobertura_transporte")
	private String coberturaTransporte;

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

	//bi-directional many-to-one association to RamoTransporte
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_transporte")
	private RamoTransporte ramoTransporte;

	public CobertTran() {
	}

	public Integer getIdCobertTransporte() {
		return this.idCobertTransporte;
	}

	public void setIdCobertTransporte(Integer idCobertTransporte) {
		this.idCobertTransporte = idCobertTransporte;
	}

	public String getCoberturaTransporte() {
		return this.coberturaTransporte;
	}

	public void setCoberturaTransporte(String coberturaTransporte) {
		this.coberturaTransporte = coberturaTransporte;
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

	public RamoTransporte getRamoTransporte() {
		return this.ramoTransporte;
	}

	public void setRamoTransporte(RamoTransporte ramoTransporte) {
		this.ramoTransporte = ramoTransporte;
	}

}