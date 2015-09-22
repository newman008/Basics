package LeetCode2;

import java.util.HashMap;

public class _138_CopyListWithRandomPointer {
	class RandomListNode {
	     int label;
	     RandomListNode next, random;
	     RandomListNode(int x) { this.label = x; }
	};
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        
        RandomListNode pre = newHead;
        RandomListNode cur = head.next;
        
        while(cur != null) {
            RandomListNode newCur = new RandomListNode(cur.label);
            map.put(cur, newCur);
            pre.next = newCur;
            pre = newCur;
            cur = cur.next;
        }
        
        cur = head;
        RandomListNode copyCur = newHead;
        while(cur != null) {
            copyCur.random = map.get(cur.random);
            copyCur = copyCur.next;
            cur = cur.next;
        }
        
        return newHead;
    }
	
	public RandomListNode copyRandomList2(RandomListNode head) {
        if(head == null) return head;
        RandomListNode cur = head;
        
        while(cur != null) {
            RandomListNode newCur = new RandomListNode(cur.label);
            newCur.next = cur.next;
            cur.next = newCur;
            cur = newCur.next;
        }
        
        cur = head;
        while(cur != null) {
            if(cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        
        // detach list
        RandomListNode newHead = head.next;
        cur = head;
        RandomListNode newCur = newHead;
        while(cur != null) {
            cur.next = cur.next.next;
            if(newCur.next != null) 
                newCur.next = newCur.next.next;
            
            cur = cur.next;
            newCur = newCur.next;
        }
        
        return newHead;
    }
}
