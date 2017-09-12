package com.beca.ejercicio16;

import java.math.BigDecimal;

public class AppMain {
	
	public static void main(String[] args) {
		double numero = 999999.23;
		
		Double entrada = new Double(numero);
		
		System.out.println(retornaFormato(entrada.toString()));
	}
	
	private static String retornaFormato(String entrada) {
		StringBuilder salida = new StringBuilder();
		
		BigDecimal number = new BigDecimal(entrada);
		long iPart = number.longValue();
		
		
		BigDecimal fraccion = number.remainder(BigDecimal.ONE);
	
		int decimal = (int)(fraccion.doubleValue()*100);
		
		decimal = Math.abs(decimal);
		
		String decimales = decimal == 0 ? "00" : decimal < 9 ? "0" + decimal : "" + decimal;
		
		salida.append("$" + iPart + "." + decimales);
		
		return salida.toString();
	}

}
