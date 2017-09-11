package com.beca.main;

import com.beca.ejemplos.Ejemplos;
import com.beca.ejemplos.base.Arreglos;
import com.beca.ejemplos.base.Excepciones;
import com.beca.ejemplos.base.Flujos;
import com.beca.ejemplos.herencia.Abstraccion;
import com.beca.ejemplos.herencia.Casting;
import com.beca.ejemplos.herencia.Constructores;
import com.beca.ejemplos.herencia.LlamadaDeContructores;
import com.beca.ejemplos.herencia.PasoDeParametros;
import com.beca.ejemplos.polimorfismo.Polimorfismo;
import com.beca.ejemplos.polimorfismo.SobreCargaSobreEscritura;
import com.beca.ejemplos.retos.TiempoEjecucion;
import com.beca.ejemplos.retos.ValidaEntrada;
import com.beca.ejemplos.retos.VistaToString;

public class AppMain{
	
	public static void main(String[] args) {
		Ejemplos ejemplos = new Ejemplos(
					new Flujos(),
					new Excepciones(),
					new Arreglos(),
					new PasoDeParametros(),
					new Abstraccion(),
					new Constructores(),
					new TiempoEjecucion(),
					new ValidaEntrada(),
					new LlamadaDeContructores(),
					new Casting(),
					new SobreCargaSobreEscritura(),
					new Polimorfismo(),
					new VistaToString()
				);

		ejemplos.ejecutaEjemplo("VistaToString");
	}
}
