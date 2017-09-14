package com.beca.ejercicio42;

public class AppMain {
	
	public static void main(String[] args) {
		
		Clase c = new Clase("objeto 1");
		
		System.out.println(c.getDato());
		
		c = new Clase("Objeto 2");
		
		System.out.println(c.getDato());
		
		//Despues de cambiar la referencia del objeto 1, queda deslindada su informacin del hub
		//con respeto al stak por lo que el gc libera la memoria que este ocupaba
		
		
	}

}

class Clase{
	
	private String dato;
	
	public Clase(String dato){
		this.dato = dato;
	}
	
	public String getDato(){
		return dato;
	}
	
}