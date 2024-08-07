package ru.specialist;

import java.lang.annotation.Annotation;
import java.util.Arrays;

import ru.specialist.graph.*;

public class App {
	
	public static void main(String[] args) {
		
		var scene = new Scene();
		
		System.out.println("Annotations:");
		Class descriptor = scene.getClass(); //Scene.class;
		Annotation[] anns = descriptor.getAnnotations();
		for(Annotation an : anns) {
			System.out.printf("Annotation type: %s\n", an.annotationType().getName());
			if (an instanceof Developer d)
				System.out.printf("\t%s : %s\n", d.name(), d.date());
		}
		
		
		
		
		scene.add(new Point(10, 20, "green"));
		scene.add(new Circle(100, 200, 50, "pink"));
		
		Circle c2 = new Circle(0, 0, 5);
		scene.add(c2);
		
		Scaleable sc = c2;
		//sc.scale(Scaleable.DEFAULT_FACTOR); // доступны методы Scaleable и Object
		sc.scale();
		
		// new Shape().draw(); // ???
		scene.scale(Scaleable.DEFAULT_FACTOR);
		
		
		scene.draw();
		
		
		Course[] courses = {
			new Course("Java 1. Intro", 40),
			new Course("Java 2. OOP", 40),
			new Course("Java 3. Client Server", 40),
			new Course("GIT Intro", 16),
			new Course("OOP Patter", 24),
			new Course("C language", 48)
		};
		
		Arrays.sort(courses);
		
		for(Course c : courses)
			System.out.println(c);
	}

}
