package com.beca.clasesAdicionales.polimorfismo;

public class SalesTax extends Sales {
	
	@Override
	public double computeSales(double price) {
		double sales = price * 1.10;

		return sales;
	}
}