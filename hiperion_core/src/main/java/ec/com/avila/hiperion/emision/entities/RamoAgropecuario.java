package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ramo_agropecuario database table.
 * 
 */
@Entity
@Table(name="ramo_agropecuario")
@NamedQuery(name="RamoAgropecuario.findAll", query="SELECT r FROM RamoAgropecuario r")
public class RamoAgropecuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_agropecuario")
	private Integer idAgropecuario;

	@Column(name="deduc_agro")
	private BigDecimal deducAgro;

	@Column(name="detalle_agro")
	private String detalleAgro;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Column(name="ganadero_plantacion")
	private Integer ganaderoPlantacion;

	@Column(name="id_usuario_actualizacion")
	private Integer idUsuarioActualizacion;

	@Column(name="id_usuario_creacion")
	private Integer idUsuarioCreacion;

	@Column(name="tasa_agro")
	private BigDecimal tasaAgro;

	@Column(name="ubicacion_agro")
	private String ubicacionAgro;

	@Column(name="valor_asegurado_agro")
	private BigDecimal valorAseguradoAgro;

	//bi-directional many-to-one association to ArchivoBase
	@OneToMany(mappedBy="ramoAgropecuario")
	private List<ArchivoBase> archivoBases;

	//bi-directional many-to-one association to ClausulasAddAgro
	@OneToMany(mappedBy="ramoAgropecuario")
	private List<ClausulasAddAgro> clausulasAddAgros;

	//bi-directional many-to-one association to CobertAgro
	@OneToMany(mappedBy="ramoAgropecuario")
	private List<CobertAgro> cobertAgros;

	//bi-directional many-to-one association to ObjAsegAgropecuario
	@OneToMany(mappedBy="ramoAgropecuario")
	private List<ObjAsegAgropecuario> objAsegAgropecuarios;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	public RamoAgropecuario() {
	}

	public Integer getIdAgropecuario() {
		return this.idAgropecuario;
	}

	public void setIdAgropecuario(Integer idAgropecuario) {
		this.idAgropecuario = idAgropecuario;
	}

	public BigDecimal getDeducAgro() {
		return this.deducAgro;
	}

	public void setDeducAgro(BigDecimal deducAgro) {
		this.deducAgro = deducAgro;
	}

	public String getDetalleAgro() {
		return this.detalleAgro;
	}

	public void setDetalleAgro(String detalleAgro) {
		this.detalleAgro = detalleAgro;
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

	public Integer getGanaderoPlantacion() {
		return this.ganaderoPlantacion;
	}

	public void setGanaderoPlantacion(Integer ganaderoPlantacion) {
		this.ganaderoPlantacion = ganaderoPlantacion;
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

	public BigDecimal getTasaAgro() {
		return this.tasaAgro;
	}

	public void setTasaAgro(BigDecimal tasaAgro) {
		this.tasaAgro = tasaAgro;
	}

	public String getUbicacionAgro() {
		return this.ubicacionAgro;
	}

	public void setUbicacionAgro(String ubicacionAgro) {
		this.ubicacionAgro = ubicacionAgro;
	}

	public BigDecimal getValorAseguradoAgro() {
		return this.valorAseguradoAgro;
	}

	public void setValorAseguradoAgro(BigDecimal valorAseguradoAgro) {
		this.valorAseguradoAgro = valorAseguradoAgro;
	}

	public List<ArchivoBase> getArchivoBases() {
		return this.archivoBases;
	}

	public void setArchivoBases(List<ArchivoBase> archivoBases) {
		this.archivoBases = archivoBases;
	}

	public ArchivoBase addArchivoBas(ArchivoBase archivoBas) {
		getArchivoBases().add(archivoBas);
		archivoBas.setRamoAgropecuario(this);

		return archivoBas;
	}

	public ArchivoBase removeArchivoBas(ArchivoBase archivoBas) {
		getArchivoBases().remove(archivoBas);
		archivoBas.setRamoAgropecuario(null);

		return archivoBas;
	}

	public List<ClausulasAddAgro> getClausulasAddAgros() {
		return this.clausulasAddAgros;
	}

	public void setClausulasAddAgros(List<ClausulasAddAgro> clausulasAddAgros) {
		this.clausulasAddAgros = clausulasAddAgros;
	}

	public ClausulasAddAgro addClausulasAddAgro(ClausulasAddAgro clausulasAddAgro) {
		getClausulasAddAgros().add(clausulasAddAgro);
		clausulasAddAgro.setRamoAgropecuario(this);

		return clausulasAddAgro;
	}

	public ClausulasAddAgro removeClausulasAddAgro(ClausulasAddAgro clausulasAddAgro) {
		getClausulasAddAgros().remove(clausulasAddAgro);
		clausulasAddAgro.setRamoAgropecuario(null);

		return clausulasAddAgro;
	}

	public List<CobertAgro> getCobertAgros() {
		return this.cobertAgros;
	}

	public void setCobertAgros(List<CobertAgro> cobertAgros) {
		this.cobertAgros = cobertAgros;
	}

	public CobertAgro addCobertAgro(CobertAgro cobertAgro) {
		getCobertAgros().add(cobertAgro);
		cobertAgro.setRamoAgropecuario(this);

		return cobertAgro;
	}

	public CobertAgro removeCobertAgro(CobertAgro cobertAgro) {
		getCobertAgros().remove(cobertAgro);
		cobertAgro.setRamoAgropecuario(null);

		return cobertAgro;
	}

	public List<ObjAsegAgropecuario> getObjAsegAgropecuarios() {
		return this.objAsegAgropecuarios;
	}

	public void setObjAsegAgropecuarios(List<ObjAsegAgropecuario> objAsegAgropecuarios) {
		this.objAsegAgropecuarios = objAsegAgropecuarios;
	}

	public ObjAsegAgropecuario addObjAsegAgropecuario(ObjAsegAgropecuario objAsegAgropecuario) {
		getObjAsegAgropecuarios().add(objAsegAgropecuario);
		objAsegAgropecuario.setRamoAgropecuario(this);

		return objAsegAgropecuario;
	}

	public ObjAsegAgropecuario removeObjAsegAgropecuario(ObjAsegAgropecuario objAsegAgropecuario) {
		getObjAsegAgropecuarios().remove(objAsegAgropecuario);
		objAsegAgropecuario.setRamoAgropecuario(null);

		return objAsegAgropecuario;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}