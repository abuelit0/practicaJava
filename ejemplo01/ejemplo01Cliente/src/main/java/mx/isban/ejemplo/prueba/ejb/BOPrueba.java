/**
 * 
 */
package mx.isban.ejemplo.prueba.ejb;

import mx.isban.agave.commons.beans.ArchitechSessionBean;
import mx.isban.agave.commons.exception.BusinessException;
import mx.isban.ejemplo.prueba.bean.PruebaEntradaBean;
import mx.isban.ejemplo.prueba.bean.PruebaSalidaBean;

/**
 * @author HP
 *	Definimos el metodo que usaremos desde el cliente
 *	Toda la documentacion va en esta interfaz
 */
public interface BOPrueba {
	/**
	 * Debemos agregar la clausula throws y siempre recibir el parametro ArchitechSessionBean
	 * @param x
	 * @param asb
	 * @return
	 * @throws BusinessException
	 */
	public PruebaSalidaBean Probando(PruebaEntradaBean entrada, ArchitechSessionBean asb) throws BusinessException;
}
