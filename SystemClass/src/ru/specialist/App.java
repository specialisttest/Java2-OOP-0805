package ru.specialist;

import java.util.Map;
import java.util.Properties;

public class App {

	public static void main(String[] args) {
		//System.exit(0);
		System.out.println("Environment");
		Map<String, String> env = System.getenv();
		for(Map.Entry<String, String> e : env.entrySet())
			System.out.printf("%-20s : %s\n", e.getKey(), e.getValue());
		
		System.out.println("Properties");
		Properties props = System.getProperties();
		for(Map.Entry<Object, Object> e : props.entrySet())
			System.out.printf("%-20s : %s\n", e.getKey(), e.getValue());
	}

}
