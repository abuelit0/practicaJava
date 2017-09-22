package com.beca.ejemplos;

import java.util.HashMap;
import com.beca.interfaz.IEjemplos;

public class Ejemplos {
	
	private HashMap<String, IEjemplos> _ejemplos;
	private String[] parametros;

	public Ejemplos(IEjemplos ... ejemplos) {
		
		this._ejemplos = new HashMap<String, IEjemplos>();
		
		for (IEjemplos iEjemplos : ejemplos) {
			_ejemplos.put(iEjemplos.getClass().getSimpleName(), iEjemplos);
		}
	}
	
	public void ejecutaEjemplo(String key) {
		_ejemplos.get(key).ejecutaEjemplo("");
	}
	
	public void SetParametros(String key, String []parametros){
		this.parametros = parametros;
		try {
			_ejemplos.get(key).ejecutaEjemplo(key, parametros);
		} catch (Exception e) {
			System.out.println("Hay un error en los parametros");
		}
	}
}
