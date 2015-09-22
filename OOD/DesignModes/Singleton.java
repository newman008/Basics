package designModes;

public class Singleton {
	// contain its instance, private
	private static Singleton instance;
	
	// make construction method private
	private Singleton() {}
	
	// public API to visit class instance
	public static Singleton GetInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton s1 = Singleton.GetInstance();
		Singleton s2 = Singleton.GetInstance();
		
		if(s1 == s2)
			System.out.println("equal instance");
	}
}
