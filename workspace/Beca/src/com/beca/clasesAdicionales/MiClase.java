package com.beca.clasesAdicionales;

public class MiClase {
	
	/**
	 * Usamos this para referenciar la misma clase, au usar this() -> nos referimos al constructor
	 * que cumpla con el formato
	 */
	public MiClase() {
		this("Mensaje desde el constructor");
	}
	
	public MiClase(String mensaje) {
		System.out.println(mensaje);
	}
	
	protected final void hola() {
		
	}
}

class otra extends MiClase {
	
	public otra() {
		super.hola();
	}
	
}