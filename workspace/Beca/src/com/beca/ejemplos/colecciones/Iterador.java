package com.beca.ejemplos.colecciones;

import java.util.HashSet;
import java.util.Iterator;

import com.beca.interfaz.IEjemplos;

public class Iterador implements IEjemplos{

	@Override
	public void ejecutaEjemplo(String arg) {
		// TODO Auto-generated method stub
		prubeaIterador();
	}
	
	private void prubeaIterador(){
		
		HashSet hs = new HashSet();
		
		for(int i =  122; i >= 97; i--)
			hs.add((char)i);
		
		Iterator iterador = hs.iterator();
		
		while(iterador.hasNext()){
			System.out.println(iterador.next());
		}
	}
}
