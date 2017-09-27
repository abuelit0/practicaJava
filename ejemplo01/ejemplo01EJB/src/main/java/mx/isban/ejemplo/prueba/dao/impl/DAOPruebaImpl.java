package mx.isban.ejemplo.prueba.dao.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import mx.isban.agave.commons.architech.Architech;
import mx.isban.agave.commons.beans.ArchitechSessionBean;
import mx.isban.agave.commons.beans.LoggingBean;
import mx.isban.agave.commons.exception.ExceptionDataAccess;
import mx.isban.agave.dataaccess.DataAccess;
import mx.isban.agave.dataaccess.channels.database.dto.RequestMessageDataBaseDTO;
import mx.isban.agave.dataaccess.channels.database.dto.ResponseMessageDataBaseDTO;
import mx.isban.agave.dataaccess.factories.jdbc.ConfigFactoryJDBC;
import mx.isban.agave.dataaccess.factories.jms.ConfigFactoryJMS;
import mx.isban.ejemplo.prueba.bean.PruebaEntradaBean;
import mx.isban.ejemplo.prueba.bean.PruebaSalidaBean;
import mx.isban.ejemplo.prueba.dao.DAOPrueba;

@Stateless
@Local(DAOPrueba.class)
@TransactionManagement(TransactionManagementType.BEAN)
public class DAOPruebaImpl extends Architech implements DAOPrueba{

	/**
	 * UID serial para la clase DAOPruebaImpl que implementa a DAOPrueba
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * @see mx.isban.ejemplo.prueba.dao.DAOPrueba#traerDatos(mx.isban.ejemplo.prueba.bean.PruebaEntradaBean, mx.isban.agave.commons.beans.ArchitechSessionBean)
	 */
	@Override
	public PruebaSalidaBean traerDatos(PruebaEntradaBean pda, ArchitechSessionBean asb) throws ExceptionDataAccess {
		RequestMessageDataBaseDTO miDTO = new RequestMessageDataBaseDTO();
		ResponseMessageDataBaseDTO respuesta = new ResponseMessageDataBaseDTO();
		
		miDTO.setCodeOperation("COD_OPER_BUSCA_PELI");
		miDTO.setTypeOperation(ConfigFactoryJDBC.OPERATION_TYPE_QUERY_PARAMS);
		miDTO.setTimeout(10); //Tiempo opcional, para evitar que la conexion dure mucho tiempo
		miDTO.setQuery("SELECT COPIAS_DISPONIBLES cd, COPIAS_RENTADAS cr FROM peliculas INNER JOIN renta ON renta.PELICULA_ID = peliculas.PELICULA_ID WHERE peliculas.PELICULA_ID = ? AND peliculas.NOMBRE_PELICULA = ?");
		miDTO.addParamToSql(pda.getIdPelicula());
		miDTO.addParamToSql(pda.getNombrePelicula());
		
		DataAccess IDA = DataAccess.getInstance(miDTO, new LoggingBean());
		respuesta = (ResponseMessageDataBaseDTO) IDA.execute("beca");
		
		if(!ConfigFactoryJMS.CODE_SUCCESFULLY.equals(respuesta.getCodeError())) {
			throw new ExceptionDataAccess(DAOPrueba.class.getName(), "BUSCA_PELI", "Error al ejecutar el Query");
		}
		
		if(respuesta.getResultQuery().get(0).get("cd").equals("") || respuesta.getResultQuery().get(0).get("cd").equals(null) 
				&& 
		   respuesta.getResultQuery().get(0).get("cr").equals("") || respuesta.getResultQuery().get(0).get("cr").equals(null)) {
			throw new ExceptionDataAccess(DAOPrueba.class.getName(), "BUSCA_PELI", "No se encontro peli");
		}
		
		PruebaSalidaBean psb = new PruebaSalidaBean();
		
		psb.setCopiasDisponibles(respuesta.getResultQuery().get(0).get("cd").toString());
		psb.setCopiasRentadas(respuesta.getResultQuery().get(0).get("cr").toString());
		
		return psb;
	}

}
