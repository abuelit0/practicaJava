package com.beca.ejercicio13;

public class Persona {
	
	private int _edad;
	private String _nombre;
	private Persona _padre;
	
	public Persona(){
		this._nombre = "Desconocido";
		this._edad = 0;
	}
	
	public Persona(int edad, String nombre){
		
		this._edad = edad;
		this._nombre = nombre;
	}
	
	public Persona(int edad, String nombre, Persona padre){
		this(edad, nombre);

		this._padre = padre;
	}
	
	public String toString(){
		return "\n" + _nombre + "\tEdad: " + _edad;
	}

	public int getEdad() {
		return _edad;
	}

	public void setEdad(int _edad) {
		this._edad = _edad;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String _nombre) {
		this._nombre = _nombre;
	}

	public Persona getPadre() {
		return _padre;
	}

	public void setPadre(Persona _padre) {
		this._padre = _padre;
	}

}
