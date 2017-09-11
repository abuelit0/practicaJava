package com.beca.ejemplos.interna;

import java.util.Locale;
import java.util.ResourceBundle;

import com.beca.interfaz.IEjemplos;

public class Internacionalizacion implements IEjemplos{

	@Override
	public void ejecutaEjemplo(String arg) {
		// TODO Auto-generated method stub
		ejemploInternacionalizacion();
	}
	
	private void ejemploInternacionalizacion() {
		
		Locale currentLocale = new Locale("en", "MX");
		
		ResourceBundle message = ResourceBundle.getBundle("MessageBundle", currentLocale);
		
		String msg1 = message.getString("greetings") + ", " + message.getString("inquiry");
		
		System.out.println(msg1 + ", " + Locale.getDefault());
	}
}