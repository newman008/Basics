package Elevator;

public class User {
    int id;
    String name;
    
    public void pressButton(int toFloor){
        Request req = new Request(toFloor);
        RequestCenter rc = RequestCenter.getInstance();
        rc.addRequest(req);
    }
}
