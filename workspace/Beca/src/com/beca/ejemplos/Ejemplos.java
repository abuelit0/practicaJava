package com.beca.ejemplos;

import java.util.HashMap;
import com.beca.interfaz.IEjemplos;

public class Ejemplos {
	
	private HashMap<String, IEjemplos> _ejemplos;

	public Ejemplos(IEjemplos ... ejemplos) {
		
		this._ejemplos = new HashMap<String, IEjemplos>();
		
		for (IEjemplos iEjemplos : ejemplos) {
			_ejemplos.put(iEjemplos.getClass().getSimpleName(), iEjemplos);
		}
	}
	
	public void ejecutaEjemplo(String key) {
		_ejemplos.get(key).ejecutaEjemplo(null);
	}
}
