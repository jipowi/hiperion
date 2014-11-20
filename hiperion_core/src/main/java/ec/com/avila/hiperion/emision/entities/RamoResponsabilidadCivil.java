package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ramo_responsabilidad_civil database table.
 * 
 */
@Entity
@Table(name="ramo_responsabilidad_civil")
@NamedQuery(name="RamoResponsabilidadCivil.findAll", query="SELECT r FROM RamoResponsabilidadCivil r")
public class RamoResponsabilidadCivil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_responsabilidad")
	private Integer idResponsabilidad;

	@Column(name="deduc_minimo_resp")
	private BigDecimal deducMinimoResp;

	@Column(name="deduc_siniestro_resp")
	private BigDecimal deducSiniestroResp;

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

	@Column(name="limite_unico_anual_resp")
	private Integer limiteUnicoAnualResp;

	@Column(name="tasa_resp")
	private BigDecimal tasaResp;

	@Column(name="tipo_contragarantia_resp")
	private String tipoContragarantiaResp;

	//bi-directional many-to-one association to ClausulasAddResp
	@OneToMany(mappedBy="ramoResponsabilidadCivil")
	private List<ClausulasAddResp> clausulasAddResps;

	//bi-directional many-to-one association to ObjAsegResponsabilidad
	@OneToMany(mappedBy="ramoResponsabilidadCivil")
	private List<ObjAsegResponsabilidad> objAsegResponsabilidads;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	//bi-directional many-to-one association to CobertResp
	@OneToMany(mappedBy="ramoResponsabilidadCivil")
	private List<CobertResp> cobertResps;

	public RamoResponsabilidadCivil() {
	}

	public Integer getIdResponsabilidad() {
		return this.idResponsabilidad;
	}

	public void setIdResponsabilidad(Integer idResponsabilidad) {
		this.idResponsabilidad = idResponsabilidad;
	}

	public BigDecimal getDeducMinimoResp() {
		return this.deducMinimoResp;
	}

	public void setDeducMinimoResp(BigDecimal deducMinimoResp) {
		this.deducMinimoResp = deducMinimoResp;
	}

	public BigDecimal getDeducSiniestroResp() {
		return this.deducSiniestroResp;
	}

	public void setDeducSiniestroResp(BigDecimal deducSiniestroResp) {
		this.deducSiniestroResp = deducSiniestroResp;
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

	public Integer getLimiteUnicoAnualResp() {
		return this.limiteUnicoAnualResp;
	}

	public void setLimiteUnicoAnualResp(Integer limiteUnicoAnualResp) {
		this.limiteUnicoAnualResp = limiteUnicoAnualResp;
	}

	public BigDecimal getTasaResp() {
		return this.tasaResp;
	}

	public void setTasaResp(BigDecimal tasaResp) {
		this.tasaResp = tasaResp;
	}

	public String getTipoContragarantiaResp() {
		return this.tipoContragarantiaResp;
	}

	public void setTipoContragarantiaResp(String tipoContragarantiaResp) {
		this.tipoContragarantiaResp = tipoContragarantiaResp;
	}

	public List<ClausulasAddResp> getClausulasAddResps() {
		return this.clausulasAddResps;
	}

	public void setClausulasAddResps(List<ClausulasAddResp> clausulasAddResps) {
		this.clausulasAddResps = clausulasAddResps;
	}

	public ClausulasAddResp addClausulasAddResp(ClausulasAddResp clausulasAddResp) {
		getClausulasAddResps().add(clausulasAddResp);
		clausulasAddResp.setRamoResponsabilidadCivil(this);

		return clausulasAddResp;
	}

	public ClausulasAddResp removeClausulasAddResp(ClausulasAddResp clausulasAddResp) {
		getClausulasAddResps().remove(clausulasAddResp);
		clausulasAddResp.setRamoResponsabilidadCivil(null);

		return clausulasAddResp;
	}

	public List<ObjAsegResponsabilidad> getObjAsegResponsabilidads() {
		return this.objAsegResponsabilidads;
	}

	public void setObjAsegResponsabilidads(List<ObjAsegResponsabilidad> objAsegResponsabilidads) {
		this.objAsegResponsabilidads = objAsegResponsabilidads;
	}

	public ObjAsegResponsabilidad addObjAsegResponsabilidad(ObjAsegResponsabilidad objAsegResponsabilidad) {
		getObjAsegResponsabilidads().add(objAsegResponsabilidad);
		objAsegResponsabilidad.setRamoResponsabilidadCivil(this);

		return objAsegResponsabilidad;
	}

	public ObjAsegResponsabilidad removeObjAsegResponsabilidad(ObjAsegResponsabilidad objAsegResponsabilidad) {
		getObjAsegResponsabilidads().remove(objAsegResponsabilidad);
		objAsegResponsabilidad.setRamoResponsabilidadCivil(null);

		return objAsegResponsabilidad;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

	public List<CobertResp> getCobertResps() {
		return this.cobertResps;
	}

	public void setCobertResps(List<CobertResp> cobertResps) {
		this.cobertResps = cobertResps;
	}

	public CobertResp addCobertResp(CobertResp cobertResp) {
		getCobertResps().add(cobertResp);
		cobertResp.setRamoResponsabilidadCivil(this);

		return cobertResp;
	}

	public CobertResp removeCobertResp(CobertResp cobertResp) {
		getCobertResps().remove(cobertResp);
		cobertResp.setRamoResponsabilidadCivil(null);

		return cobertResp;
	}

}