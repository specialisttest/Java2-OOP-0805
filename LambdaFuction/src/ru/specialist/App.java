package ru.specialist;

import java.util.*;
import static java.lang.System.out;

public class App {
	

	public static void main(String[] args) {
		List<Course> courses = new ArrayList<Course>();
		
		courses.add(new Course("Java 1. Base", 40));
		courses.add(new Course("Java 2. OOP", 40));
		courses.add(new Course("Pattern OOP", 24));
		courses.add(new Course("Git", 16));
		
		
		// y = f(x)
		// y = sin(x)
		// y = log(x)
		// y = sin(log(x))
		
//		for(Course c : courses)
//			out.println(c);
		
//		courses.stream()
//			.forEach( out::println );
		
//		for(Course c : courses)
//			if (c.getLength() > 20)
//				out.println(c);
		
//		courses.stream()
//			.filter( c -> c.getLength() > 20 )
//			.forEach( out::println );
		
		/*List<Course> lCourse = new ArrayList<Course>();
		for(Course c : courses)
			if (c.getLength() > 20)
				lCourse.add(c);
		
		Collections.sort(lCourse, (c1, c2) -> c1.getTitle().compareTo(c2.getTitle()));
		
		for(Course c : lCourse)
			out.println(c);*/
		
		courses.stream()
			.filter( c -> c.getLength() > 20 )
			.sorted( (c1, c2) -> c1.getTitle().compareTo(c2.getTitle()))
			.forEach( out::println );		
		
		

	}

}
