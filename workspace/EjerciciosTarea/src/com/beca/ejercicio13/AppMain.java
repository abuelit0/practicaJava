package com.beca.ejercicio13;

public class AppMain {

	public static void main(String[] args) {
		
		Persona padre = new Persona(30, "Padre");
		
		Persona []personas = {
				new Persona(22, "Adulto 1"),
				new Persona(34, "Adulto 2"),
				new Persona(17, "Adolecente 1"),
				new Persona(7, "Ni�o 1", padre),
				new Persona(15, "Adolecente 2")
		};
		
		for (Persona persona : personas) {
			try {
				administraEntrada(persona);
			} catch (MenorDeEdadException | AdolecenteException e) {
				// TODO Auto-generated catch block
				ManejadorDeExcepciones.administraExcepcion(e);
			}
		}
	}
	
	
	public static void administraEntrada(Persona cliente) throws MenorDeEdadException, AdolecenteException{
		
		if(cliente.getEdad() < 12)
			throw new MenorDeEdadException(cliente);
		
		if(cliente.getEdad() < 18)
			throw new AdolecenteException(cliente);
		
		System.out.println("Bienvenido: " + cliente);
	}
}
