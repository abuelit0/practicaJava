package com.beca.clasesAdicionales;

/**
 * Clase para ejemplificar la estructura base de un objeto
 * @author HP
 *
 */
public class MiObjeto  extends MiBaseClass{
	
	private int valorEntero;
	private String valorCadena = "Valor original";
	
	public int getValorEntero() {
		return valorEntero;
	}
	public void setValorEntero(int valorEntero) {
		this.valorEntero = valorEntero;
	}
	public String getValorCadena() {
		return valorCadena;
	}
	public void setValorCadena(String valorCadena) {
		this.valorCadena = valorCadena;
	}
	
	public String toString() {
		return getValorCadena() + "\t" + getValorEntero();
	}
}
