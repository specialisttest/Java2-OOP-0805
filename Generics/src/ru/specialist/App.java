package ru.specialist;

import static java.lang.System.out;

public class App {
	
	/*public static boolean isGreater(int x, int y) {
		return x > y;
	}

	public static boolean isGreater(double x, double y) {
		return x > y;
	}
	
	public static boolean isGreater(String x, String y) {
		return x.compareTo(y) > 0;
	}*/
	
	public static <T extends Comparable<? super T>> boolean isGreater(T x, T y) {
		return x.compareTo(y) > 0;
	}
	
	public static void main(String[] args) {
		
		out.println ( App.<Integer>isGreater(11, 6) );
		out.println ( isGreater(2.5, 6.1) );
		out.println ( isGreater("abc", "cde") );
		
		
		Pair<Integer> p1 = new Pair<Integer>(5, 6);
		
		//Pair<Double> p2 = new Pair<Double>(2.5, 6.1);
		var p2 = new Pair<Double>(2.5, 6.1);
		
		//Pair<String> p3 = new Pair<String>("abc", "cde");
		Pair<String> p3 = new Pair<>("abc", "cde");
		
		//Pair<App> p33 = new Pair<App>("abc", "cde");
		
		Pair2<String, Integer> p4 = new Pair2<String, Integer>("abc", 56);
		
		//Pair2<Object, Object> p5 = new Pair2<Object, Object>("abc", 56);
		Pair2 p5 = new Pair2("abc", 56); // raw type
		
		
		out.printf("%d\n", p1.getX() * p1.getY());
		out.printf("%s\n", p1.isGreater());
		
		out.printf("(%d, %d)\n", p1.getX(), p1.getY());
		
		out.printf("(%f, %f)\n", p2.getX(), p2.getY());
		out.printf("(%s, %s)\n", p3.getX(), p3.getY());
		
		out.printf("(%s, %d)\n", p4.getX(), p4.getY());
		
		

	}

}
