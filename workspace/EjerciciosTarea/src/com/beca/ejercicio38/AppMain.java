package com.beca.ejercicio38;

public class AppMain {
	
	static Operacion primos = (n) -> {
		
		boolean salida = true;
		int cont = 0;

		for(int i = 1; i < n; i++){
			System.out.println("Ejecuta ... " + i);
			if(n % i == 0)
				cont++;
			if(cont > 1){
				salida = false;
				break;
			}
		}
		
		return salida;
	};
	
	static Operacion pares = (n) -> {
		return n%2 == 0 ? true : false;
	};
	
	public static void main(String[] args) {
		
		int evaluado = 83;
		
		System.out.println("no-short-circuit");
		
		if(pares.is(evaluado) & primos.is(evaluado))
			System.out.println("Es par y primo");
		else
			System.out.println("No es par ni primo");
		
		System.out.println("short-circuit");
		
		if(pares.is(evaluado) && primos.is(evaluado))
			System.out.println("Es par y primo");
		else
			System.out.println("No es par ni primo");
		
	}

}
interface Operacion {
	public boolean is(int n);
}
