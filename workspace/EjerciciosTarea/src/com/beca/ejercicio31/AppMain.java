package com.beca.ejercicio31;

import java.util.ArrayList;
import java.util.Collections;

public class AppMain {
	
	public static void main(String[] args) {
		ArrayList<String> cadenas = new ArrayList<String>();
		
		cadenas.add("a");
		cadenas.add("b");
		cadenas.add("c");
		cadenas.add("d");
		cadenas.add("e");
		cadenas.add("a");
		cadenas.add("g");
		cadenas.add("h");
		
		Collections.singleton("a").forEach(System.out::println);;
		
		Collections.singleton("z").forEach(System.out::println);;
		
		
	}

}
