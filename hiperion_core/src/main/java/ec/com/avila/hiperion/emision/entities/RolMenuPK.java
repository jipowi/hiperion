package ec.com.avila.hiperion.emision.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rol_menu database table.
 * 
 */
@Embeddable
public class RolMenuPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_rol", insertable=false, updatable=false)
	private Integer idRol;

	@Column(name="menu_id", insertable=false, updatable=false)
	private Integer menuId;

	public RolMenuPK() {
	}
	public Integer getIdRol() {
		return this.idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public Integer getMenuId() {
		return this.menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RolMenuPK)) {
			return false;
		}
		RolMenuPK castOther = (RolMenuPK)other;
		return 
			this.idRol.equals(castOther.idRol)
			&& this.menuId.equals(castOther.menuId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRol.hashCode();
		hash = hash * prime + this.menuId.hashCode();
		
		return hash;
	}
}