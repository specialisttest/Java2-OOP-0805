package ru.specialist;

public class App {

	public static void main(String[] args) {
//		var db = new DbConnection(); // открыли соединенис БД
//		try {
//			db.execute();			 // выполняем запросы к БД
//		} finally {
//			db.close();	
//		}
		
		// Ресурсный try
		try (var db = new DbConnection() /*; несколько объектов*/){
			db.execute();
		} // неявно вызывается db.close()
		
		
									 // где закрывать соединение ??
		//System.gc();
		//System.runFinalization();

	}

}
