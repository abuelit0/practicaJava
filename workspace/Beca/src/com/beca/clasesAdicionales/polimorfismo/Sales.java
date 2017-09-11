package com.beca.clasesAdicionales.polimorfismo;

import com.beca.clasesAdicionales.MiBaseClass;

public class Sales extends MiBaseClass {
	
	public double computeSales(double price) {
		double sales = price;
		
		return sales;
	}
	/*
	private double computeSales(double price){
		return 0;
	}*/
	
	public double computeSales(double price, int qty) {
		double sales = price * qty;
		
		return sales;
	}
	
	public double computeSales(double price, int qty, double discount) {
		double sales = price * qty - discount;
		
		return sales;
	}

}
