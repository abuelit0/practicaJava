package com.beca.ejercicio6;

public class ClasePrincipal {

	private InnerClass objeto;
	private String dato;
	
	public ClasePrincipal(String dato){
		_inizializaObjetoInner(dato);
		this.dato = dato;
	}
	
	public void consultaDatoObjetoInner(){
		System.out.println(objeto.getData());
	}
	
	private void _inizializaObjetoInner(String dato){
		objeto = new InnerClass(dato);
		
	}
	
	class InnerClass{
		
		private String _data;
		
		public InnerClass(String dato){
			this._data = dato;
		}
		
		public void saludo(){
			System.out.println("Saludo");
		}
		
		public String getData(){
			return _data;
		}
		
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}
}
