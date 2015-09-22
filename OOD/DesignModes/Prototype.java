package designModes;

public class Prototype {
	
	public static void main(String[] args) {
		concretePrototype1 p1 = new concretePrototype1("I");
		concretePrototype1 c1 = (concretePrototype1) p1.clone();
		System.out.println(c1.id);
	}
}

abstract class prototype1{
	public String id;
	
	public prototype1(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public abstract prototype1 clone();
}

class concretePrototype1 extends prototype1 {

	public concretePrototype1(String id) {
		super(id);
	}

	@Override
	public prototype1 clone() {
		// TODO Auto-generated method stub
		return new concretePrototype1(id); 
	}
	
}

class concretePrototype2 extends prototype1 {

	public concretePrototype2(String id) {
		super(id);
	}

	@Override
	public prototype1 clone() {
		// TODO Auto-generated method stub
		return new concretePrototype2(id); 
	}
	
}


