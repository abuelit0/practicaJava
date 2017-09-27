package mx.isban.ejemplo.clientes.controller;

import java.util.Arrays;
import java.util.Map;

import javax.validation.Valid;

import mx.isban.agave.commons.architech.Architech;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mx.isban.ejemplo.clientes.beans.ClienteBean;
import mx.isban.ejemplo.clientes.beans.ClientesWrapper;

@Controller
@RequestMapping("/clientes")
public class ClientesController extends Architech{

	/** Serial version UID de la clase */
	private static final long serialVersionUID = -2288138134885533326L;



	/**
	 * @param model Modelo
	 * @return Objeto ModelAndView
	 */
	@RequestMapping(value = "/alta", method = RequestMethod.GET)
    public ModelAndView alta(Map<String, Object> model) {
		
		info("inicio alta");
		
        ClienteBean cb = new ClienteBean();
		ModelAndView mav = new ModelAndView();
        model.put("clienteForm", cb);
        mav.addObject(model);
		mav.setViewName("public/clientes/AltaCliente");
        return mav;
    }
	
	/**
	 * @param cb Formulario de clientes
	 * @param result Resultado de validacion
	 * @param model Modelo
	 * @return Objeto ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(path = "guardarCliente.do", method = RequestMethod.POST)
	public ModelAndView altaCliente(@Valid @ModelAttribute("clienteForm") ClienteBean cb, 
			BindingResult result, Map<String, Object> model) throws Exception {

		info("inicio altaCliente");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject(model);

		mav.setViewName("public/clientes/AltaClienteExito");
		
		if (result.hasErrors()) {
			mav.setViewName("public/clientes/AltaCliente");
        }
		return mav;
	}
	

	
	/**
	 * @param model Modelo
	 * @return Objeto ModelAndView
	 */
	@RequestMapping(value = "/altas", method = RequestMethod.GET)
    public ModelAndView altas(Map<String, Object> model) {
		
		info("inicio altas");
		
        ClienteBean cb = new ClienteBean();
        ModelAndView mav = new ModelAndView();
		
        model.put("clientesForm", new ClientesWrapper(Arrays.asList(cb,cb)));
		mav.addObject(model);
		mav.setViewName("public/clientes/AltaClientes");
		
		return mav;
    }
	
	/**
	 * @param cb Formulario de clientes
	 * @param result Resultado de validacion
	 * @param model Modelo
	 * @return Objeto ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(path = "guardarClientes.do", method = RequestMethod.POST)
	public ModelAndView altasCliente(@Valid @ModelAttribute("clientesForm") ClientesWrapper cb, 
			BindingResult result, Map<String, Object> model) throws Exception {
		
		info("inicio altasCliente");
		
		ModelAndView mav = new ModelAndView();

		model.put("clientesForm", cb);
		
		mav.addObject(model);
        mav.setViewName("public/clientes/AltaClientesExito");
		
		if (result.hasErrors()) {
			mav.setViewName("public/clientes/AltaClientes");
        }
		return mav;
	}
	
}
