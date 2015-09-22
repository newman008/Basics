package Hash;

public class String {
	
	private char[] s;
	int M;
	
	public int hashCode() {
		int hash = 0;
		for(int i = 0; i < s.length; i++)
			hash = hash * 31 + s[i];
		return hash;
	}
	
	// Modular Hash
	public int hash(String s) {
		return (s.hashCode() & 0x7fffffff) % M;
	}
}
