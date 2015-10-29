package ArraysAndStrings;

/*
 * Implement a method to perform basic string compression using the counts of repeated characters. 
 * For example, the string aabcccccaaa would become a2blc5a3. 
 * If the "compressed" string would not become smaller than the original string, your method should return the original string.
 */

public class _15 {
    
    public static String compress(String s) {
        if(s == null || s.length() <= 2) return s;
        
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char pre = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == pre){
                count++;
            } else {
                sb.append(pre);
                sb.append(count);
                pre = cur;
                count = 1;
            }
        }
        
        sb.append(pre);
        sb.append(count);
        
        if(sb.length() < s.length()) return sb.toString();
        else return s;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(_15.compress("aabcccccaaa"));
    }

}
