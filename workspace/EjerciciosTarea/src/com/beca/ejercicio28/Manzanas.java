package com.beca.ejercicio28;

public class Manzanas {
	
	static int totalManzanas = 0;
	private int numeroManzana;
	
	public Manzanas(){
		setNumeroManzana(++totalManzanas);
	}

	public int getNumeroManzana() {
		return numeroManzana;
	}

	public void setNumeroManzana(int numeroManzana) {
		this.numeroManzana = numeroManzana;
	}

}
