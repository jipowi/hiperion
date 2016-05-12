/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ec.com.avila.hiperion.dto.AseguradoraDTO;
import ec.com.avila.hiperion.dto.PersonaContactoAseguradoraDTO;
import ec.com.avila.hiperion.dto.RamoDTO;

/**
 * 
 * <b> Incluir aqui la descripcion de la clase. </b>
 * 
 * @author Paul Jimenez
 * @version 1.0,Aug 3, 2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class AseguradoraBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer codAseguradora;
	private String ruc;
	private String direccion;
	private String telefono;
	private String mailAseguradora;
	private List<AseguradoraDTO> aseguradorasList;

	// Informacion del contacto
	private String nombre;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String identificacion;
	private String cargo;
	private String email;
	private String telefonoContacto;
	private static List<PersonaContactoAseguradoraDTO> contactoList = new ArrayList<>();

	// informacion del ramo de la aseguradora
	private String nombreRamo;
	private BigDecimal comision;
	private static ArrayList<RamoDTO> ramoList = new ArrayList<RamoDTO>();

	private Boolean activarTabla = false;
	private Boolean activarNewAseguradora = false;

	/**
	 * @return the codAseguradora
	 */
	public Integer getCodAseguradora() {
		return codAseguradora;
	}

	/**
	 * @param codAseguradora
	 *            the codAseguradora to set
	 */
	public void setCodAseguradora(Integer codAseguradora) {
		this.codAseguradora = codAseguradora;
	}

	/**
	 * @return the ruc
	 */
	public String getRuc() {
		return ruc;
	}

	/**
	 * @param ruc
	 *            the ruc to set
	 */
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion
	 *            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno
	 *            the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno
	 *            the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion
	 *            the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo
	 *            the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telefonoContacto
	 */
	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	/**
	 * @param telefonoContacto
	 *            the telefonoContacto to set
	 */
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	/**
	 * @return the contactoList
	 */
	public List<PersonaContactoAseguradoraDTO> getContactoList() {
		return contactoList;
	}

	/**
	 * @param contactoList
	 *            the contactoList to set
	 */
	public void setContactoList(List<PersonaContactoAseguradoraDTO> contactoList) {
		AseguradoraBean.contactoList = contactoList;
	}

	/**
	 * @return the nombreRamo
	 */
	public String getNombreRamo() {
		return nombreRamo;
	}

	/**
	 * @param nombreRamo
	 *            the nombreRamo to set
	 */
	public void setNombreRamo(String nombreRamo) {
		this.nombreRamo = nombreRamo;
	}

	/**
	 * @return the comision
	 */
	public BigDecimal getComision() {
		return comision;
	}

	/**
	 * @param comision
	 *            the comision to set
	 */
	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

	/**
	 * @return the ramoList
	 */
	public ArrayList<RamoDTO> getRamoList() {
		return ramoList;
	}

	/**
	 * @param ramoList
	 *            the ramoList to set
	 */
	public static void setRamoList(ArrayList<RamoDTO> ramoList) {
		AseguradoraBean.ramoList = ramoList;
	}

	/**
	 * @return the mailAseguradora
	 */
	public String getMailAseguradora() {
		return mailAseguradora;
	}

	/**
	 * @param mailAseguradora
	 *            the mailAseguradora to set
	 */
	public void setMailAseguradora(String mailAseguradora) {
		this.mailAseguradora = mailAseguradora;
	}

	/**
	 * @return the aseguradorasList
	 */
	public List<AseguradoraDTO> getAseguradorasList() {
		return aseguradorasList;
	}

	/**
	 * @param aseguradorasList
	 *            the aseguradorasList to set
	 */
	public void setAseguradorasList(List<AseguradoraDTO> aseguradorasList) {
		this.aseguradorasList = aseguradorasList;
	}

	/**
	 * @return the activarTabla
	 */
	public Boolean getActivarTabla() {
		return activarTabla;
	}

	/**
	 * @param activarTabla
	 *            the activarTabla to set
	 */
	public void setActivarTabla(Boolean activarTabla) {
		this.activarTabla = activarTabla;
	}

	/**
	 * @return the activarNewAseguradora
	 */
	public Boolean getActivarNewAseguradora() {
		return activarNewAseguradora;
	}

	/**
	 * @param activarNewAseguradora
	 *            the activarNewAseguradora to set
	 */
	public void setActivarNewAseguradora(Boolean activarNewAseguradora) {
		this.activarNewAseguradora = activarNewAseguradora;
	}

	/**
	 * 
	 * <b> Pemrite agregar un contacto </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addContacto() {
		contactoList = new ArrayList<PersonaContactoAseguradoraDTO>();
		PersonaContactoAseguradoraDTO item = new PersonaContactoAseguradoraDTO(this.nombre, this.apellidoMaterno, this.apellidoPaterno,
				this.identificacion, this.cargo, this.email, this.telefonoContacto);

		contactoList.add(item);

		nombre = "";
		apellidoMaterno = "";
		apellidoPaterno = "";
		identificacion = "";
		cargo = "";
		email = "";
		telefonoContacto = "";

		return null;
	}

	/**
	 * 
	 * <b> Permite agregar un nuevo ramo asociado a la aseguradora </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 10, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addRamo() {
		RamoDTO item = new RamoDTO(this.nombreRamo, this.comision);

		ramoList.add(item);

		nombreRamo = "";
		comision = new BigDecimal(0.0);

		return null;
	}

	/**
	 * 
	 * <b> Permite editar un contacto una vez ingresado </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((PersonaContactoAseguradoraDTO) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite editar una ramo ingresado </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 10, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void editRamo(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((RamoDTO) event.getObject()).getNombreRamo());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite eliminar un contacto </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		contactoList.remove((PersonaContactoAseguradoraDTO) event.getObject());
	}

	/**
	 * 
	 * <b> Permite eliminar un ramo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Aug 10, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void cancelRamo(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		contactoList.remove((RamoDTO) event.getObject());
	}
}
