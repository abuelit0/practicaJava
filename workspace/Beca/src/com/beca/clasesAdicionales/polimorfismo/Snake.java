package com.beca.clasesAdicionales.polimorfismo;

/**
 * Clase que hereda de la clase animal para ejemplificar la herencia
 * @author HP
 *
 */
public class Snake extends Animal {
	
	/**
	 * Forma direrente en la que come la serpiente
	 */
	@Override
	public void eat() {
		System.out.println("Snake eating ...");
	}

}
