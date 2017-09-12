package com.beca.ejercicio27;

public class SuperClase {
	
	static int objetosCreados = 0;
	
	private String color;
	private int referencia;
	
	public SuperClase(){
		this.color = "Blanco";
		this.referencia = objetosCreados++;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getReferencia() {
		return referencia;
	}
	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}
	
	public String toString(){
		return "Valores super clase: " + color + ", " + referencia;
	}
	
}
