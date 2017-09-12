package com.beca.ejercicio31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppMain {
	
	static Buscador b = (lista, elemento) -> {
		
		Comparator<String> c = new Comparator<String>() {
	      public int compare(String u1, String u2) {
	        return u1.compareTo(u2);
	      }
	    };
	    
	    String mensaje = Collections.binarySearch(lista, elemento, c) >= 0 ? "Se encontro el objeto" : "No esta el elemento";
		
	    return mensaje;
	};
	
	public static void main(String[] args) {
		
		List<String> cadenas = new ArrayList<String>();
		
		cadenas.add("a");
		cadenas.add("b");
		cadenas.add("c");
		cadenas.add("d");
		cadenas.add("e");
		cadenas.add("g");
		cadenas.add("h");
		
		
		String busqueda1 = "b";
		String busqueda2 = "z";
		
		System.out.println(b.busca(cadenas, busqueda1));
		System.out.println(b.busca(cadenas, busqueda2));
		
	}

}

interface Buscador{
	public String busca(List<String> lista, String elemento);
}
