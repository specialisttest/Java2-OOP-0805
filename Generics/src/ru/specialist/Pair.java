package ru.specialist;

public class Pair<T extends Comparable<? super T>> {
	
	private T x, y; // Object
	
	// true если x > y
	// false иначе
	public boolean isGreater() {
		
		return x.compareTo(y) > 0;
	}
	
	public Pair(T x, T y) {
		this.x = x;
		this.y = y;
	}

	public T getX() {
		return x;
	}

	public T getY() {
		return y;
	}
	
	

}
