package com.beca.ejemplos.base;

import com.beca.interfaz.IEjemplos;

public class Flujos implements IEjemplos {
	
	public void ejecutaEjemplo(String key) {
		_switch();
		
		_labels();
	}
	
	private void _switch() {
		char sex = 'x';
		
		switch (sex) {
		case 'M':
			System.out.println("I am a male");
			//break;

		case 'F':
			System.out.println("I am a female");
		default:
			System.out.println("I am what i am");
			break;
		}
	}
	
	private void _labels() {
		int [] scores = {3, 9, 10, 0, 8, 10, 7, 1, 9, 8};
		
		outer:
			for(int i = 0; i < 10; i++){
				if(scores[i] <= 0) break outer;
				
				if(scores[i] > 5){
					inner:
						for(int j = 0; j < 3; j++){
							if(scores[i] == 10){
								System.out.println("Perfect score, more claps!!!!");
								continue inner;
							}
							System.out.println("Nice socre! One clap!");
							continue outer;
						}
				}
				if(scores[i] <= 5) System.out.println("More practice ...");
			}
	}
	
}