package ec.com.avila.hiperion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parroquia database table.
 * 
 */
@Entity
public class Parroquia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_parroquia")
	private Integer idParroquia;

	@Column(name="nombre_parroquia")
	private String nombreParroquia;

	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="parroquia")
	private List<Direccion> direccions;

	//bi-directional many-to-one association to Canton
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_canton")
	private Canton canton;

	//bi-directional many-to-one association to TipoParroquia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_parroquia")
	private TipoParroquia tipoParroquia;

	public Parroquia() {
	}

	public Integer getIdParroquia() {
		return this.idParroquia;
	}

	public void setIdParroquia(Integer idParroquia) {
		this.idParroquia = idParroquia;
	}

	public String getNombreParroquia() {
		return this.nombreParroquia;
	}

	public void setNombreParroquia(String nombreParroquia) {
		this.nombreParroquia = nombreParroquia;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setParroquia(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setParroquia(null);

		return direccion;
	}

	public Canton getCanton() {
		return this.canton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
	}

	public TipoParroquia getTipoParroquia() {
		return this.tipoParroquia;
	}

	public void setTipoParroquia(TipoParroquia tipoParroquia) {
		this.tipoParroquia = tipoParroquia;
	}

}