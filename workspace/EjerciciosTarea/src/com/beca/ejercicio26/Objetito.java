package com.beca.ejercicio26;

public class Objetito {
	
	private String nombre;
	private String color;
	private int altura;
	private String configuracion;
	
	private Objetito(String configuracion){
		this.configuracion = configuracion;
	}

	Objetito() {
		this("Default");
	}
	
	protected Objetito(int altura, String color){
		this("Protected");
		this.altura = altura;
		this.color = color;
	}
	
	public Objetito(String nombre, int altura){
		this("Public");
		this.nombre = nombre;
		this.altura = altura;
	}
	
	public String toString(){
		return "\nConfiguracion: " + this.configuracion + 
				"\nColor: " + this.color + 
				"\nNombre: " + this.nombre +
				"\nAltura: " + this.altura;
	}
}
