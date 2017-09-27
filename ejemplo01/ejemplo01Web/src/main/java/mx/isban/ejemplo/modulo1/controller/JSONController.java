package mx.isban.ejemplo.modulo1.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mx.isban.agave.commons.architech.Architech;
import mx.isban.agave.commons.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import mx.isban.ejemplo.modulo1.beans.ResultUsuarioBean;
import mx.isban.ejemplo.modulo1.beans.UsuarioBean;
import mx.isban.ejemplo.modulo1.beans.Usuario;
import mx.isban.ejemplo.modulo1.ejb.BOUsuarios;

@RestController
@RequestMapping(JSONController.GENERAL_URL_MAPPER)
public class JSONController extends Architech {

	/** Serial version UID de la clase */
	private static final long serialVersionUID = -2288138134885533326L;

	static final String GENERAL_URL_MAPPER = "/json";
	
	private static final String TIPE_VIEW_JSON="TypeView:json";

	/*
	 * Permite manipular las vistas en la seccion de exepciones
	 * eliminando la necesidad de agregar logica de validaciones
	 * dentro de los controladores.
	 * */
	private Map<String, String> mappers = new HashMap<String, String>();

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private BOUsuarios boUsuarios;

	public JSONController() {
		String tmp = "private/usuarios/Form_RJson";
		mappers.put("", tmp);
		mappers.put("/", tmp);
		mappers.put("Form_RJson", tmp);
		mappers.put("Form_RJson.jsp", tmp);

		mappers.put("/FormJQueryAjax_RJSON", TIPE_VIEW_JSON);
		mappers.put("/FormJQueryAjax_RJSON.jsp", TIPE_VIEW_JSON);
	}

	
	@RequestMapping(value = {"","/","Form_RJson", "Form_RJson.jsp" }, method = RequestMethod.GET)
	public ModelAndView inicio() {
		
		info("inicio inicio");
		
		return new ModelAndView(mappers.get(""));
	}
	

	@RequestMapping(value = {"","/","Form_RJson", "Form_RJson.jsp" }, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	Object getJSON(@Valid @ModelAttribute Usuario e) throws BusinessException {
		
		info("inicio getJSON");
		
		UsuarioBean bu = new UsuarioBean();
		bu.setNombreUsuario(e.getNombre());
		ResultUsuarioBean s = boUsuarios.validaUsuario(bu,
				this.getArchitechBean());
		return s;

	}

	@RequestMapping(value = { "FormJQueryAjax_RJSON",
			"FormJQueryAjax_RJSON.jsp" }, method = RequestMethod.GET)
	public ModelAndView inicio2() {
		
		info("inicio inicio2");
		
		return new ModelAndView("private/usuarios/FormJQueryAjax_RJSON");
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	ResultUsuarioBean getJSON() throws BusinessException {

		info("inicio getJSON");
		
		ResultUsuarioBean s = boUsuarios.validaUsuario(new UsuarioBean(),
				this.getArchitechBean());

		return s;

	}

	@RequestMapping(value = "/postAjax", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	Object getJSONAjax(@Valid @ModelAttribute Usuario e)
			throws BusinessException {
		
		info("inicio getJSONAjax");
		
		UsuarioBean bu = new UsuarioBean();
		bu.setNombreUsuario(e.getNombre());
		ResultUsuarioBean s = boUsuarios.validaUsuario(bu,
				this.getArchitechBean());
		return s;

	}

	@RequestMapping(value = "/principal", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Object getPrincipal(Principal p) throws BusinessException {
		
		info("inicio getPrincipal");
		
		UsuarioBean bu = new UsuarioBean();
		debug(getArchitechBean().toString());
		bu.setNombreUsuario(p.getName());
		ResultUsuarioBean s = boUsuarios.validaUsuario(bu,
				this.getArchitechBean());
		return s;

	}
	
	public void setBoUsuarios(BOUsuarios boUsuarios) {
		this.boUsuarios = boUsuarios;
	}

	@ExceptionHandler(BindException.class)
	public ModelAndView handleError(HttpServletRequest req, BindException ex) {

		debug("Ingresa al manejo de excepción");
		
		ModelAndView mav = new ModelAndView();
		String attr = "Referer";
		if (req.getHeader("Referer") == null) {
			mav.setView(new MappingJackson2JsonView());
			mav.addObject("Error de validaci\u00f3n", ex.getAllErrors());
		} else {
			int indice = req.getHeader(attr).indexOf(GENERAL_URL_MAPPER);
			debug("Indice: " + indice);
			String url = req.getHeader(attr).substring(
					indice + GENERAL_URL_MAPPER.length());
			debug("url: " + url);
			if (ex.getBindingResult() != null
					&& ex.getBindingResult().hasFieldErrors()) {
				Map<String, List<String>> errorMap = new HashMap<String, List<String>>();
				for (FieldError fieldError : ex.getBindingResult()
						.getFieldErrors()) {
					String message;
					String errorFild = new StringBuilder(
							fieldError.getField()).append(".")
							.append(fieldError.getCode()).toString();
					try {						
						message = messageSource.getMessage(errorFild,
								fieldError.getArguments(), req.getLocale());
					} catch (NoSuchMessageException e) {
						warn(String
								.format("No se ha definido un mensaje para el código: %s en el Locale %s",
										errorFild, req.getLocale()));
						message = fieldError.getDefaultMessage();
					}

					List<String> fieldErrors = errorMap.get(fieldError
							.getField());

					if (fieldErrors == null) {
						fieldErrors = new ArrayList<String>();
						errorMap.put(fieldError.getField(), fieldErrors);
					}

					fieldErrors.add(message);
				}

				mav.addObject("errors", errorMap);
				while(mappers.get(url) == null){
					url = url.substring(0, url.lastIndexOf("/"));
				}
				debug("URL target:"+url);
				if(TIPE_VIEW_JSON.equals(mappers.get(url))){
					mav.setView(new MappingJackson2JsonView());
				}else {
					mav.setViewName(mappers.get(url));
				}

			}
		}
		debug("Sale del manejo de excepción");
		return mav;
	}
}
