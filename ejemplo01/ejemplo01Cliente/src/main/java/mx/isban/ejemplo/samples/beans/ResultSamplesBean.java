package mx.isban.ejemplo.samples.beans;

import java.io.Serializable;

public class ResultSamplesBean implements Serializable{

	private static final long serialVersionUID = 4938985616760440508L;
	
	/**
	 * Parametro A de resultado
	 */
	private String paramA;


	/**
	 * @return parametro A de resultado
	 */
	public String getParamA() {
		return paramA;
	}

	/**
	 * @param paramA Parametro A de resultado
	 */
	public void setParamA(String paramA) {
		this.paramA = paramA;
	}
	

}
