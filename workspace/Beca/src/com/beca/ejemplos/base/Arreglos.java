package com.beca.ejemplos.base;

import com.beca.clasesAdicionales.Persona;
import com.beca.interfaz.IEjemplos;

/**
 * 
 * @author Luis Guillermo
 *
 *	Ejemplos para ver arreglos
 */
public class Arreglos implements IEjemplos {

	public void ejecutaEjemplo(String key) {
		
		ejemplo1();
		ejemplo2();
		ejemplo3();
	}
	
	/**
	 * Definicion de un arreglo
	 */
	private void ejemplo1() {
		int []scores;
		
		scores = new int[3];
		
		scores[0] = 10;
		//scores[1] = 7;
		scores[2] = 9;
		
		System.out.println(scores);
	}
	
	/**
	 * Recorrer un arreglo
	 */
	private void ejemplo2() {
		int []numbers = new int[3];
		
		numbers[0] = 100;
		numbers[1] = 200;
		numbers[2] = 300;
		
		int []newNumbers = {100, 200, 300};
		
		imprimeArreglo(newNumbers);
		imprimeArreglo(new int[]{1,2,3,4});
		numbers = newNumbers;
	}
	
	private void ejemplo3() {
		Persona you = new Persona();
		
		you.talk();
		you.jump(3);
		
		System.out.println(you.tellAge());
		
		Arreglos.talkOnly(you);
		
		Arreglos m = new Arreglos();
		m.jumpOnly(you);
	}
	
	static void talkOnly(Persona p) {
		p.talk();
	}
	
	void jumpOnly(Persona p) {
		p.jump(2);
	}
	
	/**
	 * Imprime un arreglo de numeros
	 * @param n Arreglo de enteros
	 */
	private void imprimeArreglo(int []n) {
		for (int i : n) {
			System.out.println(i);
		}
	}
}


