package mx.isban.ejemplo.samples.beans;

import java.io.Serializable;


public class SamplesBean implements Serializable{


	private static final long serialVersionUID = 4938985616760440508L;
	
	/**
	 * Parametro A de bean
	 */
	private String paramA;


	/**
	 * @return parametro A de bean
	 */
	public String getParamA() {
		return paramA;
	}

	/**
	 * @param paramA Parametro A de bean
	 */
	public void setParamA(String paramA) {
		this.paramA = paramA;
	}
	
	
}
