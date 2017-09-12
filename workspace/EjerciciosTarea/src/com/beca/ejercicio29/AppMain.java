package com.beca.ejercicio29;

public class AppMain {
	
	public static void main(String[] args) {
		Lunch lunch = new Lunch("Jamon", "Naranja");
		
		System.out.println(lunch);
		
		lunch.consumir();
	}

}
