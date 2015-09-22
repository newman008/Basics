package designModes;
abstract class Product{
	
}

class ConcreteProductA extends Product {
	
}

class ConcreteProductB extends Product {
	
}

interface Creator{
	Product CreateProduct();
}

class ConcreteCreatorA implements Creator {
	@Override
	public Product CreateProduct() {
		return new ConcreteProductA();
	}
}

class ConcreteCreatorB implements Creator {
	@Override
	public Product CreateProduct() {
		return new ConcreteProductB();
	}
}

public class FactoryMethod {
	public static void main(String[] args) {
		Creator factory = new ConcreteCreatorA();
		Product product = factory.CreateProduct();
	}
}
