package ru.specialist.graph;

import java.util.Objects;

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
	
	@Override
	public Circle clone() {
		return new Circle(getX(), getY(), getRadius(), getColor());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getX(), getY(), getRadius(), getColor());
	}
	
	@Override
	public boolean equals(Object obj) {
		/*if (obj instanceof Circle c)
			return this.getX() == c.getX() && 
			this.getY() == c.getY() &&
			this.getRadius() == c.getRadius() &&
			this.getColor().equals(c.getColor());
		else
			return false;*/
		
		if (this == obj) return true;
		if (obj == null) return false;
		if (Circle.class != obj.getClass()) return false;
		
		Circle c = (Circle)obj;
		
		return this.getX() == c.getX() && 
				this.getY() == c.getY() &&
				this.getRadius() == c.getRadius() &&
				this.getColor().equals(c.getColor());
	}		
}
