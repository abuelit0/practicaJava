package com.beca.ejercicio4;

public class ClaseObjeto {

	private String _descripcion;
	public static int objetos = 0;
	
	static{
		
		System.out.println("Se agrego un nuevo objeto.");
	}
	
	{
		System.out.println("Bloque de inizializacion no estatico");
		_descripcion = "Default";
		objetos++;
	}
	
	public ClaseObjeto(){
		
	}
	
	public ClaseObjeto(String descripcion){
		setDescripcion(descripcion);
	}
	
	public String toString(){
		return _descripcion;
	}
	

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String _descripcion) {
		this._descripcion = _descripcion;
	}
}
