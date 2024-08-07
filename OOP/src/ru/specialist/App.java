package ru.specialist;

public class App {

	public static void main(String[] args) {
		// Course c; // объект не создаётся!!! есть только ссылка, которая по умолчанию будет null
		
		Course.printCounter();
		
		Course c1 = new Course("Java 2. OOP", 40);
		//c1.title = "Java 2. OOP";
		//c1.length = 40;
		
		//c1.setLength(42);
		//System.out.println(c1.getLength());
		//c1.length = -100;
		
		c1.print(); // this = c1
		
		
		Course c2 = new Course("Pattern OOP", 24);
		//c2.title = "Pattern OOP";
		//c2.length = 24;
		
		c2.print(); // this = c2
		
		Course c3 = new Course("New course");
		c3.print();
		
		//Course c4 = new Course();
		//c4.print();
		new Course().print();
		
		Course.printCounter();
		
		// объекты в одном состоянии, но разные identity
		var c5 = new Course("Spring Intro", 40);
		var c6 = new Course("Spring Intro", 40);
		
		c5.print();
		c6.print();
		
		System.out.println( c5 == c6 ); // сравнение ссылок (только identity)
		System.out.println( c5.equals(c6) ); // сравнение по полям
		
		
		
		var c7 = new Course("GIT Intro", 16);
		var c8 = c7; // копирование ссылки на объект
		
		System.out.println( c7 == c8 ); // две ссылки на один тот же объект
		
		c8.print();
		c7.setLength(24); // изменение объекта через ссылку (c7) будет видно через другую ссылку (c8)
		c8.print();
		
		int a = 10;
		int b = a;
		System.out.println(b);
		a++; // 11
		System.out.println(b);
		
		
		

	}

}
