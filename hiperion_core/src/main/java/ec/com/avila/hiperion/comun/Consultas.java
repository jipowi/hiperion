package ec.com.avila.hiperion.comun;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		// ASEGURADORA
		@NamedQuery(name = "Aseguradora.findAll", query = "SELECT c FROM Aseguradora c"),
		@NamedQuery(name = "Aseguradora.findByRuc", query = "SELECT c FROM Aseguradora c WHERE c.ruc =:ruc"),
		@NamedQuery(name = "Aseguradora.findByAseguradora", query = "SELECT c FROM Aseguradora c WHERE c.idAseguradora =:aseguradora"),
		@NamedQuery(name = "Aseguradora.find", query = "SELECT c FROM Aseguradora c WHERE c.ruc =:ruc AND c.idAseguradora =:aseguradora"),
		// CATALOGO
		@NamedQuery(name = "Catalogo.findById", query = "SELECT c FROM Catalogo c WHERE c.idCatalogo =:idCatalogo"),
		@NamedQuery(name = "Catalogo.findAll", query = "SELECT c FROM Catalogo c ORDER BY c.idCatalogo"),
		// TIPO_DIRECCION
		@NamedQuery(name = "TipoDireccion.findAll", query = "SELECT t FROM TipoDireccion t ORDER BY t.descTipoDireccion"),
		@NamedQuery(name = "TipoDireccion.findCodigo", query = "SELECT t FROM TipoDireccion t WHERE t.codigoTipoDireccion =:codTipoDireccion"),
		@NamedQuery(name = "TipoDireccion.findDescripcion", query = "SELECT t FROM TipoDireccion t WHERE t.descTipoDireccion =:descripcion"),
		// CLIENTE
		@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c ORDER BY c.idCliente"),
		// DETALLE_CATALOGO
		@NamedQuery(name = "DetalleCatalogo.findAll", query = "SELECT d FROM DetalleCatalogo d ORDER BY d.idDetalleCatalogo"),
		@NamedQuery(name = "DetalleCatalogo.findByCodCatalogo", query = "SELECT d FROM DetalleCatalogo d WHERE d.catalogo.idCatalogo =:idCatalogo ORDER BY d.descDetCatalogo"),
		@NamedQuery(name = "DetalleCatalogo.findByCodCatalogoAndCodDetalle", query = "SELECT d FROM DetalleCatalogo d WHERE d.catalogo.idCatalogo =:idCatalogo AND d.codDetalleCatalogo=:codDetalleCatalogo"),
		@NamedQuery(name = "DetalleCatalogo.findByCodDepCatalogo", query = "SELECT d FROM DetalleCatalogo d WHERE d.codDepDetalleCatalogo =:codDepDetalleCatalogo AND d.codDepDetalleCatalogo=:codDepDetCalogo"),
		@NamedQuery(name = "DetalleCatalogo.findByCodigoDetalle", query = "SELECT d FROM DetalleCatalogo d WHERE d.codDepDetalleCatalogo =:codDepDetalleCatalogo AND d.catalogo.idCatalogo=:idCatalogo"),
		// PERSONA
		@NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p ORDER BY p.idPersona"),
		// RAMO
		@NamedQuery(name = "Ramo.findAll", query = "SELECT r FROM Ramo r ORDER BY r.idRamo"),
		@NamedQuery(name = "Ramo.findByCodigoRamo", query = "SELECT r FROM Ramo r WHERE r.codigoRamo =:codigoRamo"),
		// USUARIO
		@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u ORDER BY u.idUsuario"),
		@NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.usuario =:nombreUsuario"),
		// PROVINCIA
		@NamedQuery(name = "Provincia.findAll", query = "SELECT p FROM Provincia p ORDER BY p.nombreProvincia"),
		@NamedQuery(name = "Provincia.findByCodProvincia", query = "SELECT p FROM Provincia p WHERE p.codigo =:codigo"),
		// CANTON
		@NamedQuery(name = "Canton.findByCodProvincia", query = "SELECT c FROM Canton c WHERE c.provincia.codigo =:codProvincia ORDER BY c.nombreCanton"),
		@NamedQuery(name = "Canton.findByIdCanton", query = "SELECT c FROM Canton c WHERE c.idCanton =:idCanton"),
		// PARROQUIA
		@NamedQuery(name = "Parroquia.findByIdCanton", query = "SELECT p FROM Parroquia p WHERE p.canton.idCanton =:idCanton ORDER BY p.nombreParroquia"),
		@NamedQuery(name = "Parroquia.findByIdParroquia", query = "SELECT p FROM Parroquia p WHERE p.idParroquia =:idParroquia") })
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
