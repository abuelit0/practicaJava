package com.beca.ejemplos.colecciones;

import java.util.Hashtable;

import com.beca.interfaz.IEjemplos;

public class HashTableEjemplo implements IEjemplos{
	
	public void ejecutaEjemplo(String arg) {
		hashTable();
	};
	
	private void hashTable(){
		Hashtable table = new Hashtable();
		
		table.put("name", "Jody");
		table.put("id", new Integer(446));
		table.put("address", "Manila");
		
		System.out.println("Table of contents: " + table);
	}

}
