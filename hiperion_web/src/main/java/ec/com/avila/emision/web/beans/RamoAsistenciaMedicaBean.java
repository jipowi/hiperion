/**
 * 
 */
package ec.com.avila.emision.web.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import ec.com.avila.hiperion.dto.ModalidadDependienteDTO;
import ec.com.avila.hiperion.dto.ModalidadFamiliaDTO;
import ec.com.avila.hiperion.dto.ModalidadTitularDTO;

/**
 * <b> Permite encapsular varios objetos en un unico objeto, para hacer uso de un solo objeto en lugar de varios mas simples </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,12/01/2014
 * @since JDK1.6
 */
@ManagedBean
@RequestScoped
public class RamoAsistenciaMedicaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// Tabla Ramo Asistencia Medica
	private BigDecimal totalMensualGrupo;

	private String filePolizaVigente;

	// Debo verificar este campo
	private String fileNotaPedido;

	// Tabla Limites Costos
	private String descripcion;
	private BigDecimal valorLimitesCostos;

	// Tabla beneficios adicionales
	private String beneficio;
	private BigDecimal valoBeneficiosAdicionales;

	// Tabla COND_PART_ASM
	private String condicion;
	private BigDecimal valor;

	// Campos Bean ModalidadTitular
	public String nombreTitular;
	public String cedulaTitular;
	public Date fechaNacimientoTitular;
	public Integer edadTitular;
	public BigDecimal primaNetaTitular;
	public Integer grupo;
	public BigDecimal valorGrupo;

	// Campos Bean ModalidadTitularDependiente
	public String nombreDependiente;
	public String cedulaDependiente;
	public Date fechaNacimientoDependiente;
	public Integer edadDependiente;
	public String parentescoDependiente;

	// Campos Bean ModalidadTitulaFamilia
	public String nombreFamilia;
	public String cedulaFamilia;
	public Date fechaNacimientoFamilia;
	public Integer edadFamilia;
	public String parentescoFamilia;

	private static final ArrayList<ModalidadDependienteDTO> titularDependienteList = new ArrayList<ModalidadDependienteDTO>();
	private static final ArrayList<ModalidadFamiliaDTO> titularFamiliaList = new ArrayList<ModalidadFamiliaDTO>();
	private static final ArrayList<ModalidadTitularDTO> titularList = new ArrayList<ModalidadTitularDTO>();

	/**
	 * @return the parentescoDependiente
	 */
	public String getParentescoDependiente() {
		return parentescoDependiente;
	}

	/**
	 * @param parentescoDependiente
	 *            the parentescoDependiente to set
	 */
	public void setParentescoDependiente(String parentescoDependiente) {
		this.parentescoDependiente = parentescoDependiente;
	}

	/**
	 * @return the parentescoFamilia
	 */
	public String getParentescoFamilia() {
		return parentescoFamilia;
	}

	/**
	 * @param parentescoFamilia
	 *            the parentescoFamilia to set
	 */
	public void setParentescoFamilia(String parentescoFamilia) {
		this.parentescoFamilia = parentescoFamilia;
	}

	/**
	 * @return the titularDependienteList
	 */
	public ArrayList<ModalidadDependienteDTO> getTitularDependienteList() {
		return titularDependienteList;
	}

	/**
	 * @return the titularFamiliaList
	 */
	public ArrayList<ModalidadFamiliaDTO> getTitularFamiliaList() {
		return titularFamiliaList;
	}

	/**
	 * @return the totalMensualGrupo
	 */
	public BigDecimal getTotalMensualGrupo() {
		return totalMensualGrupo;
	}

	/**
	 * @return the nombreTitular
	 */
	public String getNombreTitular() {
		return nombreTitular;
	}

	/**
	 * @param nombreTitular
	 *            the nombreTitular to set
	 */
	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	/**
	 * @return the cedulaTitular
	 */
	public String getCedulaTitular() {
		return cedulaTitular;
	}

	/**
	 * @param cedulaTitular
	 *            the cedulaTitular to set
	 */
	public void setCedulaTitular(String cedulaTitular) {
		this.cedulaTitular = cedulaTitular;
	}

	/**
	 * @return the fechaNacimientoTitular
	 */
	public Date getFechaNacimientoTitular() {
		return fechaNacimientoTitular;
	}

	/**
	 * @param fechaNacimientoTitular
	 *            the fechaNacimientoTitular to set
	 */
	public void setFechaNacimientoTitular(Date fechaNacimientoTitular) {
		this.fechaNacimientoTitular = fechaNacimientoTitular;
	}

	/**
	 * @return the edadTitular
	 */
	public Integer getEdadTitular() {
		return edadTitular;
	}

	/**
	 * @param edadTitular
	 *            the edadTitular to set
	 */
	public void setEdadTitular(Integer edadTitular) {
		this.edadTitular = edadTitular;
	}

	/**
	 * @return the primaNetaTitular
	 */
	public BigDecimal getPrimaNetaTitular() {
		return primaNetaTitular;
	}

	/**
	 * @param primaNetaTitular
	 *            the primaNetaTitular to set
	 */
	public void setPrimaNetaTitular(BigDecimal primaNetaTitular) {
		this.primaNetaTitular = primaNetaTitular;
	}

	/**
	 * @return the nombreDependiente
	 */
	public String getNombreDependiente() {
		return nombreDependiente;
	}

	/**
	 * @param nombreDependiente
	 *            the nombreDependiente to set
	 */
	public void setNombreDependiente(String nombreDependiente) {
		this.nombreDependiente = nombreDependiente;
	}

	/**
	 * @return the cedulaDependiente
	 */
	public String getCedulaDependiente() {
		return cedulaDependiente;
	}

	/**
	 * @param cedulaDependiente
	 *            the cedulaDependiente to set
	 */
	public void setCedulaDependiente(String cedulaDependiente) {
		this.cedulaDependiente = cedulaDependiente;
	}

	/**
	 * @return the fechaNacimientoDependiente
	 */
	public Date getFechaNacimientoDependiente() {
		return fechaNacimientoDependiente;
	}

	/**
	 * @param fechaNacimientoDependiente
	 *            the fechaNacimientoDependiente to set
	 */
	public void setFechaNacimientoDependiente(Date fechaNacimientoDependiente) {
		this.fechaNacimientoDependiente = fechaNacimientoDependiente;
	}

	/**
	 * @return the edadDependiente
	 */
	public Integer getEdadDependiente() {
		return edadDependiente;
	}

	/**
	 * @param edadDependiente
	 *            the edadDependiente to set
	 */
	public void setEdadDependiente(Integer edadDependiente) {
		this.edadDependiente = edadDependiente;
	}

	/**
	 * @return the nombreFamilia
	 */
	public String getNombreFamilia() {
		return nombreFamilia;
	}

	/**
	 * @param nombreFamilia
	 *            the nombreFamilia to set
	 */
	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}

	/**
	 * @return the cedulaFamilia
	 */
	public String getCedulaFamilia() {
		return cedulaFamilia;
	}

	/**
	 * @param cedulaFamilia
	 *            the cedulaFamilia to set
	 */
	public void setCedulaFamilia(String cedulaFamilia) {
		this.cedulaFamilia = cedulaFamilia;
	}

	/**
	 * @return the fechaNacimientoFamilia
	 */
	public Date getFechaNacimientoFamilia() {
		return fechaNacimientoFamilia;
	}

	/**
	 * @param fechaNacimientoFamilia
	 *            the fechaNacimientoFamilia to set
	 */
	public void setFechaNacimientoFamilia(Date fechaNacimientoFamilia) {
		this.fechaNacimientoFamilia = fechaNacimientoFamilia;
	}

	/**
	 * @return the edadFamilia
	 */
	public Integer getEdadFamilia() {
		return edadFamilia;
	}

	/**
	 * @param edadFamilia
	 *            the edadFamilia to set
	 */
	public void setEdadFamilia(Integer edadFamilia) {
		this.edadFamilia = edadFamilia;
	}

	/**
	 * @param totalMensualGrupo
	 *            the totalMensualGrupo to set
	 */
	public void setTotalMensualGrupo(BigDecimal totalMensualGrupo) {
		this.totalMensualGrupo = totalMensualGrupo;
	}

	/**
	 * @return the filePolizaVigente
	 */
	public String getFilePolizaVigente() {
		return filePolizaVigente;
	}

	/**
	 * @param filePolizaVigente
	 *            the filePolizaVigente to set
	 */
	public void setFilePolizaVigente(String filePolizaVigente) {
		this.filePolizaVigente = filePolizaVigente;
	}

	/**
	 * @return the fileNotaPedido
	 */
	public String getFileNotaPedido() {
		return fileNotaPedido;
	}

	/**
	 * @param fileNotaPedido
	 *            the fileNotaPedido to set
	 */
	public void setFileNotaPedido(String fileNotaPedido) {
		this.fileNotaPedido = fileNotaPedido;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the valorLimitesCostos
	 */
	public BigDecimal getValorLimitesCostos() {
		return valorLimitesCostos;
	}

	/**
	 * @param valorLimitesCostos
	 *            the valorLimitesCostos to set
	 */
	public void setValorLimitesCostos(BigDecimal valorLimitesCostos) {
		this.valorLimitesCostos = valorLimitesCostos;
	}

	/**
	 * @return the beneficio
	 */
	public String getBeneficio() {
		return beneficio;
	}

	/**
	 * @param beneficio
	 *            the beneficio to set
	 */
	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}

	/**
	 * @return the valoBeneficiosAdicionales
	 */
	public BigDecimal getValoBeneficiosAdicionales() {
		return valoBeneficiosAdicionales;
	}

	/**
	 * @param valoBeneficiosAdicionales
	 *            the valoBeneficiosAdicionales to set
	 */
	public void setValoBeneficiosAdicionales(BigDecimal valoBeneficiosAdicionales) {
		this.valoBeneficiosAdicionales = valoBeneficiosAdicionales;
	}

	/**
	 * @return the condicion
	 */
	public String getCondicion() {
		return condicion;
	}

	/**
	 * @param condicion
	 *            the condicion to set
	 */
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/**
	 * @return the grupo
	 */
	public Integer getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo
	 *            the grupo to set
	 */
	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the valorGrupo
	 */
	public BigDecimal getValorGrupo() {
		return valorGrupo;
	}

	/**
	 * @param valorGrupo
	 *            the valorGrupo to set
	 */
	public void setValorGrupo(BigDecimal valorGrupo) {
		this.valorGrupo = valorGrupo;
	}

	/**
	 * @return the titularlist
	 */
	public ArrayList<ModalidadTitularDTO> getTitularlist() {
		return titularList;
	}

	/**
	 * 
	 * <b> Permite agregar un dependiente. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 23/03/2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addActionTitularDependiente() {
		ModalidadDependienteDTO titularDependienteItem = new ModalidadDependienteDTO(this.nombreDependiente, this.cedulaDependiente,
				this.fechaNacimientoDependiente, this.edadDependiente, this.parentescoDependiente);

		titularDependienteList.add(titularDependienteItem);

		nombreDependiente = "";
		cedulaDependiente = "";
		fechaNacimientoDependiente = null;
		edadDependiente = 0;
		parentescoDependiente = "";

		return null;
	}

	/**
	 * 
	 * <b> Permite agregar un titular </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 18, 2014]
	 * </p>
	 * 
	 * @return
	 */
	public String addActionTitular() {
		ModalidadTitularDTO titularItem = new ModalidadTitularDTO(this.nombreTitular, this.cedulaTitular, this.fechaNacimientoTitular,
				this.edadTitular, this.primaNetaTitular, this.grupo, this.valorGrupo);

		titularList.add(titularItem);

		nombreTitular = "";
		cedulaTitular = "";
		fechaNacimientoTitular = null;
		edadTitular = 0;
		primaNetaTitular = new BigDecimal(0);
		grupo = 0;
		valorGrupo = new BigDecimal(0);

		return null;
	}

	/**
	 * 
	 * <b> Permite agregar un familiar </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 23/03/2014]
	 * </p>
	 * 
	 * @return
	 */

	public String addActionTitularFamilia() {
		ModalidadFamiliaDTO titularFamiliaItem = new ModalidadFamiliaDTO(this.nombreFamilia, this.cedulaFamilia, this.fechaNacimientoFamilia,
				this.edadFamilia, this.parentescoFamilia);

		titularFamiliaList.add(titularFamiliaItem);

		nombreTitular = "";
		cedulaTitular = "";
		fechaNacimientoTitular = null;
		edadTitular = 0;
		parentescoFamilia = "";

		return null;
	}

	/**
	 * 
	 * <b> Permite modificar el dependiente. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 23/03/2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditTitularDependiente(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ModalidadDependienteDTO) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite editar un titular </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 18, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditTitular(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ModalidadTitularDTO) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite modificar un familiar. </b>
	 * <p>
	 * [Author: Avila Sistemas, Date: 23/03/2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onEditTitularFamilia(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((ModalidadFamiliaDTO) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * 
	 * <b> Permite remover un titular dependiente. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 23/03/2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelTitularDependiente(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		titularDependienteList.remove((ModalidadDependienteDTO) event.getObject());
	}

	/**
	 * 
	 * <b> Permite eliminar un titular de la lista </b>
	 * <p>
	 * [Author: Paul Jimenez, Date: Jul 18, 2014]
	 * </p>
	 * 
	 * @param event
	 */
	public void onCancelTitular(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		titularList.remove((ModalidadTitularDTO) event.getObject());
	}

	/**
	 * 
	 * <b> Permite remover un titular mas Familia. </b>
	 * <p>
	 * [Author: Franklin Pozo, Date: 23/03/2014]
	 * </p>
	 * 
	 * @param event
	 */

	public void onCancelTitularFamilia(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Cancelled");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		titularFamiliaList.remove((ModalidadFamiliaDTO) event.getObject());
	}

}
