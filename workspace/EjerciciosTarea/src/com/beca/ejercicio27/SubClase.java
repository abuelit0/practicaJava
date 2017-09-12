package com.beca.ejercicio27;

public class SubClase extends SuperClase{
	
	private String detalle;
	private int valor;
	
	public SubClase(String detalle, int valor){
		super();
		
		this.detalle = detalle;
		this.valor = valor;
	}
	

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String toString(){
		return super.toString() + "\nValores subclase: " + detalle + ", " + valor;
	}
	
}
