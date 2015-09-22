package designModes;


public class SimpleFactory {
	
	public static Product CreateProduct(int num) {
		Product result = null;
		switch(num) 
		{
			case 1: 
				result = new ConcreteProductA();
				break;
			case 2:
				result = new ConcreteProductB();
				break;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product A = SimpleFactory.CreateProduct(1);
		Product B = SimpleFactory.CreateProduct(2);
		Product C = SimpleFactory.CreateProduct(1);
		
	}

}
