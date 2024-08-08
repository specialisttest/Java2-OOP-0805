package ru.specialist;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class App {

	public static final int MAX_ATTEMPTS = 7;
	public static final int MAX_SECONDS = 30;
	
	public static void main(String[] args)
	{
		
		int q = new Random().nextInt(100)+1; // [1..100]
		System.out.println(q);
		
		System.out.println("Enter en for english");
		System.out.println("Enter ru for russian");
		
		var sc = new Scanner(System.in);
		var msg = ResourceBundle.getBundle("ru.specialist.messages");
		
		int x = 0;
		int counter = 0;
		long startTime = System.currentTimeMillis();
		do
		{
			System.out.print(msg.getString("guess"));
			if (sc.hasNextInt())
				x = sc.nextInt();
			else {
				String r = sc.next();
				switch(r.toLowerCase()) {
					case "ru" : 
						Locale.setDefault(Locale.of("RU"));
						msg = ResourceBundle.getBundle("ru.specialist.messages");
						break;
					case "en":
						Locale.setDefault(Locale.US);
						msg = ResourceBundle.getBundle("ru.specialist.messages");
						break;
				}
				continue;
			}
				
			if (x == 0 || 
				(System.currentTimeMillis() - startTime) > MAX_SECONDS*1000) break;
			if (x > q)
				System.out.println(msg.getString("big"));
			if (x < q)
				System.out.println(msg.getString("small"));
			++counter;
		}
		while(counter < MAX_ATTEMPTS && x != q);
		
		String result = "";
		if (x == 0)
			result = msg.getString("give_up");
		else
			if ( (System.currentTimeMillis() - startTime) > MAX_SECONDS*1000)
				result = msg.getString("time_out");
			else
				if(counter >= MAX_ATTEMPTS && x != q )
					result = msg.getString("attempts_out");
				else
					result = String.format(msg.getString("win"), counter);
			
		System.out.println(result);
		
	}
}
