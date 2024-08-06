package ru.specialist.people;

import static java.lang.System.out;

public class Stuff extends Person implements Cloneable {
	
	private String position;
	
	public Stuff(String name, int age, String position) {
		super(name, age); // вызов конструктора super класса
		
		out.println("Stuff ctor(String, int, String)");
		setPosition(position);
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public final void print() {
		System.out.println(this); // toString()
		//System.out.printf("%s - %\t", getPosition());
		//super.print(); // Person.print
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", getPosition(), getName());
	}
	
	@Override
	public Stuff clone() {
		return new Stuff(getName(), getAge(), getPosition());
	}
	

}
