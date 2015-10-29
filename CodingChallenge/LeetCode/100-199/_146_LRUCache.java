package LeetCode2;

import java.util.HashMap;

public class _146_LRUCache {
    class DoubleLinkedListNode {
        int val;
        int key;
        DoubleLinkedListNode pre;
        DoubleLinkedListNode next;
        
        public DoubleLinkedListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    
    private int capacity;
    private int len;
    private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode end;
    
    
    public _146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.len = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            DoubleLinkedListNode latest = map.get(key);
            removeNode(latest);
            setHead(latest);
            return latest.val;
        } else {
            return -1;
        }
    }
    
    private void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode cur = node;
        DoubleLinkedListNode pre = node.pre;
        DoubleLinkedListNode post = node.next;
        
        if(pre == null) {
            head = post;
        } else {
            pre.next = post;
        }
        
        if(post == null) {
            end = pre;
        } else {
            post.pre = pre;
        }
    }
    
    private void setHead(DoubleLinkedListNode node) {
        node.next = head;
        node.pre = null;
        if(head != null) head.pre = node;
        head = node;
        if(end == null) end = node;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            DoubleLinkedListNode oldNode = map.get(key);
            oldNode.val = value;
            removeNode(oldNode);
            setHead(oldNode);
        } else {
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
            if(len < capacity) {
                setHead(newNode);
                map.put(key, newNode);
                len++;
            } else {
                map.remove(end.key);
                end = end.pre;
                if(end != null) end.next = null;
                setHead(newNode);
                map.put(key, newNode);
            }
        }
    }
}
