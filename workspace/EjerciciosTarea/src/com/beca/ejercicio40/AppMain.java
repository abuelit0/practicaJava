package com.beca.ejercicio40;

public class AppMain {
	
	static Operacion parseable = (c) -> {
		
		try{
			Integer.parseInt(c);
		}catch (NumberFormatException e){
			return false;
		}	
			return true;
	};
	
	public static void main(String[] args) {
		
		String mensaje = "Algo inesperado ocurrio";
		
		try{
			mensaje = parseable.is(args[0]) ? "success" : "Fail";
			
		}catch(ArrayIndexOutOfBoundsException e){
			mensaje = "No hay ningun argumento para verificar";
		}finally {
			System.out.println(mensaje);
		}
		
	}

}


interface Operacion{
	public boolean is(String cadena);
}