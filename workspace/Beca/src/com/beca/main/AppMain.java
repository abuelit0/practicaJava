package com.beca.main;

import com.beca.ejemplos.Abstraccion;
import com.beca.ejemplos.Arreglos;
import com.beca.ejemplos.Constructores;
import com.beca.ejemplos.Ejemplos;
import com.beca.ejemplos.Excepciones;
import com.beca.ejemplos.Flujos;
import com.beca.ejemplos.PasoDeParametros;

public class AppMain {
	
	public static void main(String[] args) {
		Ejemplos ejemplos = new Ejemplos(
					new Flujos(),
					new Excepciones(),
					new Arreglos(),
					new PasoDeParametros(),
					new Abstraccion(),
					new Constructores()
				);
		
		ejemplos.ejecutaEjemplo("Constructores");
	}
}
