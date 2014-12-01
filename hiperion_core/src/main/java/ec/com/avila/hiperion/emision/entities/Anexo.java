package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the anexo database table.
 * 
 */
@Entity
@NamedQuery(name = "Anexo.findAll", query = "SELECT a FROM Anexo a")
public class Anexo extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_anexo")
	private Integer idAnexo;

	@Column(name = "nombre_anexo")
	private String nombreAnexo;

	// bi-directional many-to-one association to DetalleAnexo
	@OneToMany(mappedBy = "anexo", cascade = { CascadeType.ALL })
	private List<DetalleAnexo> detalleAnexos;

	public Anexo() {
	}

	public Integer getIdAnexo() {
		return this.idAnexo;
	}

	public void setIdAnexo(Integer idAnexo) {
		this.idAnexo = idAnexo;
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