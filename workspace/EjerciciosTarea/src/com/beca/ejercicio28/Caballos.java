package com.beca.ejercicio28;

public class Caballos {
	
	private boolean manzana;
	
	public Caballos(){
		if(Manzanas.totalManzanas > 0){
			manzana = true;
			Manzanas.totalManzanas-=1;
		}else
			manzana = false;
	}
	
	public String toString(){
		return "A este caballo" + (manzana ? 
				" le tocara" : " no le tocara")
				+ " una manzana";
	}

}
