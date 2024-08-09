package ru.specialist;

public class App {

	public static void main(String[] args) {
		Course c1 = new Course("Java 1. Base", 40);
		Course c2 = new Course( 0 );
		
		Course c3 = new Course("Java 1. Base", 40);
		
		System.out.println( c1 );
		System.out.println( c2 );
		System.out.println( c3 );
		
		System.out.println( c1.equals(c3) );
		
		System.out.println(c1.title());
		System.out.println(c1.titleUpper());

	}

}
