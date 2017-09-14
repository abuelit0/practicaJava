package com.beca.ejercicio43;

public class AppMain {
	
	public static void main(String[] args) {
		
		int c = 1;
		Clase clase = new Clase("Dato original");
		
		System.out.println("Antes de mandar llamar los metodos: ");
		System.out.println("El dato primitivo vale:\t" + c);
		System.out.println("El objeto vale:\t" + clase);
		
		valor(c);
		referencia(clase);
		
		System.out.println("Despues de mandar llamar los metodos: ");
		System.out.println("El dato primitivo vale:\t" + c);
		System.out.println("El objeto vale:\t" + clase);
		
		//Los datos enviados por valor no cambian, se hace una copia de su valor
		//Los datos enviados por referencia cambian ya que no se realizan copias de su informacion
		//solo se hace una referencia nueva al mismo objeto
	}
	
	private static void valor(int c){
		c = 0;
	}
	
	private static void referencia(Clase clase){
		clase.setDato("Cambio en el metodo");
	}

}

class Clase{
	
	private String dato;
	
	public Clase(String dato){
		this.dato = dato;
	}
	
	public void setDato(String dato){
		this.dato = dato;
	}
	
	public String toString(){
		return dato;
	}
}