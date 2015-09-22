package Hash;

public class LinearProbingHashTable<Key, Value> {
	
	private int N;           // number of key-value pairs in the symbol table
    private int M;           // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values
	
    public LinearProbingHashTable(int capacity) {
        M = capacity;
        keys = (Key[])   new Object[M];
        vals = (Value[]) new Object[M];
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
		for(int i = hash(key); keys[i] != null; i = (i+1) % M){
			if(keys[i].equals(key)) return vals[i];
		}
		return null;	
	}
	
	public void put(Key key, Value val) {
		if(val == null) {
			deleteKey(key);
			return;
		}
		
		if(N > M / 2) resize(2 * M);
		
		int i;
		for(i = hash(key); keys[i] != null; i = (i+1) % M) {
			if(keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	public void deleteKey(Key key) {
		if(!containsKey(key)) return;
		
		int i = hash(key);
		while(!keys[i].equals(key))
			i = (i+1) % M;
		
		keys[i] = null;
		vals[i] = null;
		
		i = (i+1) % M;
		while(keys[i] != null) {
			Key keyRehash = keys[i];
			Value valRehash = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyRehash, valRehash);
			i = (i+1) % M;
		}
		
		N--;
		
		if(N > 0 && N <= M / 8) resize(M / 2);
		
	}
	
	private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
	
	private void resize(int capacity) {
		LinearProbingHashTable<Key, Value> tmp = new LinearProbingHashTable<Key, Value>(capacity);
		for(int i = 0; i < M; i++) {
			if(keys[i] != null) tmp.put(keys[i], vals[i]);
		}
		keys = tmp.keys;
		vals = tmp.vals;
		M = tmp.M;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
