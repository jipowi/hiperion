package ec.com.avila.hiperion.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the persona_aseguradora database table.
 * 
 */
@Entity
@Table(name="persona_aseguradora")
public class PersonaAseguradora implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonaAseguradoraPK id;

	public PersonaAseguradora() {
	}

	public PersonaAseguradoraPK getId() {
		return this.id;
	}

	public void setId(PersonaAseguradoraPK id) {
		this.id = id;
	}

}