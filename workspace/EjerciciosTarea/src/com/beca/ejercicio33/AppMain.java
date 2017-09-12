package com.beca.ejercicio33;

import java.util.ArrayList;
import java.util.Iterator;

public class AppMain {
	
	static Recorrer r = (l) -> {
		
		Iterator<Long> i = l.iterator();
		
		while(i.hasNext())
			System.out.println(i.next());
		
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
		
		r.itera(listaLong);
	}
}

interface Recorrer{
	public void itera(ArrayList<Long> l);
}
