package ru.specialist.graph;

public abstract class Shape {
	
	public static final String DEFAULT_COLOR = "black";
	
	private String color;

	public Shape() {
		this(DEFAULT_COLOR);
	}
	
	public Shape(String color) {
		setColor(color);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public abstract void draw();
	

}
