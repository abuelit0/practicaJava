package mx.isban.ejemplo.samples.beans;

import java.io.Serializable;
import java.util.Map;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RequestSampleTrxCommonDTO implements Serializable {

	/**
	 * identificador serial
	 */
	private static final long serialVersionUID = -4052739728371917859L;

	//@NotNull
	@Pattern(regexp="[A-Z][[A-Z]+[0-9]*]*-[A-Z][[A-Z]+[0-9]*]*")
	@Size(min=6, max=13)
	/** idTemplate se conforma de:
	 **   -> nombre transaccion(4) + "-"(1) + nombre formato salida(7-8) 
	 **/
	private String idTemplate;
	
	/**  Codigo de Operacion usado por cmpChannelCics:
	 * - log
	 * - modo profile (isActiveProfileMode): serializar
	 *      y deserializar un objeto para/desde un archivo
	 **/
	//@NotNull
	@Pattern(regexp="[A-Z][[A-Z]+[0-9]*]*")
	@Size(min=10, max=24)
	private String codOper;	

	private RequestSampleTrxHeaderDTO reqTrxHeader;
	
	private Map<String,String> paramIn;
	
	private RequestMetadataAPIDTO reqMetadataAPI;
	
	public String getIdTemplate() {
		return idTemplate;
	}

	public void setIdTemplate(String idTemplate) {
		this.idTemplate = idTemplate;
	}

	public RequestSampleTrxHeaderDTO getReqTrxHeader() {
		return reqTrxHeader;
	}

	public void setReqTrxHeader(RequestSampleTrxHeaderDTO reqTrxHeader) {
		this.reqTrxHeader = reqTrxHeader;
	}

	public Map<String, String> getParamIn() {
		return paramIn;
	}

	public void setParamIn(Map<String, String> paramIn) {
		this.paramIn = paramIn;
	}

	public RequestMetadataAPIDTO getReqMetadataAPI() {
		return reqMetadataAPI;
	}

	public void setReqMetadataAPIDTO(RequestMetadataAPIDTO reqMetadataAPI) {
		this.reqMetadataAPI = reqMetadataAPI;
	}

	public String getCodOper() {
		return codOper;
	}

	public void setCodOper(String codOper) {
		this.codOper = codOper;
	}
	
		
}
