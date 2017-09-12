package com.beca.ejercicio29;

public abstract class Alimento extends Base{
	
	private String descripcion;
	
	public Alimento(String descripcion){
		this.descripcion = descripcion;
	}
	
	public abstract void consumir();

	public String getDescripcion() {
		return descripcion;
	}
}
