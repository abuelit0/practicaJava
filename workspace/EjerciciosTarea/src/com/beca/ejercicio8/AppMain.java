package com.beca.ejercicio8;

public class AppMain {

	public static void main(String[] args) {
		metodo();
	}
	
	public static void metodo(){
		int [] arreglo = {1,2,3,4,5,6,7};
		int referencia = 0;
		
		do{
			
			etiqueta:
			for(int i = 0; i < arreglo.length; i++){
				
				while(true){
					
					if(arreglo[i] != 4){
						System.out.println("Continua: " + arreglo[i]);
						continue etiqueta;
					}else{
						System.out.println("Sale");
						break etiqueta;
					}
					
				}
			}
			
		}while(referencia == 1);
	}
}
