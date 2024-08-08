package ru.specialist;

import java.io.IOException;

import ru.specialist.graph.*;

public class App {
	
	public static void main(String[] args) throws IOException {
		var scene = new Scene();
		
		scene.add(new Circle(100, 200, 50, "pink"));
		scene.add(new Point(10, 20, "green"));
		
		
		scene.save("../scene.json");
		System.out.println("Scene saved.");
		
	}

}
