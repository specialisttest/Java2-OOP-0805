package ru.specialist.people;

import static java.lang.System.out;

public /*final*/ class Person { // extends Object

	private String name;
	private int age;
	
	public Person() {
		out.println("Person ctor()");
	}
	
	public Person(String name, int age) {
		out.println("Person ctor(String, int)");
		this.name = name;
		this.age = age;
	}
	
	public void print() {
		System.out.printf("%-15s : %d\n", getName(), getAge());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
