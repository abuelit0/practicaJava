package mx.isban.ejemplo.modulo1.ejb;

import mx.isban.agave.commons.beans.ArchitechSessionBean;
import mx.isban.agave.commons.exception.BusinessException;
import mx.isban.ejemplo.modulo1.beans.ResultUsuarioBean;
import mx.isban.ejemplo.modulo1.beans.UsuarioBean;

public interface BOUsuarios {
	
	public ResultUsuarioBean validaUsuario(UsuarioBean valor, ArchitechSessionBean asb) throws BusinessException;

}
