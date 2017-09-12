package com.beca.ejercicio29;

public class Bebida extends Alimento{
	
	private String sabor;
	private int mililitros;
	
	public Bebida(String sabor) {
		super("Alimento liquido");
		
		this.sabor = sabor;
	}

	public void consumir() {
		System.out.println("Blub, blub, blub .... ahh!");
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public int getMililitros() {
		return mililitros;
	}

	public void setMililitros(int mililitros) {
		this.mililitros = mililitros;
	}
}
