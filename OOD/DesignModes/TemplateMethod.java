package designModes;

abstract class AbstractClass {
    public abstract void PrimitiveOperation1();
    public abstract void PrimitiveOperation2();
    
    public void TemplateMethod() {
            PrimitiveOperation1();
            PrimitiveOperation2();
            System.out.println("next steps");
    }
}

class ConcreteClassA extends AbstractClass {

    @Override
    public void PrimitiveOperation1() {
        // TODO Auto-generated method stub
        System.out.println("class A: Method 1");
    }

    @Override
    public void PrimitiveOperation2() {
        // TODO Auto-generated method stub
        System.out.println("class A: Method 2");
    }
    
}

class ConcreteClassB extends AbstractClass {

    @Override
    public void PrimitiveOperation1() {
        // TODO Auto-generated method stub
        System.out.println("class B: Method 1");
    }

    @Override
    public void PrimitiveOperation2() {
        // TODO Auto-generated method stub
        System.out.println("class B: Method 2");
    }
    
}

public class TemplateMethod {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AbstractClass c;
        
        c = new ConcreteClassA();
        c.TemplateMethod();
        
        c= new ConcreteClassB();
        c.TemplateMethod();
    }

}
