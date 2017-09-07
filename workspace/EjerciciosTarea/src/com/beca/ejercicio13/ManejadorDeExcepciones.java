package com.beca.ejercicio13;

import com.beca.ejercicio13.interfaz.IEdadExceptions;

public class ManejadorDeExcepciones {
	
	public static void administraExcepcion(IEdadExceptions e){
		
		System.out.println("Llamada de atencion: " + e.llamadaDeAtencion());
		
		System.out.println("Se realizara un reporte sobre: " + e.reporte());
	}

}
