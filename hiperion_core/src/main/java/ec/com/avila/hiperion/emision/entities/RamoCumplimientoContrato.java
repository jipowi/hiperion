package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ramo_cumplimiento_contrato database table.
 * 
 */
@Entity
@Table(name="ramo_cumplimiento_contrato")
@NamedQuery(name="RamoCumplimientoContrato.findAll", query="SELECT r FROM RamoCumplimientoContrato r")
public class RamoCumplimientoContrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contrato")
	private Integer idContrato;

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

	@Column(name="objeto_aseg_contrato")
	private String objetoAsegContrato;

	@Column(name="tipo_contragarantia_contrato")
	private String tipoContragarantiaContrato;

	@Column(name="valor_asegurado_contrato")
	private BigDecimal valorAseguradoContrato;

	@Column(name="valor_contrato")
	private BigDecimal valorContrato;

	//bi-directional many-to-one association to CobertContrato
	@OneToMany(mappedBy="ramoCumplimientoContrato")
	private List<CobertContrato> cobertContratos;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	public RamoCumplimientoContrato() {
	}

	public Integer getIdContrato() {
		return this.idContrato;
	}

	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
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

	public String getObjetoAsegContrato() {
		return this.objetoAsegContrato;
	}

	public void setObjetoAsegContrato(String objetoAsegContrato) {
		this.objetoAsegContrato = objetoAsegContrato;
	}

	public String getTipoContragarantiaContrato() {
		return this.tipoContragarantiaContrato;
	}

	public void setTipoContragarantiaContrato(String tipoContragarantiaContrato) {
		this.tipoContragarantiaContrato = tipoContragarantiaContrato;
	}

	public BigDecimal getValorAseguradoContrato() {
		return this.valorAseguradoContrato;
	}

	public void setValorAseguradoContrato(BigDecimal valorAseguradoContrato) {
		this.valorAseguradoContrato = valorAseguradoContrato;
	}

	public BigDecimal getValorContrato() {
		return this.valorContrato;
	}

	public void setValorContrato(BigDecimal valorContrato) {
		this.valorContrato = valorContrato;
	}

	public List<CobertContrato> getCobertContratos() {
		return this.cobertContratos;
	}

	public void setCobertContratos(List<CobertContrato> cobertContratos) {
		this.cobertContratos = cobertContratos;
	}

	public CobertContrato addCobertContrato(CobertContrato cobertContrato) {
		getCobertContratos().add(cobertContrato);
		cobertContrato.setRamoCumplimientoContrato(this);

		return cobertContrato;
	}

	public CobertContrato removeCobertContrato(CobertContrato cobertContrato) {
		getCobertContratos().remove(cobertContrato);
		cobertContrato.setRamoCumplimientoContrato(null);

		return cobertContrato;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}