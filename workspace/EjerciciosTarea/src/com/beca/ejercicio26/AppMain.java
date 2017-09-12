package com.beca.ejercicio26;

public class AppMain {
	
	public static void main(String[] args) {
		
		Objetito objetoDefault = new Objetito();
		Objetito objetoProtegido = new Objetito(10, "Rojo");
		Objetito objetoPublic = new Objetito("Rojo", 10);
		
		System.out.println(objetoDefault);
		System.out.println(objetoProtegido);
		System.out.println(objetoPublic);
	}

}
