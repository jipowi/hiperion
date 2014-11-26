package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the anexo database table.
 * 
 */
@Entity
@NamedQuery(name="Anexo.findAll", query="SELECT a FROM Anexo a")
public class Anexo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_anexo")
	private Integer idAnexo;

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

	@Column(name="nombre_anexo")
	private String nombreAnexo;

	//bi-directional many-to-one association to DetalleAnexo
	@OneToMany(mappedBy="anexo")
	private List<DetalleAnexo> detalleAnexos;

	public Anexo() {
	}

	public Integer getIdAnexo() {
		return this.idAnexo;
	}

	public void setIdAnexo(Integer idAnexo) {
		this.idAnexo = idAnexo;
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

	public String getNombreAnexo() {
		return this.nombreAnexo;
	}

	public void setNombreAnexo(String nombreAnexo) {
		this.nombreAnexo = nombreAnexo;
	}

	public List<DetalleAnexo> getDetalleAnexos() {
		return this.detalleAnexos;
	}

	public void setDetalleAnexos(List<DetalleAnexo> detalleAnexos) {
		this.detalleAnexos = detalleAnexos;
	}

	public DetalleAnexo addDetalleAnexo(DetalleAnexo detalleAnexo) {
		getDetalleAnexos().add(detalleAnexo);
		detalleAnexo.setAnexo(this);

		return detalleAnexo;
	}

	public DetalleAnexo removeDetalleAnexo(DetalleAnexo detalleAnexo) {
		getDetalleAnexos().remove(detalleAnexo);
		detalleAnexo.setAnexo(null);

		return detalleAnexo;
	}

}