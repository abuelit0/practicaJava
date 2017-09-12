package com.beca.ejercicio21;

public class AppMain {
	
	public static void main(String[] args) {
		
		String valor = "345.67";
		
		double valorDoble;
		int valorEntero;
		
		valorDoble = Double.parseDouble(valor);
		valorEntero = (int)Double.parseDouble(valor);
		
		System.out.println(valorDoble);
		System.out.println(valorEntero);
	}
}
