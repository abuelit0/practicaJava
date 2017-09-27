package mx.isban.ejemplo.prueba.bean;

import mx.isban.ejemplo.comunes.beans.BaseBean;

public class PruebaSalidaBean extends BaseBean{

	/**
	 * UID Serializado para el bean PruebaSalida
	 */
	private static final long serialVersionUID = 1L;

	private String copiasDisponibles = "";
	private String copiasRentadas = "";
	
	/**
	 * @return the copiasRentadas
	 */
	public String getCopiasRentadas() {
		return copiasRentadas;
	}
	
	/**
	 * @param copiasRentadas the copiasRentadas to set
	 */
	public void setCopiasRentadas(String copiasRentadas) {
		this.copiasRentadas = copiasRentadas;
	}
	
	/**
	 * @return the copiasDisponibles
	 */
	public String getCopiasDisponibles() {
		return copiasDisponibles;
	}
	
	/**
	 * @param copiasDisponibles the copiasDisponibles to set
	 */
	public void setCopiasDisponibles(String copiasDisponibles) {
		this.copiasDisponibles = copiasDisponibles;
	}
}
