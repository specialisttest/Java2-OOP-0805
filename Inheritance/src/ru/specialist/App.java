package ru.specialist;

import ru.specialist.people.*;

sealed class A permits B, D{}
sealed class B extends A permits C{}
non-sealed class C extends B{}
final class D extends A{}


public class App {

	public static void main(String[] args) {
		Stuff s1 = new Stuff("Sergey", 46, "teacher"); // ctor: Object, Person, Stuff
		s1.print(); // Stuff.print()
		
		Person p1 = new Person("Anna", 32);
		p1.print(); // Person.print()
		
		p1 = s1; // преобразование типа ссылки sub class -> super class
		
		p1.print(); // Stuff.print()
		
		
		/*	Таблица виртуальных метод
		 * Class	Method		Address
		 * Person	print		XXXX
		 * Stuff	print		YYYY
		 * 
		 */
		 
		/*if (p1 instanceof Stuff) {
			Stuff sx = (Stuff)p1; // преобразование типа ссылки super class -> sub class
			System.out.println(sx.getPosition());
		}*/
		
		if (p1 instanceof Stuff sx) {
			System.out.println(sx.getPosition());
		}
		
		
		Stuff s2 = s1.clone(); // копия объекта
		s1.setPosition("head teacher");
		
//		s1.setName("Sergey");
//		s1.setAge(46);
//		s1.setPosition("teacher");
		
		//s1.print();
		
		System.out.println( s2 ); // System.out.println( s1.toString() );
		
		Person[] people = {
			new Person("Sergey", 46),
			new Stuff("Alex", 32, "teacher"),
			new Stuff("Dima", 32, "cleaner")
		};
		
		for(Person p : people)
			p.print();
		
		
		
		

	}

}
