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
import mx.isban.agave.dataaccess.channels.cics.dto.RequestMessageCicsDTO;
import mx.isban.agave.dataaccess.channels.cics.dto.ResponseMessageCicsDTO;
import mx.isban.agave.dataaccess.channels.cics.utils.headers.HeaderPs7;
import mx.isban.agave.dataaccess.channels.cics.utils.headers.HeaderPs8;
import mx.isban.agave.dataaccess.factories.jms.ConfigFactoryJMS;
import mx.isban.ejemplo.samples.beans.CicsBean;
import mx.isban.ejemplo.samples.dao.DAOSamplesCics;

@Stateless
@Local(DAOSamplesCics.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class DAOSamplesCicsImpl extends Architech implements DAOSamplesCics {

	/** Serial version UID de la clase */
	private static final long serialVersionUID = 6711822210144483632L;

	/** ID de canal a acesar a datos */
	private static final String ID_CANAL = "CANAL_CICS";


	/*
	 * (non-Javadoc) 
	 * @see mx.isban.genericcics.principal.dao.DAOSamplesCics#usoIsbanDataAccessCics(mx.isban.genericcics.samples.beans.BeanSamples, mx.isban.agave.commons.beans.ArchitechSessionBean) 
	 */       
	@Override
	public CicsBean usoIsbanDataAccessCics(CicsBean valor, ArchitechSessionBean asb) throws ExceptionDataAccess {
		debug("Ejecutando B401");

        RequestMessageCicsDTO requestDTO = new RequestMessageCicsDTO();

        final StringBuilder mensajeParaTrama = new StringBuilder();
        CicsBean br = null;
        
        // Agregar header PS7 manualmente:
        // parametro de configuracion ADD_HEADER=FALSE
        /*
        mensajeParaTrama.append("    ")
	        .append(valor.getUsuario())
	        .append(valor.getTransaccion())
	        .append(valor.getLongitud())
	        .append("1123451O00N2")
	        .append(valor.getTrama());
         */
        
        // Agregar header PS7 desde IsbanDataAccess:        
        // parametro de configuracion ADD_HEADER=TRUE
        mensajeParaTrama.append(valor.getTrama());
        requestDTO.setHeaderPs7(armarHeaderPs7(valor));
        
        // Agregar header PS8 parametro ADD_PS8_HEADER = TRUE | AUTO. 
        // Se puede modificar en el archivo de configuracion, en caso e que no se tenga indicado el valor default es AUTO
        requestDTO.setHeaderPs8(armarHeaderPs8());
        
        // Llenando informacion general del dto
        requestDTO.setCodeOperation("COD_OPER_TEST_01_ENVIO_CICS");
        requestDTO.setTypeOperation(ConfigFactoryJMS.OPERATION_TYPE_SEND_AND_RECEIVE_MESSAGE);
//        requestDTO.setTimeout(30000); // Opcional, si no se especifica se toma del archivo de
//                                  // configuracion xml
//        requestDTO.setUser("DEIFSNMX"); // Opcional, si no se especifica se toma del archivo de
//                                       // configuracion xml
        if(valor.getUsuario()!=null && !valor.getUsuario().isEmpty()){
        	requestDTO.setUser(valor.getUsuario());
        }
        requestDTO.setTransaction(valor.getTransaccion());
        requestDTO.setMessage(mensajeParaTrama.toString());

        // Ejecutando operación
        long iniTime = info("inicio envio trama", 0L);
        DataAccess ida = DataAccess.getInstance(requestDTO, this.getLoggingBean());
        ResponseMessageCicsDTO responseDTO = (ResponseMessageCicsDTO) ida.execute(ID_CANAL);
        info("fin recepcion trama", iniTime);
        
        // Explotando resultados
        debug("Respuesta que regresa el CICS a la transacción solicitada   : " + responseDTO.getResponseMessage());
        debug("Código de error                 : " + responseDTO.getCodeError());
        debug("Mensaje de error                : " + responseDTO.getMessageError());
        debug("Resultado en Json               : " + responseDTO.getResultToJSONString());

        if (!ConfigFactoryJMS.CODE_SUCCESFULLY.equals(responseDTO.getCodeError())) {
			throw new ExceptionDataAccess(responseDTO.getClass().getName(), responseDTO.getCodeError(), responseDTO.getMessageError());
        }
    
        br = new CicsBean();
        br.setRespuesta(responseDTO.getResponseMessage());
        
		return br;
	}


	/**
	 * @param requestDTO DTO de request
	 * @param valor Bean con valores
	 * @return Objeto de Header armado
	 */
	private HeaderPs7 armarHeaderPs7( CicsBean valor){
	    // ADD HEADER PS7 TRUE - Se puede realizar la sobreescritura de lo que esta configurado
        HeaderPs7 headerPs7 = new HeaderPs7();
        headerPs7.setUser("DEIFSNMX"); //Opcional, si no se especifica se toma del archivo de configuracion xml
        headerPs7.setTransaction(valor.getTransaccion()); //Obligatorio

        return headerPs7;
	}
	

	/**
	 * @return Objeto de Header armado
	 */
	private HeaderPs8 armarHeaderPs8(){
	    // ADD_PS8_HEADER = TRUE | AUTO
	    // Los datos enviados en este parametro seran usado para la cadena de PS8
	    // En caso de que no se envie el objeto se van a colocar espacios en blanco
		HeaderPs8 headerPs8 = new HeaderPs8();
        //datos de prueba
        headerPs8.setCodeChannel("001");
        headerPs8.setIp("180.176.16.28");
        headerPs8.setCodeTransaccion("PE68");
        headerPs8.setNumberTransaccion("PE68");
		headerPs8.setTypeCustomer("01");
		headerPs8.setIdCustomer("00002030");
		headerPs8.setTypeAuthenticating("01");
		headerPs8.setTypeFirm("01");
		headerPs8.setCodeApp("0001");
		headerPs8.setVersionMessage("01");
		headerPs8.setUseInfrastructure("01");
		headerPs8.setDateApp("01");
        return headerPs8;
	}
}