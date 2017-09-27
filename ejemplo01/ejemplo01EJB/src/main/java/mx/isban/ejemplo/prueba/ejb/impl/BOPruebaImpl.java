package mx.isban.ejemplo.prueba.ejb.impl;

import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import mx.isban.agave.commons.architech.Architech;
import mx.isban.agave.commons.beans.ArchitechSessionBean;
import mx.isban.agave.commons.exception.BusinessException;
import mx.isban.agave.commons.exception.ExceptionDataAccess;
import mx.isban.ejemplo.prueba.bean.PruebaEntradaBean;
import mx.isban.ejemplo.prueba.bean.PruebaSalidaBean;
import mx.isban.ejemplo.prueba.dao.DAOPrueba;
import mx.isban.ejemplo.prueba.ejb.BOPrueba;

/**
 * Todos los businessObjects e implementaciones llevan estas 3 anotaciones
 * @author HP
 *
 */

@Stateless
@Local(BOPrueba.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class BOPruebaImpl extends Architech implements BOPrueba{

	/**
	 * UID serial para el businessObject Prueba
	 */
	private static final long serialVersionUID = 1L;

	@EJB DAOPrueba DAOP;
	
	//para crear este bloque usamos ' /* + enter'
	/*
	 * (non-Javadoc)
	 * @see mx.isban.ejemplo.prueba.ejb.BOPrueba#Probando(mx.isban.ejemplo.prueba.bean.PruebaEntradaBean, mx.isban.agave.commons.beans.ArchitechSessionBean)
	 */
	@Override
	public PruebaSalidaBean Probando(PruebaEntradaBean entrada, ArchitechSessionBean asb) throws BusinessException {
		
		StringBuilder errores = new StringBuilder();
		
		boolean valido = true;
		
		if(!Pattern.matches("[a-zA-Z]+", entrada.getNombrePelicula())) {
			valido = false;
			errores.append("\nEl nombre de la pelicula solo puede contener letras: ");
			errores.append(entrada.getNombrePelicula());
		}
		
		if(!Pattern.matches("[0-9]+", entrada.getIdPelicula())) {
			valido = false;
			errores.append("\nEl id de la pelicula solo puede contener numeros: ");
			errores.append(entrada.getIdPelicula());
		}else {
			valido = valido & valido;
		}

		if(!valido) {
			throw new BusinessException(this.getClass().getName(), "probando", errores.toString());
		}
		
		try {
			return DAOP.traerDatos(entrada, asb);
		}catch(ExceptionDataAccess e) {
			showException(e);
			throw new BusinessException(e.getClassName(), e.getCode(), e.getMessage());
		}
	}
}
