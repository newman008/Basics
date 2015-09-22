package LeetCode2;

public class _38_CountAndSay {
	public String countAndSay(int n) {
        if(n == 0) return null;
        String result = "1";
        
        for(int i = 1; i < n; i++) {
            result = say(result);
        }
        
        return result;
    }
    
    private String say(String s) {
        String res = "";
        int count = 1;
        int index = 1;
        char last = s.charAt(0);
        
        while(index <= s.length() -1){
            if(s.charAt(index) == last){
                count++;
            } else {
                res = res + count;
                res = res + last;
                count = 1;
                last = s.charAt(index);
            }
            index++;
        }
        res = res + count;
        res = res + last;
        
        return res;
    }
}
