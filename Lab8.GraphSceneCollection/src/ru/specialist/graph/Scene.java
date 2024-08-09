package ru.specialist.graph;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scene {
	
	private List<Shape> shapes = new ArrayList<Shape>();
	
	public boolean add(Shape shape) {
		shapes.add(shape);
		return true;
	}
	
	public void sort() {
		Collections.sort(shapes);
	}
	
	public void draw() {
		for(Shape shape : shapes)
			shape.draw();
	}
	
	// Jackson, GSON - библиотеки для работы с JSON в Java
	
	public void save(String fileName) throws IOException {
		try(var fos = new FileOutputStream(fileName);
			var writer = new PrintWriter(fos) ) {
			writer.println('[');
			int i = 0;
			for(Shape shape : shapes){
				writer.println("\t{");
				if (shape instanceof Point p) {
					writer.println("\t\t\"type\" : \"Point\",");
					writer.printf("\t\t\"x\" : %d,\n", p.getX());
					writer.printf("\t\t\"y\" : %d,\n", p.getY());
					writer.printf("\t\t\"color\" : \"%s\"\n", p.getColor());
				}
				if (shape instanceof Circle c) {
					writer.println("\t\t\"type\" : \"Circle\",");
					writer.printf("\t\t\"x\" : %d,\n", c.getX());
					writer.printf("\t\t\"y\" : %d,\n", c.getY());
					writer.printf("\t\t\"radius\" : %d,\n", c.getY());
					writer.printf("\t\t\"color\" : \"%s\"\n", c.getColor());
				}
				writer.print("\t}");
				if (++i <= shapes.size()-1)
					writer.print(",");
				writer.println();
			}
				
			writer.println(']');
		}
		
	}

}
