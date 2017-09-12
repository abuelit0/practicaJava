package com.beca.ejercicio22;

public class AppMain {
	
	/**
	 * Ejemplo de entrada " ,.-"
	 * @param args formato " ,.-"
	 */
	public static void main(String[] args) {
		
		String texto = "3.14, 0x17-5b, cat.dog.";
		
		String separadores = "[" + args[0] + "]+";
		
		String[] parts = texto.split(separadores);
		
		for (String string : parts) {
			System.out.println(string);
		}
	}

}