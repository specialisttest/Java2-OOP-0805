package ru.specialist;

public class Pair2<T1, T2>{
	
	private T1 x;
	private T2 y;
	
	public Pair2(T1 x, T2 y) {
		this.x = x;
		this.y = y;
	}
	public T1 getX() {
		return x;
	}
	public T2 getY() {
		return y;
	}
	
	

}
