package com.beca.clasesAdicionales;

/**
 * Clase para mostrar ejemplo del toString
 * @author HP
 *
 */
public class MiBaseClass {

	/**
	 * Metodo sobreescrito del toString
	 */
	public String toString(){
		return this.getClass().getSimpleName();
	}
}
