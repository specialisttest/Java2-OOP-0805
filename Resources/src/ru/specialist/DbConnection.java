package ru.specialist;

import java.io.Closeable;
import java.io.IOException;

public class DbConnection implements Closeable /* или AutoCloseable */{
	
	public DbConnection() {
		System.out.println("Open db connection");
	}
	
	public void execute() {
		System.out.println("execute db commands");
	}

	@Override
	public void close() {
		System.out.println("Close db connection");
		
	}
	
	
	// Устарело и не следует использовать
	/*@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("Close db connection");
		
		
	}*/

}
