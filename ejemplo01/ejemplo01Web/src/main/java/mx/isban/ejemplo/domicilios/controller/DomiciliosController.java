package mx.isban.ejemplo.domicilios.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import mx.isban.agave.commons.architech.Architech;
import net.sf.json.JSONObject;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.isban.ejemplo.domicilios.beans.DomicilioBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/domicilios")
public class DomiciliosController extends Architech{

	/** Serial version UID de la clase */
	private static final long serialVersionUID = -2288138134885533326L;

	/** Fuente de mensajes properties */
	@Autowired
	private MessageSource messageSource;


	/**
	 * @param model Modelo
	 * @return Objeto ModelAndView
	 */
	@RequestMapping(value = "/alta", method = RequestMethod.GET)
    public ModelAndView viewLogin(Map<String, Object> model) {
		
		info("inicio viewLogin");
		
        DomicilioBean cb = new DomicilioBean();
		ModelAndView mav = new ModelAndView();
        model.put("domicilioForm", cb);
		mav.setViewName("public/domicilios/AltaDomicilio");
        return mav;
    }
	
	/**
	 * @param db Formulario de clientes
	 * @param result Resultado de validacion
	 * @param model Modelo
	 * @return Objeto de tipo Json
	 * @throws Exception
	 */
	@RequestMapping(path = "guardarDomicilio.do", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody JSONObject altaDomicilio(@Valid @ModelAttribute("domicilioForm") DomicilioBean db, 
			BindingResult result, Map<String, Object> model) throws Exception {
		
		info("inicio altaDomicilio");
		
		JSONObject res = new JSONObject();
		List<String> list = new ArrayList<String>();
		
        if(result.hasErrors()){
            res.put("status", "FAIL");
            
			for (FieldError fieldError : result.getFieldErrors()) {
				String message = fieldError.getDefaultMessage();
				this.debug("Locale: "+LocaleContextHolder.getLocale());
				if (messageSource != null) {
					message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
				}
				
				list.add(message);
			}

			
            res.put("result", list);
        }else{
            res.put("status", "SUCCESS");
            res.put("result", db);
        }

        return res;
	}
}
