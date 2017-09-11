package com.beca.ejemplos.polimorfismo;

import com.beca.clasesAdicionales.polimorfismo.Sales;
import com.beca.clasesAdicionales.polimorfismo.SalesTax;
import com.beca.interfaz.IEjemplos;

public class SobreCargaSobreEscritura implements IEjemplos {
	
	@Override
	public void ejecutaEjemplo(String key) {
		sobreEscrituraSobreCarga();
	}
	
	
	
	private void sobreEscrituraSobreCarga() {
		
		Sales s = new Sales();
		SalesTax st = new SalesTax();
		
		System.out.println(s.computeSales(100));
		System.out.println(s.computeSales(100, 3));
		System.out.println(s.computeSales(100, 3, 10.50));
		
		System.out.println(st.computeSales(100));
	}
}
