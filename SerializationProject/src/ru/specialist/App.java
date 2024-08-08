package ru.specialist;

import java.io.*;

public class App {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Course[] courses = {
			new Course("Java 2. OOP", 40, "Specialist.ru"),
			new Course("Pattern OOP", 24, "Specialist.ru"),
			new Course("Spring Intro", 40, "Specialist.ru"),
			new Course("GIT Intro", 16, "Specialist.ru")
		};
		
		for(var c : courses)
			c.print();
		
		try (var oos = new ObjectOutputStream(new FileOutputStream("../courses.txt"))) {
			oos.writeObject(courses);
		}
		
		courses = null;
		
		try (var ois = new ObjectInputStream(new FileInputStream("../courses.txt"))) {
			courses = (Course[])ois.readObject();
			
			for(var c : courses)
				c.print();
			
		}
		
		

	}

}
