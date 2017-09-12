package com.beca.ejercicio29;

public class Comida extends Alimento{
	
	private String ingredientePrincipal;

	public Comida(String ingredientePrincipal) {
		super("Alimento solido");
		
		this.setIngredientePrincipal(ingredientePrincipal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void consumir() {
		// TODO Auto-generated method stub
		System.out.println("Chom, chom, chom ... mmmmmm!");
	}

	public String getIngredientePrincipal() {
		return ingredientePrincipal;
	}

	public void setIngredientePrincipal(String ingredientePrincipal) {
		this.ingredientePrincipal = ingredientePrincipal;
	}

}
