package LeetCode2;

import java.util.LinkedList;
import java.util.Queue;

public class _225_ImplementStackUsingQueue {
	Queue<Integer> q = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        for(int i = 0; i < q.size() - 1; i++) {
            q.offer(q.remove());
        }
        q.remove();
    }

    // Get the top element.
    public int top() {
        for(int i = 0; i < q.size() - 1; i++) {
            q.offer(q.remove());
        }
        int res = q.remove();
        q.offer(res);
        return res;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
