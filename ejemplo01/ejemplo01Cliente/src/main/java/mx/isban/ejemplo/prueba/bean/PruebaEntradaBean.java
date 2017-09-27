package mx.isban.ejemplo.prueba.bean;

import mx.isban.ejemplo.comunes.beans.BaseBean;

public class PruebaEntradaBean extends BaseBean{

	/**
	 * UID serial para el bean PruebaEntrada
	 */
	private static final long serialVersionUID = 1L;
	
	private String idPelicula = "";
	private String nombrePelicula = "";
	/**
	 * @return the idPelicula
	 */
	public String getIdPelicula() {
		return idPelicula;
	}
	/**
	 * @param idPelicula the idPelicula to set
	 */
	public void setIdPelicula(String idPelicula) {
		this.idPelicula = idPelicula;
	}
	/**
	 * @return the nombrePelicula
	 */
	public String getNombrePelicula() {
		return nombrePelicula;
	}
	/**
	 * @param nombrePelicula the nombrePelicula to set
	 */
	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}
	
	

}
