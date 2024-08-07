package ru.specialist;

import ru.specialist.graph.*;

public class App {
	
	public static void main(String[] args) {
		var scene = new Scene();
		
		scene.add(new Circle(100, 200, 50, "pink"));
		scene.add(new Point(10, 20, "green"));
		
		// new Shape().draw(); // ???
		scene.sort();
		scene.draw();
		
		Circle c1 = new Circle(10, 20, 5, "red");
		Circle c2 = new Circle(10, 20, 5, "red");
		
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(null));
		System.out.println(c1.equals(new Point(10,20)));
		System.out.println(c1.equals(new Sphere(10, 20, 0, 5, "red")));
		
		
	}

}
