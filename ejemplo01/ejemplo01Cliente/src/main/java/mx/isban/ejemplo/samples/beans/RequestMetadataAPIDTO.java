package mx.isban.ejemplo.samples.beans;

import java.io.Serializable;


public class RequestMetadataAPIDTO implements Serializable {

	/**
	 * identificador serial
	 */
	private static final long serialVersionUID = 902990381766960825L;
	
	private String idSesion;

	public String getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}
	
}
