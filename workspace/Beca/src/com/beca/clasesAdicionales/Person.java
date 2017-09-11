package com.beca.clasesAdicionales;

public class Person {

	static int maleCount;
	static int femaleCount;
	
	private String name;
	private char sex;
	private int age;
	
	static void showSexDistribution() {
		if(maleCount > femaleCount)
			System.out.println("Majority are male.");
		else if(femaleCount > maleCount)
			System.out.println("Majority are female.");
		else
			System.out.println("Equal number of male and female.");
	}
	
	void tellSex() {
		if(sex == 'M')
			System.out.println("I'm Male.");
		else if(sex == 'F')
			System.out.println("I'm Female.");
		else
			System.out.println("I don't know.");
				
	}
	
	void tellAge() {
		if(age < 10)
			System.out.println("I', just a kid.");
		else if(age < 20)
			System.out.println("i'm a teenager.");
		else
			System.out.println("I'm a grown up.");
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
