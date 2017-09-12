package com.beca.ejercicio24;

public class AppMain {
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		Gato gato = new Gato();
		
		Animal gatoAnimal = null;
		Gato animalGato = null;
		
		gatoAnimal = gato;
		
		try{
			animalGato = (Gato) animal; //ClassCastException
		}catch(ClassCastException e){
			System.out.println("No se a podido realizar el cast");
		}finally{
			System.out.println(gatoAnimal);
			System.out.println(animalGato);
			
			System.out.println(animal);
			System.out.println(gato);
		}
	}

}
