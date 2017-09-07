package com.beca.ejercicio3;

public class Clase {
	
	public Clase(){
		System.out.println("Constructor sin parametro clase Clase");
	}
	
	public Clase(String mensaje){
		this();
		System.out.println("Mensaje impreso desde el constructor Clase sin parametros: " + mensaje);
	}

}
