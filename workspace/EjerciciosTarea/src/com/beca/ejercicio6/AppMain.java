package com.beca.ejercicio6;

import com.beca.ejercicio6.ClasePrincipal.InnerStaticClass;

public class AppMain {
	
	public static void main(String[] args) {

		ClasePrincipal objeto = new ClasePrincipal();
		
		ClasePrincipal.InnerClass obejtoInnerClass = objeto.new InnerClass();
		ClasePrincipal.InnerStaticClass objetoInnerStaticClass = new InnerStaticClass();
		
		System.out.println(objeto.tomaDatoInner());
		System.out.println(objeto.tomaDatoInnerStatic());
		
		System.out.println(obejtoInnerClass);
		System.out.println(objetoInnerStaticClass);
	}

}
