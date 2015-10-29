package CallCenter;

class Responder extends Employee {
    public Responder(){
        rank = 1;
    }
}

class Manager extends Employee {
    public Manager() {
        rank = 2;
    }
}

class Director extends Employee {
    public Director() {
        rank = 3;
    }
}

public abstract class Employee {
    private Call curCall = null;
    protected int rank;
    
    public Employee() {
        
    }
    
    public void pickCall(Call call) {
        curCall = call;
        //..
    }
    
    public void completeCall(Call call) {
        curCall = null;
        //..
    }
    
    public void escalateAndReassign(Call call) {
        
    }
    
    public boolean assignNewCall() {
        return true;
    }
    
    public boolean isFree() {
        return curCall == null;
    }
    
    public int getRank() {
        return rank;
    }
}
