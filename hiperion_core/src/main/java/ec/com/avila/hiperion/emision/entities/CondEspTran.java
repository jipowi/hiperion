package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cond_esp_trans database table.
 * 
 */
@Entity
@Table(name="cond_esp_trans")
@NamedQuery(name="CondEspTran.findAll", query="SELECT c FROM CondEspTran c")
public class CondEspTran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_condicion_esp_transporte")
	private Integer idCondicionEspTransporte;

	@Column(name="condicion_esp_trans")
	private String condicionEspTrans;

	@Column(name="descripcion_cond_esp_trans")
	private String descripcionCondEspTrans;

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

	public CondEspTran() {
	}

	public Integer getIdCondicionEspTransporte() {
		return this.idCondicionEspTransporte;
	}

	public void setIdCondicionEspTransporte(Integer idCondicionEspTransporte) {
		this.idCondicionEspTransporte = idCondicionEspTransporte;
	}

	public String getCondicionEspTrans() {
		return this.condicionEspTrans;
	}

	public void setCondicionEspTrans(String condicionEspTrans) {
		this.condicionEspTrans = condicionEspTrans;
	}

	public String getDescripcionCondEspTrans() {
		return this.descripcionCondEspTrans;
	}

	public void setDescripcionCondEspTrans(String descripcionCondEspTrans) {
		this.descripcionCondEspTrans = descripcionCondEspTrans;
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