package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ramo_equipo_maquinaria database table.
 * 
 */
@Entity
@Table(name="ramo_equipo_maquinaria")
@NamedQuery(name="RamoEquipoMaquinaria.findAll", query="SELECT r FROM RamoEquipoMaquinaria r")
public class RamoEquipoMaquinaria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_equipo_maquinaria")
	private Integer idEquipoMaquinaria;

	@Column(name="deduc_min_aseg_maq")
	private BigDecimal deducMinAsegMaq;

	@Column(name="deduc_minimo_siniestro_maq")
	private BigDecimal deducMinimoSiniestroMaq;

	@Column(name="deduc_porc_siniestro_maq")
	private BigDecimal deducPorcSiniestroMaq;

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

	@Column(name="tasa_equipo_maq")
	private BigDecimal tasaEquipoMaq;

	//bi-directional many-to-one association to ClausulasAddEqMaq
	@OneToMany(mappedBy="ramoEquipoMaquinaria")
	private List<ClausulasAddEqMaq> clausulasAddEqMaqs;

	//bi-directional many-to-one association to CobertAddEqMaq
	@OneToMany(mappedBy="ramoEquipoMaquinaria")
	private List<CobertAddEqMaq> cobertAddEqMaqs;

	//bi-directional many-to-one association to CobertEqMaq
	@OneToMany(mappedBy="ramoEquipoMaquinaria")
	private List<CobertEqMaq> cobertEqMaqs;

	//bi-directional many-to-one association to ObjAsegEquipoMaq
	@OneToMany(mappedBy="ramoEquipoMaquinaria")
	private List<ObjAsegEquipoMaq> objAsegEquipoMaqs;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	public RamoEquipoMaquinaria() {
	}

	public Integer getIdEquipoMaquinaria() {
		return this.idEquipoMaquinaria;
	}

	public void setIdEquipoMaquinaria(Integer idEquipoMaquinaria) {
		this.idEquipoMaquinaria = idEquipoMaquinaria;
	}

	public BigDecimal getDeducMinAsegMaq() {
		return this.deducMinAsegMaq;
	}

	public void setDeducMinAsegMaq(BigDecimal deducMinAsegMaq) {
		this.deducMinAsegMaq = deducMinAsegMaq;
	}

	public BigDecimal getDeducMinimoSiniestroMaq() {
		return this.deducMinimoSiniestroMaq;
	}

	public void setDeducMinimoSiniestroMaq(BigDecimal deducMinimoSiniestroMaq) {
		this.deducMinimoSiniestroMaq = deducMinimoSiniestroMaq;
	}

	public BigDecimal getDeducPorcSiniestroMaq() {
		return this.deducPorcSiniestroMaq;
	}

	public void setDeducPorcSiniestroMaq(BigDecimal deducPorcSiniestroMaq) {
		this.deducPorcSiniestroMaq = deducPorcSiniestroMaq;
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

	public BigDecimal getTasaEquipoMaq() {
		return this.tasaEquipoMaq;
	}

	public void setTasaEquipoMaq(BigDecimal tasaEquipoMaq) {
		this.tasaEquipoMaq = tasaEquipoMaq;
	}

	public List<ClausulasAddEqMaq> getClausulasAddEqMaqs() {
		return this.clausulasAddEqMaqs;
	}

	public void setClausulasAddEqMaqs(List<ClausulasAddEqMaq> clausulasAddEqMaqs) {
		this.clausulasAddEqMaqs = clausulasAddEqMaqs;
	}

	public ClausulasAddEqMaq addClausulasAddEqMaq(ClausulasAddEqMaq clausulasAddEqMaq) {
		getClausulasAddEqMaqs().add(clausulasAddEqMaq);
		clausulasAddEqMaq.setRamoEquipoMaquinaria(this);

		return clausulasAddEqMaq;
	}

	public ClausulasAddEqMaq removeClausulasAddEqMaq(ClausulasAddEqMaq clausulasAddEqMaq) {
		getClausulasAddEqMaqs().remove(clausulasAddEqMaq);
		clausulasAddEqMaq.setRamoEquipoMaquinaria(null);

		return clausulasAddEqMaq;
	}

	public List<CobertAddEqMaq> getCobertAddEqMaqs() {
		return this.cobertAddEqMaqs;
	}

	public void setCobertAddEqMaqs(List<CobertAddEqMaq> cobertAddEqMaqs) {
		this.cobertAddEqMaqs = cobertAddEqMaqs;
	}

	public CobertAddEqMaq addCobertAddEqMaq(CobertAddEqMaq cobertAddEqMaq) {
		getCobertAddEqMaqs().add(cobertAddEqMaq);
		cobertAddEqMaq.setRamoEquipoMaquinaria(this);

		return cobertAddEqMaq;
	}

	public CobertAddEqMaq removeCobertAddEqMaq(CobertAddEqMaq cobertAddEqMaq) {
		getCobertAddEqMaqs().remove(cobertAddEqMaq);
		cobertAddEqMaq.setRamoEquipoMaquinaria(null);

		return cobertAddEqMaq;
	}

	public List<CobertEqMaq> getCobertEqMaqs() {
		return this.cobertEqMaqs;
	}

	public void setCobertEqMaqs(List<CobertEqMaq> cobertEqMaqs) {
		this.cobertEqMaqs = cobertEqMaqs;
	}

	public CobertEqMaq addCobertEqMaq(CobertEqMaq cobertEqMaq) {
		getCobertEqMaqs().add(cobertEqMaq);
		cobertEqMaq.setRamoEquipoMaquinaria(this);

		return cobertEqMaq;
	}

	public CobertEqMaq removeCobertEqMaq(CobertEqMaq cobertEqMaq) {
		getCobertEqMaqs().remove(cobertEqMaq);
		cobertEqMaq.setRamoEquipoMaquinaria(null);

		return cobertEqMaq;
	}

	public List<ObjAsegEquipoMaq> getObjAsegEquipoMaqs() {
		return this.objAsegEquipoMaqs;
	}

	public void setObjAsegEquipoMaqs(List<ObjAsegEquipoMaq> objAsegEquipoMaqs) {
		this.objAsegEquipoMaqs = objAsegEquipoMaqs;
	}

	public ObjAsegEquipoMaq addObjAsegEquipoMaq(ObjAsegEquipoMaq objAsegEquipoMaq) {
		getObjAsegEquipoMaqs().add(objAsegEquipoMaq);
		objAsegEquipoMaq.setRamoEquipoMaquinaria(this);

		return objAsegEquipoMaq;
	}

	public ObjAsegEquipoMaq removeObjAsegEquipoMaq(ObjAsegEquipoMaq objAsegEquipoMaq) {
		getObjAsegEquipoMaqs().remove(objAsegEquipoMaq);
		objAsegEquipoMaq.setRamoEquipoMaquinaria(null);

		return objAsegEquipoMaq;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}