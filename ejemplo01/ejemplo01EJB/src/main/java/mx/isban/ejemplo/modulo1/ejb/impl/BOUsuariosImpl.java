package mx.isban.ejemplo.modulo1.ejb.impl;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import mx.isban.agave.commons.architech.Architech;
import mx.isban.agave.commons.beans.ArchitechSessionBean;
import mx.isban.agave.commons.beans.LoggingBean;
import mx.isban.agave.commons.exception.BusinessException;
import mx.isban.agave.commons.exception.ExceptionDataAccess;
import mx.isban.agave.dataaccess.DataAccess;
import mx.isban.agave.dataaccess.channels.cics.dto.RequestMessageCicsDTO;
import mx.isban.agave.dataaccess.channels.cics.dto.ResponseMessageCicsDTO;
import mx.isban.agave.dataaccess.factories.jms.ConfigFactoryJMS;
import mx.isban.ejemplo.modulo1.beans.ResultUsuarioBean;
import mx.isban.ejemplo.modulo1.beans.UsuarioBean;
import mx.isban.ejemplo.modulo1.ejb.BOUsuarios;

@Stateless
@Remote(BOUsuarios.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class BOUsuariosImpl extends Architech implements BOUsuarios {
	
	private static final long serialVersionUID = 6711822210144483632L;

	private static final String ID_CANAL = "CANAL_CICS";
	
	private static final String TRAMA = "%, $, , : ; clientes@santander.com.mx;";
	
	@Resource
	private SessionContext scontext;
	
	/*
	 * (non-Javadoc)
	 * @see mx.isban.ejemplo.modulo1.ejb.BOUsuarios#validaUsuario(mx.isban.ejemplo.modulo1.beans.BeanUsuario, mx.isban.agave.commons.beans.ArchitechSessionBean)
	 */
	@Override
	public ResultUsuarioBean validaUsuario(UsuarioBean valor, ArchitechSessionBean asb) throws BusinessException {
		debug("Ejecutando TRX LB08");
		debug("Principal: "+scontext.getCallerPrincipal());
		RequestMessageCicsDTO requestDTO = new RequestMessageCicsDTO();
		requestDTO.setCodeOperation("COD_OPER_TEST_01_ENVIO_CICS");
		requestDTO.setTypeOperation(ConfigFactoryJMS.OPERATION_TYPE_SEND_AND_RECEIVE_MESSAGE);
        requestDTO.setMessage(TRAMA);

        // Ejecutando operación
        ResponseMessageCicsDTO responseDTO;
		try {
			DataAccess ida = DataAccess.getInstance(requestDTO, new LoggingBean());
			responseDTO = (ResponseMessageCicsDTO) ida.execute(ID_CANAL);
			
			// Explotando resultados
			debug("Respuesta que regresa el CICS a la transacción solicitada   : " + responseDTO.getResponseMessage());
			debug("Código de error: " + responseDTO.getCodeError());
			debug("Mensaje de error: " + responseDTO.getMessageError());
			debug("Resultado en Json: " + responseDTO.getResultToJSONString());
			
			if (!ConfigFactoryJMS.CODE_SUCCESFULLY.equals(responseDTO.getCodeError())) {
				throw new BusinessException(responseDTO.getCodeError(), responseDTO.getMessageError());
			}
		} catch (ExceptionDataAccess e) {
			showException(e);
		}
		return null;
	}
}