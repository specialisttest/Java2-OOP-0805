
// on demand holder
// + thread safe
// + lazy init
// - no ctor params
// - no try catch for ctor
public class Singleton5 {
	private Singleton5() {
		System.out.println("Singleton 5 created");
	}
	
	private static class OnDemandHolder {
		private static final Singleton5 instance = new Singleton5(); 
		
	}
	
	public static  Singleton5 getInstance() {
		return OnDemandHolder.instance;
	}

}
