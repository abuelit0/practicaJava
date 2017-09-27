package mx.isban.ejemplo.samples.dao;

import mx.isban.ejemplo.samples.beans.CicsBean;
import mx.isban.agave.commons.beans.ArchitechSessionBean;
import mx.isban.agave.commons.exception.ExceptionDataAccess;

/**
 * @author Arquitectura Tecnica
 * Interfaz de acceso a datos - base de datos
 */
public interface DAOSamplesCics {
	/**
	 * @param param Bean de ejemplo
	 * @param asb Objeto de arquitectura
	 * @return Objeto lleno con resultado
	 */
	public CicsBean usoIsbanDataAccessCics(CicsBean valor, ArchitechSessionBean asb) throws ExceptionDataAccess;

}
