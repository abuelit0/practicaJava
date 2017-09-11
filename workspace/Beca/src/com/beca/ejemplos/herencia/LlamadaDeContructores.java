package com.beca.ejemplos.herencia;

import com.beca.clasesAdicionales.herencia.Hija;
import com.beca.interfaz.IEjemplos;

public class LlamadaDeContructores implements IEjemplos {
	
	@Override
	public void ejecutaEjemplo(String key) {
		// TODO Auto-generated method stub
		llamadas();
	}
	
	private static void llamadas() {
		@SuppressWarnings("unused")
		Hija a = new Hija();
	}

}
