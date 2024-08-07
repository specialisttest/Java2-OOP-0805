package ru.specialist.graph;

public class Scene {
	
	public static final int MAX_SIZE = 100;
	
	private Shape[] shapes = new Shape[MAX_SIZE];
	private int shapesCounter = 0;
	
	public boolean add(Shape shape) {
		if (shapesCounter >= MAX_SIZE) return false;
		shapes[shapesCounter++] = shape;
		return true;
	}
	
	public void draw() {
		for(int i=0; i < shapesCounter; i++)
			shapes[i].draw(); // полиморфизм!!!
	}

}
