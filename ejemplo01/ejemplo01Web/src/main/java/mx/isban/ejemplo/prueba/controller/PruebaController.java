/**
 * Luis Guillermo Alvarez Jimenez
 */
package mx.isban.ejemplo.prueba.controller;

import javax.ejb.EJB;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.isban.agave.commons.architech.Architech;
import mx.isban.agave.commons.exception.BusinessException;
import mx.isban.ejemplo.comunes.beans.AnsRequestBean;
import mx.isban.ejemplo.comunes.beans.AnsResponseBean;
import mx.isban.ejemplo.comunes.utils.E_WS_STATUS;
import mx.isban.ejemplo.prueba.bean.PruebaEntradaBean;
import mx.isban.ejemplo.prueba.bean.PruebaSalidaBean;
import mx.isban.ejemplo.prueba.ejb.BOPrueba;

/**
 * @author HP
 *
 */
@Controller
@RequestMapping(consumes="application/json", path="/", produces="application/json")
public class PruebaController extends Architech{

	/**
	 * UID serializado para el controlador prueba
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Para hacer referencia al bussines object que manejaremos en este controlador
	 */
	@EJB BOPrueba prueba;
	
	@RequestMapping(path={"/emisionPrueba"}, method=RequestMethod.POST)
	public ResponseEntity<AnsResponseBean<PruebaSalidaBean>> emisionPrueba(@RequestBody AnsRequestBean<PruebaEntradaBean> entrada) throws Exception{
		
		/**
		 * Creamos una respuesta con estatus
		 */
		AnsResponseBean<PruebaSalidaBean> response = new AnsResponseBean<>(E_WS_STATUS.DEFAULT);
		
		if(null == entrada.getAnsPayload()) {
			throw new BusinessException(this.getClass().getName(), "pruebaController", "Los datos de entrada son nulos");
		}
		
		try {
			PruebaSalidaBean psb = prueba.Probando(entrada.getAnsPayload(), null);
			
			//En caso de si poder ejecutar
			response.setAnsStatus(E_WS_STATUS.REGRESO);
			response.setAnsResult(psb);
			response.setAnsMessage("Busqueda exitosa");
			response.setAnsCount(1);
			
		}catch(BusinessException e) {
			//
			response.setAnsStatus(E_WS_STATUS.RECHAZO);
			response.setAnsMessage(e.getMessage());
		}
		
		//Retorna el response y un status
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}