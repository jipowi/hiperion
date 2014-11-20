package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rol_menu database table.
 * 
 */
@Entity
@Table(name="rol_menu")
@NamedQuery(name="RolMenu.findAll", query="SELECT r FROM RolMenu r")
public class RolMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolMenuPK id;

	public RolMenu() {
	}

	public RolMenuPK getId() {
		return this.id;
	}

	public void setId(RolMenuPK id) {
		this.id = id;
	}

}