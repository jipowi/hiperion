/*
 * Copyright 2014 JIPOVI Solutions - ECUADOR 
 * Todos los derechos reservados
 */
package ec.com.avila.hiperion.dao;

import javax.ejb.Local;

import ec.com.avila.hiperion.emision.entities.RamoAccidentesPersonale;

/**
 * <b> Interface local de la tabla RamoAccidentesPersonale </b>
 * 
 * @author Franklin Pozo
 * @version 1.0,30/12/2013
 * @since JDK1.6
 */
@Local
public interface RamoAccidentesPersonalesDao extends GenericDAO<RamoAccidentesPersonale, Long> {

}
