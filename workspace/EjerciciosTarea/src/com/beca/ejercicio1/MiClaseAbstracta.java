package com.beca.ejercicio1;

public abstract class MiClaseAbstracta {

	private int variableDeInstancia;
	
	public void metodoNoAbstracto(){
		System.out.println("Metodo no abstracto");
	}
	
	public abstract void metodoAbstracto();

	public int getVariableDeInstancia() {
		return variableDeInstancia;
	}

	public void setVariableDeInstancia(int variableDeInstancia) {
		this.variableDeInstancia = variableDeInstancia;
	}
}
