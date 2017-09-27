package mx.isban.ejemplo.samples.dao.impl;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import mx.isban.agave.commons.architech.Architech;
import mx.isban.agave.commons.beans.ArchitechSessionBean;
import mx.isban.agave.commons.beans.LoggingBean;
import mx.isban.agave.commons.exception.ExceptionDataAccess;
import mx.isban.agave.dataaccess.DataAccess;
import mx.isban.agave.dataaccess.channels.genericmq.dto.RequestMessageGenericMQDTO;
import mx.isban.agave.dataaccess.channels.genericmq.dto.ResponseMessageGenericMQDTO;
import mx.isban.agave.dataaccess.factories.jmsgeneric.ConfigFactoryJMSGeneric;
import mx.isban.ejemplo.samples.beans.ResultSamplesBean;
import mx.isban.ejemplo.samples.beans.SamplesBean;
import mx.isban.ejemplo.samples.dao.DAOSamplesMq;

@Stateless
@Local(DAOSamplesMq.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class DAOSamplesMqImpl extends Architech implements DAOSamplesMq {

	/** Serial version UID de la clase */
	private static final long serialVersionUID = 6711822210144483632L;

	/** ID de canal a acesar a datos */
	private static final String ID_CANAL = "ID_CANAL_GENERIC_MQ_ASINCRONA";


	/*
	 * (non-Javadoc) 
	 * @see mx.isban.ejemplo.principal.dao.DAOSamplesMq#usoIsbanDataAccessMq(mx.isban.ejemplo.samples.beans.BeanSamples, mx.isban.agave.commons.beans.ArchitechSessionBean) 
	 */
	@Override
	public ResultSamplesBean usoIsbanDataAccessMq(SamplesBean valor, ArchitechSessionBean asb) throws ExceptionDataAccess {
		debug("Ejecutando TRX LB08");

        RequestMessageGenericMQDTO requestDTO = new RequestMessageGenericMQDTO();

        final StringBuilder mensaje = new StringBuilder();
        mensaje.append("Mensaje de Hola Mundo");

        // Llenando informacion general del dto
        requestDTO.setCodeOperation("COD_OPER_TEST_02_ENVIO_ASINCRONO");
        requestDTO.setTypeOperation(ConfigFactoryJMSGeneric.OPERATION_TYPE_SEND_MESSAGE);
        requestDTO.setTimeout(3000); // Opcional, sino se especifica se toma del archivo de
                                  // configuracion xml
        requestDTO.setIdCorraletion("13456789"); // Opcional, sino se especifica el queue manager le asigna uno por defecto
        requestDTO.setMessage(mensaje.toString());

        // Ejecutando operacion
        DataAccess ida = DataAccess.getInstance(requestDTO, new LoggingBean());
        ResponseMessageGenericMQDTO responseDTO = (ResponseMessageGenericMQDTO) ida.execute(ID_CANAL);

        // Explotando resultados
        debug("Respuesta que regresa el Proceso de la peticion solicitada   : " + responseDTO.getResponseMessage());
        debug("Código de error                 : " + responseDTO.getCodeError());
        debug("Mensaje de error                : " + responseDTO.getMessageError());
        debug("Resultado en Json               : " + responseDTO.getResultToJSONString());

        if (!ConfigFactoryJMSGeneric.CODE_SUCCESFULLY.equals(responseDTO.getCodeError())) {
        	throw new ExceptionDataAccess(responseDTO.getClass().getName(), responseDTO.getCodeError(), responseDTO.getMessageError());
        } // este valor
    

		return null;
	}
}