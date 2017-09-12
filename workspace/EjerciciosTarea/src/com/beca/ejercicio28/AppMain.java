package com.beca.ejercicio28;

import java.util.Vector;

public class AppMain {
	
	public static void main(String[] args) {
		Vector<Manzanas> v = new Vector<Manzanas>();
		Vector<Caballos> c = new Vector<Caballos>();
		
		int manzanasTotal = 4;
		int caballosTotal = 6;
		
		
		for(int i = 0; i < manzanasTotal; i++)
			v.add(new Manzanas());
		
		for(int i = 0; i < caballosTotal; i++)
			c.add(new Caballos());
		
		for (Caballos caballos : c) {
			System.out.println(caballos);
		}
	}

}
