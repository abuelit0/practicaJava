package com.beca.ejercicio5;

public class AppMain {
	
	public static void main(String[] args) {
		
		String[][] arreglo2D = new String[3][4];
		String[][][] arreglo3D = new String[3][4][5];
		
		AppMain objeto = new AppMain();
		
		objeto._inicializa2D(arreglo2D);
		objeto._imprime2D(arreglo2D);
		objeto._mueve2Da3D(arreglo2D, arreglo3D);
		objeto._imprime3D(arreglo3D);
		
	}
	
	private void _mueve2Da3D(String[][] A2D, String[][][] A3D){
		
		for(int i = 0; i < A2D.length; i++)
			for(int j = 0; j < A2D[i].length; j++){
				A3D[0][i][j] = A2D[i][j];
			}
	}
	
	private void _imprime3D(String [][][] A3D){
		
		for (String[][] is : A3D) {
			for (String[] is2 : is) {
				for (String i : is2) {
					System.out.print(i + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	private void _imprime2D(String [][] A2D){
		
		for (String[] is : A2D) {
			for (String i : is) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}
	
	private void _inicializa2D(String [][] A2D){
		for(int i = 0; i < A2D.length; i++)
			for(int j = 0; j < A2D[i].length; j++)
				A2D[i][j] =  i + "," + j;
	}

}
