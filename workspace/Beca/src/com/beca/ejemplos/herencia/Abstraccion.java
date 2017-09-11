package com.beca.ejemplos.herencia;

import com.beca.clasesAdicionales.Person;
import com.beca.interfaz.IEjemplos;

public class Abstraccion implements IEjemplos {

	public void ejecutaEjemplo(String key) {
	}
	
	public void ejemplo1() {
		@SuppressWarnings("unused")
		Person p = new Person();
	}
}
