package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the obj_aseg_lc_in database table.
 * 
 */
@Entity
@Table(name="obj_aseg_lc_in")
@NamedQuery(name="ObjAsegLcIn.findAll", query="SELECT o FROM ObjAsegLcIn o")
public class ObjAsegLcIn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto_aseg_lucro")
	private Integer idObjetoAsegLucro;

	@Column(name="detalle_obj_lc_incendio")
	private String detalleObjLcIncendio;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Column(name="forma_seguro_lc")
	private String formaSeguroLc;

	@Column(name="id_usuario_actualizacion")
	private Integer idUsuarioActualizacion;

	@Column(name="id_usuario_creacion")
	private Integer idUsuarioCreacion;

	@Column(name="item_obj_lc_incendio")
	private Integer itemObjLcIncendio;

	@Column(name="ubicacion_obj_lc_incendio")
	private String ubicacionObjLcIncendio;

	@Column(name="utilidad_bruta_lc_incendio")
	private BigDecimal utilidadBrutaLcIncendio;

	//bi-directional many-to-one association to RamoLcIncendio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_lucro")
	private RamoLcIncendio ramoLcIncendio;

	public ObjAsegLcIn() {
	}

	public Integer getIdObjetoAsegLucro() {
		return this.idObjetoAsegLucro;
	}

	public void setIdObjetoAsegLucro(Integer idObjetoAsegLucro) {
		this.idObjetoAsegLucro = idObjetoAsegLucro;
	}

	public String getDetalleObjLcIncendio() {
		return this.detalleObjLcIncendio;
	}

	public void setDetalleObjLcIncendio(String detalleObjLcIncendio) {
		this.detalleObjLcIncendio = detalleObjLcIncendio;
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

	public String getFormaSeguroLc() {
		return this.formaSeguroLc;
	}

	public void setFormaSeguroLc(String formaSeguroLc) {
		this.formaSeguroLc = formaSeguroLc;
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

	public Integer getItemObjLcIncendio() {
		return this.itemObjLcIncendio;
	}

	public void setItemObjLcIncendio(Integer itemObjLcIncendio) {
		this.itemObjLcIncendio = itemObjLcIncendio;
	}

	public String getUbicacionObjLcIncendio() {
		return this.ubicacionObjLcIncendio;
	}

	public void setUbicacionObjLcIncendio(String ubicacionObjLcIncendio) {
		this.ubicacionObjLcIncendio = ubicacionObjLcIncendio;
	}

	public BigDecimal getUtilidadBrutaLcIncendio() {
		return this.utilidadBrutaLcIncendio;
	}

	public void setUtilidadBrutaLcIncendio(BigDecimal utilidadBrutaLcIncendio) {
		this.utilidadBrutaLcIncendio = utilidadBrutaLcIncendio;
	}

	public RamoLcIncendio getRamoLcIncendio() {
		return this.ramoLcIncendio;
	}

	public void setRamoLcIncendio(RamoLcIncendio ramoLcIncendio) {
		this.ramoLcIncendio = ramoLcIncendio;
	}

}