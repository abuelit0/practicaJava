package com.beca.ejercicio17;

public class AppMain {
	
	public static void main(String[] args) {
		
		String numero = "10";
		Integer entero = new Integer(1);
		
		int numeroEntero = Integer.parseInt(numero);
		
		double numeroDoble = entero.doubleValue();
		
		System.out.println(numeroEntero);
		System.out.println(numeroDoble);
		System.out.println(Integer.valueOf(numero));
	}

}
