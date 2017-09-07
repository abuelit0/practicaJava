package com.beca.ejercicio11;

public class AppMain {
	
	public static void main(String[] args) {
		
		
		System.out.println("Aqui se lanza una excepcion");
		metodo(2);
		
		System.out.println("\nAqui no se lanza ninguna excepcion");
		metodo(1);
		
	}
	
	public static void metodo(int entrada){
		
		try{
			
			System.out.println("Comienza el try");
			
			if(entrada != 1)
				throw new MiExcepcion();
			
			System.out.println("Termina el try");
			
		}catch (MiExcepcion e) {
			System.out.println("Se ejecuta el catch: " + e);
		}finally{
			System.out.println("Se ejecuta el finally");
		}
	}

}

class MiExcepcion extends Exception{
	
	public String toString(){
		return "Esta es la excepcion";
	}
	
}