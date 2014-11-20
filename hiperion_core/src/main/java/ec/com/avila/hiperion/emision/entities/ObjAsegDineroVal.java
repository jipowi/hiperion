package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the obj_aseg_dinero_val database table.
 * 
 */
@Entity
@Table(name="obj_aseg_dinero_val")
@NamedQuery(name="ObjAsegDineroVal.findAll", query="SELECT o FROM ObjAsegDineroVal o")
public class ObjAsegDineroVal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ob_aseg_dinero_valores")
	private Integer idObAsegDineroValores;

	private String desde;

	@Column(name="dinero_valores")
	private BigDecimal dineroValores;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	private String hasta;

	@Column(name="id_usuario_actualizacion")
	private Integer idUsuarioActualizacion;

	@Column(name="id_usuario_creacion")
	private Integer idUsuarioCreacion;

	@Column(name="item_obj_dinero")
	private Integer itemObjDinero;

	@Column(name="limite_embarque_obj_dinero")
	private BigDecimal limiteEmbarqueObjDinero;

	@Column(name="limite_estimado")
	private BigDecimal limiteEstimado;

	@Column(name="medio_transporte_dinero")
	private String medioTransporteDinero;

	//bi-directional many-to-one association to RamoDineroValore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_dinero")
	private RamoDineroValore ramoDineroValore;

	public ObjAsegDineroVal() {
	}

	public Integer getIdObAsegDineroValores() {
		return this.idObAsegDineroValores;
	}

	public void setIdObAsegDineroValores(Integer idObAsegDineroValores) {
		this.idObAsegDineroValores = idObAsegDineroValores;
	}

	public String getDesde() {
		return this.desde;
	}

	public void setDesde(String desde) {
		this.desde = desde;
	}

	public BigDecimal getDineroValores() {
		return this.dineroValores;
	}

	public void setDineroValores(BigDecimal dineroValores) {
		this.dineroValores = dineroValores;
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

	public String getHasta() {
		return this.hasta;
	}

	public void setHasta(String hasta) {
		this.hasta = hasta;
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

	public Integer getItemObjDinero() {
		return this.itemObjDinero;
	}

	public void setItemObjDinero(Integer itemObjDinero) {
		this.itemObjDinero = itemObjDinero;
	}

	public BigDecimal getLimiteEmbarqueObjDinero() {
		return this.limiteEmbarqueObjDinero;
	}

	public void setLimiteEmbarqueObjDinero(BigDecimal limiteEmbarqueObjDinero) {
		this.limiteEmbarqueObjDinero = limiteEmbarqueObjDinero;
	}

	public BigDecimal getLimiteEstimado() {
		return this.limiteEstimado;
	}

	public void setLimiteEstimado(BigDecimal limiteEstimado) {
		this.limiteEstimado = limiteEstimado;
	}

	public String getMedioTransporteDinero() {
		return this.medioTransporteDinero;
	}

	public void setMedioTransporteDinero(String medioTransporteDinero) {
		this.medioTransporteDinero = medioTransporteDinero;
	}

	public RamoDineroValore getRamoDineroValore() {
		return this.ramoDineroValore;
	}

	public void setRamoDineroValore(RamoDineroValore ramoDineroValore) {
		this.ramoDineroValore = ramoDineroValore;
	}

}