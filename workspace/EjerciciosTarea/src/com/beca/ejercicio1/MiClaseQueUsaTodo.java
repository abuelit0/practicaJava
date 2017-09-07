package com.beca.ejercicio1;

public class MiClaseQueUsaTodo extends MiClaseAbstracta implements MiInterfaz{

	public MiClaseQueUsaTodo(int variableDeInstancia) {
		// TODO Auto-generated constructor stub
		super.setVariableDeInstancia(variableDeInstancia);
	}
	
	@Override
	public void metodoInterfaz() {
		// TODO Auto-generated method stub
		System.out.println("Definicion del metodo de la interfaz");
	}

	@Override
	public void metodoAbstracto() {
		// TODO Auto-generated method stub
		System.out.println("Definicion del metodo de la clase abstracta");
	}

	
}
