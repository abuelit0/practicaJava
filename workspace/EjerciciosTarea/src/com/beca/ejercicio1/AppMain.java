package com.beca.ejercicio1;

public class AppMain {
	public static void main(String[] args) {
	
		MiClaseQueUsaTodo objeto = new MiClaseQueUsaTodo(100);
		
		objeto.metodoAbstracto();
		objeto.metodoInterfaz();
		objeto.metodoNoAbstracto();
		
		System.out.println("Variable de instancia:\t" + objeto.getVariableDeInstancia() + "\nConstadte:\t\t" + objeto.constante);
		
	}
}
