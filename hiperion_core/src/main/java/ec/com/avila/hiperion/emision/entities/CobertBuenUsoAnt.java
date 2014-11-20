package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobert_buen_uso_ant database table.
 * 
 */
@Entity
@Table(name="cobert_buen_uso_ant")
@NamedQuery(name="CobertBuenUsoAnt.findAll", query="SELECT c FROM CobertBuenUsoAnt c")
public class CobertBuenUsoAnt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cobert_buen_uso_ant")
	private Integer idCobertBuenUsoAnt;

	@Column(name="cobertura_anticipo")
	private String coberturaAnticipo;

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

	//bi-directional many-to-one association to RamoBuenUsoAnt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ind_buen_uso_ant")
	private RamoBuenUsoAnt ramoBuenUsoAnt;

	public CobertBuenUsoAnt() {
	}

	public Integer getIdCobertBuenUsoAnt() {
		return this.idCobertBuenUsoAnt;
	}

	public void setIdCobertBuenUsoAnt(Integer idCobertBuenUsoAnt) {
		this.idCobertBuenUsoAnt = idCobertBuenUsoAnt;
	}

	public String getCoberturaAnticipo() {
		return this.coberturaAnticipo;
	}

	public void setCoberturaAnticipo(String coberturaAnticipo) {
		this.coberturaAnticipo = coberturaAnticipo;
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

	public RamoBuenUsoAnt getRamoBuenUsoAnt() {
		return this.ramoBuenUsoAnt;
	}

	public void setRamoBuenUsoAnt(RamoBuenUsoAnt ramoBuenUsoAnt) {
		this.ramoBuenUsoAnt = ramoBuenUsoAnt;
	}

}