package ec.com.avila.hiperion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aseguradora database table.
 * 
 */
@Entity
public class Aseguradora implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aseguradora")
	private Integer idAseguradora;

	@Column(name="codigo_aseguradora")
	private String codigoAseguradora;

	private String direcion;

	@Column(name="email_aseguradora")
	private String emailAseguradora;

	private String ruc;

	@Column(name="telf_convencional_aseg")
	private String telfConvencionalAseg;

	//bi-directional many-to-many association to Persona
	@ManyToMany(mappedBy="aseguradoras")
	private List<Persona> personas;

	//bi-directional many-to-many association to Ramo
	@ManyToMany(mappedBy="aseguradoras")
	private List<Ramo> ramos;

	//bi-directional many-to-one association to RamoAseguradora
	@OneToMany(mappedBy="aseguradora")
	private List<RamoAseguradora> ramoAseguradoras;

	public Aseguradora() {
	}

	public Integer getIdAseguradora() {
		return this.idAseguradora;
	}

	public void setIdAseguradora(Integer idAseguradora) {
		this.idAseguradora = idAseguradora;
	}

	public String getCodigoAseguradora() {
		return this.codigoAseguradora;
	}

	public void setCodigoAseguradora(String codigoAseguradora) {
		this.codigoAseguradora = codigoAseguradora;
	}

	public String getDirecion() {
		return this.direcion;
	}

	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}

	public String getEmailAseguradora() {
		return this.emailAseguradora;
	}

	public void setEmailAseguradora(String emailAseguradora) {
		this.emailAseguradora = emailAseguradora;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTelfConvencionalAseg() {
		return this.telfConvencionalAseg;
	}

	public void setTelfConvencionalAseg(String telfConvencionalAseg) {
		this.telfConvencionalAseg = telfConvencionalAseg;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public List<Ramo> getRamos() {
		return this.ramos;
	}

	public void setRamos(List<Ramo> ramos) {
		this.ramos = ramos;
	}

	public List<RamoAseguradora> getRamoAseguradoras() {
		return this.ramoAseguradoras;
	}

	public void setRamoAseguradoras(List<RamoAseguradora> ramoAseguradoras) {
		this.ramoAseguradoras = ramoAseguradoras;
	}

	public RamoAseguradora addRamoAseguradora(RamoAseguradora ramoAseguradora) {
		getRamoAseguradoras().add(ramoAseguradora);
		ramoAseguradora.setAseguradora(this);

		return ramoAseguradora;
	}

	public RamoAseguradora removeRamoAseguradora(RamoAseguradora ramoAseguradora) {
		getRamoAseguradoras().remove(ramoAseguradora);
		ramoAseguradora.setAseguradora(null);

		return ramoAseguradora;
	}

}