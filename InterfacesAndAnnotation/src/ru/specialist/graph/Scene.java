package ru.specialist.graph;

@Developer(name="Sergey", date="07/08/24")
public class Scene {
	
	public static final int MAX_SIZE = 100;
	
	private Shape[] shapes = new Shape[MAX_SIZE];
	private int shapesCounter = 0;
	
	//@Severity
	//@Severity(value="WARN")
	@Severity("WARN") // value="WARN"
	public boolean add(Shape shape) {
		if (shapesCounter >= MAX_SIZE) return false;
		shapes[shapesCounter++] = shape;
		return true;
	}
	
	public void draw() {
		for(int i=0; i < shapesCounter; i++)
			shapes[i].draw(); // полиморфизм!!!
	}
	
	public void scale(double factor) {
		for(int i=0; i < shapesCounter; i++)
			if (shapes[i] instanceof Scaleable sc)
				sc.scale(factor); // полиморфизм!!!
		
//			if (shapes[i] instanceof Scaleable) {
//				Scaleable sc = (Scaleable)shapes[i];
//				sc.scale(factor);
//			}
		
			// BAD
//			if (shapes[i] instanceof  Circle circle)
//				circle.scale(factor);
		
	}

}
