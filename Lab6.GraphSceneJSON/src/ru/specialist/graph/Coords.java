package ru.specialist.graph;

import java.util.Objects;

public class Coords implements Cloneable {
	private int x = 0, y = 0;
	
	private double distance = 0d;
	private boolean invalidDistance = false;
	
	public Coords() {
		this(0, 0);
	}
	
	public Coords(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (this.x != x) {
			this.x = x;
			invalidDistance = true;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		if (this.y != y) {
			this.y = y;
			invalidDistance = true;
		}
	}
	
	public double distance() {
		if (invalidDistance) {
			distance = Math.sqrt( getX()*getX() + getY()*getY() );
			invalidDistance = false;
		}
		
		return distance;
	}
	
	@Override
	public String toString() {
		return String.format("(%d, %d)", getX(), getY());
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Coords(getX(), getY());
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		Coords other = (Coords) obj;
		return x == other.x && y == other.y;
	}
	
	
}
