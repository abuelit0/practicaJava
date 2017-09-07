package com.beca.ejercicio4;

public class ClaseObjeto {

	private String _descripcion;
	public static int objetos = 0;
	
	public ClaseObjeto(String descripcion){
		this.Inizializacion();
		setDescripcion(descripcion);
	}
	
	public static void Inizializacion(){
		objetos++;
		System.out.println("Se agrego un nuevo objeto.");
	}

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String _descripcion) {
		this._descripcion = _descripcion;
	}
}
