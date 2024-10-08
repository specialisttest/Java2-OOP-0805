package ru.specialist.graph;

public class Coords {
	private int x, y;
	
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
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("(%d, %d)", getX(), getY());
	}
}
