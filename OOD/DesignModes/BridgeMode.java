package designModes;

abstract class Implementor {
    public abstract void Operation();
}

class concreteImplementorA extends Implementor {

    @Override
    public void Operation() {
        System.out.println("Implementor A");
    }
    
}

class concreteImplementorB extends Implementor {

    @Override
    public void Operation() {
        System.out.println("Implementor B");    
    }
    
}

abstract class Abstraction {
    Implementor implementor;
    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }
    
    public void Operation() {
        implementor.Operation();
    }
}

class RefinedAbstraction extends Abstraction {
    @Override
    public void Operation() {
        implementor.Operation();
    }
}

public class BridgeMode {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Abstraction ab = new RefinedAbstraction();
        ab.setImplementor(new concreteImplementorA());
        ab.Operation();
        
        ab.setImplementor(new concreteImplementorB());
        ab.Operation();

    }

}
