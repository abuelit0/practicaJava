package com.beca.ejercicio39;

public class AppMain {
	
	static Operacion divisible = (x, y) -> {
		
		return x%y == 0 ? true : false;
	};
	
	public static void main(String[] args) {
		
		try{
			
			String mensaje = 
					divisible.is(
							Integer.parseInt(args[0]), 
							Integer.parseInt(args[1])
					) ? 
						args[0] + " es divisible entre " + args[1] : 
						args[0] + " no es divisible entre " + args[1];

			System.out.println(mensaje);
			
		}catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
			
			String mensaje = e instanceof NumberFormatException ? "Alguno de los parametros no es un numero" 
					: e instanceof ArrayIndexOutOfBoundsException ? "No se mandaron los parametro minimos necesarios" :
					"Algo fuera de los esperado ocurrio: " + e;
			
			System.out.println(mensaje);
			
		}
		
	}

}

interface Operacion {
	public boolean is(int x, int y);
}

