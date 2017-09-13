package com.beca.ejercicio21;

import java.text.NumberFormat;

public class AppMain {
	
	public static void main(String[] args) {
		
		String valor = "345.67";
		double salidaD;

		NumberFormat nf = NumberFormat.getInstance();

		salidaD = Double.parseDouble(valor);
		
		System.out.println(nf.format(salidaD));
		System.out.println(nf.format((int)salidaD));
	}
}
