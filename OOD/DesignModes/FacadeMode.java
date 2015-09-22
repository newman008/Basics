package designModes;

class SubSystemOne{
	public void methodOne() {
		System.out.println("system method one");
	}
}

class SubSystemTwo{
	public void methodTwo() {
		System.out.println("system method two");
	}
}

class SubSystemThree{
	public void methodThree() {
		System.out.println("system method three");
	}
}

class Facade {
	SubSystemThree three;
	SubSystemTwo two;
	SubSystemOne one;
	
	public Facade() {
		three = new SubSystemThree();
		two = new SubSystemTwo();
		one = new SubSystemOne();
	}
	
	public void methodA() {
		System.out.println("system method A");
		three.methodThree();
		two.methodTwo();
		one.methodOne();
	}
	
	public void methodB() {
		System.out.println("system method B");
		three.methodThree();
		one.methodOne();
	}
}


public class FacadeMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Facade fm = new Facade();
		fm.methodA();
		fm.methodB();
		
	}

}
