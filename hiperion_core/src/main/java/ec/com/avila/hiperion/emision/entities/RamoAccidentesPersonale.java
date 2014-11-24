package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the ramo_accidentes_personales database table.
 * 
 */
@Entity
@Table(name = "ramo_accidentes_personales")
@NamedQuery(name = "RamoAccidentesPersonale.findAll", query = "SELECT r FROM RamoAccidentesPersonale r")
public class RamoAccidentesPersonale extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_accidentes")
	private Integer idAccidentes;

	private Integer facturacion;

	@Column(name = "prima_neta_persona")
	private BigDecimal primaNetaPersona;

	@Column(name = "prima_total_persona")
	private BigDecimal primaTotalPersona;

	@Column(name = "tasa_accidente")
	private BigDecimal tasaAccidente;

	// bi-directional many-to-one association to ClausulasAddAccPer
	@OneToMany(mappedBy = "ramoAccidentesPersonale")
	private List<ClausulasAddAccPer> clausulasAddAccPers;

	// bi-directional many-to-one association to Poliza
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;

	// bi-directional many-to-one association to GrupoAccPersonale
	@OneToMany(mappedBy = "ramoAccidentesPersonale")
	private List<GrupoAccPersonale> grupoAccPersonales;

	public RamoAccidentesPersonale() {
	}

	public Integer getIdAccidentes() {
		return this.idAccidentes;
	}

	public void setIdAccidentes(Integer idAccidentes) {
		this.idAccidentes = idAccidentes;
	}

	public Integer getFacturacion() {
		return this.facturacion;
	}

	public void setFacturacion(Integer facturacion) {
		this.facturacion = facturacion;
	}

	public BigDecimal getPrimaNetaPersona() {
		return this.primaNetaPersona;
	}

	public void setPrimaNetaPersona(BigDecimal primaNetaPersona) {
		this.primaNetaPersona = primaNetaPersona;
	}

	public BigDecimal getPrimaTotalPersona() {
		return this.primaTotalPersona;
	}

	public void setPrimaTotalPersona(BigDecimal primaTotalPersona) {
		this.primaTotalPersona = primaTotalPersona;
	}

	public BigDecimal getTasaAccidente() {
		return this.tasaAccidente;
	}

	public void setTasaAccidente(BigDecimal tasaAccidente) {
		this.tasaAccidente = tasaAccidente;
	}

	public List<ClausulasAddAccPer> getClausulasAddAccPers() {
		return this.clausulasAddAccPers;
	}

	public void setClausulasAddAccPers(List<ClausulasAddAccPer> clausulasAddAccPers) {
		this.clausulasAddAccPers = clausulasAddAccPers;
	}

	public ClausulasAddAccPer addClausulasAddAccPer(ClausulasAddAccPer clausulasAddAccPer) {
		getClausulasAddAccPers().add(clausulasAddAccPer);
		clausulasAddAccPer.setRamoAccidentesPersonale(this);

		return clausulasAddAccPer;
	}

	public ClausulasAddAccPer removeClausulasAddAccPer(ClausulasAddAccPer clausulasAddAccPer) {
		getClausulasAddAccPers().remove(clausulasAddAccPer);
		clausulasAddAccPer.setRamoAccidentesPersonale(null);

		return clausulasAddAccPer;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

	public List<GrupoAccPersonale> getGrupoAccPersonales() {
		return this.grupoAccPersonales;
	}

	public void setGrupoAccPersonales(List<GrupoAccPersonale> grupoAccPersonales) {
		this.grupoAccPersonales = grupoAccPersonales;
	}

	public GrupoAccPersonale addGrupoAccPersonale(GrupoAccPersonale grupoAccPersonale) {
		getGrupoAccPersonales().add(grupoAccPersonale);
		grupoAccPersonale.setRamoAccidentesPersonale(this);

		return grupoAccPersonale;
	}

	public GrupoAccPersonale removeGrupoAccPersonale(GrupoAccPersonale grupoAccPersonale) {
		getGrupoAccPersonales().remove(grupoAccPersonale);
		grupoAccPersonale.setRamoAccidentesPersonale(null);

		return grupoAccPersonale;
	}

}