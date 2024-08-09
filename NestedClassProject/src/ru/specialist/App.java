package ru.specialist;

public class App {

	public static void main(String[] args) {
		Outer.Nested n = new Outer.Nested();
		Outer o = new Outer(10);
		
		Outer.Inner in1 = o.new Inner ();
		Outer.Inner in2 = o.new Inner ();
		
		n.increment(o);
		in1.increment();
		in2.increment();
		
		System.out.println( o.getData() );
		
		Invoice inv = new Invoice("Рога&Копыта");
		inv.add("Книга",200,2);
		inv.add("Флэшка",500,3);
		
		System.out.println(inv);


	}

}
