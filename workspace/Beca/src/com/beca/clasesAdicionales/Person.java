package com.beca.clasesAdicionales;

/**
 * Clase para generar personas con metodos simples
 * @author HP
 *
 */
public class Person extends MiBaseClass {

	private static int maleCount;
	private static int femaleCount;
	
	private String name;
	private char sex;
	private int age;
	
	private String mensaje;
	
	static void showSexDistribution() {
		if(maleCount > femaleCount)
			System.out.println("Majority are male.");
		else if(femaleCount > maleCount)
			System.out.println("Majority are female.");
		else
			System.out.println("Equal number of male and female.");
	}
	
	/**
	 * Imprime el sexo de la persona
	 */
	public void tellSex() {
		mensaje = sex == 'M' ? "I'm Male." : sex == 'F' ? "I'm Female." : "I don't know.";
		
		System.out.println(mensaje);
	}
	
	/**
	 * Imprime un mensaje referente a la edad de la persona
	 */
	public void tellAge() {
		mensaje = age < 10 ? "I', just a kid." : age < 20 ? "i'm a teenager." : "I'm a grown up.";
		
		System.out.println(mensaje);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
