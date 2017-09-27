package mx.isban.ejemplo.samples.dao;

import java.util.Map;

import mx.isban.agave.commons.beans.ArchitechSessionBean;
import mx.isban.agave.commons.exception.ExceptionDataAccess;
import mx.isban.agave.dataaccess.channels.partenon.dto.ResponseMessagePartenonDTO;

public interface DAOSamplesPartenon {

    ResponseMessagePartenonDTO usoIsbanDataAccessPartenonTrx(Map<String, String> mapaCabeceras, Map<String, Object[]> paramIn, ArchitechSessionBean asb) throws ExceptionDataAccess;

    ResponseMessagePartenonDTO usoIsbanDataAccessPartenonMetadata(Map<String, String> mapaCabeceras, ArchitechSessionBean asb) throws ExceptionDataAccess;

    ResponseMessagePartenonDTO usoIsbanDataAccessPartenonVersion(ArchitechSessionBean asb) throws ExceptionDataAccess;

}
