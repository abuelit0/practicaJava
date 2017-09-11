package com.beca.clasesAdicionales.polimorfismo;

public class Horse extends Animal {
	
	@Override
	public void eat() {
		System.out.println("Horse eating ...");
	}
	
	public void eat(String s) {
		System.out.println("Horse eating " + s);
	}

}
