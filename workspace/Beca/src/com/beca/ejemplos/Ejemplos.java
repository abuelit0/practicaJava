package com.beca.ejemplos;

import java.util.HashMap;
import com.beca.interfaz.IEjemplos;

/**
 * Clase principal que maneja las implementaciones de IEjemplos
 * @author HP
 *
 */
public class Ejemplos {
	
	private HashMap<String, IEjemplos> _ejemplos;

	/**
	 * Constructor que recibe cualquier cantidad de ejemplos
	 * @param ejemplos arreglo de ejemplos
	 */
	public Ejemplos(IEjemplos ... ejemplos) {
		
		this._ejemplos = new HashMap<String, IEjemplos>();
		
		for (IEjemplos iEjemplos : ejemplos) {
			_ejemplos.put(iEjemplos.getClass().getSimpleName(), iEjemplos);
		}
	}
	
	/**
	 * Manda ejecutar un ejemplo en particular 
	 * @param key nombre de ejemplo
	 */
	public void ejecutaEjemplo(String key) {
		_ejemplos.get(key).ejecutaEjemplo(null);
	}
}
