package mx.isban.ejemplo.prueba.dao;

import mx.isban.agave.commons.beans.ArchitechSessionBean;
import mx.isban.agave.commons.exception.ExceptionDataAccess;
import mx.isban.ejemplo.prueba.bean.PruebaEntradaBean;
import mx.isban.ejemplo.prueba.bean.PruebaSalidaBean;


public interface DAOPrueba {
	
	public PruebaSalidaBean traerDatos(PruebaEntradaBean pda, ArchitechSessionBean asb) throws ExceptionDataAccess;
}
