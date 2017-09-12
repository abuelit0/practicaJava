package com.beca.ejercicio23;

import java.util.regex.Pattern;

public class AppMain {
	
	public static void main(String[] args) {
		
		System.out.println(tipoCadena("123"));
		System.out.println(tipoCadena("qwe"));
		System.out.println(tipoCadena("123qwe"));
		
	}
	
	private static String tipoCadena(String entrada){
		return 
			Pattern.matches("[0-9]*", entrada) ? "Numerico" : 
			Pattern.matches("[a-zA-Z]*", entrada) ? "Alfabetico" : 
			"Mixto";
	}

}
