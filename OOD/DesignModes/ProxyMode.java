package designModes;

abstract class Subject {
    public abstract void request();
}

class RealSubject extends Subject{
    public void request() {
        System.out.println("real request");
    }
}

class Proxy extends Subject {
    RealSubject rsub;
    
    public void request() {
        if(rsub == null)
            rsub = new RealSubject();
        rsub.request();
    }
}

public class ProxyMode {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Proxy proxy = new Proxy();
        proxy.request();

    }

}
