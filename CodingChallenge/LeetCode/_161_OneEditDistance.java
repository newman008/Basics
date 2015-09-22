package LeetCode2;

public class _161_OneEditDistance {
	
	public boolean isOneEditDistance(String s, String t) {
        if(s.length() > t.length()) return isOneEditDistance(t, s);
        
        if(t.length() - s.length() >= 2) return false;
        else if(t.length() - s.length() == 1) {
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != t.charAt(i)) return s.substring(i).equals(t.substring(i+1));
            }
            
        } else {
            int count = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != t.charAt(i)) count++;
            }
            
            return count <= 1;
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		String t = "";
		_161_OneEditDistance t1 = new _161_OneEditDistance();
		t1.isOneEditDistance(s, t);
	}

}
