package mx.isban.ejemplo.comunes.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import mx.isban.ejemplo.comunes.utils.E_WS_STATUS;


/**
 * Clase de envoltura de una respuesta del servicio we
 * 
 * @author bonifacio.velazquez
 * @param <T>
 *            Objeto generico con los datos de salida
 */
@XmlRootElement(name = "ansResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ansResponse", propOrder = { "ansStatus", "ansMessage", "ansCount", "ansType", "ansResult" })
@JsonPropertyOrder({ "ansStatus", "ansMessage", "ansCount", "ansType", "ansResult" })
public class AnsResponseBean<T> extends BaseBean {

	/**
	 * Id de serializacion
	 */
	private static final long serialVersionUID = -2585979893971024126L;

	/**
	 * Contador de resultados que la operacion regresa
	 */
	private Integer ansCount = Integer.valueOf(-1);

	/**
	 * Mensaje de la operaci&oacute;n
	 */
	private String ansMessage = "Sin ejecucion aun";

	/**
	 * Contenedor del payload
	 * 
	 * @XmlElement(name="ansResult")
	 */
	private T ansResult;

	/**
	 * Indicador del estatus de la operai&oacute;n
	 */
	private E_WS_STATUS ansStatus = E_WS_STATUS.DEFAULT;

	/**
	 * Tipo del objeto de retorno
	 */
	private String ansType;

	/**
	 * Constructor default
	 */
	public AnsResponseBean() {
		super();
	}

	/**
	 * Constructor que inicializa el objeto con los atributos enviados
	 * 
	 * @param code
	 *            Codigo de salida
	 */
	public AnsResponseBean(E_WS_STATUS code) {
		this(code, null);
	}

	/**
	 * Constructor que inicializa el objeto con los atributos enviados
	 * 
	 * @param code
	 *            Codigo de salida
	 * @param message
	 *            Mensaje de salida
	 */
	public AnsResponseBean(E_WS_STATUS code, String message) {
		this(code, message, -1);
	}

	/**
	 * Constructor que inicializa el objeto con los atributos enviados
	 * 
	 * @param code
	 *            Codigo de salida
	 * @param message
	 *            Mensaje de salida
	 * @param count
	 *            Contador de registros
	 * 
	 */
	public AnsResponseBean(E_WS_STATUS code, String message, Integer count) {
		this(code, message, count, null);
	}

	/**
	 * Constructor que inicializa el objeto con los atributos enviados
	 * 
	 * @param code
	 *            Codigo de salida
	 * @param message
	 *            Mensaje de salida
	 * @param count
	 *            Contador de registros
	 * @param object
	 *            Datos del payload de salida
	 */
	public AnsResponseBean(E_WS_STATUS code, String message, Integer count, T object) {
		this();
		this.ansStatus = code;
		this.ansMessage = message;
		this.ansCount = count;
		if (object != null) {
			this.ansResult = object;
		}
	}

	/**
	 * @return Contador de registros
	 */
	public Integer getAnsCount() {
		return ansCount;
	}

	/**
	 * @return Mensaje de salida
	 */
	public String getAnsMessage() {
		return ansMessage;
	}

	/**
	 * @return Datos de salida
	 */
	public T getAnsResult() {
		return ansResult;
	}

	/**
	 * @return El valor del atributo ansStatus
	 */
	public E_WS_STATUS getAnsStatus() {
		return ansStatus;
	}

	/**
	 * @return El tipo de dato de salida
	 */
	public String getAnsType() {
		if (ansResult != null) {
			setAnsType(ansResult.getClass().getSimpleName());
		}
		return this.ansType;
	}

	/**
	 * @param ansCount
	 *            Contador a asignar
	 */
	public void setAnsCount(Integer ansCount) {
		this.ansCount = ansCount;
	}

	/**
	 * @param ansMessage
	 *            Mensaje a asignar
	 */
	public void setAnsMessage(String ansMessage) {
		this.ansMessage = ansMessage;
	}

	/**
	 * @param ansResult
	 *            Resultado a asignar
	 */
	public void setAnsResult(T ansResult) {
		this.ansResult = ansResult;
	}

	/**
	 * @param ansStatus
	 *            El valor que se asignar&aacute; al atributo ansStatus
	 */
	public void setAnsStatus(E_WS_STATUS ansStatus) {
		this.ansStatus = ansStatus;
	}

	/**
	 * @param ansType
	 *            tipo de dato a asignar
	 */
	public void setAnsType(String ansType) {
		this.ansType = ansType;
	}

}
