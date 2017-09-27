package mx.isban.ejemplo.domicilios.beans;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;


public class DomicilioBean {


	@Size(min=1, max=40)
	private String calle;

	@Size(min=1, max=40)
	private String colonia;

	@Size(min=1, max=40)
	private String municipio;
	
	@Size(min=2, max=3)
	private String estado;

	@Range(min=1, max=1000000)
	private String numeroInt;

	@Range(min=1, max=1000001)
	private String numeroExt;

	@Range(min=10000, max=99999)
	private String codigoPostal;

	@AssertTrue
	private boolean activo;


	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumeroInt() {
		return numeroInt;
	}

	public void setNumeroInt(String numeroInt) {
		this.numeroInt = numeroInt;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getNumeroExt() {
		return numeroExt;
	}

	public void setNumeroExt(String numeroExt) {
		this.numeroExt = numeroExt;
	}


	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
