package com.beca.ejemplos.base;

import com.beca.exceptions.PruebaException;
import com.beca.interfaz.IEjemplos;

public class Excepciones implements IEjemplos{

	public void ejecutaEjemplo(String key) {
		// TODO Auto-generated method stub
		 _ejemplo1();
		EjemploThrows();
	}

	public void otra(String a) {
		
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
			// TODO: handle exception
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
			//throw new PruebaException("Error: Invalid grade", grades);
			throw new PruebaException("Error: Invalid grade");
		}

	}

}