package StackAndQueues;

import java.util.*;

/*
 * In the classic problem of the Towers of Hanoi, 
 * you have 3 towers and N disks of different sizes which can slide onto any tower. 
 * The puzzle starts with disks sorted in ascending order of size from top to bottom
 */

class Tower{
    private Stack<Integer> disks;
    private int index;
    public Tower(int i) {
        index = i;
    }
    public int index(){
        return index;
    }
    public void add(int d) {
        disks.push(d);
    }
    public void moveTopTo(Tower t) {
        int top = disks.pop();
        t.add(top);
    }
    public void moveDisks(int n, Tower destination, Tower buffer) {
        if(n > 0) {
            moveDisks(n-1, buffer, destination);
            moveTopTo(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }
}

public class _34 {
    
    public void moveDisks(int n, Tower origin, Tower destination, Tower buffer) {
        if(n <= 0) return ;
        
        moveDisks(n-1, origin, buffer, destination);
        
        moveTop(origin, destination);
        
        moveDisks(n-1, buffer, destination, origin);
    }
    
    public void moveTop(Tower origin, Tower destination) {
        origin.moveTopTo(destination);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
