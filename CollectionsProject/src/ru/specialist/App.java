package ru.specialist;

import java.util.*;
import static java.lang.System.out;

public class App {
	
	public static int compareCourse(Course c1, Course c2) {
		return c1.getLength() - c2.getLength();
	}

	public static void main(String[] args) {
		List<Course> courses = new LinkedList<Course>();
				//new ArrayList<Course>();
		
		out.println(courses.size()); // 0
		
		courses.add(new Course("Java 1. Base", 40));
		courses.add(new Course("Java 2. OOP", 40));
		courses.add(new Course("Pattern OOP", 24));
		courses.add(new Course("Git", 16));
		
		out.println(courses.size()); // 4
		
		//courses.get(index)
		//courses.set(index, value)
		//courses.remove(index)
		
		// BAD : 
		//	1. Работает только для List
		//  2. Может быть неоптимальным скорость переборки (например LinkedList)
		//for(int i = 0; i < courses.size(); i++)
		//	out.println( courses.get(i));
		
		// GOOD
//		Iterator<Course> iter = courses.iterator();
//		while(iter.hasNext()) {
//			Course c = iter.next();
//			out.println( c );
//		}
		/*Collections.sort(courses, new Comparator<Course>() {
			@Override
			public int compare(Course o1, Course o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});*/
//		Collections.sort(courses,
//				(o1,o2) -> o1.getTitle().compareTo(o2.getTitle()) );
		
//		Collections.sort(courses,
//				(o1,o2) -> App.compareCourse(o1, o2) );
		Collections.sort(courses, App::compareCourse );

		for(Course c : courses)
			out.println(c);
		
		
		out.println(courses.size()); // 4
		
		Set<Course> courseSet = new HashSet<Course>(); 
				//new LinkedHashSet<Course>();
		
		courseSet.add(new Course("Java 2. OOP", 40));
		courseSet.add(new Course("Java 2. OOP", 40));
		
		courseSet.add(new Course("Pattern OOP", 24));
		courseSet.add(new Course("Git", 16));
		
		for(Course c : courseSet)
			out.println(c);	
		
		Map<Course, String> coursesToTeacher = new HashMap<Course, String>();
		
		coursesToTeacher.put(new Course("Java 2. OOP", 40), "Sergey");
		coursesToTeacher.put(new Course("MS SQL", 24), "Fedor");
		
		//Set<Course> keys = coursesToTeacher.keySet();
//		for(Course c : coursesToTeacher.keySet())
//			out.printf("key: %s value: %s\n", c, coursesToTeacher.get(c));
		
		//for(Map.Entry<Course,String> pair :  coursesToTeacher.entrySet())
		for(var pair :  coursesToTeacher.entrySet())
			out.printf("key: %s value: %s\n", pair.getKey(), pair.getValue());
		
		
		Map<Course, List<String>> coursesToTeachers = new HashMap<>();
		
//		var t1 = new ArrayList<String>();
//		t1.add("Sergey");
//		t1.add("Alex");
//
//		coursesToTeachers.put(new Course("Java 2. OOP", 40), t1);
		
		coursesToTeachers.put(new Course("Java 2. OOP", 40), List.of("Sergey", "Alex"));
		coursesToTeachers.put(new Course("Git", 16), 
				new ArrayList<String>(List.of("Sergey", "Fedor")));
		
		for(var pair :  coursesToTeachers.entrySet()) {
			out.printf("Course: %s\n", pair.getKey());
			for(var teacher : pair.getValue())
				out.printf("\t%s\n", teacher);
		}
			

		
		

	}

}
