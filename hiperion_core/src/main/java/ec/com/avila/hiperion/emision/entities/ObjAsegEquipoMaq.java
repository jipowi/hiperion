package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the obj_aseg_equipo_maq database table.
 * 
 */
@Entity
@Table(name="obj_aseg_equipo_maq")
@NamedQuery(name="ObjAsegEquipoMaq.findAll", query="SELECT o FROM ObjAsegEquipoMaq o")
public class ObjAsegEquipoMaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto_equipo_maq")
	private Integer idObjetoEquipoMaq;

	@Column(name="anio_obj_maq")
	private Integer anioObjMaq;

	@Column(name="chasis_obj_eq_maq")
	private String chasisObjEqMaq;

	@Column(name="color_obj_eq_maq")
	private String colorObjEqMaq;

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

	@Column(name="item_obj_eq_maq")
	private Integer itemObjEqMaq;

	@Column(name="marca_obj_eq_maq")
	private String marcaObjEqMaq;

	@Column(name="modelo_obj_eq_maq")
	private String modeloObjEqMaq;

	@Column(name="motor_objj_eq_maq")
	private String motorObjjEqMaq;

	@Column(name="numero_serie_obj_maq")
	private String numeroSerieObjMaq;

	@Column(name="valor_aseg_obj_eq_maq")
	private BigDecimal valorAsegObjEqMaq;

	//bi-directional many-to-one association to RamoEquipoMaquinaria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_equipo_maquinaria")
	private RamoEquipoMaquinaria ramoEquipoMaquinaria;

	public ObjAsegEquipoMaq() {
	}

	public Integer getIdObjetoEquipoMaq() {
		return this.idObjetoEquipoMaq;
	}

	public void setIdObjetoEquipoMaq(Integer idObjetoEquipoMaq) {
		this.idObjetoEquipoMaq = idObjetoEquipoMaq;
	}

	public Integer getAnioObjMaq() {
		return this.anioObjMaq;
	}

	public void setAnioObjMaq(Integer anioObjMaq) {
		this.anioObjMaq = anioObjMaq;
	}

	public String getChasisObjEqMaq() {
		return this.chasisObjEqMaq;
	}

	public void setChasisObjEqMaq(String chasisObjEqMaq) {
		this.chasisObjEqMaq = chasisObjEqMaq;
	}

	public String getColorObjEqMaq() {
		return this.colorObjEqMaq;
	}

	public void setColorObjEqMaq(String colorObjEqMaq) {
		this.colorObjEqMaq = colorObjEqMaq;
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

	public Integer getItemObjEqMaq() {
		return this.itemObjEqMaq;
	}

	public void setItemObjEqMaq(Integer itemObjEqMaq) {
		this.itemObjEqMaq = itemObjEqMaq;
	}

	public String getMarcaObjEqMaq() {
		return this.marcaObjEqMaq;
	}

	public void setMarcaObjEqMaq(String marcaObjEqMaq) {
		this.marcaObjEqMaq = marcaObjEqMaq;
	}

	public String getModeloObjEqMaq() {
		return this.modeloObjEqMaq;
	}

	public void setModeloObjEqMaq(String modeloObjEqMaq) {
		this.modeloObjEqMaq = modeloObjEqMaq;
	}

	public String getMotorObjjEqMaq() {
		return this.motorObjjEqMaq;
	}

	public void setMotorObjjEqMaq(String motorObjjEqMaq) {
		this.motorObjjEqMaq = motorObjjEqMaq;
	}

	public String getNumeroSerieObjMaq() {
		return this.numeroSerieObjMaq;
	}

	public void setNumeroSerieObjMaq(String numeroSerieObjMaq) {
		this.numeroSerieObjMaq = numeroSerieObjMaq;
	}

	public BigDecimal getValorAsegObjEqMaq() {
		return this.valorAsegObjEqMaq;
	}

	public void setValorAsegObjEqMaq(BigDecimal valorAsegObjEqMaq) {
		this.valorAsegObjEqMaq = valorAsegObjEqMaq;
	}

	public RamoEquipoMaquinaria getRamoEquipoMaquinaria() {
		return this.ramoEquipoMaquinaria;
	}

	public void setRamoEquipoMaquinaria(RamoEquipoMaquinaria ramoEquipoMaquinaria) {
		this.ramoEquipoMaquinaria = ramoEquipoMaquinaria;
	}

}