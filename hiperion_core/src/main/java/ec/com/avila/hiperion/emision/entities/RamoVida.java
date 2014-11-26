package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ramo_vida database table.
 * 
 */
@Entity
@Table(name="ramo_vida")
@NamedQuery(name="RamoVida.findAll", query="SELECT r FROM RamoVida r")
public class RamoVida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vida")
	private Integer idVida;

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

	@Column(name="prima_neta_persona_vida")
	private BigDecimal primaNetaPersonaVida;

	@Column(name="prima_total_persona_vida")
	private BigDecimal primaTotalPersonaVida;

	@Column(name="tasa_incapicidad")
	private BigDecimal tasaIncapicidad;

	@Column(name="tasa_muerte")
	private BigDecimal tasaMuerte;

	@Column(name="tasa_vida")
	private BigDecimal tasaVida;

	@Column(name="total_asegurados")
	private Integer totalAsegurados;

	//bi-directional many-to-one association to GrupoVida
	@OneToMany(mappedBy="ramoVida")
	private List<GrupoVida> grupoVidas;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	public RamoVida() {
	}

	public Integer getIdVida() {
		return this.idVida;
	}

	public void setIdVida(Integer idVida) {
		this.idVida = idVida;
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

	public BigDecimal getPrimaNetaPersonaVida() {
		return this.primaNetaPersonaVida;
	}

	public void setPrimaNetaPersonaVida(BigDecimal primaNetaPersonaVida) {
		this.primaNetaPersonaVida = primaNetaPersonaVida;
	}

	public BigDecimal getPrimaTotalPersonaVida() {
		return this.primaTotalPersonaVida;
	}

	public void setPrimaTotalPersonaVida(BigDecimal primaTotalPersonaVida) {
		this.primaTotalPersonaVida = primaTotalPersonaVida;
	}

	public BigDecimal getTasaIncapicidad() {
		return this.tasaIncapicidad;
	}

	public void setTasaIncapicidad(BigDecimal tasaIncapicidad) {
		this.tasaIncapicidad = tasaIncapicidad;
	}

	public BigDecimal getTasaMuerte() {
		return this.tasaMuerte;
	}

	public void setTasaMuerte(BigDecimal tasaMuerte) {
		this.tasaMuerte = tasaMuerte;
	}

	public BigDecimal getTasaVida() {
		return this.tasaVida;
	}

	public void setTasaVida(BigDecimal tasaVida) {
		this.tasaVida = tasaVida;
	}

	public Integer getTotalAsegurados() {
		return this.totalAsegurados;
	}

	public void setTotalAsegurados(Integer totalAsegurados) {
		this.totalAsegurados = totalAsegurados;
	}

	public List<GrupoVida> getGrupoVidas() {
		return this.grupoVidas;
	}

	public void setGrupoVidas(List<GrupoVida> grupoVidas) {
		this.grupoVidas = grupoVidas;
	}

	public GrupoVida addGrupoVida(GrupoVida grupoVida) {
		getGrupoVidas().add(grupoVida);
		grupoVida.setRamoVida(this);

		return grupoVida;
	}

	public GrupoVida removeGrupoVida(GrupoVida grupoVida) {
		getGrupoVidas().remove(grupoVida);
		grupoVida.setRamoVida(null);

		return grupoVida;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}