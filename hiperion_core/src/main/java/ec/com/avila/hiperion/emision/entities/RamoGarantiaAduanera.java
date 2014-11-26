package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ramo_garantia_aduanera database table.
 * 
 */
@Entity
@Table(name="ramo_garantia_aduanera")
@NamedQuery(name="RamoGarantiaAduanera.findAll", query="SELECT r FROM RamoGarantiaAduanera r")
public class RamoGarantiaAduanera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aduanera")
	private Integer idAduanera;

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

	@Column(name="obj_asg_aduanera")
	private String objAsgAduanera;

	@Column(name="sector_aduanera")
	private String sectorAduanera;

	@Column(name="tipo_contragarantia_aduanera")
	private String tipoContragarantiaAduanera;

	@Column(name="valor_contrato_aduanera")
	private BigDecimal valorContratoAduanera;

	@Column(name="valor_poliza_aduanera")
	private BigDecimal valorPolizaAduanera;

	//bi-directional many-to-one association to CobertAduanera
	@OneToMany(mappedBy="ramoGarantiaAduanera")
	private List<CobertAduanera> cobertAduaneras;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	public RamoGarantiaAduanera() {
	}

	public Integer getIdAduanera() {
		return this.idAduanera;
	}

	public void setIdAduanera(Integer idAduanera) {
		this.idAduanera = idAduanera;
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

	public String getObjAsgAduanera() {
		return this.objAsgAduanera;
	}

	public void setObjAsgAduanera(String objAsgAduanera) {
		this.objAsgAduanera = objAsgAduanera;
	}

	public String getSectorAduanera() {
		return this.sectorAduanera;
	}

	public void setSectorAduanera(String sectorAduanera) {
		this.sectorAduanera = sectorAduanera;
	}

	public String getTipoContragarantiaAduanera() {
		return this.tipoContragarantiaAduanera;
	}

	public void setTipoContragarantiaAduanera(String tipoContragarantiaAduanera) {
		this.tipoContragarantiaAduanera = tipoContragarantiaAduanera;
	}

	public BigDecimal getValorContratoAduanera() {
		return this.valorContratoAduanera;
	}

	public void setValorContratoAduanera(BigDecimal valorContratoAduanera) {
		this.valorContratoAduanera = valorContratoAduanera;
	}

	public BigDecimal getValorPolizaAduanera() {
		return this.valorPolizaAduanera;
	}

	public void setValorPolizaAduanera(BigDecimal valorPolizaAduanera) {
		this.valorPolizaAduanera = valorPolizaAduanera;
	}

	public List<CobertAduanera> getCobertAduaneras() {
		return this.cobertAduaneras;
	}

	public void setCobertAduaneras(List<CobertAduanera> cobertAduaneras) {
		this.cobertAduaneras = cobertAduaneras;
	}

	public CobertAduanera addCobertAduanera(CobertAduanera cobertAduanera) {
		getCobertAduaneras().add(cobertAduanera);
		cobertAduanera.setRamoGarantiaAduanera(this);

		return cobertAduanera;
	}

	public CobertAduanera removeCobertAduanera(CobertAduanera cobertAduanera) {
		getCobertAduaneras().remove(cobertAduanera);
		cobertAduanera.setRamoGarantiaAduanera(null);

		return cobertAduanera;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}