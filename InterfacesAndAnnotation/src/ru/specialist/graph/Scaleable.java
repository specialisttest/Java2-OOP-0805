package ru.specialist.graph;

// В C++
//	чисто абстрактные классы - pure abstract class

@FunctionalInterface
public interface Scaleable {
	
	public static final double DEFAULT_FACTOR = 2D;
	
	//public abstract
	void scale(double factor);
	
	// Java 9
	private void scaleImpl() {
		scale(DEFAULT_FACTOR);
	}
	
	// since Java 8
	// public 
	default void scale() {
		// доступны только методы этого интерфейса и методы класса Object
		scaleImpl();
	}
	
	public static void scaleScene(Scene scene) {
		scene.scale(DEFAULT_FACTOR);
	}

}

interface AnotherScaleable {
	
	default void scale() {
		
	}
}

interface Scaleable3D extends Scaleable /*,... */ {
	
	void scale3D(double factorX, double factorY, double factorZ);
	
}


// автоматически реализует и Scaleable, т.к. Scaleable наследник Scaleable3D
class Sphere implements Scaleable3D {

	@Override
	public void scale(double factor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scale3D(double factorX, double factorY, double factorZ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scale() {
		// TODO Auto-generated method stub
		
	}
	
}

// реализует Scaleable, Scalebale3D
class SphereColor extends Sphere {
	
}







