package com.beca.ejercicio35;

import java.util.ArrayList;

public class AppMain {
	
	public static void main(String[] args) {
		
		ClaseColeccion c = new ClaseColeccion();
		
		c.agregar("uno");
		c.agregar("dos");
		c.agregar("tres");
		c.agregar("cuatro");
		
		c.imprime();
		
	}
}

class ClaseColeccion{
	
	private ArrayList<String> cadenas;
	
	public ClaseColeccion(){
		cadenas = new ArrayList<>();
	}
	
	public void agregar(String elemento){
		cadenas.add(elemento);
	}
	
	public void imprime(){
		cadenas.stream().forEach(x -> System.out.println(x));
	}
	
	
}