package com.beca.util;

import java.util.Scanner;

public class Utilidades {
	
	private static Scanner _e = new Scanner(System.in);
	
	public static String LeeCadena(){
		String salida = "";
		
		salida = _e.nextLine();
		
		return salida;
	}
	
	public static int LeeNumero(){		
		return Integer.parseInt(LeeCadena());
	}
	
	
}
