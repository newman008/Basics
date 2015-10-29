package StackAndQueues;

import java.util.Stack;

/*
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use at most one additional stack to hold items, 
 * but you may not copy the elements into any other data structure (such as an array). 
 * The stack supports the following operations: push, pop, peek, and isEmpty.
 */

public class _36 {
    
    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty()){
            int tmp = s.pop();
            while(!r.isEmpty() && tmp < r.peek()){
                s.push(r.pop());
            }
            r.push(tmp);
        }
        
        return r;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
