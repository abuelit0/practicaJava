package com.beca.ejercicio18;

public class AppMain {

	public static void main(String[] args) {
		
		String result = "original";
		
		result.concat(" nuevo mensaje");
		
		System.out.println(result);
		
		result = result.concat(" nuevo mensaje");
		
		System.out.println(result);
	}
}
