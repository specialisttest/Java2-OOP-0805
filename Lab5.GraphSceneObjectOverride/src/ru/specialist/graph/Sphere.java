package ru.specialist.graph;

public class Sphere extends Circle{
	
	private int z;

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public Sphere(int x, int y, int z, int radius, String color) {
		super(x, y, radius, color);
		setZ(z);
	}
	
	

}
