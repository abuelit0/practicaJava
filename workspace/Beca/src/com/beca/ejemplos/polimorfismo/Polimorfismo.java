package com.beca.ejemplos.polimorfismo;

import com.beca.clasesAdicionales.polimorfismo.Animal;
import com.beca.clasesAdicionales.polimorfismo.Horse;
import com.beca.clasesAdicionales.polimorfismo.Snake;
import com.beca.interfaz.IEjemplos;

public class Polimorfismo implements IEjemplos {

	@Override
	public void ejecutaEjemplo(String key) {
		polimorfismoImplisito();
	}
	
	private void polimorfismoImplisito() {
		
		Animal pig = new Animal();
		Snake viper = new Snake();
		Horse stallion = new Horse();
		Animal animalViper = new Snake();
		Animal animalStallion = new Horse();
		
		pig.eat();
		//pig.eat("Maiz");
		
		viper.eat();
		//viper.eat("Gatitos");
		
		stallion.eat();
		stallion.eat("glass");
		
		animalViper.eat();
		//animalViper.eat();
		
		animalStallion.eat();
		((Horse)animalStallion).eat("carrots");
	}
}
