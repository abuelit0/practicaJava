package com.beca.ejemplos.colecciones;

import java.util.HashMap;

import com.beca.interfaz.IEjemplos;

public class HashMapEjemplo implements IEjemplos{

	@Override
	public void ejecutaEjemplo(String arg) {
		// TODO Auto-generated method stub
		hashMap();
	}
	
	private void hashMap(){
		HashMap map = new HashMap();
		
		map.put("name", "Jody");
		map.put("id", new Integer(446));
		map.put("address", "Manila");
		
		System.out.println(map);
		
		System.out.println("Name: " + map.get("name"));
		System.out.println("ID: " + map.get("id"));
		System.out.println("Address: " + map.get("address"));
	}
}
