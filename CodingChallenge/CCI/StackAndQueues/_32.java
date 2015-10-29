package StackAndQueues;

import java.util.*;

/*
 * How would you design a stack which, in addition to push and pop, 
 * also has a function min which returns the minimum element? 
 * Push, pop and min should all operate in 0(1) time.
 */

public class _32 extends Stack<Integer>{
    
    Stack s;
    public _32(){
        s = new Stack<Integer>();
    }
    
    public int min() {
        if(s.isEmpty()) return Integer.MAX_VALUE;
        else return (int) s.peek();
    }
    
    public void push(int val) {
        if(val <= min()) {
            s.push(val);
        }
        super.push(val);
    }
    
    public Integer pop() {
        int val = super.pop();
        if(val == min()){
            s.pop();
        }
        return val;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
