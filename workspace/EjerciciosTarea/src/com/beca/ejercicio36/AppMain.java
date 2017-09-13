package com.beca.ejercicio36;

import java.util.ArrayList;

public class AppMain {
	
	public static void main(String[] args) {
		
		ArrayList generica = new ArrayList<>();
		ArrayList<String> cadenas = new ArrayList<>();
		
		
		cadenas.add("Cadena 1");
		cadenas.add("Cadena 2");
		
		System.out.println(cadenas);
		
		System.out.println(generica);
		
		cadenas = generica;
	}
}
