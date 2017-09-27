package mx.isban.ejemplo.samples.beans;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CicsBean implements Serializable{

	
	private static final long serialVersionUID = 4938985616760440508L;
	
	/**
	 * Usuario de Transaccion
	 */
	@NotNull
	@Size(min=8, max=8)
	private String usuario;

	/**
	 * Nombre de Transaccion
	 */
	@NotNull
	@Size(min=4, max=4)
	private String transaccion;

	/**
	 * Longitud de Transaccion
	 */
	@NotNull
	@Size(min=4, max=4)
	private String longitud;
	
	/**
	 * Trama de entrada
	 */
	@Size(min=1, max=1000)
	private String trama;
	
	/**
	 * Respuesta de transaccion
	 */
	private String respuesta;
	
	/**
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * @return Usuario de transaccion
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario Usuario de transaccion
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

	/**
	 * @return the transaccion
	 */
	public String getTransaccion() {
		return transaccion;
	}

	/**
	 * @param transaccion the transaccion to set
	 */
	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}

	/**
	 * @return the longitud
	 */
	public String getLongitud() {
		return longitud;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	/**
	 * @return the trama
	 */
	public String getTrama() {
		return trama;
	}

	/**
	 * @param trama the trama to set
	 */
	public void setTrama(String trama) {
		this.trama = trama;
	}
}
