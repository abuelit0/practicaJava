package mx.isban.ejemplo.samples.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class ResponseCicsDTO.
 */
public class ResponseSampleCicsDTO implements Serializable {

	/** identificador serial. */
	private static final long serialVersionUID = -1352282317069264183L;

	/** The param out. */
	private List<Map<String,String>> paramOut;
	
	/** The extras. */
	private String extras;
	
	/** The out mas pag. */
	private String outMasPag;

	/** The result code. */
	private String resultCode;
	
	/** The result msg. */
	private String resultMsg;
	
	/** The avisos. */
	private List<String> avisos;

	/** The errores. */
	private List<String> errores;
	
	/**
	 * Gets the param out.
	 *
	 * @return the param out
	 */
	public List<Map<String, String>> getParamOut() {
		return paramOut;
	}

	/**
	 * Sets the param out.
	 *
	 * @param paramOut the param out
	 */
	public void setParamOut(List<Map<String, String>> paramOut) {
		this.paramOut = paramOut;
	}

	/**
	 * Gets the result code.
	 *
	 * @return the result code
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * Sets the result code.
	 *
	 * @param resultCode the new result code
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * Gets the result msg.
	 *
	 * @return the result msg
	 */
	public String getResultMsg() {
		return resultMsg;
	}

	/**
	 * Sets the result msg.
	 *
	 * @param resultMsg the new result msg
	 */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	/**
	 * Gets the extras.
	 *
	 * @return the extras
	 */
	public String getExtras() {
		return extras;
	}

	/**
	 * Sets the extras.
	 *
	 * @param extras the new extras
	 */
	public void setExtras(String extras) {
		this.extras = extras;
	}

	/**
	 * Gets the out mas pag.
	 *
	 * @return the out mas pag
	 */
	public String getOutMasPag() {
		return outMasPag;
	}

	/**
	 * Sets the out mas pag.
	 *
	 * @param outMasPag the new out mas pag
	 */
	public void setOutMasPag(String outMasPag) {
		this.outMasPag = outMasPag;
	}

	/**
	 * Gets the avisos.
	 *
	 * @return the avisos
	 */
	public List<String> getAvisos() {
		return avisos;
	}

	/**
	 * Sets the avisos.
	 *
	 * @param avisos the new avisos
	 */
	public void setAvisos(List<String> avisos) {
		this.avisos = avisos;
	}

	/**
	 * Gets the errores.
	 *
	 * @return the errores
	 */
	public List<String> getErrores() {
		return errores;
	}

	/**
	 * Sets the errores.
	 *
	 * @param errores the new errores
	 */
	public void setErrores(List<String> errores) {
		this.errores = errores;
	}	
		
	
	
}
