package mx.isban.ejemplo.clientes.beans;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

public class ClientesWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -675988936518995215L;
	
	@Valid
	private List<ClienteBean> clientes;
	
	public ClientesWrapper(){
		
	}
	
	public ClientesWrapper(List<ClienteBean> cl){
		clientes = cl;
	}

	public List<ClienteBean> getClientes() {
		return clientes;
	}

	public void setClientes(List<ClienteBean> clientes) {
		this.clientes = clientes;
	}

}
