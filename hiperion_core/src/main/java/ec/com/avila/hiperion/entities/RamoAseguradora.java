package ec.com.avila.hiperion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ramo_aseguradora database table.
 * 
 */
@Entity
@Table(name="ramo_aseguradora")
public class RamoAseguradora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ramo_aseguradora")
	private Integer idRamoAseguradora;

	private BigDecimal comision;

	//bi-directional many-to-one association to Aseguradora
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_aseguradora")
	private Aseguradora aseguradora;

	//bi-directional many-to-one association to Ramo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ramo")
	private Ramo ramo;

	public RamoAseguradora() {
	}

	public Integer getIdRamoAseguradora() {
		return this.idRamoAseguradora;
	}

	public void setIdRamoAseguradora(Integer idRamoAseguradora) {
		this.idRamoAseguradora = idRamoAseguradora;
	}

	public BigDecimal getComision() {
		return this.comision;
	}

	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

	public Aseguradora getAseguradora() {
		return this.aseguradora;
	}

	public void setAseguradora(Aseguradora aseguradora) {
		this.aseguradora = aseguradora;
	}

	public Ramo getRamo() {
		return this.ramo;
	}

	public void setRamo(Ramo ramo) {
		this.ramo = ramo;
	}

}