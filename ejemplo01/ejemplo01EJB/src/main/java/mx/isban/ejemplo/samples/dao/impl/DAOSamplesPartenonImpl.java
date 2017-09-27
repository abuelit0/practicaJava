package mx.isban.ejemplo.samples.dao.impl;

import java.util.Arrays;
import java.util.Map;
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
import mx.isban.agave.dataaccess.channels.partenon.dto.RequestMessagePartenonDTO;
import mx.isban.agave.dataaccess.channels.partenon.dto.ResponseMessagePartenonDTO;
import mx.isban.agave.dataaccess.channels.partenon.util.EnumTiposOperacionPartenon;
import mx.isban.agave.dataaccess.factories.partenon.ConfigFactoryPartenon;
import mx.isban.ejemplo.samples.dao.DAOSamplesPartenon;

@Stateless
@Local(DAOSamplesPartenon.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class DAOSamplesPartenonImpl extends Architech implements DAOSamplesPartenon {

    private static final long serialVersionUID = -8904404824977858608L;
    /** ID de canal a acesar a datos */
    private static final String ID_CANAL = "CANAL_PARTENON";

    /*
     * (non-Javadoc)
     * 
     * @see mx.isban.genericcics.principal.dao.DAOSamplesCics#usoIsbanDataAccessCics(mx.isban.genericcics.samples.beans.BeanSamples, mx.isban.agave.commons.beans.ArchitechSessionBean)
     */
    @Override
    public ResponseMessagePartenonDTO usoIsbanDataAccessPartenonMetadata(Map<String, String> valoresCabecera, ArchitechSessionBean asb) throws ExceptionDataAccess {
        debug("Ejecutando usoIsbanDataAccessPartenonMetadata");

        RequestMessagePartenonDTO requestDTO = new RequestMessagePartenonDTO();

        // Parametro Opcional, si no esta informado se ejecuta una operacion de consulta
        requestDTO.setTipoOperacionExec(EnumTiposOperacionPartenon.OPERACION_GET_METADATA);

        requestDTO.setTrxName((String) valoresCabecera.get("TRX_NAME"));
        requestDTO.setTrxOperacion((String) valoresCabecera.get("TRX_OPERACION"));
        requestDTO.setTrxVersion((String) valoresCabecera.get("TRX_VERSION"));

        // Ejecutando operación
        long iniTime = info("inicio envio trama", 0L);
        DataAccess ida = DataAccess.getInstance(requestDTO, this.getLoggingBean());
        ResponseMessagePartenonDTO responseDTO = (ResponseMessagePartenonDTO) ida.execute(ID_CANAL);
        info("fin recepcion trama", iniTime);

        // Explotando resultados
        debug("Respuesta que regresa Partenon a la transacción solicitada   : " + responseDTO.getMessageError());
        debug("Código de error                 : " + responseDTO.getCodeError());
        debug("Mensaje de error                : " + responseDTO.getMessageError());
        debug("Resultado en Json Metadata      : " + responseDTO.getMetadata());

        if (!ConfigFactoryPartenon.CODE_SUCCESFULLY.equals(responseDTO.getCodeError())) {
            throw new ExceptionDataAccess(responseDTO.getClass().getName(), responseDTO.getCodeError(), responseDTO.getMessageError());
        }

        return responseDTO;
    }

    @Override
    public ResponseMessagePartenonDTO usoIsbanDataAccessPartenonTrx(Map<String, String> valoresCabecera, Map<String, Object[]> paramIn, ArchitechSessionBean asb) throws ExceptionDataAccess {
        debug("Ejecutando usoIsbanDataAccessPartenonTrx");

        RequestMessagePartenonDTO requestDTO = new RequestMessagePartenonDTO();

        requestDTO.setTrxName((String) valoresCabecera.get("TRX_NAME"));
        requestDTO.setTrxOperacion((String) valoresCabecera.get("TRX_OPERACION"));
        requestDTO.setTrxVersion((String) valoresCabecera.get("TRX_VERSION"));

        requestDTO.setEmpresa((String) valoresCabecera.get("EMPRESA"));
        requestDTO.setCentro((String) valoresCabecera.get("CENTRO"));
        requestDTO.setPuestoFisico((String) valoresCabecera.get("PUESTO_FISICO"));
        requestDTO.setTipoTerminal((String) valoresCabecera.get("TIPO_TERMINAL"));
        requestDTO.setIdioma((String) valoresCabecera.get("IDIOMA"));
        requestDTO.setCanalFisico((String) valoresCabecera.get("CANAL_FISICO"));
        requestDTO.setCanalLogico((String) valoresCabecera.get("CANAL_LOGICO"));
        
        requestDTO.setParamsIn(paramIn);
        
        trace("Valores a Enviar: ");
        for (Entry<String, Object[]> entry : paramIn.entrySet()) {
            trace("Llave: " + entry.getKey() + " Valor: " + Arrays.toString(entry.getValue()));
        }

        // Ejecutando operación
        long iniTime = info("inicio envio trama", 0L);
        DataAccess ida = DataAccess.getInstance(requestDTO, this.getLoggingBean());
        ResponseMessagePartenonDTO responseDTO = (ResponseMessagePartenonDTO) ida.execute(ID_CANAL);
        info("fin recepcion trama", iniTime);

        // Explotando resultados
        debug("Respuesta que regresa Partenon a la transacción solicitada   : " + responseDTO.getMessageError());
        debug("Código de error                 : " + responseDTO.getCodeError());
        debug("Mensaje de error                : " + responseDTO.getMessageError());
        debug("Resultado en Json               : " + responseDTO.getResultToJSONString());

        if (!ConfigFactoryPartenon.CODE_SUCCESFULLY.equals(responseDTO.getCodeError())) {
            throw new ExceptionDataAccess(responseDTO.getClass().getName(), responseDTO.getCodeError(), responseDTO.getMessageError());
        }

        return responseDTO;
    }
    
    @Override
    public ResponseMessagePartenonDTO usoIsbanDataAccessPartenonVersion(ArchitechSessionBean asb) throws ExceptionDataAccess {
        debug("Ejecutando usoIsbanDataAccessPartenonVersion");

        RequestMessagePartenonDTO requestDTO = new RequestMessagePartenonDTO();

        // Parametro Opcional, si no esta informado se ejecuta una operacion de consulta
        requestDTO.setTipoOperacionExec(EnumTiposOperacionPartenon.OPERACION_GET_VERSION);

        // Ejecutando operación
        long iniTime = info("inicio envio trama", 0L);
        DataAccess ida = DataAccess.getInstance(requestDTO, this.getLoggingBean());
        ResponseMessagePartenonDTO responseDTO = (ResponseMessagePartenonDTO) ida.execute(ID_CANAL);
        info("fin recepcion trama", iniTime);

        // Explotando resultados
        debug("Respuesta que regresa Partenon a la transacción solicitada   : " + responseDTO.getMessageError());
        debug("Código de error                 : " + responseDTO.getCodeError());
        debug("Mensaje de error                : " + responseDTO.getMessageError());
        debug("Resultado de la version         : " + responseDTO.getVersion());

        if (!ConfigFactoryPartenon.CODE_SUCCESFULLY.equals(responseDTO.getCodeError())) {
            throw new ExceptionDataAccess(responseDTO.getClass().getName(), responseDTO.getCodeError(), responseDTO.getMessageError());
        }

        return responseDTO;
    }

}