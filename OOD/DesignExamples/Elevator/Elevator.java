package Elevator;

public class Elevator {
    private int curFloor;
    private static Elevator instance= null;
    private Elevator() {};
    
    public static Elevator getInstance(){
        if(instance == null) {
            synchronized(Elevator.class) {
                instance = new Elevator();
            }
        }
        return instance;
    }
    
    public int getCurFloor() {
        return curFloor;
    }
    
    public void moveToTargetFloor(int toFloor) {
        curFloor = toFloor;
    }
    
    public void moveUp(){};
    public void moveDown(){};
}
