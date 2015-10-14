package LeetCode2;

public class _6_ZigZagConversion {
    public String convert(String s, int numRows) {
        char[] ch = s.toCharArray();
        int l = s.length();
        
        StringBuffer[] res = new StringBuffer[numRows];
        for(int i = 0; i < numRows; i++) {
            res[i] = new StringBuffer();
        }
        
        int i = 0;
        while(i < l) {
            for(int j = 0; j < numRows && i < l; j++) {
                res[j].append(ch[i++]);
            }
            for(int j = numRows - 2; j > 0 && i < l; j--) {
                res[j].append(ch[i++]);
            }
        }
        
        for(int j = 1; j < numRows; j++) 
            res[0].append(res[j]);
        
        return res[0].toString();
    }
}
