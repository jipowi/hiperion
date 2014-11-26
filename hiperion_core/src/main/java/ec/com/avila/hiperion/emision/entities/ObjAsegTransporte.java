package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the obj_aseg_transporte database table.
 * 
 */
@Entity
@Table(name="obj_aseg_transporte")
@NamedQuery(name="ObjAsegTransporte.findAll", query="SELECT o FROM ObjAsegTransporte o")
public class ObjAsegTransporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_obj_asg_transporte")
	private Integer idObjAsgTransporte;

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

	@Column(name="item_transporte")
	private Integer itemTransporte;

	@Column(name="limite_embarque_transporte")
	private BigDecimal limiteEmbarqueTransporte;

	@Column(name="limite_movilizacion_anual")
	private BigDecimal limiteMovilizacionAnual;

	@Column(name="medio_transporte")
	private String medioTransporte;

	@Column(name="tipo_embalaje")
	private String tipoEmbalaje;

	@Column(name="trayecto_desde")
	private String trayectoDesde;

	@Column(name="trayecto_hasta")
	private String trayectoHasta;

	private String valuacion;

	//bi-directional many-to-one association to RamoTransporte
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_transporte")
	private RamoTransporte ramoTransporte;

	public ObjAsegTransporte() {
	}

	public Integer getIdObjAsgTransporte() {
		return this.idObjAsgTransporte;
	}

	public void setIdObjAsgTransporte(Integer idObjAsgTransporte) {
		this.idObjAsgTransporte = idObjAsgTransporte;
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

	public Integer getItemTransporte() {
		return this.itemTransporte;
	}

	public void setItemTransporte(Integer itemTransporte) {
		this.itemTransporte = itemTransporte;
	}

	public BigDecimal getLimiteEmbarqueTransporte() {
		return this.limiteEmbarqueTransporte;
	}

	public void setLimiteEmbarqueTransporte(BigDecimal limiteEmbarqueTransporte) {
		this.limiteEmbarqueTransporte = limiteEmbarqueTransporte;
	}

	public BigDecimal getLimiteMovilizacionAnual() {
		return this.limiteMovilizacionAnual;
	}

	public void setLimiteMovilizacionAnual(BigDecimal limiteMovilizacionAnual) {
		this.limiteMovilizacionAnual = limiteMovilizacionAnual;
	}

	public String getMedioTransporte() {
		return this.medioTransporte;
	}

	public void setMedioTransporte(String medioTransporte) {
		this.medioTransporte = medioTransporte;
	}

	public String getTipoEmbalaje() {
		return this.tipoEmbalaje;
	}

	public void setTipoEmbalaje(String tipoEmbalaje) {
		this.tipoEmbalaje = tipoEmbalaje;
	}

	public String getTrayectoDesde() {
		return this.trayectoDesde;
	}

	public void setTrayectoDesde(String trayectoDesde) {
		this.trayectoDesde = trayectoDesde;
	}

	public String getTrayectoHasta() {
		return this.trayectoHasta;
	}

	public void setTrayectoHasta(String trayectoHasta) {
		this.trayectoHasta = trayectoHasta;
	}

	public String getValuacion() {
		return this.valuacion;
	}

	public void setValuacion(String valuacion) {
		this.valuacion = valuacion;
	}

	public RamoTransporte getRamoTransporte() {
		return this.ramoTransporte;
	}

	public void setRamoTransporte(RamoTransporte ramoTransporte) {
		this.ramoTransporte = ramoTransporte;
	}

}