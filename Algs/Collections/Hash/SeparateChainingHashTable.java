package Hash;

// do not resize
// do not support delete

public class SeparateChainingHashTable<Key, Value> {
    private int N;
    private int M;
    private Node[] st;
    
    public SeparateChainingHashTable(int M) {
        this.M = M;
        st = new Node[M];
    }
    
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    
    public int size() {
        return N;
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public boolean containsKey(Key key) {
        return get(key) != null;
    }
    
    public Value get(Key key) {
        int i = hash(key);
        for(Node node = st[i]; node != null; node = node.next) {
            if(node.key.equals(key)) return (Value)node.val;
        }
        return null;
    }
    
    public void put(Key key, Value val) {
        int i = hash(key);
        for(Node node = st[i]; node != null; node = node.next) {
            if(node.key.equals(key)) {
                node.val = val;
                return;
            }
        }
        N++;
        st[i] = new Node(key, val, st[i]);
    }
    
    private static class Node {
        private Object key;
        private Object val;
        private Node next;
        
        public Node(Object key, Object val, Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
