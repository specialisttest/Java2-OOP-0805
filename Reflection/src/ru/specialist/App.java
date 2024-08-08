package ru.specialist;

import java.lang.reflect.*;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		Scanner sc = new Scanner(System.in);
		
//		1.
//		var c = new ru.specialist.plugin.Calculator();
//		Class desc = c.getClass();
//		2.		
//		Class desc = ru.specialist.plugin.Calculator.class;
		
//		3.		
		String className = "ru.specialist.plugin.Calculator";
		
		Class desc = Class.forName(className);
		
		Object c = desc.newInstance(); // new Calculator();
		
		Field[] fields = desc.getDeclaredFields();
		
		for(Field field :  fields) {
			System.out.printf("%s = ", field.getName());
			int n = sc.nextInt();
			field.setInt(c, n);  // c.x = n;
		}
		
		Method[] methods = desc.getDeclaredMethods();
		for(Method method : methods) {
			if (Modifier.isPublic(method.getModifiers()))
				System.out.println(method.getName());
		}
		
		if (sc.hasNextLine()) sc.nextLine();
		System.out.print("Выберите метод: ");
		String action = sc.nextLine();
		
		Method methodForAction = desc.getMethod(action);
		Object result = methodForAction.invoke(c); // c.add();
		
		System.out.println(result);
		

	}

}
