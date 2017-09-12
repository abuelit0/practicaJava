package com.beca.ejercicio25;

import java.io.IOException;

public class AppMain {
	
	public static void main(String[] args) {
		Original original = new Original();
		Copia copia = new Copia();
		
		try {
			System.out.println(original.saludo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(copia.saludo(10));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
