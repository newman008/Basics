package designModes;

abstract class Strategy {
    public abstract void AlgorithmInterface();
}

class ConcreteStrategyA extends Strategy {

    @Override
    public void AlgorithmInterface() {
        // TODO Auto-generated method stub
        System.out.println("called A");
    }
    
}

class ConcreteStrategyB extends Strategy {

    @Override
    public void AlgorithmInterface() {
        // TODO Auto-generated method stub
        System.out.println("called B");
    }
    
}

class ConcreteStrategyC extends Strategy {

    @Override
    public void AlgorithmInterface() {
        // TODO Auto-generated method stub
        System.out.println("called C");
    }
    
}

class Context2 {
    private Strategy strategy;
    public Context2(Strategy st) {
        strategy = st;
    }
    
    public void ContextInterface() {
        strategy.AlgorithmInterface();
    }
    
}

public class StrategyPattern {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Context2 context = null;
        context = new Context2(new ConcreteStrategyA());
        context.ContextInterface();
        context = new Context2(new ConcreteStrategyB());
        context.ContextInterface();
        context = new Context2(new ConcreteStrategyC());
        context.ContextInterface();
    }

}
