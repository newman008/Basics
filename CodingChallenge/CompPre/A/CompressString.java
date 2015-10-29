package Amazon;
/*
 * compress string，但是要in place
 * abcddd => a1b1c1d3
 */

public class CompressString {
    
    public static String compress(String s) {
        if(s == null || s.length() <= 1) return s;
        
        StringBuilder res = new StringBuilder();
        char pre = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == pre) {
                count++;
            } else {
                res.append(pre);
                res.append(count);
                pre = s.charAt(i);
                count = 1;
            }
        }
        res.append(pre);
        res.append(count);
        
        return res.length() < s.length() ? res.toString() : s;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print(CompressString.compress("abb"));
    }

}
