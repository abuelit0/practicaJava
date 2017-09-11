package com.beca.ejemplos.herencia;

import com.beca.clasesAdicionales.MiClase;
import com.beca.interfaz.IEjemplos;

public class Constructores implements IEjemplos {

	@Override
	public void ejecutaEjemplo(String key) {
		_ejemplo1();
	}
	
	private void _ejemplo1(){
		@SuppressWarnings("unused")
		MiClase objeto = new MiClase();
		objeto = new MiClase("Este mensaje se manda desde el constructor");
	}

}