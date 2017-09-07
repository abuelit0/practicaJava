package com.beca.ejercicio3;

public class SubClase extends Clase{
	
	public SubClase(){
		super("Soy le constructor SubClase");
	}
	
	public SubClase(String mensaje){
		this();
		System.out.println("Mensaje impreso desde el constructor SubClase sin parametros: " + mensaje);
	}
}
