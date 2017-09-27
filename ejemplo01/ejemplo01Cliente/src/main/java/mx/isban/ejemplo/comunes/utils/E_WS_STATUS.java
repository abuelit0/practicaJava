package mx.isban.ejemplo.comunes.utils;

/**
 * Enumerador de los status validos en las peticiones al servicio web de ANS
 * @author bonifacio.velazquez
 *
 */
public enum E_WS_STATUS {
	/**
	 * Status default de una peticion aun sin procesar
	 */
	DEFAULT(-1, "DEFAULT"), 
	/**
	 * Status valido unicamente para la entrada (Request)
	 */
	ENVIO(0, "ENVIO"), 
	/**
	 * Status de salida para el caso de un error
	 */
	ERROR(2, "ERROR"), 
	/**
	 * Status de salida para el caso de una validacion que no paso la prueba
	 */
	RECHAZO(3, "RECHAZO"), 
	/**
	 * Status de salida para el caso de una operacion exitosa
	 */
	REGRESO(1, "REGRESO");

	/**
	 * Descripci&oacute;n del status
	 */
	private String desc;

	/**
	 * Id del status
	 */
	private int id;
	
	/**
	 * Regresa el significado en numerico del item
	 * @param dato Dato a convertir
	 * @return Item resultante, null si no es valido
	 */
	public static Integer intValue(String dato) {
		Integer val2return = null;
		for (E_WS_STATUS e : E_WS_STATUS.values()) {
			if (e.desc.equalsIgnoreCase(dato.trim())) {
				val2return = e.id;
				break;
			}
		}
		return val2return;
	}

	/**
	 * Constructor default
	 * @param id Id del item
	 * @param desc Descripci&oacute;n del item
	 */
	E_WS_STATUS(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.desc;
	}

}
