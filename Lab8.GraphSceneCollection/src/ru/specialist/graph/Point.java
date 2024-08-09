package ru.specialist.graph;

import java.util.Objects;

public class Point extends Shape{
	
	//private int x, y;
	private Coords coords;  // композиция
	
	public Point(int x, int y) {
		this(x, y, DEFAULT_COLOR);
	}
	
	public Point(int x, int y, String color) {
		super(color);
		coords = new Coords(x,y);
		//setX(x);
		//setY(y);
	}

	public int getX() {
		return coords.getX(); //return x;
	}

	public void setX(int x) {
		coords.setX(x);//this.x = x;
	}

	public int getY() {
		return coords.getY();  // return y;
	}

	public void setY(int y) {
		coords.setY(y); //this.y = y;
	}
	
	@Override
	public void draw() {
		System.out.printf("Point %s : %s\n", coords, getColor() );
	}
	
	@Override
	public double distance() {
		return coords.distance();
	}
	
	@Override
	public Point clone() {
		return new Point(getX(), getY(), getColor());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getX(), getY(), getColor());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		
		Point p = (Point)obj;
		
		return this.getX() == p.getX() && 
				this.getY() == p.getY() &&
				this.getColor().equals(p.getColor());
	}	
	
}
