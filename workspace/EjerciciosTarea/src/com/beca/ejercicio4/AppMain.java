package com.beca.ejercicio4;

public class AppMain {

	public static void main(String[] args) {
		ClaseObjeto objeto = new ClaseObjeto("Nuevo objeto");
		
		System.out.println(objeto);
		
		objeto = new ClaseObjeto();
		
		System.out.println(objeto);
		
		System.out.println(ClaseObjeto.objetos);
	}
}
