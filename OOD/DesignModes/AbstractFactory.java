
package designModes;

abstract class AbstractProductA {
    
}

class ProductA1 extends AbstractProductA {
    
}

class ProductA2 extends AbstractProductA {
    
}

abstract class AbstractProductB {
    
}

class ProductB1 extends AbstractProductB {
    
}

class ProductB2 extends AbstractProductB {
    
}

interface bstractFactory {
    AbstractProductA CreateProductA();
    AbstractProductB CreateProductB();
}

class ConcreteFactory1 implements bstractFactory {

    @Override
    public AbstractProductA CreateProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB CreateProductB() {
        return new ProductB1();
    }
    
}

class ConcreteFactory2 implements bstractFactory {

    @Override
    public AbstractProductA CreateProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB CreateProductB() {
        return new ProductB2();
    }
    
}

public class AbstractFactory {
    bstractFactory factory1 = new ConcreteFactory1();
    AbstractProductA a = factory1.CreateProductA();
    AbstractProductB b = factory1.CreateProductB();
}
