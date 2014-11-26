package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ramo_rotura_maquinaria database table.
 * 
 */
@Entity
@Table(name="ramo_rotura_maquinaria")
@NamedQuery(name="RamoRoturaMaquinaria.findAll", query="SELECT r FROM RamoRoturaMaquinaria r")
public class RamoRoturaMaquinaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rotura")
	private Integer idRotura;

	@Column(name="deduc_minimo_aseg_rot_maq")
	private BigDecimal deducMinimoAsegRotMaq;

	@Column(name="deduc_minimo_siniestro_rot")
	private BigDecimal deducMinimoSiniestroRot;

	@Column(name="deduc_siniestro_rot_maq")
	private BigDecimal deducSiniestroRotMaq;

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

	@Column(name="tasa_rot_maq")
	private BigDecimal tasaRotMaq;

	//bi-directional many-to-one association to ClausulasAddRotura
	@OneToMany(mappedBy="ramoRoturaMaquinaria")
	private List<ClausulasAddRotura> clausulasAddRoturas;

	//bi-directional many-to-one association to CobertAddRotura
	@OneToMany(mappedBy="ramoRoturaMaquinaria")
	private List<CobertAddRotura> cobertAddRoturas;

	//bi-directional many-to-one association to CobertRotura
	@OneToMany(mappedBy="ramoRoturaMaquinaria")
	private List<CobertRotura> cobertRoturas;

	//bi-directional many-to-one association to ObjAsegRotura
	@OneToMany(mappedBy="ramoRoturaMaquinaria")
	private List<ObjAsegRotura> objAsegRoturas;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	public RamoRoturaMaquinaria() {
	}

	public Integer getIdRotura() {
		return this.idRotura;
	}

	public void setIdRotura(Integer idRotura) {
		this.idRotura = idRotura;
	}

	public BigDecimal getDeducMinimoAsegRotMaq() {
		return this.deducMinimoAsegRotMaq;
	}

	public void setDeducMinimoAsegRotMaq(BigDecimal deducMinimoAsegRotMaq) {
		this.deducMinimoAsegRotMaq = deducMinimoAsegRotMaq;
	}

	public BigDecimal getDeducMinimoSiniestroRot() {
		return this.deducMinimoSiniestroRot;
	}

	public void setDeducMinimoSiniestroRot(BigDecimal deducMinimoSiniestroRot) {
		this.deducMinimoSiniestroRot = deducMinimoSiniestroRot;
	}

	public BigDecimal getDeducSiniestroRotMaq() {
		return this.deducSiniestroRotMaq;
	}

	public void setDeducSiniestroRotMaq(BigDecimal deducSiniestroRotMaq) {
		this.deducSiniestroRotMaq = deducSiniestroRotMaq;
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

	public BigDecimal getTasaRotMaq() {
		return this.tasaRotMaq;
	}

	public void setTasaRotMaq(BigDecimal tasaRotMaq) {
		this.tasaRotMaq = tasaRotMaq;
	}

	public List<ClausulasAddRotura> getClausulasAddRoturas() {
		return this.clausulasAddRoturas;
	}

	public void setClausulasAddRoturas(List<ClausulasAddRotura> clausulasAddRoturas) {
		this.clausulasAddRoturas = clausulasAddRoturas;
	}

	public ClausulasAddRotura addClausulasAddRotura(ClausulasAddRotura clausulasAddRotura) {
		getClausulasAddRoturas().add(clausulasAddRotura);
		clausulasAddRotura.setRamoRoturaMaquinaria(this);

		return clausulasAddRotura;
	}

	public ClausulasAddRotura removeClausulasAddRotura(ClausulasAddRotura clausulasAddRotura) {
		getClausulasAddRoturas().remove(clausulasAddRotura);
		clausulasAddRotura.setRamoRoturaMaquinaria(null);

		return clausulasAddRotura;
	}

	public List<CobertAddRotura> getCobertAddRoturas() {
		return this.cobertAddRoturas;
	}

	public void setCobertAddRoturas(List<CobertAddRotura> cobertAddRoturas) {
		this.cobertAddRoturas = cobertAddRoturas;
	}

	public CobertAddRotura addCobertAddRotura(CobertAddRotura cobertAddRotura) {
		getCobertAddRoturas().add(cobertAddRotura);
		cobertAddRotura.setRamoRoturaMaquinaria(this);

		return cobertAddRotura;
	}

	public CobertAddRotura removeCobertAddRotura(CobertAddRotura cobertAddRotura) {
		getCobertAddRoturas().remove(cobertAddRotura);
		cobertAddRotura.setRamoRoturaMaquinaria(null);

		return cobertAddRotura;
	}

	public List<CobertRotura> getCobertRoturas() {
		return this.cobertRoturas;
	}

	public void setCobertRoturas(List<CobertRotura> cobertRoturas) {
		this.cobertRoturas = cobertRoturas;
	}

	public CobertRotura addCobertRotura(CobertRotura cobertRotura) {
		getCobertRoturas().add(cobertRotura);
		cobertRotura.setRamoRoturaMaquinaria(this);

		return cobertRotura;
	}

	public CobertRotura removeCobertRotura(CobertRotura cobertRotura) {
		getCobertRoturas().remove(cobertRotura);
		cobertRotura.setRamoRoturaMaquinaria(null);

		return cobertRotura;
	}

	public List<ObjAsegRotura> getObjAsegRoturas() {
		return this.objAsegRoturas;
	}

	public void setObjAsegRoturas(List<ObjAsegRotura> objAsegRoturas) {
		this.objAsegRoturas = objAsegRoturas;
	}

	public ObjAsegRotura addObjAsegRotura(ObjAsegRotura objAsegRotura) {
		getObjAsegRoturas().add(objAsegRotura);
		objAsegRotura.setRamoRoturaMaquinaria(this);

		return objAsegRotura;
	}

	public ObjAsegRotura removeObjAsegRotura(ObjAsegRotura objAsegRotura) {
		getObjAsegRoturas().remove(objAsegRotura);
		objAsegRotura.setRamoRoturaMaquinaria(null);

		return objAsegRotura;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}