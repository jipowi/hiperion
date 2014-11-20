package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_lc_in database table.
 * 
 */
@Entity
@Table(name="cobert_lc_in")
@NamedQuery(name="CobertLcIn.findAll", query="SELECT c FROM CobertLcIn c")
public class CobertLcIn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_lucro")
	private Integer idCobertLucro;

	@Column(name="cobertura_lc_incendio")
	private String coberturaLcIncendio;

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

	//bi-directional many-to-one association to RamoLcIncendio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_lucro")
	private RamoLcIncendio ramoLcIncendio;

	public CobertLcIn() {
	}

	public Integer getIdCobertLucro() {
		return this.idCobertLucro;
	}

	public void setIdCobertLucro(Integer idCobertLucro) {
		this.idCobertLucro = idCobertLucro;
	}

	public String getCoberturaLcIncendio() {
		return this.coberturaLcIncendio;
	}

	public void setCoberturaLcIncendio(String coberturaLcIncendio) {
		this.coberturaLcIncendio = coberturaLcIncendio;
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

	public RamoLcIncendio getRamoLcIncendio() {
		return this.ramoLcIncendio;
	}

	public void setRamoLcIncendio(RamoLcIncendio ramoLcIncendio) {
		this.ramoLcIncendio = ramoLcIncendio;
	}

}