package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the canton database table.
 * 
 */
@Entity
@NamedQuery(name = "Canton.findAll", query = "SELECT c FROM Canton c")
public class Canton extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_canton")
	private Integer idCanton;

	@Column(name = "nombre_canton")
	private String nombreCanton;

	// bi-directional many-to-one association to Provincia
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name = "id_provincia")
	private Provincia provincia;

	// bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy = "canton")
	private List<Direccion> direccions;

	// bi-directional many-to-one association to Parroquia
	@OneToMany(mappedBy = "canton")
	private List<Parroquia> parroquias;

	public Canton() {
	}

	public Integer getIdCanton() {
		return this.idCanton;
	}

	public void setIdCanton(Integer idCanton) {
		this.idCanton = idCanton;
	}

	public String getNombreCanton() {
		return this.nombreCanton;
	}

	public void setNombreCanton(String nombreCanton) {
		this.nombreCanton = nombreCanton;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setCanton(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setCanton(null);

		return direccion;
	}

	public List<Parroquia> getParroquias() {
		return this.parroquias;
	}

	public void setParroquias(List<Parroquia> parroquias) {
		this.parroquias = parroquias;
	}

	public Parroquia addParroquia(Parroquia parroquia) {
		getParroquias().add(parroquia);
		parroquia.setCanton(this);

		return parroquia;
	}

	public Parroquia removeParroquia(Parroquia parroquia) {
		getParroquias().remove(parroquia);
		parroquia.setCanton(null);

		return parroquia;
	}

}