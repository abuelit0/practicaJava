package com.beca.ejercicio7;

public class AppMainEjercicio7 {
	
	static int variable1 = 10;
	
	public static void main(String[] args) {
		
		int variable2 = 20;
		
		for(int i = 0; i < 10; i++){
			int variable3 = 30;
			
			{
				int variable5 = 50;
				System.out.println(variable1);
				System.out.println(variable2);
				System.out.println(variable3);
				//No alcanzamos a variable4
				System.out.println(variable5);
			}
			
			System.out.println(variable1);
			System.out.println(variable2);
			System.out.println(variable3);
			//No alcanzamos a variable4
			//No alcanzamos a variable5
			
			break;
		}
		
		System.out.println(variable1);
		System.out.println(variable2);
		//No alcanzamos a variable3
		//No alcanzamos a variable4
		//No alcanzamos a variable5
		
	}
	
	public static void otroMetodo(){
		int variable4 = 40;
		
		System.out.println(variable1);
		//No alcanzamos a variable2
		//No alcanzamos a variable3
		System.out.println(variable4);
		//No alcanzamos a variable5
	}

}
