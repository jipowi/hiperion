package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the tarjeta_credito database table.
 * 
 */
@Entity
@Table(name="tarjeta_credito")
@NamedQuery(name="TarjetaCredito.findAll", query="SELECT t FROM TarjetaCredito t")
public class TarjetaCredito extends Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tarjeta")
	private Integer idTarjeta;

	@Column(name="numero_meses")
	private BigDecimal numeroMeses;

	private String tarjeta;

	@Column(name="tipo_pago")
	private String tipoPago;

	//bi-directional many-to-one association to PagoPoliza
	@OneToMany(mappedBy="tarjetaCredito")
	private List<PagoPoliza> pagoPolizas;

	public TarjetaCredito() {
	}

	public Integer getIdTarjeta() {
		return this.idTarjeta;
	}

	public void setIdTarjeta(Integer idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public BigDecimal getNumeroMeses() {
		return this.numeroMeses;
	}

	public void setNumeroMeses(BigDecimal numeroMeses) {
		this.numeroMeses = numeroMeses;
	}

	public String getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public List<PagoPoliza> getPagoPolizas() {
		return this.pagoPolizas;
	}

	public void setPagoPolizas(List<PagoPoliza> pagoPolizas) {
		this.pagoPolizas = pagoPolizas;
	}

	public PagoPoliza addPagoPoliza(PagoPoliza pagoPoliza) {
		getPagoPolizas().add(pagoPoliza);
		pagoPoliza.setTarjetaCredito(this);

		return pagoPoliza;
	}

	public PagoPoliza removePagoPoliza(PagoPoliza pagoPoliza) {
		getPagoPolizas().remove(pagoPoliza);
		pagoPoliza.setTarjetaCredito(null);

		return pagoPoliza;
	}

}