package mx.isban.ejemplo.modulo1.beans;

import java.io.Serializable;

import mx.isban.agave.commons.exception.BusinessException;

public class UsuarioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2160561054799921448L;
	
	private String nombreUsuario;

	public String getNombreUsuario() throws BusinessException {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	
}
