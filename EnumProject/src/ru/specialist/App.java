package ru.specialist;

// class Colors extends Enum<Colors>
enum Colors {
	Red(0xFF, 0x00, 0x00), 
	Green(0x00, 0xFF, 0x00),
	Blue(0x00, 0x00, 0xFF),
	Yellow(0x00, 0xFF, 0xFF),
	White(0xFF, 0xFF, 0xFF),
	Black(0x00, 0x00, 0x00);
	
	private int red, green, blue;
	
	Colors(){}
	
	Colors(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	@Override
	public String toString() {
		return String.format("#%h%h%h", red, green, blue);
	}
	
	public String negative() {
		return String.format("#%h%h%h", 255-red, 255-green, 255-blue);
	}
}

public class App {
	
	public static void main(String[] args) {
		Colors c1 = Colors.Green;
		System.out.println( c1.name() );
		int k1 = c1.ordinal();
		System.out.println( k1);
		
		Colors c2 = Colors.valueOf("Blue");
		System.out.println( c2 );
		System.out.println( c2.negative() );
		
		for(Colors c : Colors.values())
			System.out.println( c );

	}

}
