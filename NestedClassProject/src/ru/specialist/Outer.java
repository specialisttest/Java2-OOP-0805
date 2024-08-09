package ru.specialist;

import java.util.Comparator;

public class Outer {
	
	// Отличия
	//  1. Снаружи составное имя Outer.Nested
	//  2. public private protected
	//  3. нарушает инкапсуляцию!!! (в обе стороны)
	public static class Nested {
		public void increment(Outer o) {
			o.data++;
		}
	}
	
	// Отличия
	//	4. Объект не самостоятелен (привязан к объекту внешнего класса)
	public class Inner {
		int data;
		public void increment() {
			//data++;
			Outer.this.data++;
		}
	}
	
	
	private int data;

	public Outer(int data) {
		this.data = data;
	}

	public int getData() {
		//new Inner();
		//this.new Inner();
		
		return data;
	}
	
	public Comparator<Integer> getMyComparator() {
		/*class MyLocale implements Comparator<Integer> {
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		}
		
		Comparator<Integer> l = new MyLocale();*/
		Comparator<Integer> l = new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		};
		
		return l;
	}
	public boolean isLessOrEqual(int c) {
		Comparator<Integer> cmp = getMyComparator();
		return cmp.compare(data, c) < 0;
		
	}
	
	public boolean isGreater(int c) {
		int k = 5;
		// k++;
		// Отличия
		//  5. нет мод. доступа, т.к. виден только внутри этого метода
		//  6. захват локальных переменных (только effective final)
		class MyLocale {
			public boolean compare(int x) {
				return data > x - k;
			}
		}
		
		MyLocale l = new MyLocale();
		
		return l.compare(c);
	}
	
	
	

}
