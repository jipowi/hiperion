package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ramo_lc_rot_maq database table.
 * 
 */
@Entity
@Table(name="ramo_lc_rot_maq")
@NamedQuery(name="RamoLcRotMaq.findAll", query="SELECT r FROM RamoLcRotMaq r")
public class RamoLcRotMaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cesante")
	private Integer idCesante;

	@Column(name="deduc_minimo_aseg_lc_rotura")
	private BigDecimal deducMinimoAsegLcRotura;

	@Column(name="deduc_minimo_lc_rotura")
	private BigDecimal deducMinimoLcRotura;

	@Column(name="deduc_num_dias")
	private Integer deducNumDias;

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

	@Column(name="period_indemnizacion_lc")
	private Integer periodIndemnizacionLc;

	@Column(name="tasa_lc_rotura")
	private BigDecimal tasaLcRotura;

	@Column(name="utilidad_bruta_lc_rotura")
	private BigDecimal utilidadBrutaLcRotura;

	//bi-directional many-to-one association to ClaAddLcRot
	@OneToMany(mappedBy="ramoLcRotMaq")
	private List<ClaAddLcRot> claAddLcRots;

	//bi-directional many-to-one association to CobertAddLcRot
	@OneToMany(mappedBy="ramoLcRotMaq")
	private List<CobertAddLcRot> cobertAddLcRots;

	//bi-directional many-to-one association to CobertLcRot
	@OneToMany(mappedBy="ramoLcRotMaq")
	private List<CobertLcRot> cobertLcRots;

	//bi-directional many-to-one association to ObjAsegLcRotMaq
	@OneToMany(mappedBy="ramoLcRotMaq")
	private List<ObjAsegLcRotMaq> objAsegLcRotMaqs;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	public RamoLcRotMaq() {
	}

	public Integer getIdCesante() {
		return this.idCesante;
	}

	public void setIdCesante(Integer idCesante) {
		this.idCesante = idCesante;
	}

	public BigDecimal getDeducMinimoAsegLcRotura() {
		return this.deducMinimoAsegLcRotura;
	}

	public void setDeducMinimoAsegLcRotura(BigDecimal deducMinimoAsegLcRotura) {
		this.deducMinimoAsegLcRotura = deducMinimoAsegLcRotura;
	}

	public BigDecimal getDeducMinimoLcRotura() {
		return this.deducMinimoLcRotura;
	}

	public void setDeducMinimoLcRotura(BigDecimal deducMinimoLcRotura) {
		this.deducMinimoLcRotura = deducMinimoLcRotura;
	}

	public Integer getDeducNumDias() {
		return this.deducNumDias;
	}

	public void setDeducNumDias(Integer deducNumDias) {
		this.deducNumDias = deducNumDias;
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

	public Integer getPeriodIndemnizacionLc() {
		return this.periodIndemnizacionLc;
	}

	public void setPeriodIndemnizacionLc(Integer periodIndemnizacionLc) {
		this.periodIndemnizacionLc = periodIndemnizacionLc;
	}

	public BigDecimal getTasaLcRotura() {
		return this.tasaLcRotura;
	}

	public void setTasaLcRotura(BigDecimal tasaLcRotura) {
		this.tasaLcRotura = tasaLcRotura;
	}

	public BigDecimal getUtilidadBrutaLcRotura() {
		return this.utilidadBrutaLcRotura;
	}

	public void setUtilidadBrutaLcRotura(BigDecimal utilidadBrutaLcRotura) {
		this.utilidadBrutaLcRotura = utilidadBrutaLcRotura;
	}

	public List<ClaAddLcRot> getClaAddLcRots() {
		return this.claAddLcRots;
	}

	public void setClaAddLcRots(List<ClaAddLcRot> claAddLcRots) {
		this.claAddLcRots = claAddLcRots;
	}

	public ClaAddLcRot addClaAddLcRot(ClaAddLcRot claAddLcRot) {
		getClaAddLcRots().add(claAddLcRot);
		claAddLcRot.setRamoLcRotMaq(this);

		return claAddLcRot;
	}

	public ClaAddLcRot removeClaAddLcRot(ClaAddLcRot claAddLcRot) {
		getClaAddLcRots().remove(claAddLcRot);
		claAddLcRot.setRamoLcRotMaq(null);

		return claAddLcRot;
	}

	public List<CobertAddLcRot> getCobertAddLcRots() {
		return this.cobertAddLcRots;
	}

	public void setCobertAddLcRots(List<CobertAddLcRot> cobertAddLcRots) {
		this.cobertAddLcRots = cobertAddLcRots;
	}

	public CobertAddLcRot addCobertAddLcRot(CobertAddLcRot cobertAddLcRot) {
		getCobertAddLcRots().add(cobertAddLcRot);
		cobertAddLcRot.setRamoLcRotMaq(this);

		return cobertAddLcRot;
	}

	public CobertAddLcRot removeCobertAddLcRot(CobertAddLcRot cobertAddLcRot) {
		getCobertAddLcRots().remove(cobertAddLcRot);
		cobertAddLcRot.setRamoLcRotMaq(null);

		return cobertAddLcRot;
	}

	public List<CobertLcRot> getCobertLcRots() {
		return this.cobertLcRots;
	}

	public void setCobertLcRots(List<CobertLcRot> cobertLcRots) {
		this.cobertLcRots = cobertLcRots;
	}

	public CobertLcRot addCobertLcRot(CobertLcRot cobertLcRot) {
		getCobertLcRots().add(cobertLcRot);
		cobertLcRot.setRamoLcRotMaq(this);

		return cobertLcRot;
	}

	public CobertLcRot removeCobertLcRot(CobertLcRot cobertLcRot) {
		getCobertLcRots().remove(cobertLcRot);
		cobertLcRot.setRamoLcRotMaq(null);

		return cobertLcRot;
	}

	public List<ObjAsegLcRotMaq> getObjAsegLcRotMaqs() {
		return this.objAsegLcRotMaqs;
	}

	public void setObjAsegLcRotMaqs(List<ObjAsegLcRotMaq> objAsegLcRotMaqs) {
		this.objAsegLcRotMaqs = objAsegLcRotMaqs;
	}

	public ObjAsegLcRotMaq addObjAsegLcRotMaq(ObjAsegLcRotMaq objAsegLcRotMaq) {
		getObjAsegLcRotMaqs().add(objAsegLcRotMaq);
		objAsegLcRotMaq.setRamoLcRotMaq(this);

		return objAsegLcRotMaq;
	}

	public ObjAsegLcRotMaq removeObjAsegLcRotMaq(ObjAsegLcRotMaq objAsegLcRotMaq) {
		getObjAsegLcRotMaqs().remove(objAsegLcRotMaq);
		objAsegLcRotMaq.setRamoLcRotMaq(null);

		return objAsegLcRotMaq;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}