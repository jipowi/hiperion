package ec.com.avila.hiperion.comun;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		// ASEGURADORA
		@NamedQuery(name = "Aseguradora.findByRuc", query = "SELECT c FROM Aseguradora c WHERE c.ruc =:ruc"),
		@NamedQuery(name = "Aseguradora.findByAseguradora", query = "SELECT c FROM Aseguradora c WHERE c.idAseguradora =:aseguradora"),
		@NamedQuery(name = "Aseguradora.find", query = "SELECT c FROM Aseguradora c WHERE c.ruc =:ruc AND c.idAseguradora =:aseguradora"),
		// CATALOGO
		@NamedQuery(name = "Catalogo.findById", query = "SELECT c FROM Catalogo c WHERE c.idCatalogo =:idCatalogo"),
		// TIPO_DIRECCION
		@NamedQuery(name = "TipoDireccion.findCodigo", query = "SELECT t FROM TipoDireccion t WHERE t.codigoTipoDireccion =:codTipoDireccion"),
		@NamedQuery(name = "TipoDireccion.findDescripcion", query = "SELECT t FROM TipoDireccion t WHERE t.descTipoDireccion =:descripcion"),
		// DETALLE_CATALOGO
		@NamedQuery(name = "DetalleCatalogo.findByCodCatalogo", query = "SELECT d FROM DetalleCatalogo d WHERE d.catalogo.idCatalogo =:idCatalogo ORDER BY d.descDetCatalogo"),
		@NamedQuery(name = "DetalleCatalogo.findByCodCatalogoAndCodDetalle", query = "SELECT d FROM DetalleCatalogo d WHERE d.catalogo.idCatalogo =:idCatalogo AND d.codDetalleCatalogo=:codDetalleCatalogo"),
		@NamedQuery(name = "DetalleCatalogo.findByCodDepCatalogo", query = "SELECT d FROM DetalleCatalogo d WHERE d.codDepDetalleCatalogo =:codDepDetalleCatalogo AND d.codDepDetalleCatalogo=:codDepDetCalogo"),
		@NamedQuery(name = "DetalleCatalogo.findByCodigoDetalle", query = "SELECT d FROM DetalleCatalogo d WHERE d.codDepDetalleCatalogo =:codDepDetalleCatalogo AND d.catalogo.idCatalogo=:idCatalogo"),
		// RAMO
		@NamedQuery(name = "Ramo.findByCodigoRamo", query = "SELECT r FROM Ramo r WHERE r.codigoRamo =:codigoRamo"),
		// USUARIO
		@NamedQuery(name = "Usuario.loginUser", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario =:nombreUsuario AND u.clave =:clave"),
		// PROVINCIA
		@NamedQuery(name = "Provincia.findByCodProvincia", query = "SELECT p FROM Provincia p WHERE p.codigo =:codigo"),
		// CANTON
		@NamedQuery(name = "Canton.findByCodProvincia", query = "SELECT c FROM Canton c WHERE c.provincia.codigo =:codProvincia ORDER BY c.nombreCanton"),
		@NamedQuery(name = "Canton.findByIdCanton", query = "SELECT c FROM Canton c WHERE c.idCanton =:idCanton"),
		// PARROQUIA
		@NamedQuery(name = "Parroquia.findByIdCanton", query = "SELECT p FROM Parroquia p WHERE p.canton.idCanton =:idCanton ORDER BY p.nombreParroquia"),
		@NamedQuery(name = "Parroquia.findByIdParroquia", query = "SELECT p FROM Parroquia p WHERE p.idParroquia =:idParroquia"),
		// ROL
		@NamedQuery(name = "Rol.findByUsuario", query = "SELECT r FROM Rol r WHERE r.usuario.idUsuario =:idUsuario"),
		// MENU
		@NamedQuery(name = "Menu.findByRol", query = "SELECT m FROM Menu m WHERE m.rol.idRol =:idRol") })
public class Consultas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer comunId;

	/**
	 * 
	 * @return
	 */
	public Integer getComunId() {
		return comunId;
	}

	/**
	 * 
	 * @param comunId
	 */
	public void setComunId(Integer comunId) {
		this.comunId = comunId;
	}
}
