package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the obj_aseg_incendio database table.
 * 
 */
@Entity
@Table(name="obj_aseg_incendio")
@NamedQuery(name="ObjAsegIncendio.findAll", query="SELECT o FROM ObjAsegIncendio o")
public class ObjAsegIncendio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto_aseg_incendio")
	private Integer idObjetoAsegIncendio;

	@Column(name="detalle_incendio")
	private String detalleIncendio;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Column(name="forma_seguro_incendio")
	private BigDecimal formaSeguroIncendio;

	@Column(name="id_usuario_actualizacion")
	private Integer idUsuarioActualizacion;

	@Column(name="id_usuario_creacion")
	private Integer idUsuarioCreacion;

	@Column(name="item_incendio")
	private String itemIncendio;

	@Column(name="ubicacion_incendio")
	private String ubicacionIncendio;

	@Column(name="utilidad_bruta_incendio_la")
	private BigDecimal utilidadBrutaIncendioLa;

	@Column(name="valor_obj_aseg_incendio")
	private BigDecimal valorObjAsegIncendio;

	//bi-directional many-to-one association to RamoIncendioLineasAliada
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_incendio")
	private RamoIncendioLineasAliada ramoIncendioLineasAliada;

	public ObjAsegIncendio() {
	}

	public Integer getIdObjetoAsegIncendio() {
		return this.idObjetoAsegIncendio;
	}

	public void setIdObjetoAsegIncendio(Integer idObjetoAsegIncendio) {
		this.idObjetoAsegIncendio = idObjetoAsegIncendio;
	}

	public String getDetalleIncendio() {
		return this.detalleIncendio;
	}

	public void setDetalleIncendio(String detalleIncendio) {
		this.detalleIncendio = detalleIncendio;
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

	public BigDecimal getFormaSeguroIncendio() {
		return this.formaSeguroIncendio;
	}

	public void setFormaSeguroIncendio(BigDecimal formaSeguroIncendio) {
		this.formaSeguroIncendio = formaSeguroIncendio;
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

	public String getItemIncendio() {
		return this.itemIncendio;
	}

	public void setItemIncendio(String itemIncendio) {
		this.itemIncendio = itemIncendio;
	}

	public String getUbicacionIncendio() {
		return this.ubicacionIncendio;
	}

	public void setUbicacionIncendio(String ubicacionIncendio) {
		this.ubicacionIncendio = ubicacionIncendio;
	}

	public BigDecimal getUtilidadBrutaIncendioLa() {
		return this.utilidadBrutaIncendioLa;
	}

	public void setUtilidadBrutaIncendioLa(BigDecimal utilidadBrutaIncendioLa) {
		this.utilidadBrutaIncendioLa = utilidadBrutaIncendioLa;
	}

	public BigDecimal getValorObjAsegIncendio() {
		return this.valorObjAsegIncendio;
	}

	public void setValorObjAsegIncendio(BigDecimal valorObjAsegIncendio) {
		this.valorObjAsegIncendio = valorObjAsegIncendio;
	}

	public RamoIncendioLineasAliada getRamoIncendioLineasAliada() {
		return this.ramoIncendioLineasAliada;
	}

	public void setRamoIncendioLineasAliada(RamoIncendioLineasAliada ramoIncendioLineasAliada) {
		this.ramoIncendioLineasAliada = ramoIncendioLineasAliada;
	}

}