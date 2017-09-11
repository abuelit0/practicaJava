package com.beca.ejemplos.retos;

import com.beca.clasesAdicionales.herencia.Hija;
import com.beca.interfaz.IEjemplos;

public class VistaToString implements IEjemplos{
	
	@Override
	public void ejecutaEjemplo(String arg) {
		// TODO Auto-generated method stub
		toStringPrueba();
	}

	
	private void toStringPrueba(){
		Hija a = new Hija();
		
		System.out.println(a);
	}
}
