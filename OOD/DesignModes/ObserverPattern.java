package designModes;

import java.util.ArrayList;

// Subject
abstract class Subject2 {
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    
    public void attach(Observer ob) {
        observers.add(ob);
    }
    
    public void detach(Observer ob) {
        observers.remove(ob);
    }
    
    public void notify1() {
        for(Observer ob : observers) {
            ob.Update();
        }
    }
}

class ConcreteSubject extends Subject2 {
    private String state;
    
    public String getState() {
        return this.state;
    }
    
    public void setState(String st) {
        this.state = st;
    }
}

abstract class Observer
{
    public abstract void Update();
}

class ConcreteObserver extends Observer {
    
    private String name;
    private String state;
    private ConcreteSubject subject;
    
    public ConcreteObserver(ConcreteSubject subject, String name) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void Update() {
        // TODO Auto-generated method stub
        state = subject.getState();
        System.out.println("Observer " + this.name + "'s new state is " + this.state);
    }
    
    public ConcreteSubject getSubject() {
        return this.subject;
    }
    
}

public class ObserverPattern {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ConcreteSubject s = new ConcreteSubject();
        s.attach(new ConcreteObserver(s,"X"));
        s.attach(new ConcreteObserver(s,"Y"));
        s.attach(new ConcreteObserver(s,"Z"));
        
        s.setState("ABC");
        s.notify1();
    }

}
