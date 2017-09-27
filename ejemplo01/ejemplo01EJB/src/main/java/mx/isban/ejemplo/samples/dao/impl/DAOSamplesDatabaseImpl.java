package mx.isban.ejemplo.samples.dao.impl;


import java.util.HashMap;
import java.util.Map.Entry;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import mx.isban.agave.commons.architech.Architech;
import mx.isban.agave.commons.beans.ArchitechSessionBean;
import mx.isban.agave.commons.beans.LoggingBean;
import mx.isban.agave.commons.exception.ExceptionDataAccess;
import mx.isban.agave.dataaccess.DataAccess;
import mx.isban.agave.dataaccess.channels.database.dto.RequestMessageDataBaseDTO;
import mx.isban.agave.dataaccess.channels.database.dto.ResponseMessageDataBaseDTO;
import mx.isban.agave.dataaccess.factories.jdbc.ConfigFactoryJDBC;
import mx.isban.agave.dataaccess.factories.jms.ConfigFactoryJMS;
import mx.isban.ejemplo.samples.beans.ResultSamplesBean;
import mx.isban.ejemplo.samples.beans.SamplesBean;
import mx.isban.ejemplo.samples.dao.DAOSamplesDatabase;

@Stateless
@Local(DAOSamplesDatabase.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class DAOSamplesDatabaseImpl extends Architech implements DAOSamplesDatabase {

	/** Serial version UID de la clase */
	private static final long serialVersionUID = 6711822210144483632L;
	
	/** ID de canal a acesar a datos */
	private static final String ID_CANAL = "CANAL_ARQ_BD";


	/*
	 * (non-Javadoc) 
	 * @see mx.isban.ejemplo.principal.dao.DAOSamplesDatabase#usoIsbanDataAccessDatabase(mx.isban.ejemplo.samples.beans.BeanSamples, mx.isban.agave.commons.beans.ArchitechSessionBean) 
	 */
	@Override
	public ResultSamplesBean usoIsbanDataAccessDatabase(SamplesBean valor, ArchitechSessionBean asb) throws ExceptionDataAccess {
		debug("Ejecutando TRX LB08");

    	ResultSamplesBean brs = null;

		RequestMessageDataBaseDTO requestDTO = new RequestMessageDataBaseDTO();
		final StringBuffer query = new StringBuffer();
	   
		query.append("select * from tabla WHERE id_param = ?");

	   // Llenando informacion general del dto
	   requestDTO.setCodeOperation("COD_OPER_TEST_03_QUERY");
	   requestDTO.setTypeOperation(ConfigFactoryJDBC.OPERATION_TYPE_QUERY_PARAMS);
	   requestDTO.setTimeout(10); // Opcional
	   requestDTO.setQuery(query.toString());

		requestDTO.addParamToSql(valor.getParamA());
	

        // Ejecutando operación
	   ResponseMessageDataBaseDTO responseDTO;
		DataAccess ida = DataAccess.getInstance(requestDTO, new LoggingBean());
		responseDTO = (ResponseMessageDataBaseDTO) ida.execute(ID_CANAL);
		
		// Explotando resultados
		debug("Respuesta que regresa la BD al query solicitado   : " + responseDTO.getResultQuery());
		debug("Respuesta que regresa la BD al query solicitado formato json  : " + responseDTO.getResultToJSONString());
		debug("Código de error: " + responseDTO.getCodeError());
		debug("Mensaje de error: " + responseDTO.getMessageError());
		
		if (!ConfigFactoryJMS.CODE_SUCCESFULLY.equals(responseDTO.getCodeError())) {
			throw new ExceptionDataAccess(responseDTO.getClass().getName(), responseDTO.getCodeError(), responseDTO.getMessageError());
		}
		if(!responseDTO.getResultQuery().isEmpty()){
			brs = new ResultSamplesBean();
			for (HashMap<String, Object> map : responseDTO.getResultQuery()) {
		       debug("Mostrando los valores del registro....");
		       for (Entry<String, Object> entry : map.entrySet()) {
		    	   brs.setParamA((String) entry.getValue());
		          debug("\tCampo nombre[" + entry.getKey() + "] - valor[" + entry.getValue() + "]");
		       
		       }
		   }
		}

		
		return brs;
	}
}