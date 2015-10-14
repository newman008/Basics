package LeetCode2;

public class _8_StringToInteger {
    public int myAtoi(String str) {
        // #0 null&empty handling
        if(str == null || str.length() == 0)
            return 0;
        char[] c = str.toCharArray();
        int len = c.length;
        int start = 0;
        int flag = 1;
        
        // #1 delete blank before string
        while(c[start] == ' ') {
            start++;
        }
        
        // #2 sign
        if(c[start] == '+') {
            flag = 1;
            start++;
        } else if(c[start] == '-') {
            flag = -1;
            start++;
        }
        
        int value = 0;
        int max = Integer.MAX_VALUE / 10; // #3 overflow handling
        while(c[start] >= '0' && c[start] <= '9') {
            if(value > max || (value == max && c[start] > '7')) {
                if(flag == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            value = value * 10 + c[start] - '0';
            start++;
            if(start == len) break;
        }
        
        return value * flag;
    }
}
