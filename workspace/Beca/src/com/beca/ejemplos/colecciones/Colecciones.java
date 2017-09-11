package com.beca.ejemplos.colecciones;

import java.util.Vector;

import com.beca.clasesAdicionales.polimorfismo.Animal;
import com.beca.clasesAdicionales.polimorfismo.Horse;
import com.beca.clasesAdicionales.polimorfismo.Sales;
import com.beca.clasesAdicionales.polimorfismo.SalesTax;
import com.beca.clasesAdicionales.polimorfismo.Snake;
import com.beca.interfaz.IEjemplos;

public class Colecciones implements IEjemplos{
	
	@Override
	public void ejecutaEjemplo(String arg) {
		// TODO Auto-generated method stub
		vector();
	}

	private void vector(){
		
		Vector<Animal> vector = new Vector<Animal>();
		
		Animal a = new Animal();
		Snake s = new Snake();
		Horse h = new Horse();
		Sales sa = new Sales();
		SalesTax stx = new SalesTax();
		
		vector.add(a);
		vector.add(s);
		vector.add(h);
		//vector.add(sa);
		//vector.add(stx);
		
		System.out.println(vector);
	}
}
