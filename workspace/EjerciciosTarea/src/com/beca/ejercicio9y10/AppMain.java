package com.beca.ejercicio9y10;

public class AppMain {

	public static void main(String[] args) {
		
		try{
			
			GeneraClassCastException();
			GeneraNullPonterException();
			GeneraArrayIndexOutOfBoundsException();
			GeneraStackOverflowError();
			GeneraAssertionError();
			GeneraNumberFormatException();
			
			
		}catch(ClassCastException e){
			System.out.println("Ocurrio una excepcion del tipo: " + e.getClass().getSimpleName());
		}catch(NullPointerException e){
			System.out.println("Ocurrio una excepcion del tipo: " + e.getClass().getSimpleName());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Ocurrio una excepcion del tipo: " + e.getClass().getSimpleName());
		}catch(StackOverflowError e){
			System.out.println("Ocurrio una excepcion del tipo: " + e.getClass().getSimpleName());
		}catch(AssertionError e){
			System.out.println("Ocurrio una excepcion del tipo: " + e.getClass().getSimpleName());
		}catch(NumberFormatException e){
			System.out.println("Ocurrio una excepcion del tipo: " + e.getClass().getSimpleName());
		}finally{
			System.out.println("Ejecucion finalizada");
		}
		
	}
	
	public static void GeneraClassCastException() throws ClassCastException{
		Object x = new Integer(0);
	     System.out.println((String)x);
		
	}
	
	public static void GeneraNullPonterException() throws NullPointerException{
		int []arreglo = null;
		
		for (int i : arreglo) {
			System.out.println(i);
		}
	}
	
	public static void GeneraArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException{
		
		int arreglo[] = new int[5];
		
		for(int i = 0; i <=5; i++)
			System.out.println(arreglo[i]);
	}
	
	public static void GeneraStackOverflowError() throws StackOverflowError{
		GeneraStackOverflowError();
	}
	
	public static void GeneraAssertionError() throws AssertionError{
		throw new AssertionError(":D");
	}
	
	public static void GeneraNumberFormatException() throws NumberFormatException{
		String numero = "no soy un numero";
		
		Integer.parseInt(numero);
	}
	
}
