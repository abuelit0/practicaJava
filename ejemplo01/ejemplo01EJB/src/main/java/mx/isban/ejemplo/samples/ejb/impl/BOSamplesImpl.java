package mx.isban.ejemplo.samples.ejb.impl;

import java.util.Date;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import mx.isban.agave.auditoria.Auditoria;
import mx.isban.agave.commons.architech.Architech;
import mx.isban.agave.commons.beans.ArchitechSessionBean;
import mx.isban.agave.commons.beans.AuditAdminBean;
import mx.isban.agave.commons.beans.AuditTransBean;
import mx.isban.agave.commons.beans.BitacoraBean;
import mx.isban.agave.commons.beans.MessageBean;
import mx.isban.agave.commons.exception.AuditoriaException;
import mx.isban.agave.commons.exception.BusinessException;
import mx.isban.agave.commons.exception.ExceptionDataAccess;
import mx.isban.agave.commons.exception.MensajeClientException;
import mx.isban.agave.dataaccess.channels.cics.dto.ResponseMessageCicsDTO;
import mx.isban.agave.dataaccess.channels.partenon.dto.ResponseMessagePartenonDTO;
import mx.isban.agave.mensajeria.MensajeClient;
import mx.isban.ejemplo.samples.beans.CicsBean;
import mx.isban.ejemplo.samples.beans.ResultSamplesBean;
import mx.isban.ejemplo.samples.beans.SamplesBean;
import mx.isban.ejemplo.samples.dao.DAOSamplesCics;
import mx.isban.ejemplo.samples.dao.DAOSamplesDatabase;
import mx.isban.ejemplo.samples.dao.DAOSamplesMq;
import mx.isban.ejemplo.samples.dao.DAOSamplesPartenon;
import mx.isban.ejemplo.samples.dao.impl.DAOSamplesEjecutor;
import mx.isban.ejemplo.samples.ejb.BOSamples;

/**
 * La clase BOSamplesImpl.
 */
@Stateless
@Remote(BOSamples.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class BOSamplesImpl extends Architech implements BOSamples {

    /** Serial version UID de la clase. */
    private static final long serialVersionUID = 6711822210144483632L;

    /** La variable dao samples database. */
    @EJB
    private DAOSamplesDatabase daoSamplesDatabase;

    /** La variable dao samples mq. */
    @EJB
    private DAOSamplesMq daoSamplesMq;

    /** La variable dao samples cics. */
    @EJB
    private DAOSamplesCics daoSamplesCics;

    @EJB
    private DAOSamplesPartenon daoSamplesPartenon;

    /*
     * (non-Javadoc)
     * 
     * @see mx.isban.ejemplo.samples.ejb.BOSamples#usoIsbanDataAccessDatabase(mx.isban.ejemplo.samples.beans.SamplesBean, mx.isban.agave.commons.beans.ArchitechSessionBean)
     */
    @Override
    public ResultSamplesBean usoIsbanDataAccessDatabase(SamplesBean valor, ArchitechSessionBean asb) throws BusinessException {
        debug("Ejecutando usoIsbanDataAccessDatabase");
        ResultSamplesBean result = null;
        try {
            result = daoSamplesDatabase.usoIsbanDataAccessDatabase(valor, asb);
        } catch (ExceptionDataAccess e) {
            error("Error:" + e.getMessage());
            showException(e);
            throw new BusinessException(BOSamplesImpl.class.getName(), e.getCode(), e.getMessage());
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see mx.isban.ejemplo.samples.ejb.BOSamples#usoIsbanDataAccessMq(mx.isban.ejemplo.samples.beans.SamplesBean, mx.isban.agave.commons.beans.ArchitechSessionBean)
     */
    @Override
    public ResultSamplesBean usoIsbanDataAccessMq(SamplesBean valor, ArchitechSessionBean asb) throws BusinessException {
        debug("Ejecutando usoIsbanDataAccessMq");

        ResultSamplesBean result = null;
        try {
            result = daoSamplesMq.usoIsbanDataAccessMq(valor, asb);
        } catch (ExceptionDataAccess e) {
            error("Error:" + e.getMessage());
            showException(e);
            throw new BusinessException(BOSamplesImpl.class.getName(), e.getCode(), e.getMessage());
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see mx.isban.ejemplo.samples.ejb.BOSamples#usoIsbanDataAccessCics(mx.isban.ejemplo.samples.beans.CicsBean, mx.isban.agave.commons.beans.ArchitechSessionBean)
     */
    @Override
    public CicsBean usoIsbanDataAccessCics(CicsBean valor, ArchitechSessionBean asb) throws BusinessException {
        debug("Ejecutando usoIsbanDataAccessCics");

        CicsBean result = null;
        try {
            result = daoSamplesCics.usoIsbanDataAccessCics(valor, asb);
        } catch (ExceptionDataAccess e) {
            error("Error:" + e.getMessage());
            showException(e);
            throw new BusinessException(BOSamplesImpl.class.getName(), e.getCode(), e.getMessage());
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see mx.isban.ejemplo.samples.ejb.BOSamples#usoMensajeria(mx.isban.ejemplo.samples.beans.SamplesBean, mx.isban.agave.commons.beans.ArchitechSessionBean)
     */
    @Override
    public ResultSamplesBean usoMensajeria(SamplesBean valor, ArchitechSessionBean sessionBean) throws BusinessException {
        debug("Ejecutando usoMensajeria");

        this.setArchitechBean(sessionBean);
        // Se obtiene un cliente de mensajeria.
        MensajeClient client = new MensajeClient(this.getLoggingBean());

        try {
            // Se crea el mensaje a enviar.
            MessageBean message = new MessageBean();
            message.setLogginBean(this.getLoggingBean());
            message.setDaoEjecutor(DAOSamplesEjecutor.class.getCanonicalName());
            message.setObjetoEjecutor(new ResultSamplesBean());

            // Se envia el mensaje.
            client.enviaMensaje(message);
        } catch (MensajeClientException e) {
            showException(e);
            throw new BusinessException(BOSamplesImpl.class.getName(), e.getCode(), e.getMessage());
        }
        return null;

    }

    /*
     * (non-Javadoc)
     * 
     * @see mx.isban.ejemplo.samples.ejb.BOSamples#usoAuditoriaAdmin(mx.isban.ejemplo.samples.beans.SamplesBean, mx.isban.agave.commons.beans.ArchitechSessionBean)
     */
    @Override
    public ResultSamplesBean usoAuditoriaAdmin(SamplesBean valor, ArchitechSessionBean asb) throws BusinessException {
        debug("Ejecutando usoAuditoriaAdmin");

        Date fecha = new Date();
        String hora = "auditAdminHora";
        String ipTerm = "auditAdminIpTerm";
        String canAplic = "auditAdminCanAplic";
        String usuario = this.getLoggingBean().getUsuario();
        String idInstaWeb = "auditAdminIdInstaWeb";
        String hostName = "auditAdminHostName";
        String datoAfectado = "";
        String tablaAfectada = "";

        AuditAdminBean auditAdminBean = new AuditAdminBean(fecha, hora, ipTerm, canAplic, usuario, "idSesion", idInstaWeb, hostName, datoAfectado, tablaAfectada);
        auditAdminBean.setCodOperacion("auditAdminCodOperacion");
        auditAdminBean.setServTrans("auditAdminServTrans");
        auditAdminBean.setIdToken("auditAdminIdToken");
        auditAdminBean.setTipoOperacion("auditAdminTipoOperacion");
        auditAdminBean.setDatoFijo("auditAdminDatoFijo");
        auditAdminBean.setDatoAfectado("auditAdminDatoAfectado");
        auditAdminBean.setTablaAfectada("auditAdminTablaAfectada");
        auditAdminBean.setValAnterior("auditAdminValAnterior");
        auditAdminBean.setValNuevo("auditAdminValNuevo");
        auditAdminBean.setIdOperacion(Long.valueOf("100"));

        try {
            Auditoria.grabaAuditoria(auditAdminBean, this.getLoggingBean());
        } catch (AuditoriaException e) {
            showException(e);
            throw new BusinessException(BOSamplesImpl.class.getName(), e.getCode(), e.getMessage());
        }

        return null;

    }

    /*
     * (non-Javadoc)
     * 
     * @see mx.isban.ejemplo.samples.ejb.BOSamples#usoAuditoriaTrans(mx.isban.ejemplo.samples.beans.SamplesBean, mx.isban.agave.commons.beans.ArchitechSessionBean)
     */
    @Override
    public ResultSamplesBean usoAuditoriaTrans(SamplesBean valor, ArchitechSessionBean asb) throws BusinessException {
        debug("Ejecutando usoAuditoriaTrans");

        Date fecha = new Date();
        String hora = "auditTransHora";
        String ipTerm = "auditTransIpTerm";
        String canAplic = "auditTransCanAplic";
        String idInstaWeb = "auditTransIdInstaWeb";
        String hostName = "auditTransHostName";
        String codCliente = "auditTransCodCliente";

        AuditTransBean auditTransBean = new AuditTransBean(fecha, hora, ipTerm, canAplic, "idSesion", idInstaWeb, hostName, codCliente);
        auditTransBean.setIdOperacion(Long.valueOf("0"));
        auditTransBean.setDescOperacion("auditTransDescOperacion");
        auditTransBean.setReferencia("auditTransReferencia");
        auditTransBean.setServTrans("auditTransServTrans");
        auditTransBean.setIdToken("auditTransIdToken");
        auditTransBean.setUsuario(this.getLoggingBean().getUsuario());
        auditTransBean.setFechaProgramada(new Date());
        auditTransBean.setTipoMoneda("auditTransTipoMoneda");
        auditTransBean.setNumTitulos(Long.valueOf("0"));
        auditTransBean.setMonto(Double.valueOf("0.00"));
        auditTransBean.setTipoCambio(Double.valueOf("0.00"));
        auditTransBean.setCodError("auditTransCodError");
        auditTransBean.setDescError("auditTransDescError");
        auditTransBean.setBancoDestino("auditTransBancoDestino");
        auditTransBean.setContrato(this.getLoggingBean().getCuentaOContrato());
        auditTransBean.setCuentaOrigen("auditTransCuentaOrigen");
        auditTransBean.setCuentaDestino("auditTransCuentaDestino");
        auditTransBean.setFechaAplicacion(new Date());
        auditTransBean.setEstatus("auditTransEstatus");
        auditTransBean.setNomArchivo("auditTransNomArchivo");

        try {
            Auditoria.grabaAuditoria(auditTransBean, this.getLoggingBean());
        } catch (AuditoriaException e) {
            showException(e);
            throw new BusinessException(BOSamplesImpl.class.getName(), e.getCode(), e.getMessage());
        }

        return null;

    }

    /*
     * (non-Javadoc)
     * 
     * @see mx.isban.ejemplo.samples.ejb.BOSamples#usoAuditoriaBitacora(mx.isban.ejemplo.samples.beans.SamplesBean, mx.isban.agave.commons.beans.ArchitechSessionBean)
     */
    @Override
    public ResultSamplesBean usoAuditoriaBitacora(SamplesBean valor, ArchitechSessionBean asb) throws BusinessException {
        debug("Ejecutando usoAuditoriaBitacora");

        BitacoraBean bitacoraBean = new BitacoraBean();
        bitacoraBean.setUsuario(this.getLoggingBean().getUsuario());
        bitacoraBean.setContrato(this.getLoggingBean().getCuentaOContrato());
        bitacoraBean.setIpTerm(this.getLoggingBean().getIp());
        bitacoraBean.setTipoOperacion("bitacoraTipoOperacion");
        bitacoraBean.setCodOperacion("bitacoraCodOperacion");
        bitacoraBean.setIdOperacion("bitacoraFolioOperacion");
        bitacoraBean.setCodCliente("bitacoraFolioUsuario");
        bitacoraBean.setEstatus("bitacoraEstatus");
        bitacoraBean.setTipoDocumento("bitacoraTipoDocumento");
        bitacoraBean.setDocumento("bitacoraDocumento");
        bitacoraBean.setIdSesion("idSession");
        bitacoraBean.setIdToken("bitacoraToken");
        bitacoraBean.setIdInstaWeb("bitacoraInstancia");
        bitacoraBean.setHostName("bitacoraHostName");
        bitacoraBean.setCampo1("bitacoraCampo1");
        bitacoraBean.setCampo2("bitacoraCampo2");
        bitacoraBean.setVarda1("bitacoraVarda1");
        bitacoraBean.setVarda2("bitacoraVarda2");
        bitacoraBean.setVarda3("bitacoraVarda3");
        bitacoraBean.setVarda4("bitacoraVarda4");
        bitacoraBean.setVarda5("bitacoraVarda5");
        bitacoraBean.setIdAplicacion("bitacoraIdAplicacion");
        bitacoraBean.setUsuario390("bitacoraUsuario390");

        try {
            Auditoria.guardaBitacora(bitacoraBean, this.getLoggingBean());
        } catch (AuditoriaException e) {
            showException(e);
            throw new BusinessException(BOSamplesImpl.class.getName(), e.getCode(), e.getMessage());
        }

        return null;

    }

    @Override
    public ResponseMessagePartenonDTO usoIsbanDataAccessPartenonMetadata(Map<String, String> valoresCabecera, ArchitechSessionBean asb) throws BusinessException {

        ResponseMessagePartenonDTO partenonDTO = null;
        try {
            partenonDTO = daoSamplesPartenon.usoIsbanDataAccessPartenonMetadata(valoresCabecera, asb);
        } catch (ExceptionDataAccess e) {
            showException(e);
            throw new BusinessException(BOSamplesImpl.class.getName(), e.getCode(), e.getMessage());
        }

        return partenonDTO;
    }

    @Override
    public ResponseMessagePartenonDTO usoIsbanDataAccessPartenonTrx(Map<String, String> valoresCabecera, Map<String, Object[]> paramIn, ArchitechSessionBean asb) throws BusinessException {

        ResponseMessagePartenonDTO partenonDTO = null;
        try {
            partenonDTO = daoSamplesPartenon.usoIsbanDataAccessPartenonTrx(valoresCabecera, paramIn, asb);
        } catch (ExceptionDataAccess e) {
            showException(e);
            throw new BusinessException(BOSamplesImpl.class.getName(), e.getCode(), e.getMessage());
        }

        return partenonDTO;
    }

    @Override
    public ResponseMessagePartenonDTO usoIsbanDataAccessPartenonVersion(ArchitechSessionBean asb) throws BusinessException {

        ResponseMessagePartenonDTO partenonDTO = null;
        try {
            partenonDTO = daoSamplesPartenon.usoIsbanDataAccessPartenonVersion(asb);
        } catch (ExceptionDataAccess e) {
            showException(e);
            throw new BusinessException(BOSamplesImpl.class.getName(), e.getCode(), e.getMessage());
        }

        return partenonDTO;
    }

    /**
     * Coloca el valor de dao samples database.
     *
     * @param daoSamplesDatabase
     *            Servicio de acceso a datos de base de datos
     */
    public void setDaoSamplesDatabase(DAOSamplesDatabase daoSamplesDatabase) {
        this.daoSamplesDatabase = daoSamplesDatabase;
    }

    /**
     * Coloca el valor de dao samples mq.
     *
     * @param daoSamplesMq
     *            es el nuevo valor de dao samples mq
     */
    public void setDaoSamplesMq(DAOSamplesMq daoSamplesMq) {
        this.daoSamplesMq = daoSamplesMq;
    }

    /**
     * Coloca el valor de dao samples cics.
     *
     * @param daoSamplesCics
     *            es el nuevo valor de dao samples cics
     */
    public void setDaoSamplesCics(DAOSamplesCics daoSamplesCics) {
        this.daoSamplesCics = daoSamplesCics;
    }


}