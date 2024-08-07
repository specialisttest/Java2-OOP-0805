package ru.specialist;

import ru.specialist.graph.*;

public class App {
	
	public static void main(String[] args) {
		var scene = new Scene();
		
		scene.add(new Point(10, 20, "green"));
		scene.add(new Circle(100, 200, 50, "pink"));
		
		// new Shape().draw(); // ???
		
		scene.draw();
		
		
	}

}
