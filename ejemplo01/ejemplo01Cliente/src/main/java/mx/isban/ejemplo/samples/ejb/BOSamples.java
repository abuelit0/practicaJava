package mx.isban.ejemplo.samples.ejb;

import java.util.Map;

import mx.isban.agave.commons.beans.ArchitechSessionBean;
import mx.isban.agave.commons.exception.BusinessException;
import mx.isban.agave.dataaccess.channels.cics.dto.ResponseMessageCicsDTO;
import mx.isban.agave.dataaccess.channels.partenon.dto.ResponseMessagePartenonDTO;
import mx.isban.ejemplo.samples.beans.CicsBean;
import mx.isban.ejemplo.samples.beans.ResultSamplesBean;
import mx.isban.ejemplo.samples.beans.SamplesBean;

/**
 * @author Arquitectura Tecnica
 * Interfaz de servicio de negocio de ejemplos
 */
public interface BOSamples {
	
	/**
	 * Uso isban data access database.
	 *
	 * @param valor el parametro valor
	 * @param asb Objeto de arquitectura
	 * @return Objeto lleno con resultado
	 * @throws BusinessException the business exception
	 */
	public ResultSamplesBean usoIsbanDataAccessDatabase(SamplesBean valor, ArchitechSessionBean asb) 
			throws BusinessException;
	
	/**
	 * Uso isban data access mq.
	 *
	 * @param valor el parametro valor
	 * @param asb Objeto de arquitectura
	 * @return Objeto lleno con resultado
	 * @throws BusinessException the business exception
	 */
	public ResultSamplesBean usoIsbanDataAccessMq(SamplesBean valor, ArchitechSessionBean asb) 
			throws BusinessException;
	
	/**
	 * Uso isban data access cics.
	 *
	 * @param valor el parametro valor
	 * @param asb Objeto de arquitectura
	 * @return Objeto lleno con resultado
	 * @throws BusinessException the business exception
	 */
	public CicsBean usoIsbanDataAccessCics(CicsBean valor,
			ArchitechSessionBean asb) throws BusinessException;
	


	/**
	 * Uso auditoria trans.
	 *
	 * @param valor el parametro valor
	 * @param asb Objeto de arquitectura
	 * @return Objeto lleno con resultado
	 * @throws BusinessException the business exception
	 */
	public ResultSamplesBean usoAuditoriaTrans(SamplesBean valor, ArchitechSessionBean asb) 
			throws BusinessException;
	
	/**
	 * Uso auditoria admin.
	 *
	 * @param valor el parametro valor
	 * @param asb Objeto de arquitectura
	 * @return Objeto lleno con resultado
	 * @throws BusinessException the business exception
	 */
	public ResultSamplesBean usoAuditoriaAdmin(SamplesBean valor, ArchitechSessionBean asb) 
			throws BusinessException;
	
	/**
	 * Uso auditoria bitacora.
	 *
	 * @param valor the valor
	 * @param asb Objeto de arquitectura
	 * @return Objeto lleno con resultado
	 * @throws BusinessException the business exception
	 */
	public ResultSamplesBean usoAuditoriaBitacora(SamplesBean valor, ArchitechSessionBean asb)
			throws BusinessException;
	
	/**
	 * Uso mensajeria.
	 *
	 * @param valor the valor
	 * @param asb Objeto de arquitectura
	 * @return Objeto lleno con resultado
	 * @throws BusinessException the business exception
	 */
	public ResultSamplesBean usoMensajeria(SamplesBean valor, ArchitechSessionBean asb)
			throws BusinessException;

    public ResponseMessagePartenonDTO usoIsbanDataAccessPartenonMetadata(Map<String, String> valoresCabecera, ArchitechSessionBean asb) throws BusinessException;
    public ResponseMessagePartenonDTO usoIsbanDataAccessPartenonTrx(Map<String, String> valoresCabecera, Map<String, Object[]> paramIn, ArchitechSessionBean asb) throws BusinessException;

    public ResponseMessagePartenonDTO usoIsbanDataAccessPartenonVersion(ArchitechSessionBean asb) throws BusinessException;




}
