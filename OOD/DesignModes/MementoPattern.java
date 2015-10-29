package designModes;

class Memento {
    private String state;
    
    public Memento(String stateToSave) {
        state = stateToSave;
    }
    
    public String getState() {
        return state;
    }
}

class Organizer {
    private String state;
    
    public void set(String state) {
        System.out.println("Originator: Setting state to "+state);
        this.state = state; 
    }
    
    public Memento createMemento() {
        return new Memento(state);
    }
    
    public Memento saveToMemento() { 
        System.out.println("Originator: Saving to Memento.");
        return new Memento(state); 
    }
    
    public void restoreFromMemento(Memento m) {
        state = m.getState();
        System.out.println("Originator: State after restoring from Memento: "+state);
    }
}

class Caretaker {
    private Memento memento;
    
    public Memento getMemento() {
        return memento;
    }
    
    public void setMemento(Memento m) {
        memento = m;
    }
}

public class MementoPattern {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Organizer o = new Organizer();
        o.set("On");
        
        Caretaker c = new Caretaker();
        c.setMemento(o.createMemento());
        
        o.set("Off");
        o.restoreFromMemento(c.getMemento());
    }

}
