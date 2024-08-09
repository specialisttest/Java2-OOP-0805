
// + lazy init
// - non thread safe
public class Singleton1 {
	
	private Singleton1() {
		System.out.println("Singleton 1 created");
	}
	
	private static Singleton1 instance = null;
	
	public static Singleton1 getInstance() {
		if (instance == null)
			instance = new Singleton1();
		
		return instance;
	}

}
