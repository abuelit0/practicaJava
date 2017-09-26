package com.beca.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.beca.interfaz.IEjemplos;
import com.beca.interfaz.Operaciones;

/**
 * Clase para probar lambdas
 * @author HP
 *
 */
public class Lambda implements IEjemplos{

	@Override
	public void ejecutaEjemplo(String arg) {
		recorridoArreglo();
		metodoLambda();
	}
	
	private void recorridoArreglo(){
		
		System.out.println("Primera forma");
		
		List<String> myList = Arrays.asList("a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3");
		
		myList.stream().filter(s -> s.startsWith("b"))
		.map(String::toUpperCase)
		.sorted()
		.forEach(System.out::println);
		
		System.out.println("Segunda forma");
		
		Integer [] source = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		Stream<Integer> pares = Arrays
				.stream(source)
				.parallel()
				.filter(x -> esPar(x));
		
		pares.forEachOrdered(x -> System.out.println(x));
		
		pares.close();
	}
	
	boolean esPar(int x){
		return x%2 == 0 ? true : false;
	}
	
	private void metodoLambda(){
		
		int a1 = 10;
		int b1 = 2;
		
		Operaciones suma = (a, b) -> a + b;
		
		Operaciones resta = (a, b) -> a - b;
		
		Operaciones multiplicacion = (a, b) -> a * b;
		
		ejecuta(suma, a1, b1);
		ejecuta(resta, a1, b1 );
		ejecuta(multiplicacion, a1, b1 );
	}
	
	private void ejecuta(Operaciones o, int a, int b){
		System.out.println(o.operacion(a, b));
	}
}


