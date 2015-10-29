package StackAndQueues;

/*
 * Describe how you could use a single array to implement three stacks.
 */

public class _31 {
    
    int stackSize = 100;
    int[] buffer = new int[stackSize * 3];
    int[] stackPointer = {-1, -1, -1};
    
    public void push(int stackNum, int value) {
        if(stackPointer[stackNum] > stackSize) return;
        stackPointer[stackNum]++;
        buffer[indexOfTop(stackNum)] = value;
    }
    
    public int pop(int stackNum) {
        if(stackPointer[stackNum] == -1) return -1;
        int val = buffer[indexOfTop(stackNum)];
        buffer[indexOfTop(stackNum)] = 0;
        stackPointer[stackNum]--;
        return val;
    }
    
    public int peek(int stackNum) {
        int index = indexOfTop(stackNum);
        return buffer[index];
    }
    
    public boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }
    
    public int indexOfTop(int stackNum) {
        return stackNum * stackSize + stackPointer[stackNum];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
