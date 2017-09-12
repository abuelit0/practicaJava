package com.beca.ejercicio29;

public class Lunch {
	
	private Torta torta;
	private Jugo jugo;
	
	public Lunch(String ingredientePrincipal, String sabor){
		torta = new Torta(ingredientePrincipal);
		jugo = new Jugo(sabor);
	}
	
	public void consumir(){
		
		torta.consumir();
		jugo.consumir();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName() + ":\n" + torta + " y " + jugo;
	}

}
