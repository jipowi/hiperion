package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ramo_buena_cal_mat database table.
 * 
 */
@Entity
@Table(name="ramo_buena_cal_mat")
@NamedQuery(name="RamoBuenaCalMat.findAll", query="SELECT r FROM RamoBuenaCalMat r")
public class RamoBuenaCalMat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_material")
	private Integer idMaterial;

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

	@Column(name="obj_aseg_cal_mat")
	private String objAsegCalMat;

	@Column(name="sector_cal_mat")
	private String sectorCalMat;

	@Column(name="valor_contrato_materiales")
	private BigDecimal valorContratoMateriales;

	@Column(name="valor_poliza_materiales")
	private BigDecimal valorPolizaMateriales;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	//bi-directional many-to-one association to CobertMateriale
	@OneToMany(mappedBy="ramoBuenaCalMat")
	private List<CobertMateriale> cobertMateriales;

	public RamoBuenaCalMat() {
	}

	public Integer getIdMaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
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

	public String getObjAsegCalMat() {
		return this.objAsegCalMat;
	}

	public void setObjAsegCalMat(String objAsegCalMat) {
		this.objAsegCalMat = objAsegCalMat;
	}

	public String getSectorCalMat() {
		return this.sectorCalMat;
	}

	public void setSectorCalMat(String sectorCalMat) {
		this.sectorCalMat = sectorCalMat;
	}

	public BigDecimal getValorContratoMateriales() {
		return this.valorContratoMateriales;
	}

	public void setValorContratoMateriales(BigDecimal valorContratoMateriales) {
		this.valorContratoMateriales = valorContratoMateriales;
	}

	public BigDecimal getValorPolizaMateriales() {
		return this.valorPolizaMateriales;
	}

	public void setValorPolizaMateriales(BigDecimal valorPolizaMateriales) {
		this.valorPolizaMateriales = valorPolizaMateriales;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

	public List<CobertMateriale> getCobertMateriales() {
		return this.cobertMateriales;
	}

	public void setCobertMateriales(List<CobertMateriale> cobertMateriales) {
		this.cobertMateriales = cobertMateriales;
	}

	public CobertMateriale addCobertMateriale(CobertMateriale cobertMateriale) {
		getCobertMateriales().add(cobertMateriale);
		cobertMateriale.setRamoBuenaCalMat(this);

		return cobertMateriale;
	}

	public CobertMateriale removeCobertMateriale(CobertMateriale cobertMateriale) {
		getCobertMateriales().remove(cobertMateriale);
		cobertMateriale.setRamoBuenaCalMat(null);

		return cobertMateriale;
	}

}