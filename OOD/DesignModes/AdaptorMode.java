package designModes;

class Target {
    public void Request() {
        System.out.println("Normal Request");
    }
}

class Adaptee {
    public void SpecificRequest() {
        System.out.println("Specific Request");
    }
}

class Adapter extends Target {
    private Adaptee adaptee = new Adaptee();
    
    @Override
    public void Request() {
        adaptee.SpecificRequest();
    }
}

public class AdaptorMode {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Target target = new Adapter();
        target.Request();
    }

}
