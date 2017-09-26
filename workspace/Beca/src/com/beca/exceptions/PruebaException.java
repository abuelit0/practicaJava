package com.beca.exceptions;

/**
 * @author HP
 * Clase para probar excepciones
 */
public class PruebaException extends Exception {

	private int[] datos = new int[0];
	
	/**
	 * Metodo constructor un arguemnto
	 * @param detalle
	 */
	public PruebaException(String detalle) {
		super(detalle);
	}
	
	/**
	 * Metodo constructor dos argumetnos
	 * @param detalle
	 * @param datos
	 */
	public PruebaException(String detalle, int []datos) {
		super(detalle);
		this.datos = datos;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + getDataDetails();
	}
	
	private String getDataDetails() {
		String salida = "\n";
		
		try{
			for (int i : datos)
				salida += i + "\t";
		}catch(NullPointerException e) {
			return "";
		}
		
		return salida += "\n";
	}
}
