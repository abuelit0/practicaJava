package com.beca.ejemplos.retos;

import java.math.BigDecimal;
import com.beca.interfaz.IEjemplos;

public class ValidaEntrada implements IEjemplos{

	@Override
	public void ejecutaEjemplo(String key) {
		
		String entrada = "-125631125631201.23123";
		
		//
		if(contieneNumero(entrada)){
			System.out.println(retornaFormato(entrada));
		}
	}
	
	private boolean contieneNumero(String entrada) {

		try{
			Double.parseDouble(entrada);
		}catch(NumberFormatException e){
			System.out.println("No se pudo recuperar ningun valor numerico");
			return false;
		}catch(NullPointerException e){
			System.out.println("No hay ninguna entrada");
		}
		
		return true;
	}
	
	@SuppressWarnings("unused")
	private String cambiaEntrada(String entrada) throws NumberFormatException, NullPointerException {

		StringBuilder a = new StringBuilder();
		
		for (int i = 0; i < entrada.length(); i++) {
			if(Character.isDigit(entrada.charAt(i)) || entrada.charAt(i) == '.'){
				a.append(entrada.charAt(i));
			}
		}
		
		Double.parseDouble(a.toString());
		
		return a.toString();
	}
	
	private String retornaFormato(String entrada) {
		StringBuilder salida = new StringBuilder();
		
		BigDecimal number = new BigDecimal(entrada);
		long iPart = number.longValue();
		
		
		BigDecimal fraccion = number.remainder(BigDecimal.ONE);
	
		int decimal = (int)(fraccion.doubleValue()*100);
		
		decimal = Math.abs(decimal);
		
		String decimales = decimal == 0 ? "00" : decimal < 9 ? "0" + decimal : "" + decimal;
		
		salida.append("$" + iPart + "." + decimales);
		
		return salida.toString();
	}
	
}
