package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ramo_asistencia_medica database table.
 * 
 */
@Entity
@Table(name="ramo_asistencia_medica")
@NamedQuery(name="RamoAsistenciaMedica.findAll", query="SELECT r FROM RamoAsistenciaMedica r")
public class RamoAsistenciaMedica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ast_medica")
	private Integer idAstMedica;

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

	@Column(name="total_mensual_grupo_asm")
	private BigDecimal totalMensualGrupoAsm;

	//bi-directional many-to-one association to CondPartAsm
	@OneToMany(mappedBy="ramoAsistenciaMedica")
	private List<CondPartAsm> condPartAsms;

	//bi-directional many-to-one association to GrupoAsm
	@OneToMany(mappedBy="ramoAsistenciaMedica")
	private List<GrupoAsm> grupoAsms;

	//bi-directional many-to-one association to LimitesCostosAsm
	@OneToMany(mappedBy="ramoAsistenciaMedica")
	private List<LimitesCostosAsm> limitesCostosAsms;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	public RamoAsistenciaMedica() {
	}

	public Integer getIdAstMedica() {
		return this.idAstMedica;
	}

	public void setIdAstMedica(Integer idAstMedica) {
		this.idAstMedica = idAstMedica;
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

	public BigDecimal getTotalMensualGrupoAsm() {
		return this.totalMensualGrupoAsm;
	}

	public void setTotalMensualGrupoAsm(BigDecimal totalMensualGrupoAsm) {
		this.totalMensualGrupoAsm = totalMensualGrupoAsm;
	}

	public List<CondPartAsm> getCondPartAsms() {
		return this.condPartAsms;
	}

	public void setCondPartAsms(List<CondPartAsm> condPartAsms) {
		this.condPartAsms = condPartAsms;
	}

	public CondPartAsm addCondPartAsm(CondPartAsm condPartAsm) {
		getCondPartAsms().add(condPartAsm);
		condPartAsm.setRamoAsistenciaMedica(this);

		return condPartAsm;
	}

	public CondPartAsm removeCondPartAsm(CondPartAsm condPartAsm) {
		getCondPartAsms().remove(condPartAsm);
		condPartAsm.setRamoAsistenciaMedica(null);

		return condPartAsm;
	}

	public List<GrupoAsm> getGrupoAsms() {
		return this.grupoAsms;
	}

	public void setGrupoAsms(List<GrupoAsm> grupoAsms) {
		this.grupoAsms = grupoAsms;
	}

	public GrupoAsm addGrupoAsm(GrupoAsm grupoAsm) {
		getGrupoAsms().add(grupoAsm);
		grupoAsm.setRamoAsistenciaMedica(this);

		return grupoAsm;
	}

	public GrupoAsm removeGrupoAsm(GrupoAsm grupoAsm) {
		getGrupoAsms().remove(grupoAsm);
		grupoAsm.setRamoAsistenciaMedica(null);

		return grupoAsm;
	}

	public List<LimitesCostosAsm> getLimitesCostosAsms() {
		return this.limitesCostosAsms;
	}

	public void setLimitesCostosAsms(List<LimitesCostosAsm> limitesCostosAsms) {
		this.limitesCostosAsms = limitesCostosAsms;
	}

	public LimitesCostosAsm addLimitesCostosAsm(LimitesCostosAsm limitesCostosAsm) {
		getLimitesCostosAsms().add(limitesCostosAsm);
		limitesCostosAsm.setRamoAsistenciaMedica(this);

		return limitesCostosAsm;
	}

	public LimitesCostosAsm removeLimitesCostosAsm(LimitesCostosAsm limitesCostosAsm) {
		getLimitesCostosAsms().remove(limitesCostosAsm);
		limitesCostosAsm.setRamoAsistenciaMedica(null);

		return limitesCostosAsm;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}