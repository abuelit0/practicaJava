package mx.isban.ejemplo.samples.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import mx.isban.agave.cache.GlobalCache;
import mx.isban.agave.commons.architech.Architech;
import mx.isban.agave.commons.exception.BusinessException;
import mx.isban.agave.configuracion.ConfiguracionConfig;
import mx.isban.agave.configuracion.ConfiguracionConfigs;
import mx.isban.agave.dataaccess.channels.partenon.dto.ResponseMessagePartenonDTO;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import mx.isban.ejemplo.samples.beans.CicsBean;
import mx.isban.ejemplo.samples.beans.PartenonBean;
import mx.isban.ejemplo.samples.beans.PartenonMetadataBean;
import mx.isban.ejemplo.samples.beans.SamplesBean;
import mx.isban.ejemplo.samples.ejb.BOSamples;
import mx.isban.ejemplo.samples.util.SamplesPartenonUtil;

@RestController
@RequestMapping("/samples")
@SessionAttributes("partenonBean")
public class SamplesController extends Architech {

    /** Serial version UID de la clase */
    private static final long serialVersionUID = -2288138134885533326L;

    @Autowired
    private BOSamples boSamples;

    /** Fuente de mensajes properties */
    @Autowired
    private MessageSource messageSource;

    /** Constante de pagina de inicio */
    private static final String LANDING_PAGE = "public/samples/SamplesMenu";
    /** Constante de pagina de inicio */
    private static final String CICS_TEST_PAGE = "public/samples/CicsTest";
    /** Constante de pagina de inicio */
    private static final String CICS_TEMPLATE_TEST_PAGE = "public/samples/CicsTemplateTest";
    private static final String PARTENON_TEMPLATE_TEST_PAGE = "public/samples/PartenonTest";

    /**
     * Landing a menu principal de menu de ejemplos
     * 
     * @return ModelAndView de menu principal
     * @throws Exception
     */
    @RequestMapping(value = { "", "/", "/inicio" }, method = RequestMethod.GET)
    public ModelAndView viewLogin(Map<String, Object> model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(LANDING_PAGE);
        return mav;
    }

    /**
     * Landing a menu pantalla de ejecucion de prueba de CICS
     * 
     * @return ModelAndView de test de CICS
     * @throws Exception
     */
    @RequestMapping(value = "/cicsTest", method = RequestMethod.GET)
    public ModelAndView viewCicsTest(Map<String, Object> model) {
        ModelAndView mav = new ModelAndView();
        CicsBean cb = new CicsBean();
        mav.setViewName(CICS_TEST_PAGE);
        model.put("cicsForm", cb);
        return mav;
    }


    /**
     * View partenon test, metodo para realizar la redireccion al ejemplo de PArtenon.
     *
     * @param model
     *            el parametro model
     * @return El model and view
     */
    @RequestMapping(value = { "/partenonTest" })
    public ModelAndView viewPartenonTest(Map<String, Object> model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(PARTENON_TEMPLATE_TEST_PAGE);
        PartenonBean partenonBean = new PartenonBean();
        partenonBean.setTrxNombre("TBQQ");
        partenonBean.setTrxOperacion("L");
        partenonBean.setTrxVersion("00013");

        model.put("partenonBean", partenonBean);
        return mav;
    }

    /**
     * Accion para ejemplo de uso de cmpConfiguracion
     * 
     * @return objeto json indicando status de accion
     */
    @RequestMapping(path = "usoConfig.do", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody JSONObject usoConfig() {
        JSONObject res = new JSONObject();
        res.put("status", "FAIL");

        info("-----Sample de uso de cmpConfiguracion------");

        info("Impresion de parametro de configuracion global MAXIMO_REGISTROS en archivo ejemplo01ArqAgave_WEB.xml ");
        info(ConfiguracionConfigs.getInstance().getConfig(ConfiguracionConfig.NOMBRE_APLICACION));

        res.put("status", "SUCCESS");

        return res;
    }

    /**
     * Accion para ejemplo de uso de cmpLogging
     * 
     * @return objeto json indicando status de accion
     */
    @RequestMapping(path = "usoLogging.do", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody JSONObject usoLogging() {
    	
    	info("inicio usoLogging");
    	
        JSONObject res = new JSONObject();
        res.put("status", "FAIL");

        debug("-----Sample de uso de cmpLogging en nivel de debug------");

        info("-----Sample de uso de cmpLogging en nivel de info------");

        warn("-----Sample de uso de cmpLogging en nivel de warn------");

        error("-----Sample de uso de cmpLogging en nivel de error------");

        res.put("status", "SUCCESS");

        return res;
    }

    /**
     * Accion para ejemplo de uso de cmpIsbanDataAccess
     * 
     * @return objeto json indicando status de accion
     */
    @RequestMapping(path = "usoIsbanDataAccessDatabase.do", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody JSONObject usoIsbanDataAccessDatabase() throws Exception {
    	
        info("inicio usoIsbanDataAccessDatabase");
        
        JSONObject res = new JSONObject();
        res.put("status", "FAIL");
        SamplesBean bs = new SamplesBean();
        bs.setParamA("0014");
        boSamples.usoIsbanDataAccessDatabase(bs, getArchitechBean());

        res.put("status", "SUCCESS");

        return res;
    }

    /**
     * Accion para ejemplo de uso de cmpIsbanDataAccess
     * 
     * @return objeto json indicando status de accion
     */
    @RequestMapping(path = "usoIsbanDataAccessMq.do", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody JSONObject usoIsbanDataAccessMq() throws Exception {
    	
        info("inicio usoIsbanDataAccessMq");
        
        JSONObject res = new JSONObject();
        res.put("status", "FAIL");
        SamplesBean bs = new SamplesBean();
        bs.setParamA("0014");

        boSamples.usoIsbanDataAccessMq(bs, getArchitechBean());

        res.put("status", "SUCCESS");

        return res;
    }

    /**
     * Accion para ejemplo de uso de cmpIsbanDataAccess
     * 
     * @return objeto json indicando status de accion
     */
    @RequestMapping(path = "usoIsbanDataAccessCics.do", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody JSONObject usoIsbanDataAccessCics(@Valid @ModelAttribute("cicsForm") CicsBean bs, BindingResult result, Map<String, Object> model) throws Exception {

    	info("inicio usoIsbanDataAccessCics");
    	
        List<String> list = new ArrayList<String>();
        JSONObject res = new JSONObject();

        if (result.hasErrors()) {
            res.put("status", "FAIL");

            for (FieldError fieldError : result.getFieldErrors()) {
                String message = fieldError.getDefaultMessage();
                this.debug("Locale: " + LocaleContextHolder.getLocale());
                if (messageSource != null) {
                    message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
                }

                list.add(message);
            }

            res.put("respuesta", list);
        } else {

            CicsBean rc = null;
            try {
                rc = boSamples.usoIsbanDataAccessCics(bs, getArchitechBean());
                res.put("status", "SUCCESS");
            } catch (BusinessException e) {
                res.put("status", "ERROR");
                showException(e);
                rc = new CicsBean();
                rc.setRespuesta(e.getCode() + "\n" + e.getMessage());
            } finally {
                res.put("respuesta", rc);
            }
        }

        return res;
    }

    /**
     * Accion para ejemplo de uso de cmpMensajeria
     * 
     * @return objeto json indicando status de accion
     */
    @RequestMapping(path = "usoMensajeria.do", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody JSONObject usoMensajeria() throws Exception {
    	
    	info("inicio usoMensajeria");
    	
        JSONObject res = new JSONObject();
        res.put("status", "FAIL");
        SamplesBean bs = new SamplesBean();
        bs.setParamA("0014");

        boSamples.usoMensajeria(bs, getArchitechBean());

        res.put("status", "SUCCESS");

        return res;
    }

    /**
     * Accion para ejemplo de uso de cmpAuditoria
     * 
     * @return objeto json indicando status de accion
     */
    @RequestMapping(path = "usoAuditoria.do", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody JSONObject usoAuditoria() throws Exception {
    	
    	info("inicio usoAuditoria");
    	
        JSONObject res = new JSONObject();
        res.put("status", "FAIL");
        SamplesBean bs = new SamplesBean();
        bs.setParamA("0014");

        boSamples.usoAuditoriaAdmin(bs, getArchitechBean());

        boSamples.usoAuditoriaBitacora(bs, getArchitechBean());

        boSamples.usoAuditoriaTrans(bs, getArchitechBean());

        res.put("status", "SUCCESS");

        return res;
    }

    /**
     * Accion para ejemplo de uso de cmpMensajeria
     * 
     * @return objeto json indicando status de accion
     */
    @RequestMapping(path = "usoCache.do", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody JSONObject usoCache() throws Exception {
    	
    	info("inicio usoCache");
    	
        JSONObject res = new JSONObject();
        res.put("status", "FAIL");
        SamplesBean bs = new SamplesBean();
        bs.setParamA("0014");

        String llave = "ArregloDeBytes01";
        byte[] dato = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        boolean result = GlobalCache.getInstance(this.getLoggingBean()).guardaDato(llave, dato);
        debug("Resultado de guardado en Cache:" + result);

        // Consulta datos en cache:
        Object resultObten = GlobalCache.getInstance(this.getLoggingBean()).obtenDato(llave);
        debug("Resultado de consulta de Cache:" + resultObten);

        res.put("status", "SUCCESS");

        return res;
    }

    @RequestMapping(path = "getTransactionPartenon.do", method = RequestMethod.POST, produces = "application/json", params = "metadata")
    public ModelAndView getMetadataPartenon(@Valid @ModelAttribute("partenonBean") PartenonBean partenonBean, BindingResult result, Map<String, Object> model) throws Exception {

        debug("TRX_NAME                 : " + partenonBean.getTrxNombre());
        debug("TRX_OPERACION            : " + partenonBean.getTrxOperacion());
        debug("TRX_VERSION              : " + partenonBean.getTrxVersion());
        debug("TRX_VERSION_DISABLED     : " + partenonBean.isTrxVersionDisabled());

        partenonBean.setListaResultados(null);
        partenonBean.setMapaScalars(null);

        Map<String, String> valoresCabecera = new HashMap<>();
        valoresCabecera.put("TRX_NAME", partenonBean.getTrxNombre());
        valoresCabecera.put("TRX_OPERACION", partenonBean.getTrxOperacion());
        valoresCabecera.put("TRX_VERSION", partenonBean.isTrxVersionDisabled() ? null : partenonBean.getTrxVersion());

        try {
            ResponseMessagePartenonDTO partenonDTO = boSamples.usoIsbanDataAccessPartenonMetadata(valoresCabecera, getArchitechBean());
            partenonDTO.getMetadata();
            SamplesPartenonUtil.metadataToMap(partenonDTO.getMetadata(), partenonBean);
            debug("Mapa generado send: " + Arrays.toString(partenonBean.getListaMetadataSend().toArray()));
            debug("Mapa generado rcve: " + Arrays.toString(partenonBean.getListaMetadataRcve().toArray()));

            partenonBean.setCodeError("SUCCESS");
        } catch (BusinessException e) {
            debug("Error: Transaccion " + e.getMessage());
            partenonBean.setCodeError("ERROR");
            partenonBean.setMessageError(e.getMessage());
            showException(e);
        }

        ModelAndView mav = new ModelAndView();
        mav.setViewName(PARTENON_TEMPLATE_TEST_PAGE);

        model.put("partenonBean", partenonBean);
        return mav;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(path = "getTransactionPartenon.do", method = RequestMethod.POST, produces = "application/json", params = "transaction")
    public ModelAndView getTransactionPartenon(@Valid @ModelAttribute("partenonBean") PartenonBean partenonBean, BindingResult result, Map<String, Object> model) throws Exception {
        debug("EJECUTA - getTransactionPartenon");
        ModelAndView mav = new ModelAndView();
        mav.setViewName(PARTENON_TEMPLATE_TEST_PAGE);

        trace("trxName      : " + partenonBean.getTrxNombre());
        trace("trxOperation : " + partenonBean.getTrxOperacion());
        trace("trxVersion   : " + partenonBean.getTrxVersion());

        Map<String, String> valoresCabecera = new HashMap<>();
        valoresCabecera.put("TRX_NAME", partenonBean.getTrxNombre());
        valoresCabecera.put("TRX_OPERACION", partenonBean.getTrxOperacion());
        valoresCabecera.put("TRX_VERSION", partenonBean.isTrxVersionDisabled() ? null : partenonBean.getTrxVersion());

        // valoresCabecera.put("EMPRESA", "E6");
        // valoresCabecera.put("CENTRO", "C13");
        // valoresCabecera.put("PUESTO_FISICO", "P171");
        // valoresCabecera.put("TIPO_TERMINAL", "J");
        // valoresCabecera.put("IDIOMA", "E");
        // valoresCabecera.put("CANAL_FISICO", "0018");
        // valoresCabecera.put("CANAL_LOGICO", "0001");

        Map<String, Object[]> params = new HashMap<String, Object[]>();
        Object[] values = null;

        debug("Se procesan los datos de entrada para la ejecucion de la transaccion");
        for (PartenonMetadataBean metadataBean : partenonBean.getListaMetadataSend()) {
            debug("Campo: " + metadataBean.getFieldName() + " Valor: [" + metadataBean.getValue() + "] ");
            if (!metadataBean.isDisabled() && metadataBean.getValue() != null) {
                values = SamplesPartenonUtil.getValues(metadataBean);
                if (values != null && values[0] != null) {
                    params.put(metadataBean.getFieldName(), values);
                }
            }
        }

        ResponseMessagePartenonDTO partenonDTO;
        try {
            partenonDTO = boSamples.usoIsbanDataAccessPartenonTrx(valoresCabecera, params, getArchitechBean());
            partenonBean.setCodeError(partenonDTO.getCodeError());

            debug("Se revisa si se tienen Warnings en la respuesta");
            SamplesPartenonUtil.logWarnings(partenonDTO.getResourceWarning());

            debug("Se colocan los resultados en el bean de salida");
            SamplesPartenonUtil.obtenerResultados(partenonDTO.getRaMappedRecord(), partenonBean);

            partenonBean.setCodeError("SUCCESS");
        } catch (BusinessException e) {
            debug("Error: Transaccion " + e.getMessage());
            partenonBean.setCodeError("ERROR");
            partenonBean.setMessageError(e.getMessage());
            showException(e);
        }

        model.put("partenonBean", partenonBean);
        return mav;
    }

    @RequestMapping(path = "getTransactionPartenonVersion.do", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody JSONObject getTransactionPartenonVersion() {
        debug("EJECUTA - getTransactionPartenonVersion");
        ResponseMessagePartenonDTO partenonDTO = null;
        JSONObject res = new JSONObject();

        try {
            partenonDTO = boSamples.usoIsbanDataAccessPartenonVersion(getArchitechBean());
            res.put("version", partenonDTO.getVersion());
            res.put("status", "SUCCESS");
        } catch (BusinessException e) {
            res.put("status", "ERROR");
            showException(e);
            partenonDTO = new ResponseMessagePartenonDTO();
            partenonDTO.setCodeError(e.getCode() + "\n" + e.getMessage());
        }

        debug("Json Generado " + res.toString());
        return res;
    }

    public void setBoSamples(BOSamples boSamples) {
        this.boSamples = boSamples;
    }
}
