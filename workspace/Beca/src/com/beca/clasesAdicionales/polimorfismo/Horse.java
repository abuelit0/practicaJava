package com.beca.clasesAdicionales.polimorfismo;

/**
 * Clase caballo que hereda de la clase animal
 * @author HP
 *
 */
public class Horse extends Animal {
	
	/**
	 * Metodo para mostrar que el caballo esta comiendo
	 */
	@Override
	public void eat() {
		System.out.println("Horse eating ...");
	}
	
	/**
	 * Metodo sobrecargado de como el caballo come de forma diferente
	 * @param s
	 */
	public void eat(String s) {
		System.out.println("Horse eating " + s);
	}

}
