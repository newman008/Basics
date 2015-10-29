package designModes;

//"State" 
abstract class State
{
    public abstract void Handle(Context1 context);
}

class ConcreteStateA extends State {

    @Override
    public void Handle(Context1 context) {
        // TODO Auto-generated method stub
        context.setState(new ConcreteStateB());
        System.out.println("State is changed to " + context.getState());
    }
    
}

class ConcreteStateB extends State {

    @Override
    public void Handle(Context1 context) {
        // TODO Auto-generated method stub
        context.setState(new ConcreteStateA());
        System.out.println("State is changed to " + context.getState());
    }
    
}

class Context1 {
    private State state;
    
    public Context1(State st) {
        state = st;
    }
    
    public State getState() {
        return state;
    }
    
    public void setState(State st) {
        this.state = st;
    }
    
    public void Request()
    {
        state.Handle(this);
    }
}

public class StatePattern {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // Setup context in a state 
        Context1 c = new Context1(new ConcreteStateA());
        
        // Issue requests, which toggles state 
        c.Request();
        c.Request();
        c.Request();
        c.Request();
    }

}
