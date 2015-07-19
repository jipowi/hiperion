package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ec.com.avila.hiperion.dto.GrupoAccPersonalesDTO;

/**
 * s
 * 
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples. </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,12/01/2014
 * @since JDK1.6
 */
@ManagedBean
@ViewScoped
public class RamoAccidentesPersonalesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Tabla RamoAccidentesPersonales
	private BigDecimal primaNetaPersona;
	private BigDecimal primaTotalPersona;
	private BigDecimal tasa;
	private Integer facturacion;
	private BigDecimal deducible;

	// Tabla ClausulasAddAccPer
	private String clausula;

	// Tabla Grupos
	private String grupo;
	private Integer numGrupo;
	private String nomGrupo;
	private Integer numPersonas;
	private String actividad;
	private Double valorGrupo;

	// Tabla miembros grupo
	private String nombre;
	private String cedula;
	private Date fechaNacimiento;
	private String parentezco;
	private String sexo;
	private Integer edad;

	// Coberturas grupo
	private String cebertura;
	private BigDecimal valorCobertura;

	private static List<GrupoAccPersonalesDTO> grupos = new ArrayList<GrupoAccPersonalesDTO>();

	// Getters and Setters
	/**
	 * @return the primaNetaPersona
	 */
	public BigDecimal getPrimaNetaPersona() {
		return primaNetaPersona;
	}

	/**
	 * @param primaNetaPersona
	 *            the primaNetaPersona to set
	 */
	public void setPrimaNetaPersona(BigDecimal primaNetaPersona) {
		this.primaNetaPersona = primaNetaPersona;
	}

	/**
	 * @return the primaTotalPersona
	 */
	public BigDecimal getPrimaTotalPersona() {
		return primaTotalPersona;
	}

	/**
	 * @param primaTotalPersona
	 *            the primaTotalPersona to set
	 */
	public void setPrimaTotalPersona(BigDecimal primaTotalPersona) {
		this.primaTotalPersona = primaTotalPersona;
	}

	/**
	 * @return the clausula
	 */
	public String getClausula() {
		return clausula;
	}

	/**
	 * @param clausula
	 *            the clausula to set
	 */
	public void setClausula(String clausula) {
		this.clausula = clausula;
	}

	/**
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo
	 *            the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the numGrupo
	 */
	public Integer getNumGrupo() {
		return numGrupo;
	}

	/**
	 * @param numGrupo
	 *            the numGrupo to set
	 */
	public void setNumGrupo(Integer numGrupo) {
		this.numGrupo = numGrupo;
	}

	/**
	 * @return the nomGrupo
	 */
	public String getNomGrupo() {
		return nomGrupo;
	}

	/**
	 * @param nomGrupo
	 *            the nomGrupo to set
	 */
	public void setNomGrupo(String nomGrupo) {
		this.nomGrupo = nomGrupo;
	}

	/**
	 * @return the numPersonas
	 */
	public Integer getNumPersonas() {
		return numPersonas;
	}

	/**
	 * @param numPersonas
	 *            the numPersonas to set
	 */
	public void setNumPersonas(Integer numPersonas) {
		this.numPersonas = numPersonas;
	}

	/**
	 * @return the actividad
	 */
	public String getActividad() {
		return actividad;
	}

	/**
	 * @param actividad
	 *            the actividad to set
	 */
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	/**
	 * @return the valorGrupo
	 */
	public Double getValorGrupo() {
		return valorGrupo;
	}

	/**
	 * @param valorGrupo
	 *            the valorGrupo to set
	 */
	public void setValorGrupo(Double valorGrupo) {
		this.valorGrupo = valorGrupo;
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
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento
	 *            the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the parentezco
	 */
	public String getParentezco() {
		return parentezco;
	}

	/**
	 * @param parentezco
	 *            the parentezco to set
	 */
	public void setParentezco(String parentezco) {
		this.parentezco = parentezco;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}

	/**
	 * @param edad
	 *            the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	/**
	 * @return the cebertura
	 */
	public String getCebertura() {
		return cebertura;
	}

	/**
	 * @param cebertura
	 *            the cebertura to set
	 */
	public void setCebertura(String cebertura) {
		this.cebertura = cebertura;
	}

	/**
	 * @return the valorCobertura
	 */
	public BigDecimal getValorCobertura() {
		return valorCobertura;
	}

	/**
	 * @param valorCobertura
	 *            the valorCobertura to set
	 */
	public void setValorCobertura(BigDecimal valorCobertura) {
		this.valorCobertura = valorCobertura;
	}

	public Integer getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(Integer facturacion) {
		this.facturacion = facturacion;
	}

	public BigDecimal getTasa() {
		return tasa;
	}

	public void setTasa(BigDecimal tasa) {
		this.tasa = tasa;
	}

	public BigDecimal getDeducible() {
		return deducible;
	}

	public void setDeducible(BigDecimal deducible) {
		this.deducible = deducible;
	}

	/**
	 * @return the grupos
	 */
	public List<GrupoAccPersonalesDTO> getGrupos() {
		return grupos;
	}

	/**
	 * @param grupos
	 *            the grupos to set
	 */
	public static void setGrupos(List<GrupoAccPersonalesDTO> grupos) {
		RamoAccidentesPersonalesBean.grupos = grupos;
	}

	/**
	 * 
	 * <b> Permite agregar un registro de grupo a la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: 05/01/2015]
	 * </p>
	 * 
	 * @return
	 */
	public String addGrupo() {
		GrupoAccPersonalesDTO grupo = new GrupoAccPersonalesDTO(this.numGrupo, this.nomGrupo, this.numPersonas, this.actividad, this.valorGrupo);
		grupos.add(grupo);

		numGrupo = 0;
		nomGrupo = "";
		numPersonas = 0;
		actividad = "";
		valorGrupo = 0.0;

		return null;
	}

	/**
	 * 
	 * <b> Permite editar un grupo </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((GrupoAccPersonalesDTO) event.getObject()).getNumGrupo().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite remover un objeto asegurado de la tabla </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Mar 3, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		grupos.remove((GrupoAccPersonalesDTO) event.getObject());
	}

}
