package LeetCode2;

public class _66_PlusOne {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        digits[l-1] += 1;
        int i = l-1;
        while(i >0 && digits[i] == 10) {
            digits[i] = 0;
            digits[i-1] += 1;
            i--;
        }
        
        if(digits[0] == 10) {
            int newl = l+1;
            int[] res = new int[newl];
            res[0] = 1;
            res[1] = 0;
            for(int j = 2; j <= newl-1; j++) {
                res[j] = digits[j-1];
            }
            return res;
        }
        
        return digits;
    }
}
