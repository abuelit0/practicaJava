package com.beca.ejemplos.herencia;

import com.beca.clasesAdicionales.herencia.Auto;
import com.beca.clasesAdicionales.herencia.Avion;
import com.beca.clasesAdicionales.herencia.Bote;
import com.beca.clasesAdicionales.herencia.Vehiculo;
import com.beca.interfaz.IEjemplos;

public class Casting implements IEjemplos {
	
	public void ejecutaEjemplo(String key) {
		ejemplo();
	}

	@SuppressWarnings("unused")
	private static void ejemplo() {
		
		Vehiculo v = new Vehiculo();
		Auto c = new Auto();
		Bote b = new Bote();
		Avion p = new Avion();
		Vehiculo vc = new Auto();
		
		v = c;
		c = (Auto) v;
		//b = p;
		
		b = (Bote)v;
		c = (Auto) vc;
		
	}
}
