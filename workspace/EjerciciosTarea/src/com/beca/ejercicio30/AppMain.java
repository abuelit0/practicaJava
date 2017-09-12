package com.beca.ejercicio30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AppMain {
	
	public static void main(String[] args) {
		ArrayList<String> cadenas = new ArrayList<String>();
		
		cadenas.add("a");
		cadenas.add("b");
		cadenas.add("c");
		cadenas.add("d");
		cadenas.add("e");
		cadenas.add("f");
		cadenas.add("g");
		cadenas.add("h");		
		
		System.out.println(cadenas.get(5));
		
		try{
			System.out.println(cadenas.get(20));
		}catch(IndexOutOfBoundsException e){
			System.out.println("El elemento no se a encontrado: " + e.getMessage());
		}finally{
			System.out.println(cadenas);
			
			Collections.reverse(cadenas);
			
			System.out.println(cadenas);
		}
	}

}
