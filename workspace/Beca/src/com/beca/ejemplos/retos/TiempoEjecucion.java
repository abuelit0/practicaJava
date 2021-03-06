package com.beca.ejemplos.retos;

import com.beca.interfaz.IEjemplos;

public class TiempoEjecucion implements IEjemplos {
	
	public void ejecutaEjemplo(String key) {
		
		_stringVSstringBuilderVSstringBuffer();
	}
	
	private void _stringVSstringBuilderVSstringBuffer() {
		String string = "";
		StringBuilder stringBuilder = new StringBuilder();
		StringBuffer stringBuffer = new StringBuffer();
		
		int repeticiones = 200000;
		String mensaje = "\tTiempo de ejecucion: ";
		
		System.out.println(stringBuilder.getClass().getSimpleName() + mensaje + proceso(repeticiones, stringBuilder));
		System.out.println(stringBuffer.getClass().getSimpleName() + mensaje + proceso(repeticiones, stringBuffer));
		System.out.println(string.getClass().getSimpleName() + "\t" + mensaje + proceso(repeticiones, string));
	}
	
	private static long proceso(int repeticiones, Object o) {
		
		long tiempo;
		
		if(o instanceof String){
			
			@SuppressWarnings("unused")
			String tmp = (String) o;
			
			tiempo = System.currentTimeMillis();
			
			for(int i = 0; i < repeticiones; i++){
				tmp += i;
			}
			
			tiempo = tiempo - System.currentTimeMillis();
			
		}else if(o instanceof StringBuffer){
			
			StringBuffer tmp = (StringBuffer) o;
			
			tiempo = System.currentTimeMillis();
			
			for(int i = 0; i < repeticiones; i++){
				tmp.append(i);
			}
			
			tiempo = tiempo - System.currentTimeMillis();
			
		}else{
			
			StringBuilder tmp = (StringBuilder) o;
			
			tiempo = System.currentTimeMillis();
			
			for(int i = 0; i < repeticiones; i++){
				tmp.append(i);
			}
			
			tiempo = tiempo - System.currentTimeMillis();
		}
		
		return Math.abs(tiempo);
	}
}
