package ru.specialist.graph;

public class Circle extends Shape {
	
	//private int x,y;
	private Coords center; // композиция
	
	private int radius;
	
	public Circle(int x, int y, int radius) {
		this(x,y,radius,DEFAULT_COLOR);
	}
	
	public Circle(int x, int y, int radius, String color) {
		super(color);
		//setX(x);
		//setY(y);
		center = new Coords(x,y);
		setRadius(radius);
	}
	
	@Override
	public void draw() {
		System.out.printf("Circle %s Radius: %d : %s\n", 
				center, getRadius(), getColor() );
	}
	
	public int getX() {
		return center.getX(); //return x;
	}
	public void setX(int x) {
		center.setX(x);//this.x = x;
	}
	public int getY() {
		return center.getY(); //return y;
	}
	public void setY(int y) {
		center.setY(y);//this.y = y;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		if (radius < 0)
			throw new IllegalArgumentException("circle radius < 0");
		
		this.radius = radius;
	}
	
	@Override
	public double distance() {
		return center.distance();
	}
	
}
