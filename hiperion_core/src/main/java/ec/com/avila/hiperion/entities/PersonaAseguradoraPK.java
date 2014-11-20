package ec.com.avila.hiperion.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the persona_aseguradora database table.
 * 
 */
@Embeddable
public class PersonaAseguradoraPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_aseguradora")
	private Integer idAseguradora;

	@Column(name="id_persona")
	private Integer idPersona;

	public PersonaAseguradoraPK() {
	}
	public Integer getIdAseguradora() {
		return this.idAseguradora;
	}
	public void setIdAseguradora(Integer idAseguradora) {
		this.idAseguradora = idAseguradora;
	}
	public Integer getIdPersona() {
		return this.idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PersonaAseguradoraPK)) {
			return false;
		}
		PersonaAseguradoraPK castOther = (PersonaAseguradoraPK)other;
		return 
			this.idAseguradora.equals(castOther.idAseguradora)
			&& this.idPersona.equals(castOther.idPersona);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAseguradora.hashCode();
		hash = hash * prime + this.idPersona.hashCode();
		
		return hash;
	}
}