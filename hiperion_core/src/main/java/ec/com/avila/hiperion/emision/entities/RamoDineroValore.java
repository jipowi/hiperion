package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ramo_dinero_valores database table.
 * 
 */
@Entity
@Table(name="ramo_dinero_valores")
@NamedQuery(name="RamoDineroValore.findAll", query="SELECT r FROM RamoDineroValore r")
public class RamoDineroValore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dinero")
	private Integer idDinero;

	@Column(name="deduc_minimo_dinero")
	private BigDecimal deducMinimoDinero;

	@Column(name="deduc_por_siniestro_dinero")
	private BigDecimal deducPorSiniestroDinero;

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

	@Column(name="porcentaje_embarque_dinero")
	private BigDecimal porcentajeEmbarqueDinero;

	@Column(name="tasa_dinero")
	private BigDecimal tasaDinero;

	//bi-directional many-to-one association to ClausulasAddDinero
	@OneToMany(mappedBy="ramoDineroValore")
	private List<ClausulasAddDinero> clausulasAddDineros;

	//bi-directional many-to-one association to CobertDineroVal
	@OneToMany(mappedBy="ramoDineroValore")
	private List<CobertDineroVal> cobertDineroVals;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	//bi-directional many-to-one association to ObjAsegDineroVal
	@OneToMany(mappedBy="ramoDineroValore")
	private List<ObjAsegDineroVal> objAsegDineroVals;

	public RamoDineroValore() {
	}

	public Integer getIdDinero() {
		return this.idDinero;
	}

	public void setIdDinero(Integer idDinero) {
		this.idDinero = idDinero;
	}

	public BigDecimal getDeducMinimoDinero() {
		return this.deducMinimoDinero;
	}

	public void setDeducMinimoDinero(BigDecimal deducMinimoDinero) {
		this.deducMinimoDinero = deducMinimoDinero;
	}

	public BigDecimal getDeducPorSiniestroDinero() {
		return this.deducPorSiniestroDinero;
	}

	public void setDeducPorSiniestroDinero(BigDecimal deducPorSiniestroDinero) {
		this.deducPorSiniestroDinero = deducPorSiniestroDinero;
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

	public BigDecimal getPorcentajeEmbarqueDinero() {
		return this.porcentajeEmbarqueDinero;
	}

	public void setPorcentajeEmbarqueDinero(BigDecimal porcentajeEmbarqueDinero) {
		this.porcentajeEmbarqueDinero = porcentajeEmbarqueDinero;
	}

	public BigDecimal getTasaDinero() {
		return this.tasaDinero;
	}

	public void setTasaDinero(BigDecimal tasaDinero) {
		this.tasaDinero = tasaDinero;
	}

	public List<ClausulasAddDinero> getClausulasAddDineros() {
		return this.clausulasAddDineros;
	}

	public void setClausulasAddDineros(List<ClausulasAddDinero> clausulasAddDineros) {
		this.clausulasAddDineros = clausulasAddDineros;
	}

	public ClausulasAddDinero addClausulasAddDinero(ClausulasAddDinero clausulasAddDinero) {
		getClausulasAddDineros().add(clausulasAddDinero);
		clausulasAddDinero.setRamoDineroValore(this);

		return clausulasAddDinero;
	}

	public ClausulasAddDinero removeClausulasAddDinero(ClausulasAddDinero clausulasAddDinero) {
		getClausulasAddDineros().remove(clausulasAddDinero);
		clausulasAddDinero.setRamoDineroValore(null);

		return clausulasAddDinero;
	}

	public List<CobertDineroVal> getCobertDineroVals() {
		return this.cobertDineroVals;
	}

	public void setCobertDineroVals(List<CobertDineroVal> cobertDineroVals) {
		this.cobertDineroVals = cobertDineroVals;
	}

	public CobertDineroVal addCobertDineroVal(CobertDineroVal cobertDineroVal) {
		getCobertDineroVals().add(cobertDineroVal);
		cobertDineroVal.setRamoDineroValore(this);

		return cobertDineroVal;
	}

	public CobertDineroVal removeCobertDineroVal(CobertDineroVal cobertDineroVal) {
		getCobertDineroVals().remove(cobertDineroVal);
		cobertDineroVal.setRamoDineroValore(null);

		return cobertDineroVal;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

	public List<ObjAsegDineroVal> getObjAsegDineroVals() {
		return this.objAsegDineroVals;
	}

	public void setObjAsegDineroVals(List<ObjAsegDineroVal> objAsegDineroVals) {
		this.objAsegDineroVals = objAsegDineroVals;
	}

	public ObjAsegDineroVal addObjAsegDineroVal(ObjAsegDineroVal objAsegDineroVal) {
		getObjAsegDineroVals().add(objAsegDineroVal);
		objAsegDineroVal.setRamoDineroValore(this);

		return objAsegDineroVal;
	}

	public ObjAsegDineroVal removeObjAsegDineroVal(ObjAsegDineroVal objAsegDineroVal) {
		getObjAsegDineroVals().remove(objAsegDineroVal);
		objAsegDineroVal.setRamoDineroValore(null);

		return objAsegDineroVal;
	}

}