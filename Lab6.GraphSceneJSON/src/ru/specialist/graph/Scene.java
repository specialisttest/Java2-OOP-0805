package ru.specialist.graph;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Scene {
	
	public static final int MAX_SIZE = 100;
	
	private Shape[] shapes = new Shape[MAX_SIZE];
	private int shapesCounter = 0;
	
	public boolean add(Shape shape) {
		if (shapesCounter >= MAX_SIZE) return false;
		shapes[shapesCounter++] = shape;
		return true;
	}
	
	public void sort() {
		Arrays.sort(shapes, 0, shapesCounter);
	}
	
	public void draw() {
		for(int i=0; i < shapesCounter; i++)
			shapes[i].draw(); // полиморфизм!!!
	}
	
	// Jackson, GSON - библиотеки для работы с JSON в Java
	
	public void save(String fileName) throws IOException {
		try(var fos = new FileOutputStream(fileName);
			var writer = new PrintWriter(fos) ) {
			writer.println('[');
			for(int i=0; i < shapesCounter; i++) {
				writer.println("\t{");
				if (shapes[i] instanceof Point p) {
					writer.println("\t\t\"type\" : \"Point\",");
					writer.printf("\t\t\"x\" : %d,\n", p.getX());
					writer.printf("\t\t\"y\" : %d,\n", p.getY());
					writer.printf("\t\t\"color\" : \"%s\"\n", p.getColor());
				}
				if (shapes[i] instanceof Circle c) {
					writer.println("\t\t\"type\" : \"Circle\",");
					writer.printf("\t\t\"x\" : %d,\n", c.getX());
					writer.printf("\t\t\"y\" : %d,\n", c.getY());
					writer.printf("\t\t\"radius\" : %d,\n", c.getY());
					writer.printf("\t\t\"color\" : \"%s\"\n", c.getColor());
				}
				writer.print("\t}");
				if (i < shapesCounter - 1)
					writer.print(",");
				writer.println();
			}
				
			writer.println(']');
		}
		
	}

}
