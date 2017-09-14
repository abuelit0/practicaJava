package com.beca.ejercicio41;


/*
 * java -DLapatita="Valor enviado desde consola" AppMain
 * 
 *
 */
public class AppMain {

	public static void main(String ... args){

		System.setProperty("Metodo", "Valor enviado atravez del metodo de System");

		System.out.println(System.getProperty("Metodo"));
		System.out.println(System.getProperty("Lapatita"));

	}
}