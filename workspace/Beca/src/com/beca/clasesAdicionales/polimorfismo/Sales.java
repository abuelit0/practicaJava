package com.beca.clasesAdicionales.polimorfismo;

import com.beca.clasesAdicionales.MiBaseClass;

/**
 * Clase para mostar funcionalidades de los objetos
 * @author HP
 *
 */
public class Sales extends MiBaseClass {
	
	/**
	 * Retorna el precio que se esta recibiendo
	 * @param price
	 * @return precio que se esta recibiendo
	 */
	public double computeSales(double price) {
		double sales = price;
		
		return sales;
	}
	
	/**
	 * Retorna el producto del precio y la cantidad
	 * @param price precio
	 * @param qty cantidad
	 * @return producto del precio y la cantidad
	 */
	public double computeSales(double price, int qty) {
		double sales = price * qty;
		
		return sales;
	}
	
	/**
	 * Calcula precio
	 * @param price precio
	 * @param qty cantidad
	 * @param discount descuento
	 * @return producto de precio con cantidad menos el descuento
	 */
	public double computeSales(double price, int qty, double discount) {
		double sales = price * qty - discount;
		
		return sales;
	}

}
