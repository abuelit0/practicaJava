package com.beca.ejercicio3;

public class SubSubClase extends SubClase{

	public SubSubClase(){
		super("Soy le constructor SubSubClase");
	}
	
	public SubSubClase(String mensaje){
		this();
		System.out.println("Mensaje impreso desde el constructor SubSubClase sin parametros: " + mensaje);
	}
}
