package ec.com.avila.hiperion.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the detalle_catalogo database table.
 * 
 */
@Entity
@Table(name = "detalle_catalogo")
public class DetalleCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_catalogo")
	private Integer idDetalleCatalogo;

	@Column(name = "cod_dep_catalogo")
	private String codDepCatalogo;

	@Column(name = "cod_dep_detalle_catalogo")
	private String codDepDetalleCatalogo;

	@Column(name = "cod_detalle_catalogo")
	private String codDetalleCatalogo;

	@Column(name = "desc_det_catalogo")
	private String descDetCatalogo;

	// bi-directional many-to-one association to Catalogo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_catalogo")
	private Catalogo catalogo;

	public DetalleCatalogo() {
	}

	public Integer getIdDetalleCatalogo() {
		return this.idDetalleCatalogo;
	}

	public void setIdDetalleCatalogo(Integer idDetalleCatalogo) {
		this.idDetalleCatalogo = idDetalleCatalogo;
	}

	public String getCodDepCatalogo() {
		return this.codDepCatalogo;
	}

	public void setCodDepCatalogo(String codDepCatalogo) {
		this.codDepCatalogo = codDepCatalogo;
	}

	public String getCodDepDetalleCatalogo() {
		return this.codDepDetalleCatalogo;
	}

	public void setCodDepDetalleCatalogo(String codDepDetalleCatalogo) {
		this.codDepDetalleCatalogo = codDepDetalleCatalogo;
	}

	public String getCodDetalleCatalogo() {
		return this.codDetalleCatalogo;
	}

	public void setCodDetalleCatalogo(String codDetalleCatalogo) {
		this.codDetalleCatalogo = codDetalleCatalogo;
	}

	public String getDescDetCatalogo() {
		return this.descDetCatalogo;
	}

	public void setDescDetCatalogo(String descDetCatalogo) {
		this.descDetCatalogo = descDetCatalogo;
	}

	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

}