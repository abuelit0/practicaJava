package com.beca.clasesAdicionales;

/**
 * Clase para mostrar como se llaman los constructores entre ellos
 * @author HP
 *
 */
public class MiClase extends MiBaseClass{
	
	/**
	 * Usamos this para referenciar la misma clase, au usar this() -> nos referimos al constructor
	 * que cumpla con el formato
	 */
	public MiClase() {
		this("Mensaje desde el constructor");
	}
	
	/**
	 * Constructor con un parametro
	 * @param mensaje
	 */
	public MiClase(String mensaje) {
		System.out.println(mensaje);
	}
	
	protected final void hola() {
		System.out.println("Hola");
	}
}

class otra extends MiClase {
	
	/**
	 * Manda llamar el metodo de su super clase
	 */
	public otra() {
		super.hola();
	}
	
}