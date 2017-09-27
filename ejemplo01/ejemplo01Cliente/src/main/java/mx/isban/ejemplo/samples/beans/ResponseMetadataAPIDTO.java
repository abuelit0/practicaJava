package mx.isban.ejemplo.samples.beans;

import java.io.Serializable;

/**
 * The Class ResponseMetadataAPIDTO.
 */
public class ResponseMetadataAPIDTO implements Serializable {
	
	/** identificador serial. */
	private static final long serialVersionUID = -801758327900468469L;
	
	/** The result. */
	private String result;

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Sets the result.
	 *
	 * @param result the new result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
}

