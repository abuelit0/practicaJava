package mx.isban.ejemplo.modulo1.beans;

import java.io.Serializable;

public class ResultUsuarioBean implements Serializable{

	/**
	 * 
	 */
	private String usuario;
	
	public ResultUsuarioBean(String us){
		usuario = us;
	}
	
	private static final long serialVersionUID = 4938985616760440508L;

	public String getExisteUsuario() {
		return "Hola mundo "+usuario;
	}

}
