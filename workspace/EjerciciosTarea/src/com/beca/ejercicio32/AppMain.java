package com.beca.ejercicio32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AppMain {
	
	static Copia c = (l) -> {
		List<Long> salida = new ArrayList<Long>();
		
		for (Object object : l) {
			salida.add((Long) object);
		}
		
		return salida;
	};
	
	public static void main(String[] args) {
		
		ArrayList<Long> listaLong = new ArrayList<Long>();
		
		listaLong.add(new Long(0));
		listaLong.add(new Long(1));
		listaLong.add(new Long(2));
		listaLong.add(new Long(3));
		listaLong.add(new Long(4));
		listaLong.add(new Long(5));
		listaLong.add(new Long(6));
		
		List<Long> copia = c.copiaLista(listaLong);
		
		listaLong.set(0, new Long(100));
		
		System.out.println("Arreglos sin modificacion");
		
		System.out.println(listaLong);
		System.out.println(copia);
		
		listaLong.add(new Long(200));
		
		System.out.println("\nArreglos despues de modificar");
		
		System.out.println(listaLong);
		System.out.println(copia);
	}

}

interface Copia{
	public List<Long> copiaLista(List l);
}