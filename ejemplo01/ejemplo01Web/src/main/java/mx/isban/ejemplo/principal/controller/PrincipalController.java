package mx.isban.ejemplo.principal.controller;

/**
 * ISBAN México - (c) Banco Santander Central Hispano
 * Todos los derechos reservados
 *
 * ControllerPrincipal.java
 *
 * Control de versiones:
 *
 * Version  Date/Hour               By                  Company     Description
 * -------  -------------------     ----------------    --------    -----------------------------------------------------------------
 * 1.0      14/07/2016 HH:MM:SS     RGM					ISBAN		Creación de clase
 */

import java.util.Map;

import mx.isban.agave.commons.architech.Architech;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PrincipalController extends Architech {

	/** Serial version UID de la clase */
	private static final long serialVersionUID = 6060356897790696110L;

	/** Constante de pagina de inicio */
	private static final String LANDING_PAGE = "public/samples/SamplesMenu";

	/**
	 * Landing a menu principal de menu de ejemplos
	 * @return ModelAndView de menu principal
	 * @throws Exception
	 */
	@RequestMapping(value = {"","/","/inicio","/inicio.do"}, method = RequestMethod.GET)
    public ModelAndView viewLogin(Map<String, Object> model) {
		
		info("inicio viewLogin");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(LANDING_PAGE);
		return mav;
    }
}
