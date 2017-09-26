package com.beca.clasesAdicionales.polimorfismo;

/**
 * Clase para ejemplificar herencia
 * @author HP
 *
 */
public class SalesTax extends Sales {
	
	/**
	 * Sobre escritura del metodo de la clase padre
	 */
	@Override
	public double computeSales(double price) {
		double sales = price * 1.10;

		return sales;
	}
}
