package InterviewQuestions;
// use array to implement Set<String> add,
// Set supports add, clone, clear, isEmpty, remove, contains, 
public class ArraySet {
	
	private static final int INIT_CAPACITY = 4;
	private int N;
	private int M;
	private String[] array;
	
	public ArraySet(){
		this(INIT_CAPACITY);
	}
	
	public ArraySet(int capacity) {
		M = capacity;
		array = new String[M];
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void resize(int capacity) {
		ArraySet tmp = new ArraySet(capacity);
		for(int i = 0; i < M; i++) {
			if(array[i] != null)
				tmp.add(array[i]);
		}
		array = tmp.array;
		M = tmp.M;
	}
	
	public boolean contains(String s) {
		
		for(int i = hash(s); array[i] != null; i = (i+1) % M) {
			if(array[i].equals(s)){
				return true;
			}
		}
		return false;
	}
	
	public boolean add(String s) {
		if(N >= M / 2) resize(M * 2);
		
		int i;
		for(i = hash(s); array[i] != null; i = (i+1) % M) {
			if(array[i].equals(s)) {
				return false;
			}
		}
		array[i] = s;
		N++;
		return true;
	}
	
	private int hash(String s) {
		return (s.hashCode() & 0x7fffffff) % M;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArraySet set = new ArraySet();
		int t1 = "ab".hashCode() & 0x7fffffff;
		int t2 = "cd".hashCode() & 0x7fffffff;
		System.out.println(t1);
		System.out.println(t2);
		set.add("ab");
		set.add("cd");
		set.add("ef");
		set.add("gh");
		set.contains("ab");
	}

}
