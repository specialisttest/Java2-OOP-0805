package ru.specialist;

import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.time.*;

public class App {

	public static void main(String[] args) {
		
		var t1 = Clock.systemUTC().millis(); //System.currentTimeMillis();
		
		//Locale.US
		//var rus = new Locale("RU", "RU"); // устарел
		
		var rus = Locale.of("RU", "RU");
		System.out.println(Locale.getDefault());
//		Locale.setDefault(Locale.US);
//		System.out.println(Locale.getDefault());
		
		Formatter frm = new Formatter();
		int length = 36;
		
		frm.format("Length: %d\n", length);
		frm.format("Length: %x\n", length); 
		frm.format("PI    : %.4f\n", Math.PI);
		
		LocalTime now = LocalTime.now();
		frm.format("%tT\n", now);
		frm.format("%tR\n", now);
		LocalDate today = LocalDate.now();
		frm.format("%tF\n", today);
		frm.format("%1$tY.%1$tm.%1$td\n", today); // 2024.08.08
		frm.format("%tY.%<tm.%<td\n", today); // 2024.08.08
		
		frm.format(Locale.US, "%tc\n", new Date());
		frm.format(rus, "%tc\n", new Date());
		
		System.out.println( frm );
		
		var text = ResourceBundle.getBundle("ru.specialist.text"
				//, Locale.GERMAN
				/*, Locale.getDefault()*/);
		
		System.out.println( text.getString("hello") );
		
		System.out.println( Math.random() );
		var rnd = new Random();
		System.out.println( rnd.nextInt() );
		System.out.println( rnd.nextInt(100) ); // [0..99]
		System.out.println( rnd.nextInt(100)+1 ); // [1..100]
		
		long t2 = Clock.systemUTC().millis(); //System.currentTimeMillis();
		
		System.out.println( t2 - t1);
		
		

	}

}
