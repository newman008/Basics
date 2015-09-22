package designModes;

import java.util.HashMap;

abstract class Flyweight {
	public abstract void Operation(int extrinsicstate);
}

class ConcreteFlyweight extends Flyweight {

	@Override
	public void Operation(int extrinsicstate) {
		// TODO Auto-generated method stub
		System.out.println("ConcreteFlyweight " + extrinsicstate);
	}
	
}

class UnsharedConcreteFlyweight extends Flyweight {

	@Override
	public void Operation(int extrinsicstate) {
		// TODO Auto-generated method stub
		System.out.println("UnsharedConcreteFlyweight " + extrinsicstate);
	}
	
}

class FlyweightFactory {
	private HashMap<String, Flyweight> flyweights = new HashMap<String, Flyweight>();
	
	public FlyweightFactory() {
		flyweights.put("X", new ConcreteFlyweight());
		flyweights.put("Y", new ConcreteFlyweight());
		flyweights.put("Z", new ConcreteFlyweight());
	}
	
	public Flyweight GetFlyweight(String key) {
		if(!flyweights.containsKey(key))
			flyweights.put(key, new ConcreteFlyweight());
		return flyweights.get(key);
	}
	
}

public class FlyweightPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Arbitrary extrinsic state 
		int extrinsicstate = 22;
		
		FlyweightFactory f = new FlyweightFactory();
		
		Flyweight fx = f.GetFlyweight("X");
	    fx.Operation(--extrinsicstate);

	    Flyweight fy = f.GetFlyweight("Y");
	    fy.Operation(--extrinsicstate);

	    Flyweight fz = f.GetFlyweight("Z");
	    fz.Operation(--extrinsicstate);
	    
	    Flyweight fu = f.GetFlyweight("U");
	    fu.Operation(--extrinsicstate);
	    
	    UnsharedConcreteFlyweight uf = new UnsharedConcreteFlyweight();
	    uf.Operation(--extrinsicstate);

	}

}
