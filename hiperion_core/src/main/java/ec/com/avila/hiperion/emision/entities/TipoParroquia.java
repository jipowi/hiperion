package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_parroquia database table.
 * 
 */
@Entity
@Table(name="tipo_parroquia")
@NamedQuery(name="TipoParroquia.findAll", query="SELECT t FROM TipoParroquia t")
public class TipoParroquia extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_parroquia")
	private Integer idTipoParroquia;

	@Column(name="desc_tipo_parroquia")
	private String descTipoParroquia;

	//bi-directional many-to-one association to Parroquia
	@OneToMany(mappedBy="tipoParroquia")
	private List<Parroquia> parroquias;

	public TipoParroquia() {
	}

	public Integer getIdTipoParroquia() {
		return this.idTipoParroquia;
	}

	public void setIdTipoParroquia(Integer idTipoParroquia) {
		this.idTipoParroquia = idTipoParroquia;
	}

	public String getDescTipoParroquia() {
		return this.descTipoParroquia;
	}

	public void setDescTipoParroquia(String descTipoParroquia) {
		this.descTipoParroquia = descTipoParroquia;
	}

	public List<Parroquia> getParroquias() {
		return this.parroquias;
	}

	public void setParroquias(List<Parroquia> parroquias) {
		this.parroquias = parroquias;
	}

	public Parroquia addParroquia(Parroquia parroquia) {
		getParroquias().add(parroquia);
		parroquia.setTipoParroquia(this);

		return parroquia;
	}

	public Parroquia removeParroquia(Parroquia parroquia) {
		getParroquias().remove(parroquia);
		parroquia.setTipoParroquia(null);

		return parroquia;
	}

}