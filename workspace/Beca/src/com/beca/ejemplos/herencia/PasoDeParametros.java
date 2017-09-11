package com.beca.ejemplos.herencia;

import com.beca.clasesAdicionales.MiObjeto;
import com.beca.interfaz.IEjemplos;

public class PasoDeParametros implements IEjemplos {

	public void ejecutaEjemplo(String key) {
		
		StringBuilder mensaje = new StringBuilder("Hola mundo");
		MiObjeto objeto = new MiObjeto();
		int valInt = 1;
		
		System.out.println("Ejemplo con StringBuilder:");
		
		System.out.println(mensaje);
		_pruebaConString(mensaje);
		System.out.println(mensaje);
		
		System.out.println("\nEjemplo con objetos:");
		
		System.out.println(objeto);
		_metodoReferencia(objeto);
		System.out.println(objeto);
		
		System.out.println("\nEjemplo con variables:");
		
		System.out.println("Valor original:\t" + valInt);
		_metodoParametro(valInt);
		System.out.println("Valor nuevo:\t" + valInt);
	}
	
	private void _metodoReferencia(MiObjeto m) {
		m.setValorCadena("Nuevo valor");
		m.setValorEntero(10);
	}
	
	private void _metodoParametro(int valor) {
		valor = 0;
	}
	
	private void _pruebaConString(StringBuilder cadena) {
		//cadena = "Otra cosa";
		cadena.replace(0, cadena.length(), "Nuevo mensaje");
	}
}
