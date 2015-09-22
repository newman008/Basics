package designModes;

abstract class Handler {
	Handler successor;
	
	public void SetSuccessor(Handler next)
    {
      successor = next;
    }
	
	public abstract void HandleRequest(int request);
}

class ConcreteHandler1 extends Handler {

	@Override
	public void HandleRequest(int request) {
		// TODO Auto-generated method stub
		if(request >= 0 && request <= 10) 
			System.out.println("ConcreteHandler1 handled request" + request);
		else
			successor.HandleRequest(request);
	}
	
}

class ConcreteHandler2 extends Handler {

	@Override
	public void HandleRequest(int request) {
		// TODO Auto-generated method stub
		if(request > 10 && request <= 20) 
			System.out.println("ConcreteHandler2 handled request" + request);
		else
			successor.HandleRequest(request);
	}
	
}

class ConcreteHandler3 extends Handler {

	@Override
	public void HandleRequest(int request) {
		// TODO Auto-generated method stub
		if(request > 20 && request <= 30) 
			System.out.println("ConcreteHandler3 handled request" + request);
		else
			successor.HandleRequest(request);
	}
	
}

public class ChainOfResponsibilityMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Handler h1 = new ConcreteHandler1();
	    Handler h2 = new ConcreteHandler2();
	    Handler h3 = new ConcreteHandler3();
	    h1.SetSuccessor(h2);
	    h2.SetSuccessor(h3);
	    
	    int[] requests = {2,3,5,19,23,22,7};
	    for (int request : requests) {
	    		h1.HandleRequest(request);
	    }
	}

}
