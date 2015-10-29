package LeetCode2;

/*
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */

public class _233_NumberOfDigitOne {
    
    public int countDigitOne(int n) {
        int count = 0;
        
        for(long m = 1; m <= n; m = m * 10) {
            long h = n / m;
            long l = n % m;
            count += (h + 8) / 10 * m + (h % 10 == 1? l+1 : 0);
        }
        
        return count;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
