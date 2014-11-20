package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ramo_lc_incendio database table.
 * 
 */
@Entity
@Table(name="ramo_lc_incendio")
@NamedQuery(name="RamoLcIncendio.findAll", query="SELECT r FROM RamoLcIncendio r")
public class RamoLcIncendio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lucro")
	private Integer idLucro;

	@Column(name="deduc_catastrofico_lc")
	private BigDecimal deducCatastroficoLc;

	@Column(name="deduc_otros_lc")
	private BigDecimal deducOtrosLc;

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

	@Column(name="periodo_indemnizacion")
	private Integer periodoIndemnizacion;

	@Column(name="tasa_comprensiva_lc")
	private BigDecimal tasaComprensivaLc;

	@Column(name="valor_items_lc")
	private BigDecimal valorItemsLc;

	//bi-directional many-to-one association to ClausulasAddLcIn
	@OneToMany(mappedBy="ramoLcIncendio")
	private List<ClausulasAddLcIn> clausulasAddLcIns;

	//bi-directional many-to-one association to CobertLcIn
	@OneToMany(mappedBy="ramoLcIncendio")
	private List<CobertLcIn> cobertLcIns;

	//bi-directional many-to-one association to ObjAsegLcIn
	@OneToMany(mappedBy="ramoLcIncendio")
	private List<ObjAsegLcIn> objAsegLcIns;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	public RamoLcIncendio() {
	}

	public Integer getIdLucro() {
		return this.idLucro;
	}

	public void setIdLucro(Integer idLucro) {
		this.idLucro = idLucro;
	}

	public BigDecimal getDeducCatastroficoLc() {
		return this.deducCatastroficoLc;
	}

	public void setDeducCatastroficoLc(BigDecimal deducCatastroficoLc) {
		this.deducCatastroficoLc = deducCatastroficoLc;
	}

	public BigDecimal getDeducOtrosLc() {
		return this.deducOtrosLc;
	}

	public void setDeducOtrosLc(BigDecimal deducOtrosLc) {
		this.deducOtrosLc = deducOtrosLc;
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

	public Integer getPeriodoIndemnizacion() {
		return this.periodoIndemnizacion;
	}

	public void setPeriodoIndemnizacion(Integer periodoIndemnizacion) {
		this.periodoIndemnizacion = periodoIndemnizacion;
	}

	public BigDecimal getTasaComprensivaLc() {
		return this.tasaComprensivaLc;
	}

	public void setTasaComprensivaLc(BigDecimal tasaComprensivaLc) {
		this.tasaComprensivaLc = tasaComprensivaLc;
	}

	public BigDecimal getValorItemsLc() {
		return this.valorItemsLc;
	}

	public void setValorItemsLc(BigDecimal valorItemsLc) {
		this.valorItemsLc = valorItemsLc;
	}

	public List<ClausulasAddLcIn> getClausulasAddLcIns() {
		return this.clausulasAddLcIns;
	}

	public void setClausulasAddLcIns(List<ClausulasAddLcIn> clausulasAddLcIns) {
		this.clausulasAddLcIns = clausulasAddLcIns;
	}

	public ClausulasAddLcIn addClausulasAddLcIn(ClausulasAddLcIn clausulasAddLcIn) {
		getClausulasAddLcIns().add(clausulasAddLcIn);
		clausulasAddLcIn.setRamoLcIncendio(this);

		return clausulasAddLcIn;
	}

	public ClausulasAddLcIn removeClausulasAddLcIn(ClausulasAddLcIn clausulasAddLcIn) {
		getClausulasAddLcIns().remove(clausulasAddLcIn);
		clausulasAddLcIn.setRamoLcIncendio(null);

		return clausulasAddLcIn;
	}

	public List<CobertLcIn> getCobertLcIns() {
		return this.cobertLcIns;
	}

	public void setCobertLcIns(List<CobertLcIn> cobertLcIns) {
		this.cobertLcIns = cobertLcIns;
	}

	public CobertLcIn addCobertLcIn(CobertLcIn cobertLcIn) {
		getCobertLcIns().add(cobertLcIn);
		cobertLcIn.setRamoLcIncendio(this);

		return cobertLcIn;
	}

	public CobertLcIn removeCobertLcIn(CobertLcIn cobertLcIn) {
		getCobertLcIns().remove(cobertLcIn);
		cobertLcIn.setRamoLcIncendio(null);

		return cobertLcIn;
	}

	public List<ObjAsegLcIn> getObjAsegLcIns() {
		return this.objAsegLcIns;
	}

	public void setObjAsegLcIns(List<ObjAsegLcIn> objAsegLcIns) {
		this.objAsegLcIns = objAsegLcIns;
	}

	public ObjAsegLcIn addObjAsegLcIn(ObjAsegLcIn objAsegLcIn) {
		getObjAsegLcIns().add(objAsegLcIn);
		objAsegLcIn.setRamoLcIncendio(this);

		return objAsegLcIn;
	}

	public ObjAsegLcIn removeObjAsegLcIn(ObjAsegLcIn objAsegLcIn) {
		getObjAsegLcIns().remove(objAsegLcIn);
		objAsegLcIn.setRamoLcIncendio(null);

		return objAsegLcIn;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}