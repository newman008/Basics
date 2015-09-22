package designModes;

abstract class Mediator {
	public abstract void send(String message, Colleague colleague);
}

class ConcreteMediator extends Mediator {
	
	private ConcreteColleague1 colleague1;
    private ConcreteColleague2 colleague2;
    
    public void setColleague1(ConcreteColleague1 c1) {
    		this.colleague1 = c1;
    }
    
    public void setColleague2(ConcreteColleague2 c2) {
		this.colleague2 = c2;
    }
    
	@Override
	public void send(String message, Colleague colleague) {
		// TODO Auto-generated method stub
		if(colleague == colleague1)
			colleague2.Notify(message);
		else
			colleague1.Notify(message);
	}
	
}

abstract class Colleague {
	Mediator mediator;
	
	public Colleague(Mediator me) {
		mediator = me;
	}
}

class ConcreteColleague1 extends Colleague {

	public ConcreteColleague1(Mediator me) {
		super(me);
		// TODO Auto-generated constructor stub
	}
	
	public void Send(String message) {
		mediator.send(message, this);
	}
	
	public void Notify(String message) {
		System.out.println("Colleague1 got message: " + message);
	}
	
}

class ConcreteColleague2 extends Colleague {

	public ConcreteColleague2(Mediator me) {
		super(me);
		// TODO Auto-generated constructor stub
	}
	
	public void Send(String message) {
		mediator.send(message, this);
	}
	
	public void Notify(String message) {
		System.out.println("Colleague2 got message: " + message);
	}
	
}

public class MediatorMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcreteMediator m = new ConcreteMediator();

	    ConcreteColleague1 c1 = new ConcreteColleague1(m);
	    ConcreteColleague2 c2 = new ConcreteColleague2(m);
	    
	    m.setColleague1(c1);
	    m.setColleague2(c2);
	    
	    c1.Send("How are you? C2");
	    c2.Send("Fine. How are you?");
	}

}
