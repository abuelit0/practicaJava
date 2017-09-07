package com.beca.ejercicio12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class AppMain {

	public static void main(String[] args) {
		
		String rutaArchivo = "";
		
		File archivo = new File ("C:\\archivo.txt");
		
		//En este caso no podemos compilar ya que debemos manejar esta
		//posible excepcion, esto por que puede estar o no el archivo
		//que queremos abrir
		try {
			FileReader fr = new FileReader (archivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Aqui ejecutamos que pasa en caso de haber una excepcion");
		}
		
		int a = 1, b = 0;
		
		//Aqui podemos compilar sin problema, esto por que el compilador
		//asume que nosotros manejaremos preventivamente la excepcion
		int c = a/b;
		
	}
}
