package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ramo_soat database table.
 * 
 */
@Entity
@Table(name="ramo_soat")
@NamedQuery(name="RamoSoat.findAll", query="SELECT r FROM RamoSoat r")
public class RamoSoat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_soat")
	private Integer idSoat;

	@Column(name="anio_soat")
	private Integer anioSoat;

	private String asegurado;

	@Column(name="chasis_soat")
	private String chasisSoat;

	@Column(name="cilindraje_soat")
	private Integer cilindrajeSoat;

	@Column(name="color_soat")
	private String colorSoat;

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

	@Column(name="marca_soat")
	private String marcaSoat;

	@Column(name="modelo_soat")
	private String modeloSoat;

	@Column(name="motor_soat")
	private String motorSoat;

	@Column(name="placa_soat")
	private String placaSoat;

	@Column(name="tipo_vehiculo_soat")
	private String tipoVehiculoSoat;

	//bi-directional many-to-one association to CobertSoat
	@OneToMany(mappedBy="ramoSoat")
	private List<CobertSoat> cobertSoats;

	//bi-directional many-to-one association to Poliza
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_poliza")
	private Poliza poliza;

	public RamoSoat() {
	}

	public Integer getIdSoat() {
		return this.idSoat;
	}

	public void setIdSoat(Integer idSoat) {
		this.idSoat = idSoat;
	}

	public Integer getAnioSoat() {
		return this.anioSoat;
	}

	public void setAnioSoat(Integer anioSoat) {
		this.anioSoat = anioSoat;
	}

	public String getAsegurado() {
		return this.asegurado;
	}

	public void setAsegurado(String asegurado) {
		this.asegurado = asegurado;
	}

	public String getChasisSoat() {
		return this.chasisSoat;
	}

	public void setChasisSoat(String chasisSoat) {
		this.chasisSoat = chasisSoat;
	}

	public Integer getCilindrajeSoat() {
		return this.cilindrajeSoat;
	}

	public void setCilindrajeSoat(Integer cilindrajeSoat) {
		this.cilindrajeSoat = cilindrajeSoat;
	}

	public String getColorSoat() {
		return this.colorSoat;
	}

	public void setColorSoat(String colorSoat) {
		this.colorSoat = colorSoat;
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

	public String getMarcaSoat() {
		return this.marcaSoat;
	}

	public void setMarcaSoat(String marcaSoat) {
		this.marcaSoat = marcaSoat;
	}

	public String getModeloSoat() {
		return this.modeloSoat;
	}

	public void setModeloSoat(String modeloSoat) {
		this.modeloSoat = modeloSoat;
	}

	public String getMotorSoat() {
		return this.motorSoat;
	}

	public void setMotorSoat(String motorSoat) {
		this.motorSoat = motorSoat;
	}

	public String getPlacaSoat() {
		return this.placaSoat;
	}

	public void setPlacaSoat(String placaSoat) {
		this.placaSoat = placaSoat;
	}

	public String getTipoVehiculoSoat() {
		return this.tipoVehiculoSoat;
	}

	public void setTipoVehiculoSoat(String tipoVehiculoSoat) {
		this.tipoVehiculoSoat = tipoVehiculoSoat;
	}

	public List<CobertSoat> getCobertSoats() {
		return this.cobertSoats;
	}

	public void setCobertSoats(List<CobertSoat> cobertSoats) {
		this.cobertSoats = cobertSoats;
	}

	public CobertSoat addCobertSoat(CobertSoat cobertSoat) {
		getCobertSoats().add(cobertSoat);
		cobertSoat.setRamoSoat(this);

		return cobertSoat;
	}

	public CobertSoat removeCobertSoat(CobertSoat cobertSoat) {
		getCobertSoats().remove(cobertSoat);
		cobertSoat.setRamoSoat(null);

		return cobertSoat;
	}

	public Poliza getPoliza() {
		return this.poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

}