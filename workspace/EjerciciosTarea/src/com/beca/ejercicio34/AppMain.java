package com.beca.ejercicio34;

import java.util.Vector;

public class AppMain {

	public static void main(String[] args) {
		
		Vector vector = new Vector();
		
		vector.add(1);
		vector.add("Texto");
		vector.add(true);
		vector.add(new AppMain());
		
		System.out.println(vector.get(1));
		
	}
}
