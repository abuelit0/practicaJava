package com.beca.ejercicio6;

public class ClasePrincipal {
	
	private static String datoPrincipalEstatico = "Dato principal estatico";
	private String datoPrincipal = "Dato principal";
	
	public String tomaDatoInnerStatic(){
		return InnerStaticClass.datoStatic;
	}
	
	public String tomaDatoInner(){
		return InnerClass.datoStatic;
	}

	static class InnerStaticClass{
		
		static String datoStatic = "Dato variable";
		String dato;
		
		public InnerStaticClass(){
			dato = "Dato de " + this.getClass().getSimpleName();
		}
		
		public String toString(){
			return "\n" + dato + "\nEl dato estatico de la clase principal es: " + datoPrincipalEstatico 
					+ "\nEl dato no estatico no se a podido acceder desde esta instancia";
		}
		
	}
	
	class InnerClass{
		
		static final String datoStatic = "Dato constante";
		String dato;
		
		public InnerClass(){
			dato = "Dato de " + this.getClass().getSimpleName();
		}
		
		public String toString(){
			return "\n" + dato + "\nEl dato estatico de la clase principal es: " + datoPrincipalEstatico 
					+ "\nEl dato no estatico es: " + datoPrincipal;
		}
		
	}
}
