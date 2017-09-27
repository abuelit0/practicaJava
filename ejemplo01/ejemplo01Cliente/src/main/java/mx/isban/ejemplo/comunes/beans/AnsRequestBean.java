package mx.isban.ejemplo.comunes.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import mx.isban.ejemplo.comunes.utils.E_WS_STATUS;


@XmlRootElement(name="ansRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
	name = "ansRequest", 
	propOrder = {
		"ansStatus",
		"ansPayload",
	}
)
@JsonPropertyOrder(
	{"ansStatus", "ansPayload", }
)
/**
 * Clase de envoltura de una peticion al servicio web
 * @author bonifacio.velazquez
 * @param <T> El objeto con el payload vendr&aacute; definido en esta secci&oacute;n
 */
public class AnsRequestBean<T> extends BaseBean {
	
	/**
	 * Id de serializaci&oacute;n
	 */
	private static final long serialVersionUID = -3938371318307576143L;

	/**
	 * Contenedor del payload
	 * @XmlElement(name="ansPayload")
	 */
	private T ansPayload;

	/**
	 * Codigo de la operacion
	 */
	private E_WS_STATUS ansStatus = E_WS_STATUS.ENVIO;

	/**
	 * Constructor default
	 */
	public AnsRequestBean() {
		super();
	}

	/**
	 * @return El valor del atributo ansPayload
	 */
	public T getAnsPayload() {
		return ansPayload;
	}

	/**
	 * @return El valor del atributo ansStatus
	 */
	public E_WS_STATUS getAnsStatus() {
		return ansStatus;
	}

	/**
	 * @param ansPayload El valor que se asignar&aacute; al atributo ansPayload
	 */
	public void setAnsPayload(T ansPayload) {
		this.ansPayload = ansPayload;
	}

	/**
	 * @param ansStatus El valor que se asignar&aacute; al atributo ansStatus
	 */
	public void setAnsStatus(E_WS_STATUS ansStatus) {
		this.ansStatus = ansStatus;
	}
	
}
