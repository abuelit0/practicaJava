package com.beca.ejemplos.base;

import com.beca.exceptions.PruebaException;
import com.beca.interfaz.IEjemplos;

/**
 * Clase de ejemplos para excepciones
 * @author HP
 *
 */
public class Excepciones implements IEjemplos{

	/**
	 * Metodo implementado para la ejecucion de ejemplo
	 */
	public void ejecutaEjemplo(String key) {
		 _ejemplo1();
		EjemploThrows();
	}
	
	@SuppressWarnings("null")
	private void _ejemplo1() {
		int[] grades = null;

		try {
			for (int i = 0; i < grades.length; i++) {
			}

		} catch (NullPointerException e) {
			System.out.println("Grades maybe empy!");
		} catch (RuntimeException e) {
			System.out.println("Problem while executing");
		} catch (Exception e) {
			System.out.println("Error in checking grades");
		} finally {
			System.out.println("I'm was finish my job here :D");
		}
	}

	private void EjemploThrows() {
		
		try {
			_checaGrades();
		} catch (PruebaException e) {
			System.out.println(e.getMessage());
		}catch (NullPointerException e) {
			
		}
	}

	private void _checaGrades() throws NullPointerException, PruebaException {
		int[] grades = { 81, 0, 75 };

		try {

			for (int i = 0; i < grades.length; i++)
				if (grades[i] <= 0) 
					throw new Exception();
		} catch (Exception e){
			throw new PruebaException("Error: Invalid grade");
		}
	}
}
