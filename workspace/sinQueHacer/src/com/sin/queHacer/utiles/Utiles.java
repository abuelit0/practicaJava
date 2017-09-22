package com.sin.queHacer.utiles;

import com.sin.queHacer.interfaces.Identidad;

public class Utiles {
	
	/**
	 * String comparator
	 */
	static Identidad<String> cadenas = (arg, ts) -> {
		boolean out = true;
		
		for (String t : ts){
			out = out && arg.equals(t);
			if(!out) break;
		}
		
		return out;
	};

}
